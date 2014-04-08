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

package com.tehforce.sofa.logic;

import com.badlogic.gdx.math.Vector2;
import com.tehforce.sofa.parser.Evaluator;
import com.tehforce.sofa.ui.Log;

/**
 * Character contains all game logic regarding characters.
 * Including:
 * 	* Attacking
 *  * Healing 
 *  * Moving
 *  * Life/Death
 *  * etc.
 * 
 * @author mockillo
 *
 */
public class Character {
	private int hp, maxHp;
	private int damage;
	private int baseDamage;
	private int defense;
	private int baseDefense;
	private Vector2 position;
	private int range;
	private String name;
	private Evaluator evaluator;
	private int cdTimer;
	private int cdMax;
	private int defendTimer = Integer.MAX_VALUE;
	private final int defendDuration = 20;

	/**
	 * @param evaluator The Evaluator object that this instance should use for token requests.
	 * @param hp Base hit points.
	 * @param damage Base damage.
	 * @param defense Base defense.
	 * @param x Starting position (X coordinate).
	 * @param y Starting position (Y coordinate).
	 * @param range Base range.
	 * @param name Class name.
	 * @param cdMax Base maximum cool down.
	 */
	public Character(Evaluator factory, int hp, int damage, int defense,
			float x, float y, int range, String name, int cdMax) {
		this.evaluator = factory;
		this.hp = hp;
		this.maxHp = hp;
		this.damage = damage;
		this.defense = defense;
		this.position = new Vector2(x, y);
		this.range = range;
		this.name = name;
		this.cdMax = cdMax;
		this.cdTimer = cdMax;
		baseDefense = defense;
		baseDamage = damage;
	}

	public int range() {
		return range;
	}

	public int getDamage() {
		return damage;
	}

	public int getDefense() {
		return defense;
	}

	public Vector2 getPosition(){
		return new Vector2(position);
	}

	public void setX(float x) {
		position.x = x;
	}

	public void setY(float y) {
		position.y = y;
	}
	
	public void setPosition(Vector2 pos){
		position = new Vector2(pos);
	}
	
	/**
	 * 
	 * @param c Target character for the operation.
	 * @return The distance between this Character and c.
	 */
	public float distance(Character c) {
		return getPosition().dst(c.getPosition());
	}

	/**
	 * 
	 * @param c Target character for operation.
	 * @return The direction vector to target from this Character instance.
	 */
	public Vector2 direction(Character c) {
		Vector2 direction = new Vector2(0, 0);

		if (c.getPosition().y > getPosition().y)
			direction.add(0, 1);
		if (c.getPosition().y < getPosition().y)
			direction.add(0, -1);
		if (c.getPosition().x > getPosition().x)
			direction.add(1, 0);
		if (c.getPosition().x < getPosition().x)
			direction.add(-1, 0);

		return direction.nor();
	}

	/**
	 * 
	 * @param c Target character for operation.
	 * @return The opposite direction vector to the target. 
	 */
	public Vector2 oppositeDirection(Character c) {
		return direction(c).sub(direction(c).scl(2));
	}

	/**
	 * Checks if this character is in attack range of target c.
	 * 
	 * @param c Target character for operation.
	 * @return
	 */
	public boolean inRange(Character c) {
		return (range() >= distance(c));
	}

	/**
	 * Checks if this character is alive.
	 * 
	 * @return
	 */
	public boolean alive() {
		return (hp > 0);
	}

	/**
	 * Checks if this character is wounded.
	 * 
	 * @return
	 */
	public boolean wounded() {
		return hp < maxHp;
	}

	/**
	 * Finds closest character based on team.
	 * 
	 * @param t Target character team.
	 * @return Closest character on team t.
	 */
	public Character closest(Team t) {
		Character nearest = null;
		float rangeToNearest = Float.MAX_VALUE;

		for (Character c : t.getCharacterList()) {
			if (!getName().matches(c.getName())) {
				if ((rangeToNearest > distance(c)) && c.alive()) {
					nearest = c;
					rangeToNearest = distance(c);
				}
			}
		}

		return nearest;
	}

	/**
	 * Finds farthest character based on team.
	 * 
	 * @param t Target character team.
	 * @return farthest character on team t.
	 */
	public Character farthest(Team t) {
		Character nearest = null;
		float rangeToNearest = Float.MIN_VALUE;

		for (Character c : t.getCharacterList()) {
			if (!getName().matches(c.getName())) {
				if ((rangeToNearest <= distance(c)) && c.alive()) {
					nearest = c;
					rangeToNearest = distance(c);
				}
			}
		}

		return nearest;
	}

	/**
	 * Requests token from factory, and updates cool down.
	 */
	public Token[] getNextTokens() {
		cdTimer++;
		defendTimer++;
		
		if(defendTimer > defendDuration){
			damage = baseDamage;
			defense = baseDefense;
		}

		evaluator.updateTokens();
		return evaluator.getToken(this);
	}

	public String getName() {
		return name;
	}

	public int getCurrentHealth() {
		return hp;
	}

	public int getMaxHealth() {
		return maxHp;
	}

	/**
	 * Attacks target character, if this character is off cool down and if this character is in range of target.
	 * 
	 * @param target Target character for this operation.
	 * @return Boolean result if the attack was successful or not. 
	 */
	public boolean attack(Character target) {
		if (cdTimer >= cdMax){
			if ((distance(target) <= range()) && target.alive()) {
				target.takeDamage(getDamage());
				Log.log("Attack", this, target);
				cdTimer = 0;
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Takes damage from attack. Reduces this characters hit points.
	 * 
	 * @param damage Amount of damage.
	 */
	public void takeDamage(int damage) {
		hp -= Math.abs(damage * (1 - getDefense()));

		if (hp <= 0)
			Log.log("Dies", this);
	}

	/**
	 * Heals target character, if this character is off cool down and in range of target character.
	 * 
	 * @param target Target character of this operation.
	 * @return Boolean result if the heal was successful or not.
	 */
	public boolean heal(Character target) {
		if (cdTimer >= cdMax){
			if (distance(target) <= range() && target.wounded()
					&& target.alive() && this.getClass().equals(Healer.class)) {
				target.takeHealing(getDamage());
				Log.log("Heal", this, target);
				cdTimer = 0;
				return true;
			}
		}

		return false;
	}

	/**
	 * Receive healing, increasing this targets hit points.
	 * @param healing Amount of healing received.
	 */
	private void takeHealing(int healing) {
		if ((hp + healing) > maxHp)
			hp = maxHp;
		else
			hp += healing;
	}

	/**
	 * Start defense mode, doubles defense and halves damage and healing.
	 */
	public void defend() {
		if(defendTimer > defendDuration){
			defense *= 2;
			damage /= 2;
			defendTimer = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
