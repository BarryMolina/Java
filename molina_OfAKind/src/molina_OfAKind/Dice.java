/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_OfAKind;

import java.util.Random;

/**
 *
 * @author barry
 */
public class Dice {

    Random p = new Random();

    int numFaces;
    int[] values;
    
	public Dice() {
		numFaces = 6;
		values = new int[5];
	}
    public Dice(int dice, int faces) {
        numFaces = faces;

        values = new int[dice];
    }
    public int[] getValues() {
        return values;
    }
    public void rollDice() {
        for (int x = 0; x < values.length; x++) {
            values[x] = p.nextInt(numFaces) + 1;
        }
    }
}
