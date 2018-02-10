package net.runelite.client.plugins.buffbar.listener;

import net.runelite.client.plugins.buffbar.extras.FreezeType;

public interface FreezeListener
{
	void frozen(FreezeType type, int ticks);

	void unfrozen();

	void freezeImmune(int ticks);

	void freezeImmuneLifted();
}
