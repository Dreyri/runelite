package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Renderable;
import net.runelite.client.plugins.buffbar.Broadcaster;

public interface Adapter
{
	void addBroadcaster(Broadcaster bc);

	boolean removeBroadcaster(Broadcaster bc);

	Renderable getAdaptee();
}
