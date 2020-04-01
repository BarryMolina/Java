/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_grocerylist;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class ListApp {

	private String filename = "groceries.txt";

	private List list = new List(filename);

	String item;
	int itemIdx;

	Scanner keyboard = new Scanner(System.in);

	public ListApp() throws IOException {
		list.loadFile();
	}

	public void run() throws IOException {
		boolean quit = false;

		int choice;

		while (!quit) {
			clearScreen();
			System.out.println("\n\n*************************************");
			System.out.println("\tGrocery List Main Menu");
			System.out.println("*************************************\n");
			System.out.println("[1] Display Items");
			System.out.println("[2] Add Items");
			System.out.println("[3] Delete Items");
			System.out.println("[4] Save and Exit");
			System.out.println();
			System.out.print("Enter your selection: ");
			choice = keyboard.nextInt();

			switch (choice) {
				case 1:
					displayList();
					break;
				case 2:
					keyboard.nextLine();
					addItems();
					break;
				case 3:
					deleteItems();
					break;
				case 4:
					list.save();
					quit = true;
			}
		} 
	}

	public void displayList() {
		clearScreen();
		System.out.println("\n\n*************************************");
		System.out.println("\tDisplay Grocery List Items");
		System.out.println("*************************************\n");
		
		displayItems();

		System.out.print("Press <enter> to return to Main Menu");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	
	public void addItems() {
		
		clearScreen();
		System.out.println("\n\n*************************************");
		System.out.println("\tAdd Grocery List Items");
		System.out.println("*************************************\n");
		
		displayItems();

		System.out.print("Enter name of item to add or 'q' to "
				+ "return to Main Menu: ");
		item = keyboard.nextLine();
		
		if (item.toLowerCase().charAt(0) != 'q') {

			list.addItem(item);

			addItems();
		}
	}
	
	public void deleteItems() {

		clearScreen();
		System.out.println("\n\n*************************************");
		System.out.println("\tDelete Grocery List Items");
		System.out.println("*************************************\n");

		displayItems();

		System.out.print("Enter item number to delete or 0 to "
				+ "return to Main Menu: ");
		itemIdx = keyboard.nextInt();

		if (itemIdx != 0 && list.getSize() > 0) {
			list.deleteItem(itemIdx - 1);
			deleteItems();
		}
	}

	public void displayItems() {

		if (list.getSize() < 1) {
			System.out.println("No items to display.\n");
		}
		else {
			for (int i = 0; i < list.getSize(); i++) {
				System.out.println((i + 1) + ". " + list.getItem(i));
			}
			System.out.println();
		}
	}
	
	public void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
