package net.runelite.client.plugins.buffbar;

import net.runelite.api.Renderable;

import java.util.ArrayList;
import java.util.List;

public class BaseBroadcaster<T> implements Broadcaster
{
	private List<T> listeners;

	public BaseBroadcaster()
	{
		listeners = new ArrayList<>();
	}

	@Override
	public boolean accept(Renderable object) {
		return false;
	}
}
