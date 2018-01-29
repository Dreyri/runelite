package net.runelite.client.plugins.highlight;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class HighlightOverlay extends Overlay
{
	private HighlightPlugin plugin;
	private Client client;

	@Inject
	public HighlightOverlay(@Nullable Client client, HighlightPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics2D, Point point)
	{

		if (!plugin.config.enabled())
			return null;

		graphics2D.setColor(plugin.config.prayerHighlightColor());

		if (plugin.config.pietyHighlightEnabled())
		{
			if (plugin.pietyWidget != null)
			{
				graphics2D.draw(plugin.pietyWidget.getBounds());
			}
		}

		if (plugin.config.chivalryHighlightEnabled())
		{
			if (plugin.chivalryWidget != null)
			{
				graphics2D.draw(plugin.chivalryWidget.getBounds());
			}
		}

		if (plugin.config.ultimateStrengthHighlightEnabled())
		{
			if (plugin.ultimateStrengthWidget != null)
			{
				graphics2D.draw(plugin.ultimateStrengthWidget.getBounds());
			}
		}

		if (plugin.config.incredibleReflexesHighlightEnabled())
		{
			if (plugin.incredibleReflexesWidget != null)
			{
				graphics2D.draw(plugin.incredibleReflexesWidget.getBounds());
			}
		}

		if (plugin.config.eagleHighlightEnabled())
		{
			if (plugin.eagleWidget != null)
			{
				graphics2D.draw(plugin.eagleWidget.getBounds());
			}
		}

		if (plugin.config.rigourHighlightEnabled())
		{
			if (plugin.rigourWidget != null)
			{
				graphics2D.draw(plugin.rigourWidget.getBounds());
			}
		}

		if (plugin.config.mysticHighlightEnabled())
		{
			if (plugin.mysticWidget != null)
			{
				graphics2D.draw(plugin.mysticWidget.getBounds());
			}
		}

		if (plugin.config.auguryHighlightEnabled())
		{
			if (plugin.auguryWidget != null)
			{
				graphics2D.draw(plugin.auguryWidget.getBounds());
			}
		}

		if (plugin.config.protMagicHighlightEnabled())
		{
			if (plugin.protMagicWidget != null)
			{
				graphics2D.draw(plugin.protMagicWidget.getBounds());
			}
		}

		if (plugin.config.protRangedHighlightEnabled())
		{
			if (plugin.protRangedWidget != null)
			{
				graphics2D.draw(plugin.protRangedWidget.getBounds());
			}
		}

		if (plugin.config.protMeleeHighlightEnabled())
		{
			if (plugin.protMeleeWidget != null)
			{
				graphics2D.draw(plugin.protMeleeWidget.getBounds());
			}
		}

		graphics2D.setColor(plugin.config.magicHighlightColor());

		if (plugin.config.iceBarrageHighlightEnabled())
		{
			if (plugin.iceBarrageWidget != null)
			{
				graphics2D.draw(plugin.iceBarrageWidget.getBounds());
			}
		}

		if (plugin.config.saradominStrikeHighlightEnabled())
		{
			if (plugin.saradominStrikeWidget != null)
			{
				graphics2D.draw(plugin.saradominStrikeWidget.getBounds());
			}
		}

		if (plugin.config.clawsGuthixHighlightEnabled())
		{
			if (plugin.clawsGuthixWidget != null)
			{
				graphics2D.draw(plugin.clawsGuthixWidget.getBounds());
			}
		}

		if (plugin.config.flamesZamorakHighlightEnabled())
		{
			if (plugin.flamesZamorakWidget != null)
			{
				graphics2D.draw(plugin.flamesZamorakWidget.getBounds());
			}
		}

		if (plugin.config.fireWaveHighlightEnabled())
		{
			if (plugin.fireWaveWidget != null)
			{
				graphics2D.draw(plugin.fireWaveWidget.getBounds());
			}
		}

		if (plugin.config.fireSurgeHighlightEnabled() && plugin.fireSurgeWidget != null)
		{
			graphics2D.draw(plugin.fireSurgeWidget.getBounds());
		}

		if (plugin.config.entangleHighlightEnabled() && plugin.entangleWidget != null)
		{
			graphics2D.draw(plugin.entangleWidget.getBounds());
		}

		if (plugin.config.teleBlockHighlightEnabled() && plugin.teleBlockWidget != null)
		{
			graphics2D.draw(plugin.teleBlockWidget.getBounds());
		}

		if (plugin.config.vengeanceHighlightEnabled() && plugin.vengeanceWidget != null)
		{
			graphics2D.draw(plugin.vengeanceWidget.getBounds());
		}

		graphics2D.setColor(plugin.config.specialHighlightColor());

		if (plugin.config.specialHighlightEnabled() && plugin.specialWidget != null)
		{
			graphics2D.draw(plugin.specialWidget.getBounds());
		}


		return null;
	}
}
