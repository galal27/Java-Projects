
//	The Game of Pig - Big Pig

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.*;

public class GameOfPig_12mmg3 {

	// Returns true or false with an equal probability of either.
	public static boolean randomTF() {
		return Math.random() > 0.5;
	} // end randomTF

	// Returns result of the first dice as a random integer of a 6 sided dice.
	public static int rollFirstDice() {
		Random rand = new Random();
		int resultFirst = rand.nextInt(6) + 1;
		return resultFirst;
	}// end rollFirstDice

	// Returns result of the second dice as a random integer of a 6 sided dice.
	public static int rollSecondDice() {
		Random rand = new Random();
		int resultSecond = rand.nextInt(6) + 1;
		return resultSecond;
	}// end rollSecondDice

	// Displays the starting conditions of the game - whether the computer is
	// playing
	// smart or not. Human goes first.
	public static void displayStartingConditions(boolean smartComputer) {
		System.out.print("The computer is playing ");
		if (smartComputer)
			System.out.println("smart.");
		else
			System.out.println("randomly.");

		System.out.println("You play first.");
	} // end displayStartingConditions

	// Display numbers rolled, given whose turn it was.
	public static void displayRolled(int playerChoice, int resultFirst, int resultSecond) {
		String message;
		if (playerChoice == 1)
			message = "\nYou rolled ";
		else
			message = "\nThe computer rolled ";
		if (resultFirst == 1 && resultSecond == 1)
			message += "two ones. That's 25 points!";
		else if (resultFirst == 1 || resultSecond == 1)
			message += "a " + resultFirst + " and a " + resultSecond + ". Turn is over!";
		else if (resultFirst == resultSecond)
			message += "two " + resultFirst + "'s. Score gets doubled!";
		else
			message += "a " + resultFirst + " and a " + resultSecond + "!";
		System.out.println(message);
	} // end displayRolled

	// The following method is from Prof. McLeod's IOHelper in exercise 1 and is
	// used to prevent an illegal choice.
	private static Scanner screenInput = new Scanner(System.in);

	public static int getInt(int low, String prompt, int high) {
		int numFromUser = 0;
		String dummy;
		boolean numericEntryOK;
		do {
			System.out.print(prompt);
			numericEntryOK = false;
			try {
				numFromUser = screenInput.nextInt();
				dummy = screenInput.nextLine();
				numericEntryOK = true;
			} catch (InputMismatchException e) {
				dummy = screenInput.nextLine();
				System.out.println(dummy + " is not an integer!");
				numFromUser = low;
			} // end try-catch
				// Indicate to the user why he is being prompted again.
			if (numFromUser < low || numFromUser > high) {
				System.out.println("The number is outside the legal limits.");
			}
		} while (!numericEntryOK || numFromUser < low || numFromUser > high);
		return numFromUser;
	} // end full parameter getInt method

	// Obtains and returns if the player would like to hold or roll again depending
	// on the rules of the game.
	// i.e. must roll if score same number on both dice. The use of the
	public static int getPlayerChoice(int resultFirst, int resultSecond) {
		String prompt;
		int playerChoice;

		if (resultFirst == 1 && resultSecond == 1)
			playerChoice = 1;
		else if (resultFirst == 1 || resultSecond == 1)
			playerChoice = 0;
		else if (resultFirst == resultSecond)
			playerChoice = 1;
		else {
			prompt = "Choose 0 to hold or 1 to roll: ";
			playerChoice = getInt(0, prompt, 1);
		}

		return playerChoice;
	} // end getPlayerChoice

	// Calculates and returns the computer's choice which depends on whether the
	// computer is
	// playing "smart" or randomly. The smart computer holds after more than 3
	// turns, or
	// if the turn yields greater than 20 points. This was based on a couple of
	// basic optimal strategies
	// seen online.
	public static int getComputerChoice(boolean smartComputer, int resultFirst, int resultSecond, int computerTurnTotal,
			int numTurns) {
		int computerChoice = 1;
		if (smartComputer) {
			if (numTurns <= 3 && computerTurnTotal <= 20) {
				if (resultFirst == 1 && resultSecond == 1)
					computerChoice = 1;
				else if (resultFirst == 1 || resultSecond == 1)
					computerChoice = 0;
				else if (resultFirst == resultSecond)
					computerChoice = 1;
				else
					computerChoice = 1;
			} else
				computerChoice = 0;
		} else {
			if (resultFirst == 1 && resultSecond == 1)
				computerChoice = 1;
			else if (resultFirst == 1 || resultSecond == 1)
				computerChoice = 0;
			else if (resultFirst == resultSecond)
				computerChoice = 1;
			else
				computerChoice = 1;
		}

		return computerChoice;
	} // end getComputerChoice

	// Obtains player turn total at end of each roll.
	public static int getPlayerTurnTotal(int resultFirst, int resultSecond) {
		int playerTurnTotal = 0;
		if (resultFirst == 1 && resultSecond == 1)
			playerTurnTotal += 25;
		else if (resultFirst == 1 || resultSecond == 1)
			playerTurnTotal += 0;
		else if (resultFirst == resultSecond)
			playerTurnTotal += (2 * resultFirst);
		else
			playerTurnTotal = resultFirst + resultSecond;
		return playerTurnTotal;
	} // end getPlayerTotal

	// Obtains player total at end of each turn. Turn totals are stored in an array,
	// which is summed
	// after each turn. The counter i is increased in gamePlay method.
	public static int getPlayerTotal(int playerTurnTotal, int i, int[] storeP) {
		int playerTotal;
		storeP[i] = playerTurnTotal;
		playerTotal = IntStream.of(storeP).sum();
		return playerTotal;
	} // end getPlayerTotal

	// Obtains computer total at end of each turn. Turn totals are stored in an
	// array, which is summed
	// after each turn. The counter j is increased in gamePlay method.
	public static int getComputerTotal(int computerTurnTotal, int j, int[] storeC) {
		int computerTotal;
		storeC[j] = computerTurnTotal;
		computerTotal = IntStream.of(storeC).sum();
		return computerTotal;
	} // end getComputerTotal

	// This method plays the Game of Pig and is provided with the starting
	// conditions of computer complexity.
	public static void playGame(boolean smartComputer) {
		int resultFirst, resultSecond;
		int playerTotal = 0, computerTotal = 0;
		int computerChoice, playerChoice = 1;
		int i = 0, j = 0, numTurns = 0;
		int[] storeP = new int[100];
		int[] storeC = new int[100];
		int playerTurnTotal = 0, computerTurnTotal = 0;

		while (computerTotal < 100 && playerTotal < 100) {

			while (playerChoice == 1) {
				resultFirst = rollFirstDice();
				resultSecond = rollSecondDice();
				displayRolled(playerChoice, resultFirst, resultSecond);
				playerTurnTotal = getPlayerTurnTotal(resultFirst, resultSecond);
				System.out.println("Player Turn Total: " + playerTurnTotal);
				playerTotal = getPlayerTotal(playerTurnTotal, i, storeP);
				i++;
				System.out.println("Player Total: " + playerTotal);
				playerChoice = getPlayerChoice(resultFirst, resultSecond);

			}

			do {
				resultFirst = rollFirstDice();
				resultSecond = rollSecondDice();
				displayRolled(playerChoice, resultFirst, resultSecond);
				computerTurnTotal = getPlayerTurnTotal(resultFirst, resultSecond);
				System.out.println("Computer Turn Total: " + computerTurnTotal);
				computerTotal = getComputerTotal(computerTurnTotal, j, storeC);
				j++;
				System.out.println("Computer Total: " + computerTotal);
				computerChoice = getComputerChoice(smartComputer, resultFirst, resultSecond, computerTurnTotal,
						numTurns);
				numTurns++;
				if (computerChoice == 0) {
					playerChoice = 1;
				}
			} while (computerChoice == 1);
		}

		if (playerTotal >= 100)
			System.out.println("\nYou win!!");
		else
			System.out.println("\nComputer wins!");

	} // end playGame

	// main generates and displays the starting conditions, and then starts the game
	// method.
	public static void main(String[] args) {
		boolean smartComputer = randomTF();
		displayStartingConditions(smartComputer);
		playGame(smartComputer);
	} // end main

}
