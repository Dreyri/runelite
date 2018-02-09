package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Player;
import net.runelite.api.Renderable;
import net.runelite.client.plugins.buffbar.broadcaster.FreezeBroadcaster;

public class PlayerAdapterNew extends BaseAdapter
{
	private FreezeBroadcaster freeze;

	private Player player;
	private String name;

	public PlayerAdapterNew(Player player)
	{
		this.player = player;
		retrieveName();

		this.freeze = new FreezeBroadcaster();
	}

	public void onGraphicChanged(int graphic)
	{
		this.freeze.onGraphicChanged(graphic);
	}

	@Override
	public Renderable getAdaptee()
	{
		return this.player;
	}

	@Override
	public void tick()
	{
		freeze.tick();
	}

	public String getName()
	{
		return this.name;
	}

	@Override
	public void invalidate()
	{
		super.invalidate();
		this.player = null;
	}

	public void retrieveName()
	{
		if (this.player != null)
			this.name = player.getName();
	}
}
