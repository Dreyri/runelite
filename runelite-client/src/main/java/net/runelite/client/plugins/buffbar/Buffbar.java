package net.runelite.client.plugins.buffbar;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.TreeSet;

public class Buffbar
{
	private TreeSet<BuffIcon> buffIcons;

	private int buffsPerRow;

	private Dimension dimension;

	public Buffbar()
	{
		buffIcons = new TreeSet<>();
		buffsPerRow = 5;

		dimension = new Dimension(buffsPerRow * BuffIcon.BUFF_ICON_SIZE, 5 * BuffIcon.BUFF_ICON_SIZE);
	}

	public boolean addBuff(BuffIcon icon)
	{
		return this.buffIcons.add(icon);
	}

	public boolean removeBuff(BuffIcon icon)
	{
		return this.buffIcons.remove(icon);
	}

	public Dimension render(Graphics2D graphics, Point drawAt)
	{
		Graphics2D buffGraphics = (Graphics2D) graphics.create();
		buffGraphics.translate(500, 400);

		int i = 0;
		for (BuffIcon buff : buffIcons)
		{
			if (buff.isActive())
			{
				buff.render(buffGraphics);
				buffGraphics.translate(buff.getDimension().getWidth(), 0);
			}
		}

		buffGraphics.dispose();

		return this.getDimension();
	}

	public Dimension getDimension()
	{
		return this.dimension;
	}
}
