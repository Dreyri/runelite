package net.runelite.client.plugins.buffbar.adapter;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;

import java.awt.Point;

@Slf4j
public class PlayerAdapter
{
	public enum FreezeType
	{
		ICE_RUSH,
		ICE_BURST,
		ICE_BLITZ,
		ICE_BARRAGE,

		BIND,
		SNARE,
		ENTANGLE,

		NONE
	}
	private Player player;
	private int cacheIdx;

	private int tickCount;

	private boolean isFrozen;
	private boolean isFreezeImmune;
	private int remainingFreeze;
	private int remainingFreezeImmunity;
	private FreezeType freezeType;

	private Point localTilePosition;

	private int queuedFreezeWhen;

	/**
	 * for internal use only
	 * @param player
	 * @param cacheIdx
	 */
	private PlayerAdapter(Player player, int cacheIdx)
	{
		this.player = player;
		this.cacheIdx = cacheIdx;

		this.tickCount = 0;
		this.isFrozen = false;
		this.localTilePosition = null;
		this.queuedFreezeWhen = 0;
		this.remainingFreeze = 0;
		this.remainingFreezeImmunity = 0;
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
		++tickCount;

		//freeze must be handled before position update as the unfreeze happens the same tick as movement.
		//so to prevent getting the freeze prematurely broken message we must handle it first
		//handle freeze
		if (isFrozen)
		{

			log.info("ticks remaining " + this.remainingFreeze);

			if (this.remainingFreeze-- <= 0)
			{
				this.isFrozen = false;
				log.info("You are now unfrozen");
				this.freezeType = FreezeType.NONE;
				this.isFreezeImmune = true;
				this.remainingFreezeImmunity = 6;
			}
		}

		Point newLocation = new Point(this.player.getNextPathLocation().getX(), this.player.getNextPathLocation().getY());
		updateLocation(newLocation);

		log.info(this.localTilePosition.toString());


		//handle freeze immunity
		if (isFreezeImmune)
		{

			log.info("remaining immunity " + this.remainingFreezeImmunity);

			if (this.remainingFreezeImmunity-- <= 0)
			{
				this.isFreezeImmune = false;
				log.info("You are no longer immune to freezes");
			}
		}


		//handle queued freeze
		if (queuedFreezeWhen > 0)
		{
			--queuedFreezeWhen;

			if (!isFrozen && !isFreezeImmune && queuedFreezeWhen == 0)
			{
				if (this.freezeType == FreezeType.ICE_BARRAGE)
				{
					log.info("You have been forzen");
					this.remainingFreeze = 32;
					this.isFrozen = true;
				}
				else if (this.freezeType == FreezeType.ICE_BLITZ)
				{
					log.info("You have been frozen");
					this.remainingFreeze = 24;
					this.isFrozen = true;
				}
			}
		}
	}

	public void animationChanged()
	{
		int graphic = this.getPlayer().getGraphic();

		if (graphic == 369)
		{
			this.freezeType = FreezeType.ICE_BARRAGE;
			this.queuedFreezeWhen = 1;
			//barrage freeze start
		}
		else if (graphic == 367)
		{
			this.freezeType = FreezeType.ICE_BLITZ;
			this.queuedFreezeWhen = 1;
		}
	}

	private void updateLocation(Point newLoc)
	{
		if (newLoc.getX() != this.localTilePosition.getX() || newLoc.getY() != this.localTilePosition.getY())
		{
			//TODO send move event
			this.localTilePosition = newLoc;
			//cannot be frozen when we've moved
			if (this.isFrozen)
			{
				log.warn("Freeze prematurely broken");
				this.isFrozen = false;
				this.remainingFreeze = 0;
				this.freezeType = FreezeType.NONE;
			}

		}
	}
}
