package net.runelite.client.plugins.buffbar;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class BuffIcon implements Comparable<BuffIcon>
{
	public static int BUFF_ICON_SIZE = 20;

	Buff buff;

	private BuffPriority priority;
	private BuffType type;
	private Dimension dimension;

	public BuffIcon(Buff buff, BuffPriority priority)
	{
		this.buff = buff;
		this.priority = priority;
		dimension = new Dimension(BUFF_ICON_SIZE, BUFF_ICON_SIZE);
	}

	public int getPriority()
	{
		return priority.getPriority();
	}

	public Dimension render(Graphics2D graphics)
	{

		return getDimension();
	}

	public boolean isActive()
	{
		return buff.isActive();
	}

	@Override
	public int compareTo(BuffIcon o)
	{
		return this.getPriority() - o.getPriority();
	}

	public Dimension getDimension()
	{
		return dimension;
	}
}
