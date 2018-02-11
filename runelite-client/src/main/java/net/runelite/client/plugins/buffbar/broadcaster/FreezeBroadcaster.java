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

	private int queuedFreeze;
	private int remainingTicks;
	private FreezeType type;
	private FreezeType queuedType;

	private int remainingImmunityTicks;

	private boolean ourPid;

	public FreezeBroadcaster(PlayerAdapterNew player, boolean ourPid)
	{
		super();

		this.ourPid = ourPid;
		this.player = player;
		this.type = null;
		this.queuedType = null;
		reset(false);
	}

	public void onGraphicChanged(int graphic)
	{
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

		if (this.queuedFreeze >= 0)
			return;

		this.queuedType = type;
		this.queuedFreeze = ourPid ? 1 : 2;
	}

	public void tick()
	{
		if (this.remainingImmunityTicks > 0)
		{
			calculateRemainingImmunity();
		}

		--this.queuedFreeze;

		if (this.queuedFreeze == 0)
		{
			calculateFreeze();
			this.queuedFreeze = -1;
			return;
		}

		if (this.remainingTicks > 0 && this.queuedFreeze < 0)
		{
			calculateRemainingFreeze();
			return;
		}


	}

	public void calculateRemainingFreeze()
	{
		--this.remainingTicks;

		if (this.remainingTicks == 0)
		{
			reset(true);
			this.remainingImmunityTicks = FREEZE_IMMUNITY_TICKS;
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
		if (this.remainingImmunityTicks > 0 || this.remainingTicks > 0)
			return;

		boolean halfOnPray = this.queuedType.isHalvedOnPray();
		OverheadIcon prayer = OverheadIcon.NONE;
		this.remainingTicks = this.queuedType.getTicks();

		if (halfOnPray && prayer == OverheadIcon.PROTECT_MAGIC)
		{
			this.remainingTicks /= 2;
		}

		this.queuedFreeze = -1;

		this.type = this.queuedType;
		this.queuedType = null;

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
		this.remainingTicks = 0;
		this.queuedFreeze = -1;
		this.remainingImmunityTicks = 0;

		if (broadcast)
			broadcastUnfrozen();
	}
}
