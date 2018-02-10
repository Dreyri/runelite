package net.runelite.client.plugins.buffbar;

import net.runelite.api.Point;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
		BufferedImage icon = buff.getIcon();

		Dimension imageSize = getScaledDimension(new Dimension(icon.getWidth(), icon.getHeight()), new Dimension(20, 20));

		graphics.setColor(new Color(0, 255, 0, 80));
		graphics.fillRect(1, 1, 19, 19);

		graphics.setColor(Color.BLACK);
		graphics.drawRect(0, 0, BUFF_ICON_SIZE, BUFF_ICON_SIZE);


		//x and y centered
		int drawX = (BUFF_ICON_SIZE - imageSize.width) / 2;
		int drawY = (BUFF_ICON_SIZE - imageSize.height) / 2;

		graphics.drawImage(icon, drawX, drawY, imageSize.width, imageSize.height, null);

		graphics.setColor(Color.GREEN);
		OverlayUtil.renderTextLocation(graphics, new Point(2, 19), buff.getText(), Color.WHITE);
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

	public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary)
	{

		int original_width = imgSize.width;
		int original_height = imgSize.height;
		int bound_width = boundary.width;
		int bound_height = boundary.height;
		int new_width = original_width;
		int new_height = original_height;

		// first check if we need to scale width
		if (original_width > bound_width)
		{
			//scale width to fit
			new_width = bound_width;
			//scale height to maintain aspect ratio
			new_height = (new_width * original_height) / original_width;
		}

		// then check if we need to scale even with the new height
		if (new_height > bound_height)
		{
			//scale height to fit instead
			new_height = bound_height;
			//scale width to maintain aspect ratio
			new_width = (new_height * original_width) / original_height;
		}

		return new Dimension(new_width, new_height);
	}
}
