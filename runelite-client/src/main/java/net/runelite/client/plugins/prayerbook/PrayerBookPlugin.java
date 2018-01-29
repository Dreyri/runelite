package net.runelite.client.plugins.prayerbook;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.time.temporal.ChronoUnit;

@PluginDescriptor(
	name = "Prayer Book plugin"
)
public class PrayerBookPlugin extends Plugin
{
	private static final Logger logger = LoggerFactory.getLogger(PrayerBookPlugin.class);

	@Inject
	Client client;

	@Inject
	PrayerBookPluginConfiguration config;

	@Override
	protected void startUp() throws Exception
	{
		logger.info("Prayer Book plugin started!");
		updatePrayers();
	}

	public void updatePrayers()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			if (config.enabled())
			{
				swapPiety(config.swapPiety());
				swapChivalry(config.swapChivalry());
				swapAugury(config.swapAugury());
				swapRigour(config.swapRigour());
			}
			else
			{
				disablePlugin();
			}
		}
	}

	public void disablePlugin()
	{
		swapPiety(false);
		swapChivalry(false);
		swapAugury(false);
		swapRigour(false);
	}

	@Subscribe
	protected void configChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("prayerbook"))
		{
			updatePrayers();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		swapPiety(false);
		swapChivalry(false);
		swapAugury(false);
		swapRigour(false);
		logger.info("Prayer Book plugin stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{

		if (gameStateChanged.getGameState() == GameState.LOADING)
		{
			updatePrayers();
		}

	}


	public void swapPiety(boolean swap)
	{
		swapPrayers(swap, PrayerBookInfo.PIETY, PrayerBookInfo.ULTIMATE_STRENGTH);
	}

	public void swapChivalry(boolean swap)
	{
		swapPrayers(swap, PrayerBookInfo.CHIVALRY, PrayerBookInfo.INCREDIBLE_REFLEXES);
	}

	public void swapAugury(boolean swap)
	{
		swapPrayers(swap, PrayerBookInfo.AUGURY, PrayerBookInfo.MYSTIC_MIGHT);
	}

	public void swapRigour(boolean swap)
	{
		swapPrayers(swap, PrayerBookInfo.RIGOUR, PrayerBookInfo.EAGLE_EYE);
	}

	public void swapPrayers(boolean swap, PrayerBookInfo pray1, PrayerBookInfo pray2)
	{
		Widget pray1w = client.getWidget(pray1.getGroupId(), pray1.getChildId());
		Widget pray2w = client.getWidget(pray2.getGroupId(), pray2.getChildId());

		if (pray1w == null || pray2w == null)
		{
			return;
		}

		int pray1x = swap ? pray2.getRelativeX() : pray1.getRelativeX();
		int pray1y = swap ? pray2.getRelativeY() : pray1.getRelativeY();

		int pray2x = swap ? pray1.getRelativeX() : pray2.getRelativeX();
		int pray2y = swap ? pray1.getRelativeY() : pray2.getRelativeY();

		pray1w.setRelativeX(pray1x);
		pray1w.setRelativeY(pray1y);

		pray2w.setRelativeX(pray2x);
		pray2w.setRelativeY(pray2y);
	}

	@Override
	public void configure(Binder binder)
	{
	}

	@Schedule(
			period = 100,
			unit = ChronoUnit.MILLIS
	)
	public void scheduledPrayerUpdate()
	{
		if (client.getGameState() == GameState.LOGGED_IN)
			updatePrayers();
	}

	@Provides
	PrayerBookPluginConfiguration provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayerBookPluginConfiguration.class);
	}

}
