package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Player;
import net.runelite.api.Renderable;

public class PlayerAdapterImpl extends  BaseAdapter {

	private String name;
	private Player player;

	public PlayerAdapterImpl(Player player)
	{
		this.name = player.getName();
		this.player = player;
	}

	@Override
	public Renderable getAdaptee()
	{
		return player;
	}

	@Override
	public void invalidate()
	{
		super.invalidate();

		this.player = null;
	}
}
