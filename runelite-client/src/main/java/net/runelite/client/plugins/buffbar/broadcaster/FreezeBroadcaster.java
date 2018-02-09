package net.runelite.client.plugins.buffbar.broadcaster;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapterNew;
import net.runelite.client.plugins.buffbar.extras.FreezeType;
import net.runelite.client.plugins.buffbar.extras.OverheadIcon;
import net.runelite.client.plugins.buffbar.listener.FreezeListener;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FreezeBroadcaster
{
	public static final int FREEZE_IMMUNITY_TICKS = 6;

	PlayerAdapterNew player;

	private List<FreezeListener> freezeListeners;

	private boolean queuedFreeze;
	private int remainingTicks;
	private FreezeType type;

	private int remainingImmunityTicks;

	private boolean isFrozen;
	private boolean isImmune;

	public FreezeBroadcaster(PlayerAdapterNew player)
	{
		this.player = player;

		this.freezeListeners = new ArrayList<>();
		reset(false);
	}

	public boolean addListener(FreezeListener listener)
	{
		return this.freezeListeners.add(listener);
	}

	public boolean removeListener(FreezeListener listener)
	{
		return this.freezeListeners.remove(listener);
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

		log.info("player {} was frozen with {}", player.getName(), type.getName());

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
	}

	public void broadcastUnfrozen()
	{
		log.info("{} unfrozen", this.player.getName());
	}

	public void broadcastFreezeImmunity(int ticks)
	{
		log.info("{} immune to freeze for {} ticks", this.player.getName(), ticks);
	}

	public void broadcastFreezeImmunityLifted()
	{
		log.info("{} is no longer immune to freezes", this.player.getName());
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
