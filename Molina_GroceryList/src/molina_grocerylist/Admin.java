/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_grocerylist;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class Admin {
	Scanner keyboard = new Scanner(System.in);

	public void intro() {
		System.out.println("Welcome to GroceryList, the app that will help you"
				+ "\nfulfill all you grocery list needs. "
				+ "\n\nTo create a new list, simply select \"Add Items\" from "
				+ "\nthe Main Menu and then enter each item you would"
				+ "\nlike to add to the list. To delete an item, you can"
				+ "\nselect the \"Delete Items\" option from the Main Menu. "
				+ "\nonce you have every item added to your list, simple select "
				+ "\n\"Save and Exit\" from the Main Menu and your grocery list"
				+ "\nwill be saved as a text document in the root folder of this"
				+ "\napp. The next time you open the app your list will be loaded"
				+ "\ninto the program so you can add or modify as needed."); 
		System.out.println("\nHappy shopping!");
		System.out.print("\nPress <enter> to continue");
		keyboard.nextLine();
	}
	
	public void goodbye() {
		System.out.println("\nYour list has been saved. Goodbye!\n");
	}
	
}
