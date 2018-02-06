package net.runelite.client.plugins.playerinfo.adapter;

import net.runelite.api.Client;
import net.runelite.api.Player;

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

	public Player getPlayer()
	{
		return this.player;
	}

	public int getCacheIndex()
	{
		return this.cacheIdx;
	}

	public void tick()
	{
		Point newLocation = new Point(this.player.getNextPathLocation().getX(), this.player.getNextPathLocation().getY());

		if (newLocation != this.localTilePosition)
		{
			//TODO send move event
			this.localTilePosition = newLocation;
			System.out.println(this.localTilePosition);
		}
	}
}
