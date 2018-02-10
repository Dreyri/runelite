package net.runelite.client.plugins.buffbar.broadcaster;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.buffbar.BaseBroadcaster;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapterNew;
import net.runelite.client.plugins.buffbar.extras.FreezeType;
import net.runelite.client.plugins.buffbar.extras.OverheadIcon;
import net.runelite.client.plugins.buffbar.listener.FreezeListener;

@Slf4j
public class FreezeBroadcaster extends BaseBroadcaster<FreezeListener>
{
	public static final int FREEZE_IMMUNITY_TICKS = 6;

	PlayerAdapterNew player;

	private boolean queuedFreeze;
	private int remainingTicks;
	private FreezeType type;

	private int remainingImmunityTicks;

	private boolean isFrozen;
	private boolean isImmune;

	public FreezeBroadcaster(PlayerAdapterNew player)
	{
		super();

		this.player = player;
		reset(false);
	}

	public void onGraphicChanged(int graphic)
	{
		//don't register freeze if already frozen or immune
		if (this.type != null || this.isImmune)
			return;

		FreezeType type;

		if (graphic == FreezeType.ICE_RUSH.getGraphic())
		{
			type = FreezeType.ICE_RUSH;
		}
		else if (graphic == FreezeType.ICE_BURST.getGraphic())
		{
			type = FreezeType.ICE_BURST;
		}
		else if (graphic == FreezeType.ICE_BLITZ.getGraphic())
		{
			type = FreezeType.ICE_BLITZ;
		}
		else if (graphic == FreezeType.ICE_BARRAGE.getGraphic())
		{
			type = FreezeType.ICE_BARRAGE;
		}
		else if (graphic == FreezeType.BIND.getGraphic())
		{
			type = FreezeType.BIND;
		}
		else if (graphic == FreezeType.SNARE.getGraphic())
		{
			type = FreezeType.SNARE;
		}
		else if (graphic == FreezeType.ENTANGLE.getGraphic())
		{
			type = FreezeType.ENTANGLE;
		}
		else
		{
			return;
		}

		this.type = type;
		this.queuedFreeze = true;
	}

	public void tick()
	{
		if (queuedFreeze)
		{
			calculateFreeze();
			return;
		}

		if (this.type != null)
		{
			calculateRemainingFreeze();
			return;
		}

		if (this.isImmune)
		{
			calculateRemainingImmunity();
		}
	}

	public void calculateRemainingFreeze()
	{
		--this.remainingTicks;

		if (this.remainingTicks == 0)
		{
			reset(true);
			this.remainingImmunityTicks = FREEZE_IMMUNITY_TICKS;
			this.isImmune = true;
			broadcastFreezeImmunity(this.remainingImmunityTicks);
		}
		else
		{
			broadcastFrozen(this.type, this.remainingTicks);
		}
	}

	public void calculateRemainingImmunity()
	{
		--this.remainingImmunityTicks;

		if (this.remainingImmunityTicks == 0)
		{
			reset(false);
			broadcastFreezeImmunityLifted();
		}
		else
		{
			broadcastFreezeImmunity(this.remainingImmunityTicks);
		}
	}

	public void calculateFreeze()
	{
		if (isImmune)
			return;

		boolean halfOnPray = type.isHalvedOnPray();
		OverheadIcon prayer = OverheadIcon.NONE;
		this.remainingTicks = type.getTicks();

		if (halfOnPray && prayer == OverheadIcon.PROTECT_MAGIC)
		{
			this.remainingTicks /= 2;
		}

		this.queuedFreeze = false;

		broadcastFrozen(this.type, this.remainingTicks);
	}

	public void broadcastFrozen(FreezeType type, int ticks)
	{
		log.info("{} frozen by {} for {} ticks", this.player.getName(), type.getName(), ticks);
		super.broadcastEvent(listener -> listener.frozen(type, ticks));
	}

	public void broadcastUnfrozen()
	{
		log.info("{} unfrozen", this.player.getName());
		super.broadcastEvent(listener -> listener.unfrozen());
	}

	public void broadcastFreezeImmunity(int ticks)
	{
		log.info("{} immune to freeze for {} ticks", this.player.getName(), ticks);
		super.broadcastEvent(listener -> listener.freezeImmune(ticks));
	}

	public void broadcastFreezeImmunityLifted()
	{
		log.info("{} is no longer immune to freezes", this.player.getName());
		super.broadcastEvent(listener -> listener.freezeImmuneLifted());
	}

	public void reset(boolean broadcast)
	{
		this.type = null;
		this.remainingTicks = 0;
		this.queuedFreeze = false;
		this.isImmune = false;
		this.remainingImmunityTicks = 0;
		this.isFrozen = false;

		if (broadcast)
			broadcastUnfrozen();
	}
}
