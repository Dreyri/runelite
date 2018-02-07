package net.runelite.client.plugins.playerinfo.buffbar;

public abstract class TimerBuff implements Buff
{
	private boolean useTicks;

	public TimerBuff()
	{
		this(true);
	}

	public TimerBuff(boolean useTicks)
	{
		this.useTicks = useTicks;
	}

	public boolean usingTicks()
	{
		return useTicks;
	}

	public void useTicks(boolean useTicks)
	{
		this.useTicks = useTicks;
	}

	public abstract int getTicks();

	public int getSeconds()
	{
		int ticks = getTicks();

		return (int)((float)ticks / 0.6f);
	}

	public String getText()
	{

		if (useTicks)
		{
			int ticks = getTicks();
			return String.valueOf(ticks);
		}
		else
		{
			int seconds = getSeconds();
			return secondsToHoursMinutesSeconds(seconds);
		}

	}

	public static String secondsToHoursMinutesSeconds(int seconds)
	{
		if (seconds < 60)
		{
			return String.valueOf(seconds);
		}
		else if (seconds < 3600)
		{
			return String.format("%d:%02d", seconds / 60, seconds % 60);
		}
		else
		{
			return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
		}
	}
}
