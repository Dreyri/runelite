package net.runelite.client.plugins.buffbar.extras;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum OverheadIcon
{
	NONE(-1),
	PROTECT_MELEE(0),
	PROTECT_RANGED(1),
	PROTECT_MAGIC(2),
	RETRIBUTION(3),
	REDEMPTION(5),
	SMITE(4);

	private int id;

	OverheadIcon(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}

	public static OverheadIcon fromInteger(int overheadId)
	{
		if (overheadId == PROTECT_MELEE.getId())
			return PROTECT_MELEE;
		if (overheadId == PROTECT_RANGED.getId())
			return PROTECT_RANGED;
		if (overheadId == PROTECT_MAGIC.getId())
			return PROTECT_MAGIC;
		if (overheadId == RETRIBUTION.getId())
			return RETRIBUTION;
		if (overheadId == REDEMPTION.getId())
			return REDEMPTION;
		if (overheadId == SMITE.getId())
			return SMITE;
		if (overheadId == NONE.getId())
			return NONE;
		else //failsafe
			return NONE;
	}

}
