/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_monstermash;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class Controller {

	private final int NUMBER_OF_MONSTERS = 12;
	private Monster[] monster;

	Scanner keyboard = new Scanner(System.in);

	public Controller() {
		char watchBattle;
		monster = new Monster[NUMBER_OF_MONSTERS];

		monster[0] = new Demogorgon("D'Artagnan", 8, 5, 10);
		monster[1] = new Demogorgon("Athos", 5, 6, 7);
		monster[2] = new Demogorgon("Aramis", 2, 8, 5);
		monster[3] = new Balrog("Durin's Bane", 8, 9, 4);
		monster[4] = new Balrog("Gothmog", 7, 10, 5);
		monster[5] = new Balrog("Lungorthin", 7, 9, 5);
		monster[6] = new Vampire("Dracula", 8, 6, 8);
		monster[7] = new Vampire("Adrian", 5, 7, 9);
		monster[8] = new Vampire("Kieran", 4, 5, 9);
		monster[9] = new Werewolf("Lucian", 8, 7, 6);
		monster[10] = new Werewolf("Elena", 6, 6, 8);
		monster[11] = new Werewolf("Remus", 5, 6, 7);

		meetTheMonsters();
		
		System.out.println("\nWould you like to see a battle between two Monsters?");
		System.out.print("y/n: ");

        watchBattle = keyboard.next().toLowerCase().charAt(0);
		if (watchBattle == 'y') {
			do {
				battle();
			} while (battleAgain() == 'y'); 
		}
        keyboard.nextLine();
	}
	public void meetTheMonsters() {
		
		System.out.printf("\n\n%-20s%-20s%-20s%-10s%s", "Monster Name", 
						"Monster Type", "Scare Factor", "Size", "Speed");
		System.out.println("\n--------------------------------------------"
				+ "--------------------------------");
		for (Monster m : monster) {
			System.out.printf("%-20s%-25s%-16s%-10s%s\n", m.getName(), 
							m.getMonsterType(), m.getScareFactor(), m.getSize(), 
							m.getSpeed());
		}
	}
	public void battle() {
		Monster m1;
		Monster m2;
		int m1Idx;
		int m2Idx;

		Random rand = new Random();

		m1Idx = rand.nextInt(monster.length);
		do {
			m2Idx = rand.nextInt(monster.length);
		} while (m2Idx == m1Idx);

		m1 = monster[m1Idx];
		m2 = monster[m2Idx];
		
		System.out.println("\n\t\t\t\tMONSTER BATTLE");
		System.out.println("***********************************************"
				+ "*****************************");
		System.out.printf("\n%-20s%-20s%-20s%-10s%s", "Monster Name", 
						"Monster Type", "Scare Factor", "Size", "Speed");
		System.out.println("\n--------------------------------------------"
				+ "--------------------------------");
		introduceMonster(m1);
		introduceMonster(m2);
		System.out.println();

		if (m1.getPowerIndex() > m2.getPowerIndex()) {
			displayWinner(m1);
		}
		else if (m2.getPowerIndex() > m1.getPowerIndex()) {
			displayWinner(m2);
		}
		else {
			System.out.println("It's a tie!!!");
		}

	}
	public void introduceMonster(Monster m) {
		System.out.printf("%-20s%-25s%-16s%-10s%s\n", m.getName(), 
						m.getMonsterType(), m.getScareFactor(), m.getSize(), 
						m.getSpeed());
	}
	public void displayWinner(Monster m) {
		System.out.println("And the winner is... " + m.getName() + " the " +
						   m.getMonsterType() + "!");
		m.speak();

	}
	public char battleAgain() {
        char again;
		System.out.println();
		System.out.println("Would you like to see another battle?");
		System.out.print("y/n: ");

        again = keyboard.next().toLowerCase().charAt(0);

		return again;
	}
}
