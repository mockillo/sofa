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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.tehforce.sofa.logic.Healer;
import com.tehforce.sofa.logic.Ranger;
import com.tehforce.sofa.logic.Team;
import com.tehforce.sofa.logic.Warrior;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.parser.Evaluator;

public class TestCharacter {

	Team red, blue;
	
	Warrior rw, bw;
	Healer rh, bh;
	Ranger rr, br;
	
	Evaluator e;

	@Before
	public void setUp() throws Exception {
		e = mock(Evaluator.class);
		red = new Team();
		blue = new Team();
		
		rw = new Warrior(null, 10, 10, "RW", 0);
		bw = new Warrior(null, 10, 10, "BW", 0);
		
		rh = new Healer(null, 10, 4, "RH", 0);
		bh = new Healer(null, 10, 16, "BH", 0);
		
		rr = new Ranger(null, 10, 7, "RR", 0);
		br = new Ranger(null, 10, 13, "BR", 0);
		
		red.setHealer(rh);
		red.setWarrior(rw);
		red.setRanger(rr);
		
		blue.setHealer(bh);
		blue.setWarrior(bw);
		blue.setRanger(br);
	}

	@Test
	public void testAttack() {
		rr.attack(bh);
		assertTrue(bh.getCurrentHealth() < bh.getMaxHealth());
	}

	@Test
	public void testHeal() {
		bw.attack(rw);
		int afterAttack = rw.getCurrentHealth();
		rh.heal(rw);
		assertTrue(rw.getCurrentHealth() > afterAttack);
	}

	@Test
	public void testDistance() {
		assertEquals(12.0, rh.distance(bh), 0.0);
		assertEquals(0.0, rh.distance(rh), 0.0);
	}
	
	@Test
	public void testRange() {
		assertTrue(rh.inRange(rr));
		assertTrue(bh.inRange(br));
		assertFalse(rh.inRange(bh));
	}
	
	@Test
	public void testClosest() {
		Character closestFriendly = rh.closest(red);
		Character closestEnemy = rh.closest(blue);
		
		assertEquals(rr, closestFriendly);
		assertEquals(bw, closestEnemy);
	}
	
	@Test
	public void testFarthest() {
		Character farthestFriendly = bh.farthest(blue);
		Character farthestEnemy = bh.farthest(red);
		
		assertEquals(bw, farthestFriendly);
		assertEquals(rh, farthestEnemy);
	}
	
	@Test
	public void testEquals(){
		Character bbh = new Healer(null, 0, 0, "BH", 0);
		assertEquals(bbh, bh);
		assertNotEquals(bbh, bw);
		assertNotEquals(rh, br);
	}
	
	@Test 
	public void testDefense(){
		Character w = new Warrior(e, 1, 2, "W", 0);
		int damage = w.getDamage(), defense = w.getDefense();
		w.defend();
		w.defend();
		w.defend();
		assertEquals((double) damage/2, w.getDamage(), 0.1f);
		assertEquals((double) defense*2, w.getDefense(), 0.1f);
		
		for(int i = 0; i < 21; i++){
			w.getNextTokens();
		}
		
		assertEquals(damage, w.getDamage(), 0.1f);
		assertEquals(defense, w.getDefense(), 0.1f);
	}
	
	@Test
	public void testCoolDown(){
		Character w = new Warrior(null, 0, 0, "W", 10);
		Character h = new Healer(null, 0, 0, "H", 10);
		
		assertTrue(w.attack(h));
		assertFalse(w.attack(h));
	}
	
	@Test
	public void testNonHealerCantHeal(){
		Character w = new Warrior(null,  0, 0, "W", 10);
		Character r = new Ranger(null, 0, 0, "R", 10);
		
		w.takeDamage(10);
		assertFalse(r.heal(w));
	}
}
