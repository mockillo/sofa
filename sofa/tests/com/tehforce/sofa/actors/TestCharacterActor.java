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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.tehforce.sofa.logic.CharacterState;
import com.tehforce.sofa.logic.Healer;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.Token;
import com.tehforce.sofa.logic.Warrior;

public class TestCharacterActor {

	Character c;
	CharacterActor ca;
	
	@Before
	public void setUp() throws Exception {
		c = new Healer(null, 5, 5, "RH", 0);
		ca = new CharacterActor(c, true);
	}

	@Test
	public void testMovingAbsolute() {	
		ca.move(10,10);
		assertEquals(new Vector2(10, 10), c.getPosition());
	}
	
	@Test
	public void testMovingRoaming(){
		Vector2 position = c.getPosition();
		ca.move();
		assertNotEquals(position, c.getPosition());
	}
	
	@Test
	public void testMovingToken(){
		Vector2 position = c.getPosition();
		Token t = new Token("Move", new Vector2(15, 16));
		ca.move(t);
		assertNotEquals(position, c.getPosition());
		assertTrue(c.getPosition().x > position.x && c.getPosition().y > position.y);
	}
	
	@Test
	public void testAnimationState(){
		ca.deltaTime = 0.25;
		ca.state = CharacterState.ATTACK;
		
		// Forcing update of draw state.
		ca.timeSinceDrawUpdate = 0.25;
		
		for(int i = 0; i < 100; i++){
			ca.updateAnimation();
			assertTrue(ca.framenumber >= 3);
			assertTrue(ca.framenumber < 5);
		}
		
		ca.state = CharacterState.MOVE;
		
		for(int i = 0; i < 100; i++){
			ca.updateAnimation();
			assertTrue(ca.framenumber >= 0);
			assertTrue(ca.framenumber < 3);
		}
	}
	
	@Test
	public void testUnsetOfAttackState(){
		ca.state = CharacterState.ATTACK;
		ca.timeSinceAttack = 0.0;
		ca.performMove(new Token("Move", new Vector2(0, 0)));
		assertTrue(ca.state == CharacterState.ATTACK);
		ca.timeSinceAttack = 0.6;
		ca.performRoam();
		assertFalse(ca.state == CharacterState.ATTACK);
	}
	
	@Test
	public void testSetOfAttackState(){
		ca.state = CharacterState.MOVE;
		Character w = new Warrior(null, 0, 0, "W", 10);
		w.takeDamage(10);
		
		ca.performAttack(new Token("Heal", w));
		assertTrue(ca.state == CharacterState.ATTACK);
	}
}
