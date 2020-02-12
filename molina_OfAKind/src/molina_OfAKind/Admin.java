/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_OfAKind;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Admin {
	Scanner keyboard = new Scanner(System.in);
	
	public void intro() throws LineUnavailableException {
		System.out.println("\nHello and welcome to OfAKind, a dice game.\n\n" +
			"In this game there are ten rounds and you'll roll 5 dice in each round.\n" +
			"In each round, the player with the most matching dice wins the round.\n" +
			"If both players have the same number of matching dice, the set made up of\n" +
			"the higher number wins. If both sets contain the same number, a tie is declared.\n" +
			"By the end of ten rounds, the player with the most wins is declared the winner.\n" +
			"\nLet's play!\n");
        SoundUtils.tone(261,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(523,300);
		System.out.println("(Press <enter> to contine)");
		keyboard.nextLine();

	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("\nGoodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
}
