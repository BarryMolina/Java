/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_ofakind2;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Game {

    Scanner keyboard = new Scanner(System.in);
    Dice d;
	
    private final int NUM_ROUNDS = 10;

    private int computer;
    private int user; 
	private String userName;

   
    public Game() {

        d = new Dice();
		System.out.print("Enter your name: ");
		if ((userName = keyboard.nextLine()).isEmpty())
			userName = "User";

    }
    public void play() throws LineUnavailableException {
		Matcher compTurn;
		Matcher userTurn;
		char response; 
        boolean quit = false;
        int round = 0;

		computer = 0;
		user = 0;
        
        while (round < NUM_ROUNDS && quit == false) {
			System.out.print("\nPress 'r' to to begin Round 1 or 'q' to quit: ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
			while (response != 'R' && response != 'Q') {
                System.out.print("\nPress 'r' to begin Round 1 or 'q' to quit: ");
                response = keyboard.nextLine().toUpperCase().charAt(0);
			}
            if (response == 'R') {
				SoundUtils.tone(523,150);
				System.out.println();
				System.out.println("Round " + (round + 1) + " results:");
				System.out.println();
				System.out.printf("%-12s%-20s%-20s%s\n", "Player", "Roll", "Best Match",
						"Kind");
				System.out.println("----------------------------------------------"
						+ "-------------------");
				compTurn = turn("Computer");
				userTurn = turn(userName);
				System.out.print("\nRound Winner: ");
				if (compTurn.greaterThan(userTurn)) {
					System.out.println("Computer");
					computer++;
				}
				else if (userTurn.greaterThan(compTurn)) {
					System.out.println(userName);
					user++;
				}
				else {
					System.out.println("Tie");
				}
				System.out.println("\nComputer: " + computer + " " + userName + 
						": "+ user); 
						
            }
            else {
                quit = true;
            }
            round++;
        }
        if (quit == false) {
            matchResults();
        }
    }
	public Matcher turn(String player) {
		Matcher roll;

		d.rollDice();
		roll = new Matcher(d.getValues());

		System.out.printf("%-12s%-20s%-20s%s\n", player + ":", 
				roll.getDice(), roll.getMatches(),
				roll.getOfAKind());
		return roll;
	} 
    public void matchResults() {
        System.out.println();
        System.out.print("And the winner is... ");
        if (computer > user) {
            System.out.println("Computer!!");
			}
		else if (user > computer) {
            System.out.println(userName + "!!");
			}
        else {
            System.out.println("It's a tie!!!");
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
