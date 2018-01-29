package net.runelite.client.plugins.highlight;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup(
		keyName = "highlight",
		name = "Highlight",
		description = "Configuration for Highlights"
)
public interface HighlightPluginConfig extends Config
{
	@ConfigItem(
			keyName = "enabled",
			name = "enabled",
			description = "Configures whether the plugin is active"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "special",
			name = "Special Attack",
			description = "enable highlight for Special Attack"
	)
	default boolean specialHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "piety",
			name = "Piety",
			description = "enable highlight for Piety"
	)
	default boolean pietyHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "chivalry",
			name = "Chivalry",
			description = "enable highlight for Chivalry"
	)
	default boolean chivalryHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "ultimatestrength",
			name = "Ultimate Strength",
			description = "enable highlight for Ultimate Strength"
	)
	default boolean ultimateStrengthHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "incrediblereflexes",
			name = "Incredible Reflexes",
			description =  "enable highlight for Incredible Reflexes"
	)
	default boolean incredibleReflexesHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "eagle",
			name = "Eagle Eye",
			description = "enable highlight for Eagle Eye"
	)
	default boolean eagleHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "rigour",
			name = "Rigour",
			description = "enable highlight for Rigour"
	)
	default boolean rigourHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "mystic",
			name = "Mystic Might",
			description = "enable highlight for Mystic Might"
	)
	default boolean mysticHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "augury",
			name = "Augury",
			description = "enable highlight for Augury"
	)
	default boolean auguryHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "protmagic",
			name = "Protect Magic",
			description = "enable highlight for Protect Magic"
	)
	default boolean protMagicHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "protranged",
			name = "Protect Ranged",
			description = "enable highlight for Protect Ranged"
	)
	default boolean protRangedHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "protMelee",
			name = "Protect Melee",
			description = "enable highlight for Protect Melee"
	)
	default boolean protMeleeHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "icebarrage",
			name = "Ice Barrage",
			description = "enable highlight for Ice Barrage"
	)
	default boolean iceBarrageHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "saradominstrike",
			name = "Saradomin Strike",
			description = "enable highlight for Saradomin Strike"
	)
	default boolean saradominStrikeHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "clawsguthix",
			name = "Claws of Guthix",
			description = "enable highlight for Claws of Guthix"
	)
	default boolean clawsGuthixHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "flameszamorak",
			name = "Flames of Zamorak",
			description = "enable highlight for Flames of Zamorak"
	)
	default boolean flamesZamorakHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "firewave",
			name = "Fire Wave",
			description = "enable highlight for Fire Wave"
	)
	default boolean fireWaveHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "firesurge",
			name = "Fire Surge",
			description = "enable highlight for Fire Surge"
	)
	default boolean fireSurgeHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "entangle",
			name = "Entangle",
			description = "enable highlight for Entangle"
	)
	default boolean entangleHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "teleblock",
			name = "Tele Block",
			description = "enable highlight for Tele Block"
	)
	default boolean teleBlockHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "vengeance",
			name = "Vengeance",
			description = "enable highlight for Vengeance"
	)
	default boolean vengeanceHighlightEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "prayercolor",
			name = "Prayer Color",
			description = "set the highlight color for prayers"
	)
	default Color prayerHighlightColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			keyName = "specialcolor",
			name = "Special Color",
			description = "set the highlight color for the special bar"
	)
	default Color specialHighlightColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			keyName = "magiccolor",
			name = "Magic Color",
			description = "set the highlight color for magic"
	)
	default Color magicHighlightColor()
	{
		return Color.WHITE;
	}
}
