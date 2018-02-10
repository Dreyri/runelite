package net.runelite.client.plugins.buffbar.listener;

public interface FreezeListener
{
	void frozen(int ticks);

	void unfrozen();

	void freezeImmune(int ticks);

	void freezeImmuneLifted();
}
