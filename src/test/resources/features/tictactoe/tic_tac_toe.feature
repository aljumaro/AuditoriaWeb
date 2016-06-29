Feature: Play tic tac toe
	Scenario: Place token
		Given i have a board like this:
			| 	| 1 | 2 | 3 |
			| 1 | 	| 	| 	|
			| 2 |	| 	| 	|
			| 3 | 	| 	| 	|
		When i place a toke in row 2 column 1
		Then the board should look like this:
			| 	| 1 | 2 | 3 |
			| 1 | 	| 	| 	|
			| 2 | x	| 	| 	|
			| 3 | 	| 	| 	|