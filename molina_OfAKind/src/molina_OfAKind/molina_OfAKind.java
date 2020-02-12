/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_OfAKind;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barry
 * Barry Molina, ITDEV-110-500, Assignment 8
 */
public class molina_OfAKind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, LineUnavailableException {
        int ROUNDS = 10;
        int NUM_DICE = 5;
        int FACES_PER_DIE = 6;
		Dice d;
		Matcher m;
		int[] dice;

		//Admin a = new Admin();
        //Game g;

		//a.intro();
		//g = new Game(ROUNDS, NUM_DICE, FACES_PER_DIE);
		//do  {
            //g.play();
		//} while (g.playAgain() == 'y');
		//a.goodbye();
		d = new Dice();
		dice = d.getValues();
		m = new Matcher(dice);
        m.calcMatches();
		for (int x = 0; x < dice.length; x++) {
			System.out.print(dice[x] + " ");
			System.out.println();
		}
		System.out.println("Most matches: " + m.getMostMatches()
						+ " match value: " + m.getMatchValue());
		
    }
    
}
