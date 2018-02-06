package net.runelite.client.plugins.playerinfo;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
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

	private PlayerInfoOverlay playerInfoOverlay;

	private PlayerAdapter localPlayer;

	private PlayerInfoPlugin()
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
		if (localPlayer == null)
		{
			localPlayer = new PlayerAdapter(client.getLocalPlayer());
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
