package net.runelite.client.plugins.playerinfo;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.client.plugins.playerinfo.adapter.PlayerAdapter;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class PlayerInfoOverlay extends Overlay
{
	Client client;
	PlayerInfoConfig config;
	PlayerInfoPlugin plugin;

	public PlayerInfoOverlay(Client client, PlayerInfoConfig config, PlayerInfoPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (config.drawLocalTileEnabled() && plugin.getLocalPlayer() != null)
		{
			PlayerAdapter localPlayerAdapter = plugin.getLocalPlayer();
			Player localPlayer = localPlayerAdapter.getPlayer();

			if (localPlayer != null)
			{
				net.runelite.api.Point tileLocation = localPlayer.getRegionLocation();

				Polygon tilePoly = Perspective.getCanvasTilePoly(client, tileLocation);

				if (tilePoly != null)
				{
					OverlayUtil.renderPolygon(graphics, tilePoly, Color.BLUE);
				}
			}
		}
		return null;
	}
}
