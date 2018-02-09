package net.runelite.client.plugins.buffbar;

import java.util.ArrayList;
import java.util.List;

public class Buffbar
{
	private List<BuffIcon> buffIcons;

	public Buffbar()
	{
		buffIcons = new ArrayList<>();
	}

	public boolean addBuff(BuffIcon icon)
	{
		return this.buffIcons.add(icon);
	}
}
