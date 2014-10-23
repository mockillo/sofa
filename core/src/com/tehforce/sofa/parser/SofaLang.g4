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
