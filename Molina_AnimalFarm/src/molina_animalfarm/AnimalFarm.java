/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_animalfarm;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class AnimalFarm {

	private final int QUIT = -999;

	private final int MAX_ANIMALS = 5;

	private final int SHEEP_IDX = 0;
	private final int COLUMBIA_IDX = 1;
	private final int CHICKEN_IDX = 2;

	private int [] animalCount = {0, 0, 0};

	Sheep [] sheep = new Sheep[MAX_ANIMALS];
	Columbia [] columbia = new Columbia[MAX_ANIMALS];
	Chicken [] chicken = new Chicken[MAX_ANIMALS];

	Animal [][] animal = {sheep, columbia, chicken};

	Scanner keyboard = new Scanner(System.in);

	public void farm() {
		int choice;

		do {
			clearScreen();
			System.out.println("\n\n*************************************");
			System.out.println("\tAnimal Farm Main Menu");
			System.out.println("*************************************\n");
			System.out.println("[1] Add Animal");
			System.out.println("[2] Find Animal");
			System.out.println("[3] Display All Animals");
			System.out.println("[4] Exit Program");
			System.out.println();
			System.out.print("Enter your selection: ");
			choice = keyboard.nextInt();

			switch (choice) {
				case 1:
					addFarm();
					break;
				case 2:
					find();
					break;
				case 3:
					displayAll();
					break;
				case 4:
					choice = QUIT;
			}
		} while (choice != QUIT);
	}

	public void addFarm() {
		int choice;
		do {
			clearScreen();
			System.out.println("\n\n**********************************");
			System.out.println("\tAdd Animal to Farm");
			System.out.println("**********************************\n");
			System.out.println("Select type of animal to add: \n");
			System.out.println("[1] Sheep");
			System.out.println("[2] Columbia Sheep");
			System.out.println("[3] Chicken");
			System.out.println("[4] Return to Main Menu");
			System.out.println();
			System.out.print("Enter your selection: ");
			choice = keyboard.nextInt();
			keyboard.nextLine();


			switch (choice) {
				case 1:
					addSheep();
					break;
				case 2:
					addColumbia();
					break;
				case 3:
					addChicken();
					break;
				case 4:
					choice = QUIT;
			}
		} while (choice != QUIT);
	}
	
	public void find() {
		Animal a;
		String tagNum;
		boolean found;

		keyboard.nextLine();
		clearScreen();
		System.out.println("\n\n****************************************");
		System.out.println("\tFind Animal by Tag Number");
		System.out.println("****************************************\n");

		System.out.print("Enter tag number of animal or q to return to "
				+ "the Main Menu: ");
		tagNum = keyboard.nextLine();

		while (tagNum.toUpperCase().charAt(0) != 'Q') {
			found = false;

			for (int i = 0; !found && i < animal.length; i++) {
				for (int j = 0; !found && j < animalCount[i]; j++) {
					if (animal[i][j].getTagNumber().equalsIgnoreCase(tagNum)) {
						System.out.println();
						System.out.println(animal[i][j].displayAll());
						found = true;
					}
				}
			}
			if (!found) {
				System.out.println("\n\tI'm sorry, no animal with that tag was found.\n");
			}

			System.out.print("Enter tag number of animal or q to return to "
					+ "the Main Menu: ");
			tagNum = keyboard.nextLine();
		}
	}
	public void displayAll() {
		clearScreen();
		System.out.println("\n\n****************************************");
		System.out.println("\tDisplay All Farm Animals");
		System.out.println("****************************************\n");
		for (int i = 0; i < animal.length; i++) {
			for (int j = 0; j < animalCount[i]; j++) {
				System.out.println(animal[i][j].displayAll());
			}
		}
		keyboard.nextLine();
		System.out.print("Press <enter> to return to Main Menu");
		keyboard.nextLine();
	}

	public void inputAnimalInfo(Animal a) {
		System.out.print("Enter Tag Number: ");
		a.setTagNumber(keyboard.nextLine());
		System.out.print("Enter Gender: ");
		a.setGender(keyboard.nextLine());
		System.out.print("Enter Location: ");
		a.setLocation(keyboard.nextLine());
	}
	
	public void inputSheepInfo(Sheep s)  {
		System.out.print("Enter Breed: ");
		s.setBreed(keyboard.nextLine());
		System.out.print("Enter Age: ");
		s.setAge(keyboard.nextInt());
		System.out.print("Enter Sale Price: ");
		s.setSalePrice(keyboard.nextDouble());
		keyboard.nextLine();
	}
	public void inputColumbiaInfo(Columbia c) {
		System.out.print("Has this Columbia sheep been sold? y/n: ");
		if (keyboard.nextLine().toUpperCase().charAt(0) == 'Y') {
			c.setIsSold(true);
		}
		else {
			c.setIsSold(false);
		}
	}
	public void inputChickenInfo(Chicken c) {
		System.out.print("Enter egg color: ");
		c.setEggColor(keyboard.nextLine());
		System.out.print("Enter egg count: ");
		c.setEggCount(keyboard.nextInt());
		keyboard.nextLine();
	}

	public void addSheep() {
		Sheep thisSheep;
		char another = 'N';
		int sheepCount;

		do {
			if (animalCount[SHEEP_IDX] < MAX_ANIMALS) {

				sheepCount = animalCount[SHEEP_IDX];

				sheep[sheepCount] = new Sheep();
				thisSheep = sheep[sheepCount];
				
				System.out.println("\n\nAdding Sheep #" + (sheepCount + 1) + " to Farm\n");
				thisSheep.setAnimalClassification("Sheep");
				inputAnimalInfo(thisSheep);
				inputSheepInfo(thisSheep);

				animalCount[SHEEP_IDX]++;
				if (animalCount[SHEEP_IDX] < MAX_ANIMALS) {
					System.out.print("\nAdd another sheep? y/n: ");
					another = keyboard.nextLine().toUpperCase().charAt(0);
				}
			} 
			else {
				System.out.println("\nMaximum number of sheep added.");
				System.out.print("\nPress <enter> to return to Add Animal Menu");
				keyboard.nextLine();
				another = 'N';
			}
		} while (another == 'Y');
	}
	public void addColumbia() {
		Columbia thisColumbia;
		char another = 'N';
		int columbiaCount;

		do {
			if (animalCount[COLUMBIA_IDX] < MAX_ANIMALS) {

				columbiaCount = animalCount[COLUMBIA_IDX];

				columbia[columbiaCount] = new Columbia();
				thisColumbia = columbia[columbiaCount];
				
				System.out.println("\n\nAdding Columbia sheep #" + 
						(columbiaCount + 1) + " to Farm\n");
				thisColumbia.setAnimalClassification("Columbia Sheep");
				inputAnimalInfo(thisColumbia);
				inputSheepInfo(thisColumbia);
				inputColumbiaInfo(thisColumbia);

				animalCount[COLUMBIA_IDX]++;
				if (animalCount[COLUMBIA_IDX] < MAX_ANIMALS) {
					System.out.print("\nAdd another Columbia sheep? y/n: ");
					another = keyboard.nextLine().toUpperCase().charAt(0);
				}
			} 
			else {
				System.out.println("\nMaximum number of Columbia sheep added.");
				System.out.print("\nPress <enter> to return to Add Animal Menu");
				keyboard.nextLine();
				another = 'N';
			}
		} while (another == 'Y');
	}
	public void addChicken() {
		Chicken thisChicken;
		char another = 'N';
		int chickenCount;

		do {
			if (animalCount[CHICKEN_IDX] < MAX_ANIMALS) {

				chickenCount = animalCount[CHICKEN_IDX];

				chicken[chickenCount] = new Chicken();
				thisChicken = chicken[chickenCount];
				
				System.out.println("\n\nAdding Chicken #" + (chickenCount + 1) + " to Farm\n");
				thisChicken.setAnimalClassification("Chicken");
				inputAnimalInfo(thisChicken);
				inputChickenInfo(thisChicken);

				animalCount[CHICKEN_IDX]++;
				if (animalCount[CHICKEN_IDX] < MAX_ANIMALS) {
					System.out.print("\nAdd another chicken? y/n: ");
					another = keyboard.nextLine().toUpperCase().charAt(0);
				}
			} 
			else {
				System.out.println("\nMaximum number of chicken added.");
				System.out.print("\nPress <enter> to return to Add Animal Menu");
				keyboard.nextLine();
				another = 'N';
			}
		} while (another == 'Y');
	}
	public void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
