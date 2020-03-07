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
public class Admin {
	Scanner keyboard = new Scanner(System.in);

	public void intro() {
		System.out.println("\nWelcome to ZooKeeper. This app can help zoo keepers "
				+ "\nkeep track of all their zoo animals. This app comes "
				+ "\npre-loaded with an assortment of mammals, reptiles,"
				+ "\nand birds for your viewing pleasure.");
		System.out.println("\nEnjoy!");
		System.out.print("\nPress <enter> to continue");
		keyboard.nextLine();
	}
	
	public void goodbye() {
		System.out.println("\nThanks for using ZooKeeper! Goodbye.\n");
	}
	
}
