package net.runelite.client.plugins.buffbar;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.plugins.buffbar.adapter.Adapter;
import net.runelite.client.plugins.buffbar.adapter.LocalPlayer;
import net.runelite.client.plugins.buffbar.adapter.NPCAdapter;
import net.runelite.client.plugins.buffbar.adapter.PlayerAdapterImpl;

import java.util.List;

public class AdapterManager
{
	private LocalPlayer localPlayer;

	private List<PlayerAdapterImpl> playerAdapters;
	private List<NPCAdapter> npcAdapters;

	/**
	 * necessary for now to avoid reloading after every loading gamestate
	 */
	private GameState lastGameState;


	@Subscribe
	public void onVarbitsChanged(VarbitChanged event)
	{
		localPlayer.onVarbitChanged(event);
	}

	@Subscribe
	public void onGamestateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.HOPPING)
		{
			this.clearNPCs();
		}
	}

	public void clearNPCs()
	{
		//TODO
	}
}
