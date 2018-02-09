package net.runelite.client.plugins.buffbar.broadcaster;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.buffbar.extras.FreezeType;
import net.runelite.client.plugins.buffbar.extras.OverheadIcon;

@Slf4j
public class FreezeBroadcaster
{
	private boolean queuedFreeze;
	private int remainingTicks;
	private FreezeType type;

	private boolean isFrozen;
	private boolean isImmune;

	public FreezeBroadcaster()
	{
		reset();
	}

	public void onGraphicChanged(int graphic)
	{
		if (this.type != null)
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

		log.info("player was frozen with {}", type.getName());

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
	}

	public void reset()
	{
		this.type = null;
		this.remainingTicks = 0;
		this.queuedFreeze = false;
		this.isImmune = false;
		this.isFrozen = false;
	}
}
