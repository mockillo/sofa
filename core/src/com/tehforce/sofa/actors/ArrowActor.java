/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Alexander Polden
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

package com.tehforce.sofa.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tehforce.sofa.GameController;
import com.tehforce.sofa.logic.Character;

/**
 * ArrowActor is responsible for drawing each arrow on the screen.
 * 
 * @author mockillo
 */
public class ArrowActor extends Actor {
	TextureRegion texture;
	Vector2 start, destination, direction;

	/**
	 * 
	 * @param source The character that shoots the arrow.
	 * @param target The target character, ie. where the arrow should fly to.
	 */
	public ArrowActor(Character source, Character target) {
		start = new Vector2(gamePosToScreenPos(source.getPosition().x), gamePosToScreenPos(source.getPosition().y));
		destination = new Vector2(gamePosToScreenPos(target.getPosition().x), gamePosToScreenPos(target.getPosition().y));
		direction = new Vector2(destination).sub(start).nor();
		
		setPosition(start.x, start.y);

		texture = new TextureRegion(GameController.getAssets().get(
				"data/arrow.png", Texture.class));
	}

	/**
	 * Calculates the rotation of the sprite based on source and destination vectors. 
	 * 
	 * @param s Source point.
	 * @param d Destination point.
	 * @return Correct angle.
	 */
	protected static double calculateRotation(Vector2 s, Vector2 d) {
		float dx = d.x - s.x;
		float dy = d.y - s.y;
		
		return 180 * Math.atan2(-dx, dy) / Math.PI;
	}

	/**
	 * Translates game position to screen position. Screen has 10 times the amount of pixels.
	 * 
	 * @param x Game coordinate to scale. 
	 * @return Screen position.
	 */
	private float gamePosToScreenPos(float x) {
		return x * 10;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		setPosition(getX() + (direction.x * 4), getY() + (direction.y * 4));

		if (new Vector2(getX(), getY()).dst(destination) <= 5)
			remove();

		float rotation = (float) calculateRotation(start, destination);
		
		batch.draw(texture, getX() + 35, getY() + 22, getOriginX(),
				getOriginY(), texture.getRegionWidth(),
				texture.getRegionHeight(), 1, 1, rotation);
	}
}
