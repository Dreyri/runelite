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
package net.runelite.client.plugins.buffbar.extras;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum FreezeType
{

	ICE_RUSH("rush", 8, 361, 325, false),
	ICE_BURST("burst", 16, 363, 326, false),
	ICE_BLITZ("blitz", 24, 367, 327, false),
	ICE_BARRAGE("barrage", 32, 369, 328, false),

	BIND("bind", 8, 181, 319, true),
	SNARE("snare", 16, 180, 320, true),
	ENTANGLE("entangle", 24, 179, 321, true);

	private String name;
	private int ticks;
	private int graphic;
	private int sprite;
	private BufferedImage image;
	private boolean halfOnPray;

	FreezeType(String name, int tickDuration, int graphicId, int spriteId, boolean halfOnPray)
	{
		this.name = name;
		this.ticks = tickDuration;
		this.graphic = graphicId;
		this.sprite = spriteId;
		this.image = null;
		this.halfOnPray = halfOnPray;
	}

	public String getName()
	{
		return this.name;
	}

	public int getTicks()
	{
		return this.ticks;
	}

	public int getGraphic()
	{
		return this.graphic;
	}

	public int getSprite()
	{
		return this.sprite;
	}

	public BufferedImage getBufferedImage()
	{
		try
		{
			if (this.image == null)
			{
				this.image = ImageIO.read(FreezeType.class.getResourceAsStream(getName() + ".png"));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return this.image;
	}

	public boolean isHalvedOnPray()
	{
		return this.halfOnPray;
	}
}
