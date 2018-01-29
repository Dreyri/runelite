package net.runelite.client.plugins.highlight;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.time.temporal.ChronoUnit;

@PluginDescriptor(
		name = "Highlight plugin"
)
public class HighlightPlugin extends Plugin
{
	@Inject
	Client client;

	@Inject
	HighlightPluginConfig config;

	@Inject
	HighlightOverlay overlay;

	Widget specialWidget;

	Widget pietyWidget;
	Widget chivalryWidget;

	Widget ultimateStrengthWidget;
	Widget incredibleReflexesWidget;

	Widget eagleWidget;
	Widget rigourWidget;

	Widget mysticWidget;
	Widget auguryWidget;

	Widget protMagicWidget;
	Widget protRangedWidget;
	Widget protMeleeWidget;

	Widget iceBarrageWidget;


	Widget entangleWidget;
	Widget teleBlockWidget;
	Widget saradominStrikeWidget;
	Widget clawsGuthixWidget;
	Widget flamesZamorakWidget;
	Widget fireWaveWidget;
	Widget fireSurgeWidget;

	Widget vengeanceWidget;

	@Provides
	HighlightPluginConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HighlightPluginConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		retrieveWidgets();
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(HighlightOverlay.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Schedule(
			period = 600,
			unit = ChronoUnit.MILLIS
	)
	public void updateWidgets()
	{
		retrieveWidgets();
	}

	@Subscribe
	public void configChanged(ConfigChanged event)
	{

	}

	public void retrieveWidgets()
	{
		if (client.getGameState() != GameState.LOGGED_IN)
			return;

		if (specialWidget == null && config.specialHighlightEnabled())
			specialWidget = client.getWidget(HighlightWidgetInfo.SPECIAL.getGroupId(), HighlightWidgetInfo.SPECIAL.getChildId());

		if (pietyWidget == null && config.pietyHighlightEnabled())
			pietyWidget = client.getWidget(HighlightWidgetInfo.PIETY.getGroupId(), HighlightWidgetInfo.PIETY.getChildId());

		if (chivalryWidget == null && config.chivalryHighlightEnabled())
			chivalryWidget = client.getWidget(HighlightWidgetInfo.CHIVALRY.getGroupId(), HighlightWidgetInfo.CHIVALRY.getChildId());

		if (ultimateStrengthWidget == null && config.ultimateStrengthHighlightEnabled())
			ultimateStrengthWidget = client.getWidget(HighlightWidgetInfo.ULTIMATE_STRENGTH.getGroupId(), HighlightWidgetInfo.ULTIMATE_STRENGTH.getChildId());

		if (incredibleReflexesWidget == null && config.incredibleReflexesHighlightEnabled())
			incredibleReflexesWidget = client.getWidget(HighlightWidgetInfo.INCREDIBLE_REFLEXES.getGroupId(), HighlightWidgetInfo.INCREDIBLE_REFLEXES.getChildId());

		if (eagleWidget == null && config.eagleHighlightEnabled())
			eagleWidget = client.getWidget(HighlightWidgetInfo.EAGLE_EYE.getGroupId(), HighlightWidgetInfo.EAGLE_EYE.getChildId());

		if (rigourWidget == null && config.rigourHighlightEnabled())
			rigourWidget = client.getWidget(HighlightWidgetInfo.RIGOUR.getGroupId(), HighlightWidgetInfo.RIGOUR.getChildId());

		if (mysticWidget == null && config.mysticHighlightEnabled())
			mysticWidget = client.getWidget(HighlightWidgetInfo.MYSTIC_MIGHT.getGroupId(), HighlightWidgetInfo.MYSTIC_MIGHT.getChildId());

		if (auguryWidget == null && config.auguryHighlightEnabled())
			auguryWidget = client.getWidget(HighlightWidgetInfo.AUGURY.getGroupId(), HighlightWidgetInfo.AUGURY.getChildId());

		if (protMagicWidget == null && config.protMagicHighlightEnabled())
			protMagicWidget = client.getWidget(HighlightWidgetInfo.PROTECT_MAGIC.getGroupId(), HighlightWidgetInfo.PROTECT_MAGIC.getChildId());

		if (protRangedWidget == null && config.protRangedHighlightEnabled())
			protRangedWidget = client.getWidget(HighlightWidgetInfo.PROTECT_RANGED.getGroupId(), HighlightWidgetInfo.PROTECT_RANGED.getChildId());

		if (protMeleeWidget == null && config.protMeleeHighlightEnabled())
			protMeleeWidget = client.getWidget(HighlightWidgetInfo.PROTECT_MELEE.getGroupId(), HighlightWidgetInfo.PROTECT_MELEE.getChildId());

		if (iceBarrageWidget == null && config.iceBarrageHighlightEnabled())
			iceBarrageWidget = client.getWidget(HighlightWidgetInfo.ANCIENT_ICE_BARRAGE.getGroupId(), HighlightWidgetInfo.ANCIENT_ICE_BARRAGE.getChildId());

		if (saradominStrikeWidget == null && config.saradominStrikeHighlightEnabled())
			saradominStrikeWidget = client.getWidget(HighlightWidgetInfo.MODERN_SARADOMIN_STRIKE.getGroupId(), HighlightWidgetInfo.MODERN_SARADOMIN_STRIKE.getChildId());

		if (clawsGuthixWidget == null && config.clawsGuthixHighlightEnabled())
			clawsGuthixWidget = client.getWidget(HighlightWidgetInfo.MODERN_CLAWS_OF_GUTHIX.getGroupId(), HighlightWidgetInfo.MODERN_CLAWS_OF_GUTHIX.getChildId());

		if (flamesZamorakWidget == null && config.flamesZamorakHighlightEnabled())
			flamesZamorakWidget = client.getWidget(HighlightWidgetInfo.MODERN_FLAMES_OF_ZAMORAK.getGroupId(), HighlightWidgetInfo.MODERN_FLAMES_OF_ZAMORAK.getChildId());

		if (fireWaveWidget == null && config.fireWaveHighlightEnabled())
			fireWaveWidget = client.getWidget(HighlightWidgetInfo.MODERN_FIRE_WAVE.getGroupId(), HighlightWidgetInfo.MODERN_FIRE_WAVE.getChildId());

		if (fireSurgeWidget == null && config.fireSurgeHighlightEnabled())
			fireSurgeWidget = client.getWidget(HighlightWidgetInfo.MODERN_FIRE_SURGE.getGroupId(), HighlightWidgetInfo.MODERN_FIRE_SURGE.getChildId());

		if (entangleWidget == null && config.entangleHighlightEnabled())
			entangleWidget = client.getWidget(HighlightWidgetInfo.MODERN_ENTANGLE.getGroupId(), HighlightWidgetInfo.MODERN_ENTANGLE.getChildId());

		if (teleBlockWidget == null && config.teleBlockHighlightEnabled())
			teleBlockWidget = client.getWidget(HighlightWidgetInfo.MODERN_TELE_BLOCK.getGroupId(), HighlightWidgetInfo.MODERN_TELE_BLOCK.getChildId());

		if (vengeanceWidget == null && config.vengeanceHighlightEnabled())
			vengeanceWidget = client.getWidget(HighlightWidgetInfo.LUNAR_VENGEANCE.getGroupId(), HighlightWidgetInfo.LUNAR_VENGEANCE.getChildId());

	}
}
