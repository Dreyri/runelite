package net.runelite.client.plugins.playerinfo.buffbar;

public enum FreezeType
{

	ICE_RUSH(8, 361, 375, false),
	ICE_BURST(16, 363, 376, false),
	ICE_BLITZ(24, 367, 377, false),
	ICE_BARRAGE(32, 369, 378, false),

	BIND(8, 181, 369, true),
	SNARE(16, 180, 370, true),
	ENTANGLE(24, 179, 371, true);

	private int ticks;
	private int graphic;
	private int sprite;
	private boolean halfOnPray;

	FreezeType(int tickDuration, int graphicId, int spriteId, boolean halfOnPray)
	{
		this.ticks = tickDuration;
		this.graphic = graphicId;
		this.sprite = spriteId;
		this.halfOnPray = halfOnPray;
	}

	public int getTicks()
	{
		return this.ticks;
	}

	public int getGraphic()
	{
		return this.graphic;
	}

	public int getSprite()
	{
		return this.sprite;
	}

	public boolean isHalvedOnPray()
	{
		return this.halfOnPray;
	}
}
