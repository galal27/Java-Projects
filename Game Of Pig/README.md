# Game of Pig (Big Pig)

This project was part of a Queen's Computer Engineering Java course. The purpose of this project is to practice designing and coding methods, and using loops, conditionals and console I/O.

The Game of Pig has been around for quite a while, requiring just one or two dice to play. The Wikipedia entry for more information. This project will use the two-dice variation called "Big Pig", and we will write a program that will allow a player to play against the computer. The rules of the game are:

 - The first player to accumulate a score of 100 or more wins.
 - The human goes first.
 - After one roll, a player has the choice to "hold" or to roll again.
 - You roll two dice. Certain conditions apply:
 - If both dice are ones, then you add 25 to your turn score, and you must roll again.
 - If one dice is one, then your turn is over and your turn score is set to zero.
 - If both dice match ("doubles"), other than ones, then you gain twice the sum of the dice, and you must roll again. For example if you rolled two fours, you would gain 16 and then have to roll again.
 - For any other dice combination, you just add the dice total to your turn score and you have the choice of rolling again.
 - When your turn is over, either through your choice or you rolled a one, then your turn sum is added to your accumulated score.
