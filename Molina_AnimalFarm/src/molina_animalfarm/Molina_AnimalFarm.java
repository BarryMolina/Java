/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_animalfarm;

/**
 *
 * @author barrymolina
 */
public class Molina_AnimalFarm {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Admin a = new Admin();
		AnimalFarm af = new AnimalFarm();

		a.intro();
		af.farm();
		a.goodbye();
	}
	
}
