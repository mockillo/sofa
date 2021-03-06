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

package com.tehforce.sofa.parser;

import com.badlogic.gdx.math.Vector2;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.CharacterClass;
import com.tehforce.sofa.logic.Team;
import com.tehforce.sofa.logic.Token;

/**
 * Value is a wrapper for the data passed between methods in the Evaluator.
 * 
 * @author mockillo
 *
 */
public class Value {
	private Object value = null;
	private boolean isBoolean;

	public Value(Object v) {
		value = v;
	}

	public Value(Object v, boolean isBoolean) {
		value = v;
		this.isBoolean = isBoolean;
	}

	public boolean isBoolean() {
		return isBoolean;
	}

	public boolean asBoolean() {
		return Boolean.parseBoolean(asString());
	}

	public int asInteger() {
		return Integer.valueOf(asString());
	}

	public float asFloat() {
		return Float.valueOf(asString());
	}

	public double asDouble() {
		return Double.valueOf(asString());
	}

	public String asString() {
		return String.valueOf(value);
	}

	public Character asCharacter() {
		return (Character) value;
	}

	public CharacterClass asCharacterClass() {
		return (CharacterClass) value;
	}

	public Team asTeam() {
		return (Team) value;
	}

	public Token asToken() {
		return (Token) value;
	}

	public boolean isNull() {
		return (value == null);
	}

	public Vector2 asVector() {
		return (Vector2) value;
	}
}
