package net.runelite.client.plugins.playerinfo.buffbar;

import java.awt.image.BufferedImage;

public class FreezeBuff extends TimerBuff
{
	@Override
	public int getTicks()
	{
		return 0;
	}

	@Override
	public BuffType getType()
	{
		return null;
	}

	@Override
	public boolean isActive()
	{
		return false;
	}

	@Override
	public BufferedImage getIcon()
	{
		return null;
	}
}
