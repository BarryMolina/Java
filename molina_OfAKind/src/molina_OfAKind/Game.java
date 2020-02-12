/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barry
 */
public class Game {

    Scanner keyboard = new Scanner(System.in);
    Dice d;

    int computer;
    int user; 

    int numRounds;
   
    public Game(int rounds, int dice, int faces) {
        numRounds = rounds;

        d = new Dice(dice, faces);

    }
    public void play() throws InterruptedException, LineUnavailableException {
		char response; 
        boolean quit = false;
        int round = 0;

		computer = 0;
		user = 0;
        
        while (round < numRounds && quit == false) {
			System.out.print("Press 'r' to to begin Round 1 or 'q' to quit: ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
			while (response != 'R' && response != 'Q') {
                System.out.print("Press 'r' to begin Round 1 or 'q' to quit: ");
                response = keyboard.nextLine().toUpperCase().charAt(0);
			}
            if (response == 'R') {
				System.out.println("\n");
				System.out.println("Round " + (round + 1) + " results:");
				System.out.println("-------------------------------------");
				System.out.println();
				compTurn = roll();
				playerTurn = roll();
				System.out.println("Player: " + )
            }
            else {
                quit = true;
            }
			SoundUtils.tone(392,150);
            System.out.println("Computer's turn.");
            Thread.sleep(MEDIUM);
            System.out.println();
			SoundUtils.tone(523,150);
            System.out.println("Your turn.");
            System.out.println();
            round++;
        }
        if (quit == false) {
            matchResults();
        }
    }
    public void roll() {
        int[] values;
		d.rollDice();
        values = d.getValues();

		return new Matcher(values);
    }
    public void matchResults() throws InterruptedException, LineUnavailableException {
        System.out.println();
        System.out.print("And the winner is");
        for (int x = 0; x < 3; x++) {
            System.out.print(".");
            Thread.sleep(VERY_SHORT);
        }
        System.out.println("\n");
        if (computer.getTotal() > user.getTotal()) {
            System.out.println(computer.getName() + "!!");
			SoundUtils.tone(523,150);
			SoundUtils.tone(261,300);
			}
        else if (computer.getTotal() < user.getTotal()) {
            System.out.println(user.getName() + "!!");
			SoundUtils.tone(261,120);
			SoundUtils.tone(392,120);
			SoundUtils.tone(523,120);
			Thread.sleep(60);
			SoundUtils.tone(392,120);
			SoundUtils.tone(523,200);
        }
        else {
            System.out.println("It's a tie!!!");
			SoundUtils.tone(261,200);
        }
    }
	public char playAgain() {
        char again;
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.print("y/n: ");

        again = keyboard.next().toLowerCase().charAt(0);
        keyboard.nextLine();

		return again;
	}
}
