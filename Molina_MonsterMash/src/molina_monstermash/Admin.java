/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_monstermash;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class Admin {

	Scanner keyboard = new Scanner(System.in);
	public void intro()
	{
		System.out.println("\nWelcome to MONSTER MASH!!\n");
		System.out.println("This app will introduce you to 12 different monsters"
				+ "\nand then ask if you'd like to see two of them battle."
				+ "\nThe winner will be decided based on each monster's individual"
				+ "\nscare factor, size, and speed. You may watch as many battles"
				+ "\nas you wish.\n");
		System.out.print("Press <enter> to continue");
		keyboard.nextLine();

	}
	public void goodBye()
	{
		System.out.println("\nThanks for playing! Goodbye.");
	}
}
