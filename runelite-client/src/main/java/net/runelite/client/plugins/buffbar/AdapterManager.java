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
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.plugins.buffbar.adapter.LocalPlayer;
import net.runelite.client.plugins.buffbar.adapter.NPCAdapter;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapterImpl;

import java.util.List;

public class AdapterManager
{
	private Client client;

	private LocalPlayer localPlayer;

	private List<PlayerAdapterImpl> playerAdapters;
	private List<NPCAdapter> npcAdapters;

	/**
	 * necessary for now to avoid reloading after every loading gamestate
	 */
	private GameState lastGameState;

	public AdapterManager(Client client)
	{
		this.client = client;
	}

	@Subscribe
	public void onVarbitsChanged(VarbitChanged event)
	{
		localPlayer.onVarbitChanged(event);
	}

	@Subscribe
	public void onGamestateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING)
		{
			this.clearNPCs();
		}
		else if (event.getGameState() == GameState.LOGGED_IN && lastGameState != GameState.LOADING)
		{
			this.populateNPCs();
			this.populatePlayers();
			this.getLocalPlayer();
		}
	}

	/**
	 * populate the npc list, the list is expected to be empty for this
	 */
	public void populateNPCs()
	{
		if (npcAdapters.size() > 0)
		{
			throw new IllegalStateException("npcAdapters must be empty before populating");
		}

		List<NPC> allCachedNPCs = client.getNpcs();


	}

	public void populatePlayers()
	{
		//TODO
	}

	public void getLocalPlayer()
	{
		//TODO
	}

	public void clearNPCs()
	{
		//TODO
	}
}
