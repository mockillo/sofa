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

public class TestTeam {

	Character a, b, c;
	Team t;
	
	@Before
	public void setUp() throws Exception {
		a = mock(Character.class);
		b = mock(Character.class);
		c = mock(Character.class);
		t = new Team();
		
		t.setHealer(a);
		t.setRanger(b);
		t.setWarrior(c);
		
		when(a.alive()).thenReturn(true);
		when(b.alive()).thenReturn(true);
		when(c.alive()).thenReturn(true);
	}

	@Test
	public void testAlive() {
		assertTrue(t.alive());
		
		when(a.alive()).thenReturn(false);
		
		assertTrue(t.alive());
		
		when(b.alive()).thenReturn(false);
		
		assertTrue(t.alive());
		
		when(c.alive()).thenReturn(false);
		
		assertFalse(t.alive());
	}
}
