package net.runelite.client.plugins.buffbar.adapter;

import net.runelite.api.NPC;
import net.runelite.api.Renderable;

public class NPCAdapter extends BaseAdapter
{
	private NPC npc;

	public NPCAdapter(NPC npc)
	{
		this.npc = npc;
	}

	@Override
	public Renderable getAdaptee()
	{
		return this.npc;
	}

	@Override
	public void invalidate()
	{
		super.invalidate();

		this.npc = null;
	}
}
