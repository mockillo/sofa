// Generated from SofaLang.g4 by ANTLR 4.1
package com.tehforce.sofa.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SofaLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SofaLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_lt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_lt(@NotNull SofaLangParser.Bop_ltContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#targetBuiltin_farthest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetBuiltin_farthest(@NotNull SofaLangParser.TargetBuiltin_farthestContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#className_Healer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName_Healer(@NotNull SofaLangParser.ClassName_HealerContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(@NotNull SofaLangParser.RootContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#booleanBuiltin_alive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanBuiltin_alive(@NotNull SofaLangParser.BooleanBuiltin_aliveContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#token_roam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken_roam(@NotNull SofaLangParser.Token_roamContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#numberBuiltin_health}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBuiltin_health(@NotNull SofaLangParser.NumberBuiltin_healthContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#directionalBultin_oppositeDirectionTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectionalBultin_oppositeDirectionTo(@NotNull SofaLangParser.DirectionalBultin_oppositeDirectionToContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#direction_down}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_down(@NotNull SofaLangParser.Direction_downContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_ge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_ge(@NotNull SofaLangParser.Bop_geContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#booleanBuiltin_inRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanBuiltin_inRange(@NotNull SofaLangParser.BooleanBuiltin_inRangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#className_Ranger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName_Ranger(@NotNull SofaLangParser.ClassName_RangerContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#booleanBuiltin_wounded}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanBuiltin_wounded(@NotNull SofaLangParser.BooleanBuiltin_woundedContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull SofaLangParser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#targetBuiltin_closest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetBuiltin_closest(@NotNull SofaLangParser.TargetBuiltin_closestContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#token_move}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken_move(@NotNull SofaLangParser.Token_moveContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#classentry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassentry(@NotNull SofaLangParser.ClassentryContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#comparison_numberBuiltin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_numberBuiltin(@NotNull SofaLangParser.Comparison_numberBuiltinContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#direction_up}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_up(@NotNull SofaLangParser.Direction_upContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#token_defend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken_defend(@NotNull SofaLangParser.Token_defendContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#className_Any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName_Any(@NotNull SofaLangParser.ClassName_AnyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#directionalBultin_direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectionalBultin_direction(@NotNull SofaLangParser.DirectionalBultin_directionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#direction_right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_right(@NotNull SofaLangParser.Direction_rightContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#expr_Otherwise}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_Otherwise(@NotNull SofaLangParser.Expr_OtherwiseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#expr_booleanBuiltin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_booleanBuiltin(@NotNull SofaLangParser.Expr_booleanBuiltinContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#direction_left}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection_left(@NotNull SofaLangParser.Direction_leftContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#numberBuiltin_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBuiltin_range(@NotNull SofaLangParser.NumberBuiltin_rangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#alignment_enemy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlignment_enemy(@NotNull SofaLangParser.Alignment_enemyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#numberBuiltin_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBuiltin_number(@NotNull SofaLangParser.NumberBuiltin_numberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#numberBuiltin_distanceTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBuiltin_distanceTo(@NotNull SofaLangParser.NumberBuiltin_distanceToContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#team}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTeam(@NotNull SofaLangParser.TeamContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#alignment_friendly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlignment_friendly(@NotNull SofaLangParser.Alignment_friendlyContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(@NotNull SofaLangParser.LogicContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#directionalBultin_directionTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectionalBultin_directionTo(@NotNull SofaLangParser.DirectionalBultin_directionToContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#targetBuiltin_target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetBuiltin_target(@NotNull SofaLangParser.TargetBuiltin_targetContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#className_Warrior}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName_Warrior(@NotNull SofaLangParser.ClassName_WarriorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_ne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_ne(@NotNull SofaLangParser.Bop_neContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(@NotNull SofaLangParser.TargetContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_gt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_gt(@NotNull SofaLangParser.Bop_gtContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#token_heal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken_heal(@NotNull SofaLangParser.Token_healContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#expr_Comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_Comparison(@NotNull SofaLangParser.Expr_ComparisonContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_le}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_le(@NotNull SofaLangParser.Bop_leContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#token_attack}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken_attack(@NotNull SofaLangParser.Token_attackContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#numberBuiltin_maxHealth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberBuiltin_maxHealth(@NotNull SofaLangParser.NumberBuiltin_maxHealthContext ctx);

	/**
	 * Visit a parse tree produced by {@link SofaLangParser#bop_eq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop_eq(@NotNull SofaLangParser.Bop_eqContext ctx);
}