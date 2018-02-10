/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.buffbar;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.plugins.buffbar.adapter.NPCAdapter;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapterNew;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class AdapterManager
{
	private Client client;

	private PlayerAdapterNew localPlayer;

	private List<PlayerAdapterNew> playerAdapters;
	private List<NPCAdapter> npcAdapters;

	/**
	 * necessary for now to avoid reloading after every loading gamestate
	 */
	private GameState lastGameState;

	public AdapterManager(Client client)
	{
		this.client = client;

		this.playerAdapters = new ArrayList<>();
		this.npcAdapters = new ArrayList<>();
		this.localPlayer = new PlayerAdapterNew(null);
	}

	@Subscribe
	public void onVarbitsChanged(VarbitChanged event)
	{
		//localPlayer.onVarbitChanged(event);
	}

	/**
	 * precondition: all players/npcs which have their graphic changed are valid
	 * @param event
	 */
	@Subscribe
	public void onGraphicChanged(GraphicChanged event)
	{
		for (PlayerAdapterNew adapter : playerAdapters)
		{
			if (adapter.getAdaptee() == event.getActor())
			{
				adapter.onGraphicChanged(((Actor) adapter.getAdaptee()).getGraphic());
			}
		}

		for (NPCAdapter adapter : npcAdapters)
		{
			if (adapter.getAdaptee() == event.getActor())
			{
				adapter.onGraphicChanged(((Actor) adapter.getAdaptee()).getGraphic());
			}
		}

		if (event.getActor() == localPlayer.getAdaptee())
		{
			localPlayer.onGraphicChanged(((Actor) localPlayer.getAdaptee()).getGraphic());
		}
	}

	@Subscribe
	public void onGamestateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING)
		{
			this.clearNPCs();
			this.clearLocalPlayer();
			this.clearPlayers();
		}
		else if (event.getGameState() == GameState.LOGGED_IN && lastGameState != GameState.LOADING)
		{
			this.populateNPCs();
			this.populatePlayers();
			this.getLocalPlayer();
		}

		lastGameState = event.getGameState();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		this.repopulate();

		Set<String> duplicates = findDuplicates(playerAdapters);

		for (String name : duplicates)
		{
			log.info("duplicate: " + name);
		}

		//log.info("Executing tick on {} NPCs", npcAdapters.size());
		for (NPCAdapter npc : npcAdapters)
		{
			if (npc.isValid())
				npc.tick();
		}

		//log.info("Executing tick on {} Players", playerAdapters.size());
		for (PlayerAdapterNew player : playerAdapters)
		{
			if (player.isValid())
				player.tick();
		}

		if (localPlayer == null)
		{
			getLocalPlayer();
		}
		else
		{
			//log.info("Executing tick on local player: {}", ((Player) localPlayer.getAdaptee()).getName());
			localPlayer.tick();
		}
	}

	public void repopulate()
	{
		repopulateNPCs();
		repopulatePlayers();
		getLocalPlayer();
	}

	public void repopulateNPCs()
	{
		List<NPC> cachedNPCs = client.getNpcs();

		for (NPC npc : cachedNPCs)
		{
			if (npcAdapters.stream().filter(npcAdapter -> npcAdapter.getAdaptee().equals(npc)).findFirst().isPresent())
			{
				continue;
			}
			else
			{
				npcAdapters.add(new NPCAdapter(npc));
			}
		}
	}

	public void repopulatePlayers()
	{
		List<Player> cachedPlayers = client.getPlayers();

		for (Player player : cachedPlayers)
		{
			Optional<PlayerAdapterNew> adapterOptional = playerAdapters.stream().filter(playerAdapter -> playerAdapter.getName().equals(player.getName())).findFirst();

			if (!adapterOptional.isPresent())
			{
				if (player != client.getLocalPlayer())
					playerAdapters.add(new PlayerAdapterNew(player));
			}
			else
			{
				adapterOptional.get().updatePlayer(player);
			}

		}
	}

	/**
	 * populate the npc list, the list is expected to be empty for this
	 */
	public void populateNPCs()
	{
		if (npcAdapters.size() > 0)
		{
			throw new IllegalStateException("npcAdapters must be empty before populating!");
		}

		List<NPC> allCachedNPCs = client.getNpcs();

		for (NPC npc : allCachedNPCs)
		{
			this.npcAdapters.add(new NPCAdapter(npc));
		}
	}

	public void populatePlayers()
	{
		if (playerAdapters.size() > 0)
		{
			throw new IllegalStateException("playerAdapters must be empty before populating!");
		}

		List<Player> allCachedPlayers = client.getPlayers();
		Player localPlayer = client.getLocalPlayer();

		for (Player player : allCachedPlayers)
		{
			//don't add the local player
			if (player == localPlayer)
				continue;

			this.playerAdapters.add(new PlayerAdapterNew(player));
		}
	}

	public PlayerAdapterNew getLocalPlayer()
	{
		if (this.localPlayer.getAdaptee() == null || !this.localPlayer.isValid())
		{
			Player localPlayerRl = client.getLocalPlayer();
			if (localPlayerRl == null)
			{
				this.localPlayer.invalidate();
			}
			else
			{
				this.localPlayer.updatePlayer(localPlayerRl);
			}
		}

		return this.localPlayer;
	}

	public void clearNPCs()
	{
		for (NPCAdapter adapter : npcAdapters)
		{
			adapter.invalidate();
		}

		npcAdapters.clear();
	}

	public void clearLocalPlayer()
	{
		localPlayer.invalidate();
	}

	public void clearPlayers()
	{
		for (PlayerAdapterNew player : playerAdapters)
		{
			player.invalidate();
		}

		playerAdapters.clear();
	}

	public static Set<String> findDuplicates(List<PlayerAdapterNew> players)
	{
		Set<String> duplicates = new HashSet<>();
		Set<String> testSet = new HashSet<>();

		for (PlayerAdapterNew player : players)
		{
			if (!testSet.add(((Player) player.getAdaptee()).getName()))
			{
				duplicates.add(((Player) player.getAdaptee()).getName());
			}
		}

		return duplicates;
	}
}
