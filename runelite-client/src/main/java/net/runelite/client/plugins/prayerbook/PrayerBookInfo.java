package net.runelite.client.plugins.prayerbook;

public enum PrayerBookInfo
{

	PIETY(541, 29, 37, 185),
	ULTIMATE_STRENGTH(541, 14, 148, 74),

	CHIVALRY(541, 28, 0, 185),
	INCREDIBLE_REFLEXES(541, 15, 0, 111),

	RIGOUR(541, 30, 74, 185),
	EAGLE_EYE(541, 26, 148, 111),

	AUGURY(541, 31, 111, 185),
	MYSTIC_MIGHT(541, 27, 0, 148);


	private int groupId;
	private int childId;

	private int relativeX;
	private int relativeY;

	PrayerBookInfo(int groupId, int childId, int relativeX, int relativeY)
	{
		this.groupId = groupId;
		this.childId = childId;

		this.relativeX = relativeX;
		this.relativeY = relativeY;
	}



	public int getGroupId()
	{
		return this.groupId;
	}

	public int getChildId()
	{
		return this.childId;
	}

	public int getRelativeX()
	{
		return this.relativeX;
	}

	public int getRelativeY()
	{
		return this.relativeY;
	}
}
