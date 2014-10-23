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

package com.tehforce.sofa.ui;

import com.tehforce.sofa.logic.Character;

/**
 * Log provides statically available methods for printing what's going on to the screen.
 * 
 * @author mockillo
 *
 */
public class Log {
	
	/**
	 * Prints a text describing an action between two targets, and their stats at the time.
	 * 
	 * @param tag What happened, ie. ATTACK, HEAL, etc.
	 * @param source Character that performs the action.
	 * @param target Character that is on the receiving end, if any.
	 */
	public static void log(String tag, Character source, Character target) {
		System.out.println("" + tag + "\t: " + source.getName() + " ("
				+ source.getDamage() + "/" + source.getCurrentHealth() + "/"
				+ source.getPosition().x + "/" + source.getPosition().y + ") vs. "
				+ target.getName() + " (" + target.getDamage() + "/"
				+ target.getCurrentHealth() + "/" + target.getPosition().x + "/" + target.getPosition().y
				+ ")");
	}

	/**
	 * Prints a text describing an action with only one character, and it's stats at the time.
	 * 
	 * @param tag What happened, ie. MOVE.
	 * @param source Character that performs the action.
	 */
	public static void log(String tag, Character source) {
		System.out.println("" + tag + "\t: " + source.getName() + " ("
				+ source.getDamage() + "/" + source.getCurrentHealth() + "/"
				+ source.getPosition().x + "/" + source.getPosition().y + ")");
	}
}
