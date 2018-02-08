package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.client.plugins.buffbar.broadcaster.FreezeBroadcaster;

public class PlayerAdapterNew
{
	private FreezeBroadcaster freeze;

	public void onGraphicChanged(int graphic)
	{

	}

	public onGameTick()
	{
		freeze.tick();
	}
}
