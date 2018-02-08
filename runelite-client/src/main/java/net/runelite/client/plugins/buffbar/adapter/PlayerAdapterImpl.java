package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Player;
import net.runelite.api.Renderable;
import net.runelite.client.plugins.buffbar.Broadcaster;

import java.util.List;

public class PlayerAdapterImpl implements Adapter {

	private String name;
	private Player player;

	private List<Broadcaster> broadcasters;

	public PlayerAdapterImpl(Player player)
	{
		this.name = player.getName();
		this.player = player;
	}

	@Override
	public void addBroadcaster(Broadcaster broadcaster)
	{
		if (!broadcaster.accept(getAdaptee()))
		{
			throw new IllegalArgumentException("broadcaster does not accept adaptee");
		}

		broadcasters.add(broadcaster);
	}

	@Override
	public boolean removeBroadcaster(Broadcaster broadcaster)
	{
		return broadcasters.remove(broadcaster);
	}

	@Override
	public Renderable getAdaptee()
	{
		return player;
	}
}
