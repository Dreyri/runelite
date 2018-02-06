package net.runelite.client.plugins.playerinfo;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class PlayerInfoOverlay extends Overlay
{
	Client client;
	PlayerInfoConfig config;
	PlayerInfoPlugin plugin;
	PlayerAdapter localPlayer;

	public PlayerInfoOverlay(Client client, PlayerInfoConfig config, PlayerInfoPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (config.drawLocalTileEnabled() && plugin.getLocalPlayer() != null)
		{
			PlayerAdapter localPlayer = plugin.getLocalPlayer();
		}
		return null;
	}
}
