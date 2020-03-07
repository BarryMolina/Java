/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_zookeeper;

/**
 *
 * @author barrymolina
 */
public class Molina_ZooKeeper {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Admin a = new Admin();
		Controller ctrl = new Controller();

		a.intro();
		ctrl.run();
		a.goodbye();
		
	}
	
}
