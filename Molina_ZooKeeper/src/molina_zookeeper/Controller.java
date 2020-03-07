/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_zookeeper;

import java.util.Scanner;


/**
 *
 * @author barrymolina
 */
public class Controller {

	private final int QUIT = -999;

	Zoo zoo = new Zoo();

	Scanner keyboard = new Scanner(System.in);

	public void run() {
		int choice;

		do {
			clearScreen();
			System.out.println("\n\n*************************************");
			System.out.println("\tZooKeeper Main Menu");
			System.out.println("*************************************\n");
			System.out.println("[1] Display All Animals");
			System.out.println("[2] Exit Program");
			System.out.println();
			System.out.print("Enter your selection: ");
			choice = keyboard.nextInt();

			switch (choice) {
				case 1:
					displayAll(zoo);
					break;
				case 2:
					choice = QUIT;
			}
		} while (choice != QUIT);
	}

	public void displayAll(Zoo zoo) {
		Animal [][] animal = zoo.getAnimal();
		String [] animalClass = zoo.getAnimalClass();

		clearScreen();
		System.out.println("\n\n*************************************");
		System.out.println("\tDisplay All Zoo Animals");
		System.out.println("*************************************");

		for (int i = 0; i < animal.length; i++) {
			System.out.println("-------------------------------------");
			System.out.println("\t\t" + animalClass[i] + "s");
			System.out.println("-------------------------------------");

			for (int j = 0; j < animal[i].length; j++) {
				System.out.println(animal[i][j]);
			}
		}
		System.out.print("Press <enter> to return to Main Menu");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	
	public void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
}
