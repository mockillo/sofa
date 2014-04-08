package com.tehforce.sofa.parser;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.Healer;
import com.tehforce.sofa.logic.Ranger;
import com.tehforce.sofa.logic.Team;
import com.tehforce.sofa.logic.Token;
import com.tehforce.sofa.logic.Warrior;

/**
 * The tests in here are purely based on expected results.
 * All the tests are based on a directly manipulated environment, and what the script SHOULD
 * produce given the current environment. 
 * 
 * Tests are based on Token equality.
 * 
 * @author mockillo
 *
 */
public class TestEvaluator {

	Character rw, rh, rr, bw, bh, br;
	
	String script = "Warrior {\n" + 
			"	distance(Enemy.Healer) < distance(Enemy.Warrior) \n" + 
			"		-> Move direction(Enemy.Healer) Attack Enemy.Healer\n" + 
			"\n" + 
			"	 Enemy.Warrior.distance(Friendly.Healer) < distance(Enemy.Warrior)\n" + 
			"		-> Move direction(Enemy.Warrior) Attack Enemy.Warrior\n" + 
			"\n" + 
			"	otherwise\n" + 
			"		-> Move direction(closest(Enemy)) Attack closest(Enemy)\n" + 
			"}\n" + 
			"\n" + 
			"Healer {\n" + 
			"	distance(Enemy.Warrior) < distance(Friendly.Warrior)\n" + 
			"		-> Move oppositeDirection(Enemy.Warrior)\n" + 
			"	Friendly.Warrior.wounded()\n" + 
			"		-> Move direction(Friendly.Warrior) Heal Friendly.Warrior\n" + 
			"	Friendly.Ranger.wounded()\n" + 
			"		-> Move direction(Friendly.Ranger) Heal Friendly.Ranger\n" + 
			"	wounded()\n" + 
			"		-> Move oppositeDirection(Enemy.Warrior) Heal Friendly.Healer\n" + 
			"	otherwise\n" + 
			"		-> Roam\n" + 
			"}\n" + 
			"\n" + 
			"Ranger {\n" + 
			"	Enemy.Ranger.alive() -> Move direction(Enemy.Ranger) Attack Enemy.Ranger\n" +
			"	Enemy.Warrior.inRange(Friendly.Ranger)\n" + 
			"		-> Move oppositeDirection(Enemy.Warrior) Attack Enemy.Warrior\n" + 
			"	Enemy.Warrior.inRange(Friendly.Healer)\n" + 
			"		-> Move direction(Enemy.Warrior) Attack Enemy.Warrior\n" +
			"	otherwise\n" + 
			"		-> Move direction(Enemy.Healer) Attack Enemy.Healer\n" + 
			"}";
	
	Team blueTeam, redTeam;
	
	ParseTree redTree;
	
	Evaluator redEvaluator;
	
	@Before
	public void setUp() throws Exception {
		SofaLangLexer llex = null;

		llex = new SofaLangLexer(new ANTLRInputStream(script));

		SofaLangParser lparser = new SofaLangParser(new CommonTokenStream(llex));

		redTree = lparser.prog();
		
		redTeam = new Team();
		blueTeam = new Team();

		redEvaluator = new Evaluator(redTeam, blueTeam, redTree);

		rw = new Warrior(redEvaluator, 10, 25, "redwarrior", 3);
		bw = new Warrior(null, 89, 25, "bluewarrior", 3);
		rh = new Healer(redEvaluator, 2, 50, "redhealer", 5);
		bh = new Healer(null, 96, 50, "bluehealer", 5);
		rr = new Ranger(redEvaluator, 10, 75, "redranger", 2);
		br = new Ranger(null, 89, 75, "blueranger", 2);

		redTeam.setWarrior(rw);
		redTeam.setHealer(rh);
		redTeam.setRanger(rr);

		blueTeam.setWarrior(bw);
		blueTeam.setHealer(bh);
		blueTeam.setRanger(br);
	}

	@Test
	public void testInitialTokenList() {
		HashMap<Character, Token[]> expectedRedTokens = new HashMap<Character, Token[]>();

		expectedRedTokens.put(rw, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", bw)
		});
		
		expectedRedTokens.put(rh, new Token[]{
				new Token("Roam", new Vector2()),
		});
		
		expectedRedTokens.put(rr, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", br)
		});
		
		redEvaluator.updateTokens();
		
		HashMap<Character, Token[]> redTokens = redEvaluator.getAllTokens();
		
		for(Character c : redTeam.getCharacterList()){
			assertArrayEquals(expectedRedTokens.get(c), redTokens.get(c));
		}
	}
	
	@Test
	public void testTriggerHealerDefenseRules(){
		HashMap<Character, Token[]> expectedRedTokens = new HashMap<Character, Token[]>();

		expectedRedTokens.put(rw, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", bw)
		});
		
		expectedRedTokens.put(rh, new Token[]{
				new Token("Move", new Vector2()),
		});
		
		expectedRedTokens.put(rr, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", br)
		});
		
		bw.setPosition(rh.getPosition());
		
		redEvaluator.updateTokens();
		
		HashMap<Character, Token[]> redTokens = redEvaluator.getAllTokens();
		
		for(Character c : redTeam.getCharacterList()){
			assertArrayEquals(expectedRedTokens.get(c), redTokens.get(c));
		}
	}
	
	@Test
	public void testTriggerHeals(){
		HashMap<Character, Token[]> expectedRedTokens = new HashMap<Character, Token[]>();

		expectedRedTokens.put(rw, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", bw)
		});
		
		expectedRedTokens.put(rh, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Heal", rw)
		});
		
		expectedRedTokens.put(rr, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", br)
		});
		
		rw.takeDamage(10);

		redEvaluator.updateTokens();
		
		HashMap<Character, Token[]> redTokens = redEvaluator.getAllTokens();
		
		for(Character c : redTeam.getCharacterList()){
			assertArrayEquals(expectedRedTokens.get(c), redTokens.get(c));
		}
	}
	
	@Test
	public void testTriggerAliveCancel(){
		HashMap<Character, Token[]> expectedRedTokens = new HashMap<Character, Token[]>();

		expectedRedTokens.put(rw, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", bw)
		});
		
		expectedRedTokens.put(rh, new Token[]{
				new Token("Roam", new Vector2()),
		});
		
		expectedRedTokens.put(rr, new Token[]{
				new Token("Move", new Vector2()),
				new Token("Attack", bh)
		});
		
		br.takeDamage(br.getMaxHealth());
		redEvaluator.updateTokens();
		
		HashMap<Character, Token[]> redTokens = redEvaluator.getAllTokens();
		
		for(Character c : redTeam.getCharacterList()){
			assertArrayEquals(expectedRedTokens.get(c), redTokens.get(c));
		}
	}
}
