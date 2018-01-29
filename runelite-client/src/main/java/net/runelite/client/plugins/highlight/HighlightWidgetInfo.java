package net.runelite.client.plugins.highlight;

import net.runelite.api.widgets.WidgetInfo;

public enum HighlightWidgetInfo
{
	SPECIAL(593, 30),

	PIETY(541, 29),
	ULTIMATE_STRENGTH(541, 14),

	CHIVALRY(541, 28),
	INCREDIBLE_REFLEXES(541, 15),

	EAGLE_EYE(541, 26),
	RIGOUR(541, 30),

	MYSTIC_MIGHT(541, 27),
	AUGURY(541, 31),

	PROTECT_RANGED(WidgetInfo.PRAYER_PROTECT_FROM_MISSILES.getGroupId(), WidgetInfo.PRAYER_PROTECT_FROM_MISSILES.getChildId()),
	PROTECT_MAGIC(WidgetInfo.PRAYER_PROTECT_FROM_MAGIC.getGroupId(), WidgetInfo.PRAYER_PROTECT_FROM_MAGIC.getChildId()),
	PROTECT_MELEE(541, 18),

	ANCIENT_ICE_BARRAGE(218, 75),

	MODERN_FIRE_SURGE(218, 70),
	MODERN_FLAMES_OF_ZAMORAK(218, 44),
	MODERN_CLAWS_OF_GUTHIX(218, 43),
	MODERN_SARADOMIN_STRIKE(218, 42),
	MODERN_FIRE_WAVE(218, 57),

	MODERN_ENTANGLE(218, 58),
	MODERN_TELE_BLOCK(218, 64),

	LUNAR_VENGEANCE(218, 138);

	private int groupId;
	private int childId;

	HighlightWidgetInfo(int group, int child)
	{
		this.groupId = group;
		this.childId = child;
	}

	public int getGroupId()
	{
		return this.groupId;
	}

	public int getChildId()
	{
		return this.childId;
	}

}
