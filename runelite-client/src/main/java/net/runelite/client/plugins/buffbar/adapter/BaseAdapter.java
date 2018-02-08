package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.client.plugins.buffbar.Broadcaster;

import java.util.List;

public abstract class BaseAdapter implements Adapter
{
	private List<Broadcaster> broadcasters;

	private boolean isValid;

	@Override
	public void addBroadcaster(Broadcaster bc)
	{
		if (!bc.accept(this.getAdaptee()))
		{
			throw new IllegalArgumentException("The broadcaster does not accept this Adapter");
		}
		this.broadcasters.add(bc);
	}

	@Override
	public boolean removeBroadcaster(Broadcaster bc)
	{
		return this.broadcasters.remove(bc);
	}

	@Override
	public boolean isValid()
	{
		return this.isValid;
	}

	@Override
	public void invalidate()
	{
		this.isValid = false;
	}
}
