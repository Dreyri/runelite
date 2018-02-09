package net.runelite.client.plugins.buffbar;

import java.awt.Dimension;
import java.awt.Graphics2D;

public abstract class BuffIcon implements Buff, Comparable<BuffIcon>
{
	public static int BUFF_ICON_SIZE = 20;

	private BuffPriority priority;
	private BuffType type;
	private Dimension dimension;

	public BuffIcon(BuffPriority priority, BuffType type)
	{
		this.priority = priority;
		this.type = type;
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
