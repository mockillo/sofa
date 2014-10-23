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

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tehforce.sofa.GameController;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.CharacterState;
import com.tehforce.sofa.logic.Ranger;
import com.tehforce.sofa.logic.Token;
import com.tehforce.sofa.ui.Log;

/**
 * CharacterActor is responsible for drawing each character, 
 * and parsing tokens generated from the TokenFactory.
 * 
 * @author mockillo
 *
 */
public class CharacterActor extends Actor {

	private Character c;
	private TextureRegion[] textures = new TextureRegion[5];
	private TextureRegion red, green;
	protected double timeSinceUpdate;
	protected double timeSinceDrawUpdate;
	protected double timeSinceAttack;
	protected double deltaTime = 0;
	private Token[] tokens;
	protected CharacterState state;
	protected int framenumber = 0;
	
	/**
	 * @param c The character this actor should draw.
	 */
	public CharacterActor(Character c) {
		this.c = c;
		setPosition(gamePosToScreenPos(c.getPosition().x), gamePosToScreenPos(c.getPosition().y));
		readAssets();
		state = CharacterState.MOVE;
	}
	
	/**
	 * @param c The character this actor should draw.
	 */
	protected CharacterActor(Character c, boolean testing) {
		this.c = c;
		setPosition(gamePosToScreenPos(c.getPosition().x), gamePosToScreenPos(c.getPosition().y));
		state = CharacterState.MOVE;
	}

	/**
	 * Sets and controls sprite frame number base on state and time.
	 */
	protected void updateAnimation(){
		if (timeSinceDrawUpdate >= 0.25 && c.alive()) {
			framenumber++;

			switch (state) {
			case ATTACK:
				if (framenumber >= 5 || framenumber < 3)
					framenumber = 3;
				break;
			case MOVE:
				if (framenumber >= 3)
					framenumber = 0;
				break;
			}

			timeSinceDrawUpdate = 0;
		} else {
			timeSinceDrawUpdate += deltaTime;
		}
	}
	
	/**
	 * Requests tokens from the Character, and calls the correct perform-method based on operation.
	 */
	private void readTokens(){
		if (timeSinceUpdate >= 0.25 && c.alive()) {
			tokens = c.getNextTokens();

			for (Token t : tokens) {
				if (t.getOperation().equals("Attack")) 
					performAttack(t);
				else if (t.getOperation().equals("Move")) 
					performMove(t);
				else if (t.getOperation().equals("Heal")) 
					performHeal(t);
				else if (t.getOperation().equals("Defend"))
					performDefend();
				else if (t.getOperation().equals("Roam"))
					performRoam();
			}
			
			timeSinceUpdate = 0;
		} else {
			timeSinceUpdate += deltaTime;
		}
	}
	
	/**
	 * draw calls all methods that need to be called each frame, for animation update and token parsing.
	 * It also draws the graphics for a character based on the frame counter from the animation update.
	 */
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		deltaTime = Gdx.graphics.getDeltaTime();

		updateAnimation();
		readTokens();
		
		if (state == CharacterState.ATTACK)
			timeSinceAttack += deltaTime;

		if (c.alive()){
			batch.draw(textures[framenumber], getX(), getY(), getOriginX(),
					getOriginY(), textures[framenumber].getRegionWidth(),
					textures[framenumber].getRegionHeight(), 1, 1, 0);

			batch.draw(red, getX()+8, getY()+50, 30, 5);
			batch.draw(green, getX()+8, getY()+50, 30.0f * ((float) c.getCurrentHealth()/(float) c.getMaxHealth()), 5);
		}
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

	private void readAssets() {
		for (int i = 0; i < 5; i++)
			textures[i] = new TextureRegion(GameController.getAssets().get(
					"data/" + c.getName() + "" + i + ".png", Texture.class));
		
		red = new TextureRegion(GameController.getAssets().get("data/red.png", Texture.class));
		green = new TextureRegion(GameController.getAssets().get("data/green.png", Texture.class));
	}

	/**
	 * Moves the character based on the content of a token with a move command.
	 * 
	 * @param t Token with move command.
	 */
	protected void move(Token t) {
		if (t.getTarget() != null) {
			moveRelative(c.getPosition().lerp(t.getTarget().getPosition(), 1));
		} else if (t.getTarget() == null && t.getArgument() != null) {
			moveRelative(t.getArgument());
		} else
			move();
	}

	/**
	 * Moves the character along (relatively) a direction vector (unit vector).
	 * 
	 * @param v
	 */
	protected void moveRelative(Vector2 v) {
		setPosition(gamePosToScreenPos(c.getPosition().x + v.x),
				gamePosToScreenPos(c.getPosition().y + v.y));
		moveAbsolute(c.getPosition().x + v.x, c.getPosition().y + v.y);
	}

	/**
	 * Moves the character to an absolute position.
	 * 
	 * @param x
	 * @param y
	 */
	protected void moveAbsolute(float x, float y) {
		setPosition(gamePosToScreenPos(x), gamePosToScreenPos(y));
		c.setX(x);
		c.setY(y);

		Log.log("Move", c);
	}

	/**
	 * Moves a character randomly around. Aka Roam, sort of.
	 */
	protected void move() {
		Random r = new Random();
		int rx = r.nextInt(100) - 50;
		int ry = r.nextInt(100) - 50;
		
		moveRelative(c.getPosition().lerp(new Vector2(rx, ry), 1).nor());
		
		Log.log("Roam", c);
	}
	
	/**
	 * Handles the execution of a attack token
	 * 
	 * @param t Token that contains target
	 */
	protected void performAttack(Token t){
		boolean valid = c.attack(t.getTarget());
		if (valid)
			state = CharacterState.ATTACK;

		if (c.getClass().equals(Ranger.class) && valid) {
			getParent().addActor(new ArrowActor(c, t.getTarget()));
		}
	}
	
	/**
	 * Handles the execution of a move token
	 * 
	 * @param t Token that contains direction
	 */
	protected void performMove(Token t){
		move(t);
		if (timeSinceAttack >= 0.5) {
			state = CharacterState.MOVE;
			timeSinceAttack = 0;
		}
	}
	
	/**
	 * Handles the execution of a heal token
	 * 
	 * @param t Token that contains target
	 */
	protected void performHeal(Token t){
		boolean valid = c.heal(t.getTarget());

		if (valid)
			state = CharacterState.ATTACK;
	}
	
	/**
	 * Handles the execution of a roam token
	 */
	protected void performRoam(){
		move();
		if (timeSinceAttack >= 0.5) {
			state = CharacterState.MOVE;
			timeSinceAttack = 0;
		}
	}
	
	/**
	 * Handles the execution of a defend token
	 */
	private void performDefend(){
		c.defend();
	}
}
