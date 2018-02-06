package net.runelite.client.plugins.playerinfo;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;

import java.awt.Point;

public class PlayerAdapter
{
	private Player player;

	Point localTilePosition;

	public PlayerAdapter(Player player)
	{
		this.player = player;
		this.localTilePosition = null;
	}

	@Subscribe
	public void gameTick(GameTick tick)
	{

	}
}
