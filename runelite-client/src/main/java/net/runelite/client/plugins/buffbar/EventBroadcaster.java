package net.runelite.client.plugins.buffbar;

public interface EventBroadcaster<T>
{
	void broadcast(T listener);
}
