package net.runelite.client.plugins.prayerbook;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "prayerbook",
	name = "Prayer book",
	description = "Configuration for the prayer book"
)
public interface PrayerBookPluginConfiguration extends Config
{
	@ConfigItem(
		keyName = "enabled",
		name = "Enable Prayer Book changes",
		description = "Configures whether Prayer Book plugin is enabled"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "swapPiety",
			name = "Swap Piety",
			description = "Swap Piety with Ultimate Strength"
	)
	default boolean swapPiety()
	{
		return false;
	}

	@ConfigItem(
			keyName = "swapChivalry",
			name = "Swap Chivalry",
			description = "Swap Chivalry with Incredible Reflexes"
	)
	default boolean swapChivalry()
	{
		return false;
	}

	@ConfigItem(
			keyName = "swapAugury",
			name = "Swap Augury",
			description = "Swap Augury with Mystic Might"
	)
	default boolean swapAugury()
	{
		return false;
	}

	@ConfigItem(
			keyName = "swapRigour",
			name = "Swap Rigour",
			description = "Swap Rigour with Eagle Eye"
	)
	default boolean swapRigour()
	{
		return false;
	}
}
