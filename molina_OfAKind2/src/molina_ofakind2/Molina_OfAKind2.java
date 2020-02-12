/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_ofakind2;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Molina_OfAKind2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws LineUnavailableException {
		Admin a = new Admin();
		Game g;


		a.intro();
		g = new Game();
		do  {
            g.play();
		} while (g.playAgain() == 'y');
		a.goodbye();
	}
}
