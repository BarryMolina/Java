/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_ofakind;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class Admin {
	Scanner keyboard = new Scanner(System.in);
	
	public void intro() {
		System.out.println("\nHello and welcome to OfAKind, a dice game.\n\n" +
			"In this game you'll roll 5 dice in each of 10 rounds. The player\n" +
			"with the most matching dice wins the round. If both players have\n" + 
			"the same number of matching dice, the set made up of the higher number wins.\n" +
			"If both sets match exactly, a tie is declared.\n" +
			"\nIf you win a round, you earn one point. After ten rounds, the player\n" +
			"with the most points is declared the winner.\n" +
			"\nLet's play!\n");
		System.out.println("(Press <enter> to contine)");
		keyboard.nextLine();

	}

	public void goodbye() {
		System.out.println("\nGoodbye!");
	}
	
}
