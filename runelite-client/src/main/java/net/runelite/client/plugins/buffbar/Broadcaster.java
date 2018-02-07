package net.runelite.client.plugins.buffbar;

import net.runelite.api.Renderable;

public interface Broadcaster
{
	/**
	 * decides whether or not this broadcaster can attach to the specified renderable object
	 * @param object the renderable we want to attach to
	 * @return true if we can attach
	 */
	boolean accept(Renderable object);
}
