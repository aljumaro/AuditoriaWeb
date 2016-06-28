Feature: Checkout
	This is the description of the feature, which can
	span multiple lines.
	You can even include empty lines, like this one:
	
	In fact, everything until the next Gherkin keyword is included
	in the description.


	Scenario Outline: Check out a banana
	Given the price of a "banana" is 40c
	When i checkout <count> "banana"
	Then the total price should be <total>c
	
	Examples:
	|	count	|	total	|
	|	1		|	40		|
	|	2		|	80		|
	|	3		|	120		|
	|	0		|	0		|