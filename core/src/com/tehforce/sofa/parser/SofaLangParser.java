// Generated from SofaLang.g4 by ANTLR 4.1
package com.tehforce.sofa.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SofaLangParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__37=1, T__36=2, T__35=3, T__34=4, T__33=5, T__32=6, T__31=7, T__30=8, 
		T__29=9, T__28=10, T__27=11, T__26=12, T__25=13, T__24=14, T__23=15, T__22=16, 
		T__21=17, T__20=18, T__19=19, T__18=20, T__17=21, T__16=22, T__15=23, 
		T__14=24, T__13=25, T__12=26, T__11=27, T__10=28, T__9=29, T__8=30, T__7=31, 
		T__6=32, T__5=33, T__4=34, T__3=35, T__2=36, T__1=37, T__0=38, INT=39, 
		ID=40, ARROW=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'Heal'", "'wounded'", "'Warrior'", "'('", "'alive'", "'Any'", 
		"'<'", "'!='", "'Down'", "'<='", "'Enemy'", "'otherwise'", "'range'", 
		"'{'", "'Healer'", "'Right'", "'closest'", "'maxhealth'", "'Roam'", "'}'", 
		"'Up'", "'Move'", "'.'", "')'", "'Friendly'", "'health'", "'Attack'", 
		"'distance'", "'>'", "'Left'", "'Ranger'", "'inRange'", "'=='", "'farthest'", 
		"'oppositeDirection'", "'direction'", "'>='", "'Defend'", "INT", "ID", 
		"'->'"
	};
	public static final int
		RULE_prog = 0, RULE_root = 1, RULE_team = 2, RULE_classentry = 3, RULE_classname = 4, 
		RULE_logic = 5, RULE_expr = 6, RULE_comparison = 7, RULE_numberBuiltin = 8, 
		RULE_directionalBuiltin = 9, RULE_booleanBuiltin = 10, RULE_targetBuiltin = 11, 
		RULE_token = 12, RULE_direction = 13, RULE_alignment = 14, RULE_target = 15, 
		RULE_bop = 16;
	public static final String[] ruleNames = {
		"prog", "root", "team", "classentry", "classname", "logic", "expr", "comparison", 
		"numberBuiltin", "directionalBuiltin", "booleanBuiltin", "targetBuiltin", 
		"token", "direction", "alignment", "target", "bop"
	};

	@Override
	public String getGrammarFileName() { return "SofaLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SofaLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	
	public static class ProgContext extends ParserRuleContext {
		public RootContext root() {
			return getRuleContext(RootContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); root();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootContext extends ParserRuleContext {
		public TeamContext team() {
			return getRuleContext(TeamContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); team();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TeamContext extends ParserRuleContext {
		public ClassentryContext classentry(int i) {
			return getRuleContext(ClassentryContext.class,i);
		}
		public List<ClassentryContext> classentry() {
			return getRuleContexts(ClassentryContext.class);
		}
		public TeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_team; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitTeam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TeamContext team() throws RecognitionException {
		TeamContext _localctx = new TeamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_team);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); classentry();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 6) | (1L << 15) | (1L << 31))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassentryContext extends ParserRuleContext {
		public LogicContext logic(int i) {
			return getRuleContext(LogicContext.class,i);
		}
		public List<LogicContext> logic() {
			return getRuleContexts(LogicContext.class);
		}
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public ClassentryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classentry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitClassentry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassentryContext classentry() throws RecognitionException {
		ClassentryContext _localctx = new ClassentryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classentry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); classname();
			setState(44); match(14);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45); logic();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 28) | (1L << 32) | (1L << INT))) != 0) );
			setState(50); match(20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassnameContext extends ParserRuleContext {
		public ClassnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classname; }
	 
		public ClassnameContext() { }
		public void copyFrom(ClassnameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassName_RangerContext extends ClassnameContext {
		public ClassName_RangerContext(ClassnameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitClassName_Ranger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassName_AnyContext extends ClassnameContext {
		public ClassName_AnyContext(ClassnameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitClassName_Any(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassName_HealerContext extends ClassnameContext {
		public ClassName_HealerContext(ClassnameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitClassName_Healer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassName_WarriorContext extends ClassnameContext {
		public ClassName_WarriorContext(ClassnameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitClassName_Warrior(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassnameContext classname() throws RecognitionException {
		ClassnameContext _localctx = new ClassnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classname);
		try {
			setState(56);
			switch (_input.LA(1)) {
			case 3:
				_localctx = new ClassName_WarriorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52); match(3);
				}
				break;
			case 15:
				_localctx = new ClassName_HealerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53); match(15);
				}
				break;
			case 31:
				_localctx = new ClassName_RangerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54); match(31);
				}
				break;
			case 6:
				_localctx = new ClassName_AnyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55); match(6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(SofaLangParser.ARROW, 0); }
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58); expr();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 5) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 18) | (1L << 25) | (1L << 26) | (1L << 28) | (1L << 32) | (1L << INT))) != 0) );
			{
			setState(63); match(ARROW);
			}
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64); token();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 19) | (1L << 22) | (1L << 27) | (1L << 38))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_booleanBuiltinContext extends ExprContext {
		public BooleanBuiltinContext booleanBuiltin() {
			return getRuleContext(BooleanBuiltinContext.class,0);
		}
		public Expr_booleanBuiltinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitExpr_booleanBuiltin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_OtherwiseContext extends ExprContext {
		public Expr_OtherwiseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitExpr_Otherwise(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr_ComparisonContext extends ExprContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Expr_ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitExpr_Comparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new Expr_ComparisonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69); comparison();
				}
				break;

			case 2:
				_localctx = new Expr_booleanBuiltinContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70); booleanBuiltin();
				}
				break;

			case 3:
				_localctx = new Expr_OtherwiseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71); match(12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	 
		public ComparisonContext() { }
		public void copyFrom(ComparisonContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Comparison_numberBuiltinContext extends ComparisonContext {
		public BopContext bop() {
			return getRuleContext(BopContext.class,0);
		}
		public NumberBuiltinContext numberBuiltin(int i) {
			return getRuleContext(NumberBuiltinContext.class,i);
		}
		public List<NumberBuiltinContext> numberBuiltin() {
			return getRuleContexts(NumberBuiltinContext.class);
		}
		public Comparison_numberBuiltinContext(ComparisonContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitComparison_numberBuiltin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparison);
		try {
			_localctx = new Comparison_numberBuiltinContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(74); numberBuiltin();
			setState(75); bop();
			setState(76); numberBuiltin();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberBuiltinContext extends ParserRuleContext {
		public NumberBuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberBuiltin; }
	 
		public NumberBuiltinContext() { }
		public void copyFrom(NumberBuiltinContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberBuiltin_rangeContext extends NumberBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public NumberBuiltin_rangeContext(NumberBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitNumberBuiltin_range(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberBuiltin_healthContext extends NumberBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public NumberBuiltin_healthContext(NumberBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitNumberBuiltin_health(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberBuiltin_numberContext extends NumberBuiltinContext {
		public TerminalNode INT() { return getToken(SofaLangParser.INT, 0); }
		public NumberBuiltin_numberContext(NumberBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitNumberBuiltin_number(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberBuiltin_distanceToContext extends NumberBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TargetBuiltinContext targetBuiltin() {
			return getRuleContext(TargetBuiltinContext.class,0);
		}
		public NumberBuiltin_distanceToContext(NumberBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitNumberBuiltin_distanceTo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberBuiltin_maxHealthContext extends NumberBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public NumberBuiltin_maxHealthContext(NumberBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitNumberBuiltin_maxHealth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberBuiltinContext numberBuiltin() throws RecognitionException {
		NumberBuiltinContext _localctx = new NumberBuiltinContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_numberBuiltin);
		int _la;
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new NumberBuiltin_distanceToContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(78); target();
					setState(79); match(23);
					}
				}

				{
				setState(83); match(28);
				}
				setState(84); match(4);
				setState(85); targetBuiltin();
				setState(86); match(24);
				}
				break;

			case 2:
				_localctx = new NumberBuiltin_healthContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(88); target();
					setState(89); match(23);
					}
				}

				{
				setState(93); match(26);
				}
				setState(94); match(4);
				setState(95); match(24);
				}
				break;

			case 3:
				_localctx = new NumberBuiltin_maxHealthContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(96); target();
					setState(97); match(23);
					}
				}

				{
				setState(101); match(18);
				}
				setState(102); match(4);
				setState(103); match(24);
				}
				break;

			case 4:
				_localctx = new NumberBuiltin_rangeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(104); target();
					setState(105); match(23);
					}
				}

				{
				setState(109); match(13);
				}
				setState(110); match(4);
				setState(111); match(24);
				}
				break;

			case 5:
				_localctx = new NumberBuiltin_numberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(112); match(INT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectionalBuiltinContext extends ParserRuleContext {
		public DirectionalBuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directionalBuiltin; }
	 
		public DirectionalBuiltinContext() { }
		public void copyFrom(DirectionalBuiltinContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DirectionalBultin_directionToContext extends DirectionalBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TargetBuiltinContext targetBuiltin() {
			return getRuleContext(TargetBuiltinContext.class,0);
		}
		public DirectionalBultin_directionToContext(DirectionalBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirectionalBultin_directionTo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectionalBultin_directionContext extends DirectionalBuiltinContext {
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public DirectionalBultin_directionContext(DirectionalBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirectionalBultin_direction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectionalBultin_oppositeDirectionToContext extends DirectionalBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TargetBuiltinContext targetBuiltin() {
			return getRuleContext(TargetBuiltinContext.class,0);
		}
		public DirectionalBultin_oppositeDirectionToContext(DirectionalBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirectionalBultin_oppositeDirectionTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectionalBuiltinContext directionalBuiltin() throws RecognitionException {
		DirectionalBuiltinContext _localctx = new DirectionalBuiltinContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_directionalBuiltin);
		int _la;
		try {
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new DirectionalBultin_directionToContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(115); target();
					setState(116); match(23);
					}
				}

				{
				setState(120); match(36);
				}
				setState(121); match(4);
				setState(122); targetBuiltin();
				setState(123); match(24);
				}
				break;

			case 2:
				_localctx = new DirectionalBultin_oppositeDirectionToContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(125); target();
					setState(126); match(23);
					}
				}

				{
				setState(130); match(35);
				}
				setState(131); match(4);
				setState(132); targetBuiltin();
				setState(133); match(24);
				}
				break;

			case 3:
				_localctx = new DirectionalBultin_directionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135); direction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanBuiltinContext extends ParserRuleContext {
		public BooleanBuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanBuiltin; }
	 
		public BooleanBuiltinContext() { }
		public void copyFrom(BooleanBuiltinContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanBuiltin_woundedContext extends BooleanBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public BooleanBuiltin_woundedContext(BooleanBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBooleanBuiltin_wounded(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanBuiltin_aliveContext extends BooleanBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public BooleanBuiltin_aliveContext(BooleanBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBooleanBuiltin_alive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanBuiltin_inRangeContext extends BooleanBuiltinContext {
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public BooleanBuiltin_inRangeContext(BooleanBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBooleanBuiltin_inRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanBuiltinContext booleanBuiltin() throws RecognitionException {
		BooleanBuiltinContext _localctx = new BooleanBuiltinContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_booleanBuiltin);
		int _la;
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new BooleanBuiltin_woundedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(138); target();
					setState(139); match(23);
					}
				}

				{
				setState(143); match(2);
				}
				setState(144); match(4);
				setState(145); match(24);
				}
				break;

			case 2:
				_localctx = new BooleanBuiltin_inRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(146); target();
					setState(147); match(23);
					}
				}

				{
				setState(151); match(32);
				}
				setState(152); match(4);
				setState(153); target();
				setState(154); match(24);
				}
				break;

			case 3:
				_localctx = new BooleanBuiltin_aliveContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(156); target();
					setState(157); match(23);
					}
				}

				{
				setState(161); match(5);
				}
				setState(162); match(4);
				setState(163); match(24);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetBuiltinContext extends ParserRuleContext {
		public TargetBuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetBuiltin; }
	 
		public TargetBuiltinContext() { }
		public void copyFrom(TargetBuiltinContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TargetBuiltin_farthestContext extends TargetBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public TargetBuiltin_farthestContext(TargetBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitTargetBuiltin_farthest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TargetBuiltin_targetContext extends TargetBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TargetBuiltin_targetContext(TargetBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitTargetBuiltin_target(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TargetBuiltin_closestContext extends TargetBuiltinContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public TargetBuiltin_closestContext(TargetBuiltinContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitTargetBuiltin_closest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetBuiltinContext targetBuiltin() throws RecognitionException {
		TargetBuiltinContext _localctx = new TargetBuiltinContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_targetBuiltin);
		int _la;
		try {
			setState(187);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new TargetBuiltin_closestContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(166); target();
					setState(167); match(23);
					}
				}

				setState(171); match(17);
				setState(172); match(4);
				setState(173); alignment();
				setState(174); match(24);
				}
				break;

			case 2:
				_localctx = new TargetBuiltin_farthestContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_la = _input.LA(1);
				if (_la==11 || _la==25) {
					{
					setState(176); target();
					setState(177); match(23);
					}
				}

				setState(181); match(34);
				setState(182); match(4);
				setState(183); alignment();
				setState(184); match(24);
				}
				break;

			case 3:
				_localctx = new TargetBuiltin_targetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(186); target();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
	 
		public TokenContext() { }
		public void copyFrom(TokenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Token_roamContext extends TokenContext {
		public Token_roamContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitToken_roam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Token_moveContext extends TokenContext {
		public DirectionalBuiltinContext directionalBuiltin() {
			return getRuleContext(DirectionalBuiltinContext.class,0);
		}
		public Token_moveContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitToken_move(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Token_healContext extends TokenContext {
		public TargetBuiltinContext targetBuiltin() {
			return getRuleContext(TargetBuiltinContext.class,0);
		}
		public Token_healContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitToken_heal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Token_attackContext extends TokenContext {
		public TargetBuiltinContext targetBuiltin() {
			return getRuleContext(TargetBuiltinContext.class,0);
		}
		public Token_attackContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitToken_attack(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Token_defendContext extends TokenContext {
		public Token_defendContext(TokenContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitToken_defend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_token);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case 22:
				_localctx = new Token_moveContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189); match(22);
				setState(190); directionalBuiltin();
				}
				break;
			case 27:
				_localctx = new Token_attackContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191); match(27);
				setState(192); targetBuiltin();
				}
				break;
			case 1:
				_localctx = new Token_healContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193); match(1);
				setState(194); targetBuiltin();
				}
				break;
			case 38:
				_localctx = new Token_defendContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195); match(38);
				}
				break;
			case 19:
				_localctx = new Token_roamContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(196); match(19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectionContext extends ParserRuleContext {
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
	 
		public DirectionContext() { }
		public void copyFrom(DirectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Direction_rightContext extends DirectionContext {
		public Direction_rightContext(DirectionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirection_right(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Direction_leftContext extends DirectionContext {
		public Direction_leftContext(DirectionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirection_left(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Direction_downContext extends DirectionContext {
		public Direction_downContext(DirectionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirection_down(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Direction_upContext extends DirectionContext {
		public Direction_upContext(DirectionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitDirection_up(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_direction);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case 21:
				_localctx = new Direction_upContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199); match(21);
				}
				break;
			case 9:
				_localctx = new Direction_downContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200); match(9);
				}
				break;
			case 30:
				_localctx = new Direction_leftContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201); match(30);
				}
				break;
			case 16:
				_localctx = new Direction_rightContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(202); match(16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentContext extends ParserRuleContext {
		public AlignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignment; }
	 
		public AlignmentContext() { }
		public void copyFrom(AlignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Alignment_enemyContext extends AlignmentContext {
		public Alignment_enemyContext(AlignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitAlignment_enemy(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Alignment_friendlyContext extends AlignmentContext {
		public Alignment_friendlyContext(AlignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitAlignment_friendly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlignmentContext alignment() throws RecognitionException {
		AlignmentContext _localctx = new AlignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_alignment);
		try {
			setState(207);
			switch (_input.LA(1)) {
			case 25:
				_localctx = new Alignment_friendlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205); match(25);
				}
				break;
			case 11:
				_localctx = new Alignment_enemyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206); match(11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); alignment();
			setState(210); match(23);
			setState(211); classname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BopContext extends ParserRuleContext {
		public BopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bop; }
	 
		public BopContext() { }
		public void copyFrom(BopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Bop_ltContext extends BopContext {
		public Bop_ltContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_lt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bop_neContext extends BopContext {
		public Bop_neContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_ne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bop_geContext extends BopContext {
		public Bop_geContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_ge(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bop_gtContext extends BopContext {
		public Bop_gtContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_gt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bop_leContext extends BopContext {
		public Bop_leContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_le(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bop_eqContext extends BopContext {
		public Bop_eqContext(BopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SofaLangVisitor ) return ((SofaLangVisitor<? extends T>)visitor).visitBop_eq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BopContext bop() throws RecognitionException {
		BopContext _localctx = new BopContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bop);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case 33:
				_localctx = new Bop_eqContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213); match(33);
				}
				break;
			case 37:
				_localctx = new Bop_geContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(214); match(37);
				}
				break;
			case 10:
				_localctx = new Bop_leContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215); match(10);
				}
				break;
			case 8:
				_localctx = new Bop_neContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(216); match(8);
				}
				break;
			case 7:
				_localctx = new Bop_ltContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217); match(7);
				}
				break;
			case 29:
				_localctx = new Bop_gtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(218); match(29);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3+\u00e0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\6\4*\n\4\r\4\16\4+\3\5\3\5\3\5\6\5\61\n\5\r\5\16"+
		"\5\62\3\5\3\5\3\6\3\6\3\6\3\6\5\6;\n\6\3\7\6\7>\n\7\r\7\16\7?\3\7\3\7"+
		"\6\7D\n\7\r\7\16\7E\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\5"+
		"\nT\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n^\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nf\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nn\n\n\3\n\3\n\3\n\3\n\5\nt\n\n"+
		"\3\13\3\13\3\13\5\13y\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0083\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008b\n\13\3\f\3\f\3\f"+
		"\5\f\u0090\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0098\n\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00a2\n\f\3\f\3\f\3\f\5\f\u00a7\n\f\3\r\3\r\3\r\5\r"+
		"\u00ac\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00be\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00c8\n\16\3\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\20\3\20\5\20\u00d2\n"+
		"\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00de\n\22"+
		"\3\22\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\u00f9\2$\3\2"+
		"\2\2\4&\3\2\2\2\6)\3\2\2\2\b-\3\2\2\2\n:\3\2\2\2\f=\3\2\2\2\16J\3\2\2"+
		"\2\20L\3\2\2\2\22s\3\2\2\2\24\u008a\3\2\2\2\26\u00a6\3\2\2\2\30\u00bd"+
		"\3\2\2\2\32\u00c7\3\2\2\2\34\u00cd\3\2\2\2\36\u00d1\3\2\2\2 \u00d3\3\2"+
		"\2\2\"\u00dd\3\2\2\2$%\5\4\3\2%\3\3\2\2\2&\'\5\6\4\2\'\5\3\2\2\2(*\5\b"+
		"\5\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-.\5\n\6\2.\60"+
		"\7\20\2\2/\61\5\f\7\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3"+
		"\2\2\2\63\64\3\2\2\2\64\65\7\26\2\2\65\t\3\2\2\2\66;\7\5\2\2\67;\7\21"+
		"\2\28;\7!\2\29;\7\b\2\2:\66\3\2\2\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\13"+
		"\3\2\2\2<>\5\16\b\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2"+
		"AC\7+\2\2BD\5\32\16\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\r\3\2\2"+
		"\2GK\5\20\t\2HK\5\26\f\2IK\7\16\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\17"+
		"\3\2\2\2LM\5\22\n\2MN\5\"\22\2NO\5\22\n\2O\21\3\2\2\2PQ\5 \21\2QR\7\31"+
		"\2\2RT\3\2\2\2SP\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\36\2\2VW\7\6\2\2WX\5"+
		"\30\r\2XY\7\32\2\2Yt\3\2\2\2Z[\5 \21\2[\\\7\31\2\2\\^\3\2\2\2]Z\3\2\2"+
		"\2]^\3\2\2\2^_\3\2\2\2_`\7\34\2\2`a\7\6\2\2at\7\32\2\2bc\5 \21\2cd\7\31"+
		"\2\2df\3\2\2\2eb\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\24\2\2hi\7\6\2\2it\7"+
		"\32\2\2jk\5 \21\2kl\7\31\2\2ln\3\2\2\2mj\3\2\2\2mn\3\2\2\2no\3\2\2\2o"+
		"p\7\17\2\2pq\7\6\2\2qt\7\32\2\2rt\7)\2\2sS\3\2\2\2s]\3\2\2\2se\3\2\2\2"+
		"sm\3\2\2\2sr\3\2\2\2t\23\3\2\2\2uv\5 \21\2vw\7\31\2\2wy\3\2\2\2xu\3\2"+
		"\2\2xy\3\2\2\2yz\3\2\2\2z{\7&\2\2{|\7\6\2\2|}\5\30\r\2}~\7\32\2\2~\u008b"+
		"\3\2\2\2\177\u0080\5 \21\2\u0080\u0081\7\31\2\2\u0081\u0083\3\2\2\2\u0082"+
		"\177\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7%\2"+
		"\2\u0085\u0086\7\6\2\2\u0086\u0087\5\30\r\2\u0087\u0088\7\32\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u008b\5\34\17\2\u008ax\3\2\2\2\u008a\u0082\3\2\2"+
		"\2\u008a\u0089\3\2\2\2\u008b\25\3\2\2\2\u008c\u008d\5 \21\2\u008d\u008e"+
		"\7\31\2\2\u008e\u0090\3\2\2\2\u008f\u008c\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\7\4\2\2\u0092\u0093\7\6\2\2\u0093\u00a7"+
		"\7\32\2\2\u0094\u0095\5 \21\2\u0095\u0096\7\31\2\2\u0096\u0098\3\2\2\2"+
		"\u0097\u0094\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\7\"\2\2\u009a\u009b\7\6\2\2\u009b\u009c\5 \21\2\u009c\u009d\7\32\2\2"+
		"\u009d\u00a7\3\2\2\2\u009e\u009f\5 \21\2\u009f\u00a0\7\31\2\2\u00a0\u00a2"+
		"\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\7\7\2\2\u00a4\u00a5\7\6\2\2\u00a5\u00a7\7\32\2\2\u00a6\u008f\3"+
		"\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7\27\3\2\2\2\u00a8"+
		"\u00a9\5 \21\2\u00a9\u00aa\7\31\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a8\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\23\2\2\u00ae"+
		"\u00af\7\6\2\2\u00af\u00b0\5\36\20\2\u00b0\u00b1\7\32\2\2\u00b1\u00be"+
		"\3\2\2\2\u00b2\u00b3\5 \21\2\u00b3\u00b4\7\31\2\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u00b2\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\7$\2\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7\32\2\2"+
		"\u00bb\u00be\3\2\2\2\u00bc\u00be\5 \21\2\u00bd\u00ab\3\2\2\2\u00bd\u00b5"+
		"\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00c0\7\30\2\2\u00c0"+
		"\u00c8\5\24\13\2\u00c1\u00c2\7\35\2\2\u00c2\u00c8\5\30\r\2\u00c3\u00c4"+
		"\7\3\2\2\u00c4\u00c8\5\30\r\2\u00c5\u00c8\7(\2\2\u00c6\u00c8\7\25\2\2"+
		"\u00c7\u00bf\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ce\7\27\2\2\u00ca"+
		"\u00ce\7\13\2\2\u00cb\u00ce\7 \2\2\u00cc\u00ce\7\22\2\2\u00cd\u00c9\3"+
		"\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\35\3\2\2\2\u00cf\u00d2\7\33\2\2\u00d0\u00d2\7\r\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d1\u00d0\3\2\2\2\u00d2\37\3\2\2\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5"+
		"\7\31\2\2\u00d5\u00d6\5\n\6\2\u00d6!\3\2\2\2\u00d7\u00de\7#\2\2\u00d8"+
		"\u00de\7\'\2\2\u00d9\u00de\7\f\2\2\u00da\u00de\7\n\2\2\u00db\u00de\7\t"+
		"\2\2\u00dc\u00de\7\37\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd"+
		"\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2"+
		"\2\2\u00de#\3\2\2\2\33+\62:?EJS]emsx\u0082\u008a\u008f\u0097\u00a1\u00a6"+
		"\u00ab\u00b5\u00bd\u00c7\u00cd\u00d1\u00dd";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}