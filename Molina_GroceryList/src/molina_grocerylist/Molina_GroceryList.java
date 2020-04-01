/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_grocerylist;

import java.io.IOException;

/**
 *
 * @author barrymolina
 */
public class Molina_GroceryList {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		Admin a = new Admin();
		ListApp app = new ListApp();

		a.intro();
		app.run();
		a.goodbye();
	}
	
}
