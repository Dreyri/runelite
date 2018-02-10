/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.buffbar;

import net.runelite.client.plugins.buffbar.extras.FreezeType;
import net.runelite.client.plugins.buffbar.listener.FreezeListener;

import java.awt.image.BufferedImage;

public class FreezeBuff extends TimerBuff implements FreezeListener
{
	private FreezeType freezeType;

	int ticks;

	private boolean immune;
	private boolean active;

	public FreezeBuff()
	{
		super();

		ticks = 0;
		freezeType = null;
		active = false;
		immune = false;
	}

	@Override
	public int getTicks()
	{
		return ticks;
	}

	@Override
	public BuffType getType()
	{
		if (immune)
			return BuffType.BUFF;
		else
			return BuffType.DEBUFF;
	}

	@Override
	public boolean isActive()
	{
		return active;
	}

	@Override
	public BufferedImage getIcon()
	{
		if (freezeType != null)
		{
			return freezeType.getBufferedImage();
		}
		else
		{
			return FreezeType.ICE_BARRAGE.getBufferedImage();
		}

		//return null;
	}

	@Override
	public void frozen(FreezeType type, int ticks)
	{
		this.freezeType = type;
		this.ticks = ticks;
		this.active = active;
	}

	@Override
	public void unfrozen()
	{
		this.active = false;
		this.ticks = 0;
	}

	@Override
	public void freezeImmune(int ticks)
	{
		this.active = true;
		this.ticks = ticks;
		this.immune = true;
	}

	@Override
	public void freezeImmuneLifted()
	{
		this.active = false;
		this.ticks = 0;
		this.immune = false;
	}
}
