package net.runelite.client.plugins.buffbar;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseBroadcaster<T> implements Broadcaster
{
	private List<T> listeners;

	public BaseBroadcaster()
	{
		listeners = new ArrayList<>();
	}

	public boolean addListener(T listener)
	{
		return listeners.add(listener);
	}

	public boolean removeListener(T listener)
	{
		return listeners.remove(listener);
	}

	public void broadcastEvent(EventBroadcaster<T> broadcast)
	{
		log.info("broadcasting to {} listeners", listeners.size());
		for (T listener : listeners)
		{
			broadcast.broadcast(listener);
		}
	}
}
