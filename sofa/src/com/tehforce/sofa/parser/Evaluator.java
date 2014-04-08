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

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import com.tehforce.sofa.logic.Character;
import com.tehforce.sofa.logic.CharacterClass;
import com.tehforce.sofa.logic.Team;
import com.tehforce.sofa.logic.Token;
import com.tehforce.sofa.parser.SofaLangParser.Alignment_enemyContext;
import com.tehforce.sofa.parser.SofaLangParser.Alignment_friendlyContext;
import com.tehforce.sofa.parser.SofaLangParser.BooleanBuiltin_aliveContext;
import com.tehforce.sofa.parser.SofaLangParser.BooleanBuiltin_inRangeContext;
import com.tehforce.sofa.parser.SofaLangParser.BooleanBuiltin_woundedContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_eqContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_geContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_gtContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_leContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_ltContext;
import com.tehforce.sofa.parser.SofaLangParser.Bop_neContext;
import com.tehforce.sofa.parser.SofaLangParser.ClassName_AnyContext;
import com.tehforce.sofa.parser.SofaLangParser.ClassName_HealerContext;
import com.tehforce.sofa.parser.SofaLangParser.ClassName_RangerContext;
import com.tehforce.sofa.parser.SofaLangParser.ClassName_WarriorContext;
import com.tehforce.sofa.parser.SofaLangParser.ClassentryContext;
import com.tehforce.sofa.parser.SofaLangParser.Comparison_numberBuiltinContext;
import com.tehforce.sofa.parser.SofaLangParser.Direction_downContext;
import com.tehforce.sofa.parser.SofaLangParser.Direction_leftContext;
import com.tehforce.sofa.parser.SofaLangParser.Direction_rightContext;
import com.tehforce.sofa.parser.SofaLangParser.Direction_upContext;
import com.tehforce.sofa.parser.SofaLangParser.DirectionalBultin_directionContext;
import com.tehforce.sofa.parser.SofaLangParser.DirectionalBultin_directionToContext;
import com.tehforce.sofa.parser.SofaLangParser.DirectionalBultin_oppositeDirectionToContext;
import com.tehforce.sofa.parser.SofaLangParser.Expr_ComparisonContext;
import com.tehforce.sofa.parser.SofaLangParser.Expr_OtherwiseContext;
import com.tehforce.sofa.parser.SofaLangParser.Expr_booleanBuiltinContext;
import com.tehforce.sofa.parser.SofaLangParser.LogicContext;
import com.tehforce.sofa.parser.SofaLangParser.NumberBuiltin_distanceToContext;
import com.tehforce.sofa.parser.SofaLangParser.NumberBuiltin_healthContext;
import com.tehforce.sofa.parser.SofaLangParser.NumberBuiltin_maxHealthContext;
import com.tehforce.sofa.parser.SofaLangParser.NumberBuiltin_numberContext;
import com.tehforce.sofa.parser.SofaLangParser.NumberBuiltin_rangeContext;
import com.tehforce.sofa.parser.SofaLangParser.ProgContext;
import com.tehforce.sofa.parser.SofaLangParser.RootContext;
import com.tehforce.sofa.parser.SofaLangParser.TargetBuiltin_closestContext;
import com.tehforce.sofa.parser.SofaLangParser.TargetBuiltin_farthestContext;
import com.tehforce.sofa.parser.SofaLangParser.TargetBuiltin_targetContext;
import com.tehforce.sofa.parser.SofaLangParser.TargetContext;
import com.tehforce.sofa.parser.SofaLangParser.TeamContext;
import com.tehforce.sofa.parser.SofaLangParser.Token_attackContext;
import com.tehforce.sofa.parser.SofaLangParser.Token_defendContext;
import com.tehforce.sofa.parser.SofaLangParser.Token_healContext;
import com.tehforce.sofa.parser.SofaLangParser.Token_moveContext;
import com.tehforce.sofa.parser.SofaLangParser.Token_roamContext;

/**
 * Evaluator is the evaluator of the AST created by ANTLR4.
 * It evaluates the entire tree on request, and takes the current status
 * of the simulation into account every single time.
 * 
 * Returns a set of tokens on request.
 * 
 * @author mockillo
 *
 */
public class Evaluator extends AbstractParseTreeVisitor<Value> implements
		SofaLangVisitor<Value> {

	private Team friendly, enemy;
	private HashMap<Character, Token[]> tokens;
	private Character current;
	private ParseTree tree;
	private ArrayList<Token[]> tokendump;

	public Evaluator(Team friendly, Team enemy, ParseTree tree) {
		this.friendly = friendly;
		this.enemy = enemy;
		this.tree = tree;
		tokendump = new ArrayList<Token[]>();
	}

	public Token[] getToken(Character c) {
		return tokens.get(c);
	}
	
	protected HashMap<Character, Token[]> getAllTokens() {
		return tokens;
	}

	public void updateTokens() {
		visit(tree);
	}

	@Override
	public Value visitAlignment_enemy(Alignment_enemyContext ctx) {
		return new Value(enemy);
	}

	@Override
	public Value visitAlignment_friendly(Alignment_friendlyContext ctx) {
		return new Value(friendly);
	}

	@Override
	public Value visitBooleanBuiltin_alive(BooleanBuiltin_aliveContext ctx) {
		if (ctx.getChildCount() > 3) {
			Character c = visit(ctx.getChild(0)).asCharacter();

			return new Value(c.alive(), true);
		} else {
			return new Value(current.alive(), true);
		}
	}

	@Override
	public Value visitBooleanBuiltin_inRange(BooleanBuiltin_inRangeContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Character t = visit(ctx.getChild(4)).asCharacter();

			return new Value(c.inRange(t), true);
		} else {
			Character t = visit(ctx.getChild(2)).asCharacter();

			return new Value(current.inRange(t), true);
		}
	}

	@Override
	public Value visitBooleanBuiltin_wounded(BooleanBuiltin_woundedContext ctx) {
		if (ctx.getChildCount() > 3) {
			Character c = visit(ctx.getChild(0)).asCharacter();

			return new Value(c.wounded(), true);
		} else {
			return new Value(current.wounded(), true);
		}
	}

	/**
	 * eq = 0;
	 */
	@Override
	public Value visitBop_eq(Bop_eqContext ctx) {
		return new Value(0);
	}

	/**
	 * ge = 1;
	 */
	@Override
	public Value visitBop_ge(Bop_geContext ctx) {
		return new Value(1);
	}

	/**
	 * gt = 5;
	 */
	@Override
	public Value visitBop_gt(Bop_gtContext ctx) {
		return new Value(5);
	}

	/**
	 * le = 2;
	 */
	@Override
	public Value visitBop_le(Bop_leContext ctx) {
		return new Value(2);
	}

	/**
	 * lt = 4;
	 */
	@Override
	public Value visitBop_lt(Bop_ltContext ctx) {
		return new Value(4);
	}

	/**
	 * ne = 3;
	 */
	@Override
	public Value visitBop_ne(Bop_neContext ctx) {
		return new Value(3);
	}

	@Override
	public Value visitClassentry(ClassentryContext ctx) {
		switch (visit(ctx.getChild(0)).asCharacterClass()) {
		case WARRIOR:
			current = friendly.getWarrior();
			break;
		case HEALER:
			current = friendly.getHealer();
			break;
		case RANGER:
			current = friendly.getRanger();
			break;
		case ANY:
			System.out.println("Invalid class entry in source file!");
			break;
		}

		for (int i = 1; i < ctx.getChildCount(); i++) {
			Value v = visit(ctx.getChild(i));

			if (v == null)
				continue;

			if (v.isNull())
				continue;

			if (v.isBoolean() && v.asBoolean()) {
				tokens.put(current, tokendump.get(tokendump.size() - 1));
				return new Value(true, true);
			}
		}

		return new Value(false, true);
	}

	@Override
	public Value visitClassName_Any(ClassName_AnyContext ctx) {
		return new Value(CharacterClass.ANY);
	}

	@Override
	public Value visitClassName_Healer(ClassName_HealerContext ctx) {
		return new Value(CharacterClass.HEALER);
	}

	@Override
	public Value visitClassName_Ranger(ClassName_RangerContext ctx) {
		return new Value(CharacterClass.RANGER);
	}

	@Override
	public Value visitClassName_Warrior(ClassName_WarriorContext ctx) {
		return new Value(CharacterClass.WARRIOR);
	}

	@Override
	public Value visitComparison_numberBuiltin(
			Comparison_numberBuiltinContext ctx) {
		Value v = null;

		float f = visit(ctx.getChild(0)).asFloat();
		float s = visit(ctx.getChild(2)).asFloat();
		int bop = visit(ctx.getChild(1)).asInteger();
		
		switch (bop) {
		case 0:
			v = new Value((Math.abs(f - s) < .0000001), true); break;

		case 1:
			v = new Value((f >= s), true); break;

		case 2:
			v = new Value((f <= s), true); break;

		case 3:
			v = new Value((f != s), true); break;

		case 4:
			v = new Value((f < s), true); break;

		default:
			v = new Value((f > s), true); break;	
		}

		return v;
	}

	@Override
	public Value visitDirection_down(Direction_downContext ctx) {
		return new Value("Down");
	}

	@Override
	public Value visitDirection_left(Direction_leftContext ctx) {
		return new Value("Left");
	}

	@Override
	public Value visitDirection_right(Direction_rightContext ctx) {
		return new Value("Right");
	}

	@Override
	public Value visitDirection_up(Direction_upContext ctx) {
		return new Value("Up");
	}

	@Override
	public Value visitDirectionalBultin_direction(
			DirectionalBultin_directionContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Value visitDirectionalBultin_directionTo(
			DirectionalBultin_directionToContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Character t = visit(ctx.getChild(4)).asCharacter();

			return new Value(c.direction(t));
		} else {
			Character t = visit(ctx.getChild(2)).asCharacter();

			return new Value(current.direction(t));
		}
	}

	@Override
	public Value visitDirectionalBultin_oppositeDirectionTo(
			DirectionalBultin_oppositeDirectionToContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Character t = visit(ctx.getChild(4)).asCharacter();

			return new Value(c.oppositeDirection(t));
		} else {
			Character t = visit(ctx.getChild(2)).asCharacter();

			return new Value(current.oppositeDirection(t));
		}
	}

	@Override
	public Value visitExpr_booleanBuiltin(Expr_booleanBuiltinContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Value visitExpr_Comparison(Expr_ComparisonContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Value visitExpr_Otherwise(Expr_OtherwiseContext ctx) {
		return new Value(true, true);
	}

	@Override
	public Value visitLogic(LogicContext ctx) {
		ArrayList<Boolean> exprBooleans = new ArrayList<Boolean>();
		ArrayList<Token> exprTokens = new ArrayList<Token>();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			Value v = visit(ctx.getChild(i));

			if (v == null)
				continue;

			if (v.isNull())
				continue;

			if (v.isBoolean())
				exprBooleans.add(v.asBoolean());
			else
				exprTokens.add(v.asToken());
		}

		Token[] myTokens = new Token[exprTokens.size()];
		exprTokens.toArray(myTokens);
		tokendump.add(myTokens);

		boolean passed = true;
		for (Boolean b : exprBooleans) {
			if (!b)
				passed = false;
		}

		if (passed)
			return new Value(true, true);
		else
			return new Value(false, true);
	}

	@Override
	public Value visitNumberBuiltin_distanceTo(
			NumberBuiltin_distanceToContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Character t = visit(ctx.getChild(4)).asCharacter();

			return new Value(c.distance(t));
		} else {
			Character t = visit(ctx.getChild(2)).asCharacter();

			return new Value(current.distance(t));
		}
	}

	@Override
	public Value visitNumberBuiltin_health(NumberBuiltin_healthContext ctx) {
		if (ctx.getChildCount() > 3) {
			Character c = visit(ctx.getChild(0)).asCharacter();

			return new Value(c.getCurrentHealth());
		} else {
			return new Value(current.getCurrentHealth());
		}
	}

	@Override
	public Value visitNumberBuiltin_maxHealth(NumberBuiltin_maxHealthContext ctx) {
		if (ctx.getChildCount() > 3) {
			Character c = visit(ctx.getChild(0)).asCharacter();

			return new Value(c.getMaxHealth());
		} else {
			return new Value(current.getMaxHealth());
		}
	}

	@Override
	public Value visitNumberBuiltin_number(NumberBuiltin_numberContext ctx) {
		return new Value(ctx.getChild(0).getText());
	}

	@Override
	public Value visitNumberBuiltin_range(NumberBuiltin_rangeContext ctx) {
		if (ctx.getChildCount() > 3) {
			Character c = visit(ctx.getChild(0)).asCharacter();

			return new Value(c.range());
		} else {
			return new Value(current.range());
		}
	}

	@Override
	public Value visitProg(ProgContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public Value visitRoot(RootContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public Value visitTarget(TargetContext ctx) {
		Team team = visit(ctx.getChild(0)).asTeam();
		Value c = null;

		switch (visit(ctx.getChild(2)).asCharacterClass()) {
		case WARRIOR:
			c = new Value(team.getWarrior());
			break;
		case HEALER:
			c = new Value(team.getHealer());
			break;
		case RANGER:
			c = new Value(team.getRanger());
			break;
		case ANY:
			c = new Value(team.getAny());
			break;
		}

		return c;
	}

	@Override
	public Value visitTargetBuiltin_closest(TargetBuiltin_closestContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Team t = visit(ctx.getChild(4)).asTeam();

			return new Value(c.closest(t));
		} else {
			Team t = visit(ctx.getChild(2)).asTeam();

			return new Value(current.closest(t));
		}
	}

	@Override
	public Value visitTargetBuiltin_farthest(TargetBuiltin_farthestContext ctx) {
		if (ctx.getChildCount() > 4) {
			Character c = visit(ctx.getChild(0)).asCharacter();
			Team t = visit(ctx.getChild(4)).asTeam();

			return new Value(c.farthest(t));
		} else {
			Team t = visit(ctx.getChild(2)).asTeam();

			return new Value(current.farthest(t));
		}
	}

	@Override
	public Value visitTargetBuiltin_target(TargetBuiltin_targetContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Value visitTeam(TeamContext ctx) {
		tokens = new HashMap<Character, Token[]>();
		return visitChildren(ctx);
	}

	@Override
	public Value visitToken_attack(Token_attackContext ctx) {
		Token t = new Token("Attack", visit(ctx.getChild(1)).asCharacter());
		return new Value(t);
	}

	@Override
	public Value visitToken_defend(Token_defendContext ctx) {
		Token t = new Token("Defend");
		return new Value(t);
	}

	@Override
	public Value visitToken_heal(Token_healContext ctx) {
		Token t = new Token("Heal", visit(ctx.getChild(1)).asCharacter());
		return new Value(t);
	}

	@Override
	public Value visitToken_move(Token_moveContext ctx) {
		Token t = new Token("Move", visit(ctx.getChild(1)).asVector());
		return new Value(t);
	}

	@Override
	public Value visitToken_roam(Token_roamContext ctx) {
		Token t = new Token("Roam");
		return new Value(t);
	}
}
