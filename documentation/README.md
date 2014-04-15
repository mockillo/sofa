# Development report (Work in Progress)

## SOFA (Scripted Offline Fighting Arena)

## Table of Content

- Introduction
- End result
	- SOFA Script
		- Introduction
		- Functions
		- Tokens
		- Grammar
	- SOFA Simulation
- Depelopment
	- Idea
	- Design
	- Implementation
	- Testing
- Challenges
	- Testing
	- Milestones ;-)
- Conclusion

### Introduction

This project is the result, and continuation of a term project in INF225 (aka. The Compiler Course) at the University in Bergen. I had such a fun time doing this project during the INF225 course that I wanted to continue the project. I was lucky enough to get our instructor from INF225 to be my supervisor in INF219 (Programming Project) this semester and we agreed that continuing this project was a good idea. 

So, what is SOFA? In short, it is a scripting language for controlling the AI of three different characters in a team. And with the accompanying simulation you can put two SOFA scripts up against each other in a battle to the death, for the simulated characters atleast.

## End result

### SOFA Script

#### Introduction

SOFA Script is, as mentioned above, a language for controlling the AI in the SOFA Simulation. It is designed to  be a language that resembles the thought pattern I had when I was doing prolog last semester. It is based on boolean predicates, where a given list of predicates has a list of tokens (commands) that will be given to the character under which the predicate is defined in the simulation.

A typical SOFA Script file has the following basic layout:

```
Warrior {
	<list of predicates>
		<predicates> -> <tokens>
	</list of predicates>
}

Healer {
	<list of predicates>
		<predicates> -> <tokens>
	</list of predicates>
}

Ranger {
	<list of predicates>
		<predicates> -> <tokens>
	</list of predicates>
}
```

Each list of predicates can be as long as you wish, and you can define hundreds of predicates in order to get as much control as you need of every characters action. You also have access to a otherwise predicate, which can be regarded as "else"-clause from the "if"-statements found in conventional programming languages.

A predicate is constructed by using one of the builtin functions, either by calling a boolean function alone or by evaluating a returned digit with binary operators.

Every builtin function can be called on every character in the simulation, from every character in the simulation. So a Warrior can have a predicate that only evaluates the state and status of its other team mates without considering its own status. This is done by calling the function as you would a static method, from say Java, on an enemy or friendly character. If you do not specify a which character your are calling the method on, by for example just calling the distance()-function by itself, like in the example above, it will be called on the character that the current block belongs to.

Example: 

```
Friendly.Healer.distance(Enemy.Warrior) < distance(Enemy.Warrior)
```

This predicate checks if our friendly healers distance to the enemy warrior is less than the distance of the CURRENT character to the enemy warrior.

The tokens you specify with each predicate are simple keywords with a potential argument.

Example:

```
Move direction(Enemy.Healer) Attack Enemy.Healer
```

The attack token takes a character as argument, while the move token takes a direction, that's why you need to use the direction()-function to get a direction to the Enemy.Healer. The attack token will always be returned to the character in the simulation, but it will only be performed if the character is in range of the target.

If we put together what we've learned to now, we can build a small Warrior block that is based around defending our healer.

```
Warrior {
	Friendly.Healer.distance(Enemy.Warrior) < distance(Enemy.Warrior)
	-> Move direction(Enemy.Warrior) Attack Enemy.Warrior
	
	Friendly.Healer.distance(Enemy.Ranger) < distance(Enemy.Ranger)
	-> Move direction(Enemy.Ranger) Attack Enemy.Ranger
	
	otherwise -> Move direction(Enemy.Healer) Attack Enemy.Healer
}
```

This script will attack any hostile enemy that is closer to our healer than they are to us. Then if none of those predicates hold, it will return the tokens from the otherwise predicate. The predicates are evaluated from top to bottom, so if the first AND the second predicates above are true, the tokens from the first one will be returned.

You can have several boolean expressions in a predicate, and you can chain them by comma separating them. The comma acts as a AND-operator and the predicate will only hold if all the boolean expressions are true.

(TODO: Insert illustrations of script flow)

#### Functions

Functions that return floating point values, that would need evaluation in a predicate (< / > / >= / <= etc..):

```
distance(target) - Returns the distance to the target
health() - Returns the current health of the character
maxhealth() - Returns the maximum health of the character
range() - Returns the range of the character
```

Functions that return directions, used with the Move token:

```
direction(target) - Returns the direction to the target.
oppositeDirection(target) - Returns the opposite direction to the target.
```

Functions that return boolean values, require no explicit evaluation:

```
wounded() - Returns true if a characters health is less than its maxhealth
inRange(target) - Returns true if a character is in range of the target character
alive() - Returns true if the target is alive
```

Functions that return a target character:

```
closest(alignment) - Returns the closest character to this from the specified alignment (Enemy or Friendly)
farthest(alignment) - Returns the farthest character to this from the specified alignment (Enemy or Friendly)
```

Directions and targets can also be specified explicitly:

Directions:

```
Up
Down
Left
Right
```

Target:

```
Enemy.Healer
Enemy.Ranger
Enemy.Warrior

Friendly.Healer
Friendly.Ranger
Friendly.Warrior

Friendly.Any - Random friendly character
Enemy.Any - Random enemy character
```


#### Tokens

These tokens can be specified as many times as you want, but internal cooldowns will prevent them from being performed a more than once per type of token.


```
Attack target - Attack target
Heal target - Heal target, only available to the healer
Move direction - Move in the given direction
Roam - Roam (move around randomly)
Defend - Reduces attack, but increases damage mitigation for short time
```

#### Grammar

Here is the complete ANTLRv4 valid grammar for those interested:

```
grammar SofaLang; 

prog: root;

INT: [0-9]+;
ID: [a-zA-Z]+;
ARROW: '->';

root:
    team
;

team:
	classentry+
;

classentry:
	classname '{' logic+ '}'
;

classname:
	'Warrior' 	#className_Warrior
	| 'Healer' 	#className_Healer
	| 'Ranger' 	#className_Ranger
	| 'Any'	#className_Any
;

logic:
	expr+ (ARROW) token+
;

expr:
	comparison 			#expr_Comparison 
	| booleanBuiltin	#expr_booleanBuiltin 
	| 'otherwise' 		#expr_Otherwise
;

comparison:
	numberBuiltin bop numberBuiltin 				#comparison_numberBuiltin
;

numberBuiltin:
	(target '.')?  ('distance') '(' targetBuiltin ')'	#numberBuiltin_distanceTo 
	| (target '.')?  ('health') '(' ')' 				#numberBuiltin_health
	| (target '.')?  ('maxhealth') '(' ')' 				#numberBuiltin_maxHealth
	| (target '.')?  ('range') '(' ')' 					#numberBuiltin_range
	| INT												#numberBuiltin_number
;

directionalBuiltin:
	(target '.')? ('direction') '(' targetBuiltin ')'							#directionalBultin_directionTo
	| (target '.')? ('oppositeDirection') '(' targetBuiltin ')'					#directionalBultin_oppositeDirectionTo
	| direction																	#directionalBultin_direction
;

booleanBuiltin:
	(target '.')?  ('wounded') 	'(' ')'				#booleanBuiltin_wounded 
	| (target '.')?  ('inRange') 	'(' target ')' 	#booleanBuiltin_inRange
	| (target '.')?  ('alive')	'(' ')'				#booleanBuiltin_alive
;


targetBuiltin:
	(target '.')? 'closest' '(' alignment ')' 		#targetBuiltin_closest
	| (target '.')? 'farthest' '(' alignment ')' 	#targetBuiltin_farthest
	| target										#targetBuiltin_target
;

token:
	'Move' 		directionalBuiltin 	#token_move
	| 'Attack' 	targetBuiltin 		#token_attack
	| 'Heal' 		targetBuiltin 	#token_heal
	| 'Defend' 						#token_defend
	| 'Roam'						#token_roam
;

direction:
	'Up' 		#direction_up
	| 'Down'	#direction_down 
	| 'Left' 	#direction_left
	| 'Right'	#direction_right
;

alignment:
	'Friendly'	#alignment_friendly 
	| 'Enemy'	#alignment_enemy
;

target:
	alignment '.' classname
;

bop:
	'==' 	#bop_eq
	| '>=' 	#bop_ge
	| '<=' 	#bop_le
	| '!=' 	#bop_ne
	| '<' 	#bop_lt
	| '>'	#bop_gt
;
```

### SOFA Simulation

## Development Approach

### Idea

The idea behind SOFA started with my fascination for games where you get to use programming as part of playing the game. Especially the game Game Hero, which is a first person shooter where you manipulate the world around you by shooting javascript snippets at objects ([Link](http://www.primerlabs.com)).

The original idea was somewhat more inspired by my interest in StarCraft 2 (As a spectator, not a player. I am terrible at it.). I was dreaming of a RTS (real time strategy) where you would assign scripts to your units instead of issuing commands. Imagine the mid bottom selected unit overview was a small code editor, and the command buttons were "Check Syntax", "Assign to Selected Unit(s)" etc. instead of "Attack" and "Move"? It would've been a fantastic game to play.

Now, the next step was to be realistic and consider the fact that a RTS with multiple races, buildings and units was not something I would be able to do in any realistic timeframe what so ever. So the project was scaled a bit down, and instead of being based off of an RTS I picked up some key elements from the MOBA (multiplayer online battle arena) genre and gave the project a name with a funny twist, basing it sort of off the abbreviation MOBA. And then the Scripted Offline Fighting Arena, or SOFA for short, was born.

### Design

The system design is based on patters that separate concerns, and I have been splitting game logic from rendering code as much as I can. And by using Scene2D from libGDX I have separated all rendering into what Scene2D calls Actors, where I have one actor for each entity that should be drawn from the game logic. This way each Actor is responsible for everything regarding drawing for it's object, and draw calls are made down the tree from the Scene at the top and down to all actors through actor groups. This way there is no massive draw()-method in the main update()-method that has to handle and draw everything in the scene.

This class diagram shows how the code is structured. I have excluded classes involved with SOFAScript. Dotted lines represent dependencies between classes, and solid represents associations.

![ClassDiagram](./images/sofa_class_diagram.png =800x)

This class diagram shows where the Evaluator is plugged into the code above, and how the generated ANTLR4 classes comes into play. I have excluded all private classes in SofaLangParser.java. Also as before, dotted lines represent dependencies between classes, and solid represents associations.

![EvaluatorClassDiagram](./images/sofa_evaluator_class_diagram.png =800x)

### Implementation

### Testing

## Challengs

### Testing

### Milestones

## Conclusion