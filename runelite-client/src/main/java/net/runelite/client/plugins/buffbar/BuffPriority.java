package net.runelite.client.plugins.buffbar;

public enum BuffPriority
{
	FREEZE(10);

	private int priority;

	BuffPriority(int priority)
	{
		this.priority = priority;
	}

	public int getPriority()
	{
		return this.priority;
	}
}
