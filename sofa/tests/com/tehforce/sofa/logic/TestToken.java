package com.tehforce.sofa.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class TestToken {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTokenEquals() {
		Warrior w = new Warrior(null, 1, 2, "Warrior1", 30);
		Warrior w2 = new Warrior(null, 1, 2, "Warrior2", 30);
		
		Token t1 = new Token("Move");
		Token t2 = new Token("Move", new Vector2());
		
		Token t3 = new Token("Attack", w);
		Token t4 = new Token("Attack", w);
		Token t5 = new Token("Attack", w2);
		
		assertEquals(t1, t2);
		assertEquals(t3, t4);
		assertNotEquals(t1, t4);
		assertNotEquals(t3, t2);
		assertNotEquals(t1, null);
		assertNotEquals(t5, t3);
	}
}
