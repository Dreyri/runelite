package net.runelite.client.plugins.playerinfo;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;

import java.awt.Point;

public class PlayerAdapter
{
	private Player player;
	private int cacheIdx;

	private Point localTilePosition;

	/**
	 * for internal use only
	 * @param player
	 * @param cacheIdx
	 */
	private PlayerAdapter(Player player, int cacheIdx)
	{
		this.player = player;
		this.cacheIdx = cacheIdx;

		this.localTilePosition = null;
	}

	public PlayerAdapter(Player player)
	{
		this(player, player == null ? -1 : player.getCacheIndex());
	}

	public PlayerAdapter(Client client, int idx)
	{
		this(client.getPlayerFromCache(idx), idx);
	}

	@Subscribe
	public void gameTick(GameTick tick)
	{

	}
}
