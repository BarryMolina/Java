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
public class Admin {
	Scanner keyboard = new Scanner(System.in);

	public void intro() {
		System.out.println("\nWelcome to Animal Farm. This app will help you"
				+ "\nkeep track of all your farm animals. You can add up to 5"
				+ "\nsheep, 5 Columbia sheep, and 5 chickens. You can then search"
				+ "\nyour animals by tag number, or simply display info for all "
				+ "\nanimals.");
		System.out.println("\nLets get started!");
		System.out.print("\nPress <enter> to continue");
		keyboard.nextLine();
	}
	
	public void goodbye() {
		System.out.println("\nThanks for using Animal Farm! Goodbye.\n");
	}
	
}
