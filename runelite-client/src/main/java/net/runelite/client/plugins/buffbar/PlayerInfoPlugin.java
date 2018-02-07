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
		localPlayer.tick();
	}

	@Subscribe
	public void onAnimationChange(GraphicChanged event)
	{
		if (localPlayer.getPlayer() == null)
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
