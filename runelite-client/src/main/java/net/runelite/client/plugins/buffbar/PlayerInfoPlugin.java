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
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GraphicChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapter;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;

@PluginDescriptor(
		name = "Player info"
)
public class PlayerInfoPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PlayerInfoConfig config;

	PlayerInfoOverlay playerInfoOverlay;

	private PlayerAdapter localPlayer;

	public PlayerInfoPlugin()
	{
		localPlayer = null;
	}

	@Provides
	PlayerInfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerInfoConfig.class);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING || event.getGameState() == GameState.LOGIN_SCREEN)
		{
			localPlayer = null;
		}

		if (event.getGameState() == GameState.LOGGED_IN)
		{
			if (localPlayer == null)
			{
				Player self = client.getLocalPlayer();

				if (self != null)
				{
					localPlayer = new PlayerAdapter(self);
				}
			}
		}
	}

	@Subscribe
	public void onTick(GameTick event)
	{
		//localPlayer.tick();
	}

	@Subscribe
	public void onAnimationChange(GraphicChanged event)
	{
		if (localPlayer == null || localPlayer.getPlayer() == null)
		{
			return;
		}
		if (event.getActor() == localPlayer.getPlayer())
		{
			localPlayer.animationChanged();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		playerInfoOverlay = new PlayerInfoOverlay(client, config, this);
	}

	@Override
	public Overlay getOverlay()
	{
		return playerInfoOverlay;
	}

	public PlayerAdapter getLocalPlayer()
	{
		return localPlayer;
	}
}
