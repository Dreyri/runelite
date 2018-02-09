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

		this.freeze = new FreezeBroadcaster(this);
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

	public void updatePlayer(Player player)
	{
		if (!this.getName().equals(player.getName()))
		{
			throw new IllegalStateException("cannot update with a different player! " + this.getName() + " -> " + player.getName());
		}

		this.player = player;

		if(!this.isValid())
		{
			this.setValid(true);
		}
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
