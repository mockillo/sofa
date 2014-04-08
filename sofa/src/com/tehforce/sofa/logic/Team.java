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

import java.util.ArrayList;
import java.util.Random;

/**
 * Team is a container for all characters on a team.
 * 
 * @author mockillo
 *
 */
public class Team {
	private Character w;
	private Character h;
	private Character r;
	ArrayList<Character> cl;

	public Team() {
		cl = new ArrayList<Character>();
	}

	public void setWarrior(Character w) {
		this.w = w;
	}

	public void setHealer(Character h) {
		this.h = h;
	}

	public void setRanger(Character r) {
		this.r = r;
	}

	public Character getWarrior() {
		return w;
	}

	public Character getHealer() {
		return h;
	}

	public Character getRanger() {
		return r;
	}

	public Character getAny() {
		switch (new Random().nextInt(3)) {
		case 0:
			return getWarrior();
		case 1:
			return getHealer();
		default:
			return getRanger();
		}
	}

	public ArrayList<Character> getCharacterList() {
		if (cl.isEmpty()){
			cl.add(w);
			cl.add(h);
			cl.add(r);
		}
		
		return cl;
	}

	/**
	 * Checks if any member of this team is still alive.
	 * @return True if any member is alive, false otherwise.
	 */
	public boolean alive() {
		for (Character c : getCharacterList()) {
			if (c.alive())
				return true;
		}

		return false;
	}

}