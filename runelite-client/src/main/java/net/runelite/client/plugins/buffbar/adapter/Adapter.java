package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.client.plugins.buffbar.Broadcaster;

public interface Adapter
{
	public void addBroadcaster(Broadcaster bc);

	public boolean removeBroadcaster(Broadcaster bc);
}
