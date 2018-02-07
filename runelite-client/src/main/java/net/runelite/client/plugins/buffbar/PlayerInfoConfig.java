package net.runelite.client.plugins.buffbar;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "buffbar",
		name = "Player info",
		description = "Configure Player info to display"
)
public interface PlayerInfoConfig extends Config
{
	@ConfigItem(
			keyName = "drawLocalTile",
			name = "Draw Local Tile",
			description = "Draw the tile you're standing on"
	)
	default boolean drawLocalTileEnabled()
	{
		return false;
	}
}
