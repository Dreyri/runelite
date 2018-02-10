package net.runelite.client.plugins.buffbar;

import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BuffIcon implements Comparable<BuffIcon>
{
	public static int BUFF_ICON_SIZE = 25;

	Buff buff;

	private BuffPriority priority;
	private BuffType type;
	private Dimension dimension;

	private Font font;

	public BuffIcon(Buff buff, BuffPriority priority)
	{
		this.buff = buff;
		this.priority = priority;
		dimension = new Dimension(BUFF_ICON_SIZE, BUFF_ICON_SIZE);

		font = Font.getFont(Font.MONOSPACED);
	}

	public int getPriority()
	{
		return priority.getPriority();
	}

	public Dimension render(Graphics2D graphics)
	{
		BufferedImage icon = buff.getIcon();

		Dimension imageSize = getScaledDimension(new Dimension(icon.getWidth(), icon.getHeight()), new Dimension(20, 20));

		//graphics.setColor(new Color(0, 255, 0, 80));
		graphics.setColor(getColorForType(buff.getType()));

		graphics.fillRect(0, 0, BUFF_ICON_SIZE, BUFF_ICON_SIZE);

		graphics.setColor(Color.BLACK);
		graphics.drawRect(0, 0, BUFF_ICON_SIZE, BUFF_ICON_SIZE);


		//x and y centered
		int drawX = (BUFF_ICON_SIZE - imageSize.width) / 2;
		int drawY = (BUFF_ICON_SIZE - imageSize.height) / 2;

		graphics.drawImage(icon, drawX, drawY, imageSize.width, imageSize.height, null);

		Font font = FontManager.getRunescapeSmallFont().deriveFont(Font.BOLD, 14);
		graphics.setFont(font);

		OverlayUtil.renderTextLocation(graphics, new Point(2, BUFF_ICON_SIZE - 1), buff.getText(), Color.GREEN);
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

	public static Color getColorForType(BuffType type)
	{
		switch (type)
		{
			case BUFF:
				return new Color(0, 255, 0, 80);
			case DEBUFF:
				return new Color(255, 0, 0, 80);
			case INFO:
				return new Color(0, 0, 255, 80);
		}

		return Color.WHITE;
	}
}
