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

package com.tehforce.sofa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.Healer;
import com.tehforce.sofa.logic.Ranger;
import com.tehforce.sofa.logic.Team;
import com.tehforce.sofa.logic.Warrior;
import com.tehforce.sofa.parser.Evaluator;
import com.tehforce.sofa.parser.SofaLangLexer;
import com.tehforce.sofa.parser.SofaLangParser;

/**
 * GameController is responsible for starting all language processing,
 * loading textures and creating teams and characters.
 * 
 * Teams, assets (textures) and characters are statically available to
 * the rest of the application. 
 * 
 * @author mockillo
 *
 */
public class GameController {

	private static AssetManager am = new AssetManager();
	private static Team blueTeam = new Team();
	private static Team redTeam = new Team();
	private static ArrayList<Character> characters = new ArrayList<Character>();
	
	private Evaluator redEvaluator, blueEvaluator;
	private ParseTree redTree, blueTree;

	/**
	 * Constructor for GameController.
	 * Initiates all language processing, character creation and texture loading.
	 * 
	 * @param leftTeam File object for the file containing the code for the team starting to the left.
	 * @param rightTeam File object for the file containing the code for the team starting to the right.
	 */
	public GameController(File leftTeam, File rightTeam) {
		SofaLangLexer rlex = null, llex = null;
		
		try {
			llex = new SofaLangLexer(new ANTLRFileStream(
					leftTeam.getAbsolutePath()));
			rlex = new SofaLangLexer(new ANTLRFileStream(
					rightTeam.getAbsolutePath()));
		} catch (IOException e) {
			System.out.println("Error reading input files: " + e.getMessage());
			Gdx.app.exit();
		}

		SofaLangParser lparser = new SofaLangParser(new CommonTokenStream(llex));
		SofaLangParser rparser = new SofaLangParser(new CommonTokenStream(rlex));
		
		lparser.setErrorHandler(new BailErrorStrategy());
		rparser.setErrorHandler(new BailErrorStrategy());
		
		try {
			redTree = lparser.prog();
			blueTree = rparser.prog();
		} catch (ParseCancellationException e){
			Gdx.app.exit();
		}
		
		redEvaluator = new Evaluator(redTeam, blueTeam, redTree);
		blueEvaluator = new Evaluator(blueTeam, redTeam, blueTree);

		Character rw = new Warrior(redEvaluator, 10, 25, "redwarrior", 3);
		Character bw = new Warrior(blueEvaluator, 89, 25, "bluewarrior", 3);
		Character rh = new Healer(redEvaluator, 2, 50, "redhealer", 5);
		Character bh = new Healer(blueEvaluator, 96, 50, "bluehealer", 5);
		Character rr = new Ranger(redEvaluator, 10, 75, "redranger", 2);
		Character br = new Ranger(blueEvaluator, 89, 75, "blueranger", 2);

		redTeam.setWarrior(rw);
		redTeam.setHealer(rh);
		redTeam.setRanger(rr);

		blueTeam.setWarrior(bw);
		blueTeam.setHealer(bh);
		blueTeam.setRanger(br);

		characters.add(rw);
		characters.add(rh);
		characters.add(rr);
		characters.add(bw);
		characters.add(bh);
		characters.add(br);

		loadTextures();
	}

	/**
	 * Loads all textures, locks the thread intentionally until all textures are finished loading.
	 */
	private void loadTextures() {
		Texture.setEnforcePotImages(false);

		for (Character c : characters)
			for (int i = 0; i < 5; i++)
				am.load("data/" + c.getName() + "" + i + ".png", Texture.class);

		am.load("data/arrow.png", Texture.class);
		am.load("data/wp.jpg", Texture.class);		
		am.load("data/red.png", Texture.class);
		am.load("data/green.png", Texture.class);

		am.update();
		am.finishLoading();
	}

	public static AssetManager getAssets() {
		return am;
	}

	public static Team getRedTeam() {
		return redTeam;
	}

	public static Team getBlueTeam() {
		return blueTeam;
	}

	public static ArrayList<Character> getCharacters() {
		return characters;
	}
}
