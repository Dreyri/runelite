/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api.widgets;

public enum WidgetInfo
{
	LOGOUT_BUTTON(WidgetID.LOGOUT_PANEL_ID, WidgetID.LogoutPanel.LOGOUT_BUTTON),

	INVENTORY(WidgetID.INVENTORY_GROUP_ID, 0),

	WORLD_MAP(WidgetID.WORLD_MAP_MENU_GROUP_ID, WidgetID.WorldMap.OPTION),

	CLUE_SCROLL_TEXT(WidgetID.CLUE_SCROLL_GROUP_ID, WidgetID.Cluescroll.CLUE_TEXT),

	QUICK_PRAYER_ORB(WidgetID.MINIMAP_GROUP_ID, WidgetID.Minimap.QUICK_PRAYER_ORB),

	EQUIPMENT(WidgetID.EQUIPMENT_GROUP_ID, 0),

	EQUIPMENT_HELMET(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.HELMET),
	EQUIPMENT_CAPE(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.CAPE),
	EQUIPMENT_AMULET(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.AMULET),
	EQUIPMENT_WEAPON(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.WEAPON),
	EQUIPMENT_BODY(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.BODY),
	EQUIPMENT_SHIELD(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.SHIELD),
	EQUIPMENT_LEGS(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.LEGS),
	EQUIPMENT_GLOVES(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.GLOVES),
	EQUIPMENT_BOOTS(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.BOOTS),
	EQUIPMENT_RING(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.RING),
	EQUIPMENT_AMMO(WidgetID.EQUIPMENT_GROUP_ID, WidgetID.Equipment.AMMO),

	DIARY_LIST(WidgetID.DIARY_GROUP_ID, 4),

	PESTCONTROL_PURPLE_SHIELD(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.PURPLE_SHIELD),
	PESTCONTROL_BLUE_SHIELD(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.BLUE_SHIELD),
	PESTCONTROL_YELLOW_SHIELD(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.YELLOW_SHIELD),
	PESTCONTROL_RED_SHIELD(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.RED_SHIELD),
	PESTCONTROL_PURPLE_HEALTH(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.PURPLE_HEALTH),
	PESTCONTROL_BLUE_HEALTH(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.BLUE_HEALTH),
	PESTCONTROL_YELLOW_HEALTH(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.YELLOW_HEALTH),
	PESTCONTROL_RED_HEALTH(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.RED_HEALTH),
	PESTCONTROL_PURPLE_ICON(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.PURPLE_ICON),
	PESTCONTROL_BLUE_ICON(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.BLUE_ICON),
	PESTCONTROL_YELLOW_ICON(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.YELLOW_ICON),
	PESTCONTROL_RED_ICON(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.RED_ICON),
	PESTCONTROL_ACTIVITY_BAR(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.ACTIVITY_BAR),
	PESTCONTROL_ACTIVITY_PROGRESS(WidgetID.PESTRCONTROL_GROUP_ID, WidgetID.PestControl.ACTIVITY_PROGRESS),

	VOLCANICMINE_GENERAL_INFOBOX_GROUP(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.GENERAL_INFOBOX_GROUP_ID),
	VOLCANICMINE_TIME_LEFT(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.TIME_LEFT),
	VOLCANICMINE_POINTS(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.POINTS),
	VOLCANICMINE_STABILITY(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.STABILITY),
	VOLCANICMINE_PLAYER_COUNT(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.PLAYER_COUNT),
	VOLCANICMINE_VENTS_INFOBOX_GROUP(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENTS_INFOBOX_GROUP_ID),
	VOLCANICMINE_VENT_A_PERCENTAGE(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_A_PERCENTAGE),
	VOLCANICMINE_VENT_B_PERCENTAGE(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_B_PERCENTAGE),
	VOLCANICMINE_VENT_C_PERCENTAGE(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_C_PERCENTAGE),
	VOLCANICMINE_VENT_A_STATUS(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_A_STATUS),
	VOLCANICMINE_VENT_B_STATUS(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_B_STATUS),
	VOLCANICMINE_VENT_C_STATUS(WidgetID.VOLCANIC_MINE_GROUP_ID, WidgetID.VolcanicMine.VENT_C_STATUS),

	CLAN_CHAT_TITLE(WidgetID.CLAN_CHAT_GROUP_ID, WidgetID.ClanChat.TITLE),
	CLAN_CHAT_NAME(WidgetID.CLAN_CHAT_GROUP_ID, WidgetID.ClanChat.NAME),
	CLAN_CHAT_OWNER(WidgetID.CLAN_CHAT_GROUP_ID, WidgetID.ClanChat.OWNER),

	BANK_ITEM_CONTAINER(WidgetID.BANK_GROUP_ID, WidgetID.Bank.ITEM_CONTAINER),
	BANK_INVENTORY_ITEMS_CONTAINER(WidgetID.BANK_INVENTORY_GROUP_ID, WidgetID.Bank.INVENTORY_ITEM_CONTAINER),
	DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER(WidgetID.DEPOSIT_BOX_GROUP_ID, WidgetID.DepositBox.INVENTORY_ITEM_CONTAINER),

	SHOP_ITEMS_CONTAINER(WidgetID.SHOP_GROUP_ID, WidgetID.Shop.ITEMS_CONTAINER),
	SHOP_INVENTORY_ITEMS_CONTAINER(WidgetID.SHOP_INVENTORY_GROUP_ID, WidgetID.Shop.INVENTORY_ITEM_CONTAINER),

	RUNE_POUCH_ITEM_CONTAINER(WidgetID.RUNE_POUCH_GROUP_ID, 0),

	MINIMAP_XP_ORB(WidgetID.MINIMAP_GROUP_ID, WidgetID.Minimap.XP_ORB),
	MINIMAP_PRAYER_ORB(WidgetID.MINIMAP_GROUP_ID, WidgetID.Minimap.PRAYER_ORB),
	MINIMAP_RUN_ORB(WidgetID.MINIMAP_GROUP_ID, WidgetID.Minimap.RUN_ORB),

	LOGIN_CLICK_TO_PLAY_SCREEN(WidgetID.LOGIN_CLICK_TO_PLAY_GROUP_ID, 0),

	FIXED_VIEWPORT(WidgetID.FIXED_VIEWPORT_GROUP_ID, WidgetID.Viewport.FIXED_VIEWPORT),
	RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX(WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID, WidgetID.Viewport.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX),
	RESIZABLE_VIEWPORT_BOTTOM_LINE(WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID, WidgetID.Viewport.RESIZABLE_VIEWPORT_BOTTOM_LINE),

	PRAYER_PROTECT_FROM_MAGIC(WidgetID.PRAYER_GROUP_ID, WidgetID.Prayer.PROTECT_FROM_MAGIC),
	PRAYER_PROTECT_FROM_MISSILES(WidgetID.PRAYER_GROUP_ID, WidgetID.Prayer.PROTECT_FROM_MISSILES),

	COMBAT_LEVEL(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.LEVEL),
	COMBAT_STYLE_ONE(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.STYLE_ONE),
	COMBAT_STYLE_TWO(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.STYLE_TWO),
	COMBAT_STYLE_THREE(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.STYLE_THREE),
	COMBAT_STYLE_FOUR(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.STYLE_FOUR),
	COMBAT_SPELLS(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.SPELLS),
	COMBAT_DEFENSIVE_SPELL_BOX(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.DEFENSIVE_SPELL_BOX),
	COMBAT_DEFENSIVE_SPELL_ICON(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.DEFENSIVE_SPELL_ICON),
	COMBAT_DEFENSIVE_SPELL_SHIELD(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.DEFENSIVE_SPELL_SHIELD),
	COMBAT_DEFENSIVE_SPELL_TEXT(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.DEFENSIVE_SPELL_TEXT),
	COMBAT_SPELL_BOX(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.SPELL_BOX),
	COMBAT_SPELL_ICON(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.SPELL_ICON),
	COMBAT_SPELL_TEXT(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.SPELL_TEXT),
	COMBAT_AUTO_RETALIATE_BOX(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.AUTO_RETALIATE_BOX),
	COMBAT_AUTO_RETALIATE_TEXT(WidgetID.COMBAT_GROUP_ID, WidgetID.Combat.AUTO_RETALIATE_TEXT),

	DIALOG_NPC_NAME(WidgetID.DIALOG_NPC_GROUP_ID, WidgetID.DialogNPC.NAME),
	DIALOG_NPC_TEXT(WidgetID.DIALOG_NPC_GROUP_ID, WidgetID.DialogNPC.TEXT),
	DIALOG_NPC_HEAD_MODEL(WidgetID.DIALOG_NPC_GROUP_ID, WidgetID.DialogNPC.HEAD_MODEL),
	DIALOG_NPC_CONTINUE(WidgetID.DIALOG_NPC_GROUP_ID, WidgetID.DialogNPC.CONTINUE),

	PRIVATE_CHAT_MESSAGE(WidgetID.PRIVATE_CHAT, 0),

	SLAYER_REWARDS_TOPBAR(WidgetID.SLAYER_REWARDS_GROUP_ID, WidgetID.SlayerRewards.TOP_BAR),

	CHATBOX(WidgetID.CHATBOX_GROUP_ID, 0),
	CHATBOX_MESSAGES(WidgetID.CHATBOX_GROUP_ID, WidgetID.Chatbox.CHATBOX_MESSAGES),
	CHATBOX_BUTTONS(WidgetID.CHATBOX_GROUP_ID, WidgetID.Chatbox.CHATBOX_BUTTONS),
	CHATBOX_REPORT_TEXT(WidgetID.CHATBOX_GROUP_ID, WidgetID.Chatbox.CHATBOX_REPORT_TEXT),

	BA_HEAL_WAVE_TEXT(WidgetID.BA_HEALER_GROUP_ID, WidgetID.BarbarianAssault.CURRENT_WAVE),
	BA_HEAL_CALL_TEXT(WidgetID.BA_HEALER_GROUP_ID, WidgetID.BarbarianAssault.TO_CALL),
	BA_HEAL_LISTEN_TEXT(WidgetID.BA_HEALER_GROUP_ID, WidgetID.BarbarianAssault.CORRECT_STYLE),
	BA_HEAL_ROLE_TEXT(WidgetID.BA_HEALER_GROUP_ID, WidgetID.BarbarianAssault.ROLE),
	BA_HEAL_ROLE_SPRITE(WidgetID.BA_HEALER_GROUP_ID, WidgetID.BarbarianAssault.ROLE_SPRITE),

	BA_COLL_WAVE_TEXT(WidgetID.BA_COLLECTOR_GROUP_ID, WidgetID.BarbarianAssault.CURRENT_WAVE),
	BA_COLL_CALL_TEXT(WidgetID.BA_COLLECTOR_GROUP_ID, WidgetID.BarbarianAssault.TO_CALL),
	BA_COLL_LISTEN_TEXT(WidgetID.BA_COLLECTOR_GROUP_ID, WidgetID.BarbarianAssault.CORRECT_STYLE),
	BA_COLL_ROLE_TEXT(WidgetID.BA_COLLECTOR_GROUP_ID, WidgetID.BarbarianAssault.ROLE),
	BA_COLL_ROLE_SPRITE(WidgetID.BA_COLLECTOR_GROUP_ID, WidgetID.BarbarianAssault.ROLE_SPRITE),

	BA_ATK_WAVE_TEXT(WidgetID.BA_ATTACKER_GROUP_ID, WidgetID.BarbarianAssault.CURRENT_WAVE),
	BA_ATK_CALL_TEXT(WidgetID.BA_ATTACKER_GROUP_ID, WidgetID.BarbarianAssault.ATK.TO_CALL),
	BA_ATK_LISTEN_TEXT(WidgetID.BA_ATTACKER_GROUP_ID, WidgetID.BarbarianAssault.CORRECT_STYLE),
	BA_ATK_ROLE_TEXT(WidgetID.BA_ATTACKER_GROUP_ID, WidgetID.BarbarianAssault.ATK.ROLE),
	BA_ATK_ROLE_SPRITE(WidgetID.BA_ATTACKER_GROUP_ID, WidgetID.BarbarianAssault.ATK.ROLE_SPRITE),

	BA_DEF_WAVE_TEXT(WidgetID.BA_DEFENDER_GROUP_ID, WidgetID.BarbarianAssault.CURRENT_WAVE),
	BA_DEF_CALL_TEXT(WidgetID.BA_DEFENDER_GROUP_ID, WidgetID.BarbarianAssault.TO_CALL),
	BA_DEF_LISTEN_TEXT(WidgetID.BA_DEFENDER_GROUP_ID, WidgetID.BarbarianAssault.CORRECT_STYLE),
	BA_DEF_ROLE_TEXT(WidgetID.BA_DEFENDER_GROUP_ID, WidgetID.BarbarianAssault.ROLE),
	BA_DEF_ROLE_SPRITE(WidgetID.BA_DEFENDER_GROUP_ID, WidgetID.BarbarianAssault.ROLE_SPRITE),

	LEVEL_UP(WidgetID.LEVEL_UP_GROUP_ID, 0),
	LEVEL_UP_SKILL(WidgetID.LEVEL_UP_GROUP_ID, WidgetID.LevelUp.SKILL),
	LEVEL_UP_LEVEL(WidgetID.LEVEL_UP_GROUP_ID, WidgetID.LevelUp.LEVEL),

	HUNTER_LEVEL_UP(WidgetID.HUNTER_LEVEL_UP_GROUP_ID, 0),
	HUNTER_LEVEL_UP_SKILL(WidgetID.HUNTER_LEVEL_UP_GROUP_ID, WidgetID.LevelUp.SKILL),
	HUNTER_LEVEL_UP_LEVEL(WidgetID.HUNTER_LEVEL_UP_GROUP_ID, WidgetID.LevelUp.LEVEL),

	QUEST_COMPLETED(WidgetID.QUEST_COMPLETED_GROUP_ID, 0),
	QUEST_COMPLETED_NAME_TEXT(WidgetID.QUEST_COMPLETED_GROUP_ID, WidgetID.QuestCompleted.NAME_TEXT),

	MOTHERLODE_MINE(WidgetID.MOTHERLODE_MINE_GROUP_ID, 0),

	PUZZLE_BOX(WidgetID.PUZZLE_BOX_GROUP_ID, WidgetID.PuzzleBox.VISIBLE_BOX),

	NIGHTMARE_ZONE(WidgetID.NIGHTMARE_ZONE_GROUP_ID, 1),

	BLAST_FURNACE_COFFER(WidgetID.BLAST_FURNACE_GROUP_ID, 0);

	private final int groupId;
	private final int childId;

	WidgetInfo(int groupId, int childId)
	{
		this.groupId = groupId;
		this.childId = childId;
	}

	public int getId()
	{
		return groupId << 16 | childId;
	}

	public int getGroupId()
	{
		return groupId;
	}

	public int getChildId()
	{
		return childId;
	}

	public int getPackedId()
	{
		return groupId << 16 | childId;
	}

	public static int TO_GROUP(int id)
	{
		return id >>> 16;
	}

	public static int TO_CHILD(int id)
	{
		return id & 0xFFFF;
	}

	public static int PACK(int groupId, int childId)
	{
		return groupId << 16 | childId;
	}

}
