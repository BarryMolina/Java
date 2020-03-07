/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_monstermash;

/**
 *
 * @author barrymolina
 */
public class Molina_MonsterMash {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Admin a = new Admin();
		Controller ctrl;

		a.intro();
		ctrl = new Controller();
		a.goodBye();
	}
}
