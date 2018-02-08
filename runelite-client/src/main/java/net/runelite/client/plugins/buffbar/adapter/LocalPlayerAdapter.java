package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.Player;
import net.runelite.api.events.VarbitChanged;

public class LocalPlayerAdapter extends PlayerAdapterImpl implements LocalPlayer
{
	public LocalPlayerAdapter(Player player)
	{
		super(player);
	}

	@Override
	public void onVarbitChanged(VarbitChanged event)
	{

	}
}
