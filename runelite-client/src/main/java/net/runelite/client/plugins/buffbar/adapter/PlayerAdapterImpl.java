package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Player;
import net.runelite.api.Renderable;
import net.runelite.client.plugins.buffbar.Broadcaster;

import java.util.List;

public class PlayerAdapterImpl {

	private String name;
	private Player player;

	private List<Broadcaster> broadcasters;

	public PlayerAdapterImpl(Player player)
	{
		this.name = player.getName();
		this.player = player;
	}

	public void addBroadcaster(Broadcaster broadcaster)
	{
		if (!broadcaster.accept(getAdaptee()))
		{
			throw new IllegalArgumentException("broadcaster does not accept adaptee");
		}

		broadcasters.add(broadcaster);
	}

	public Renderable getAdaptee()
	{
		return player;
	}
}
