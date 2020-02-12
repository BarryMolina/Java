/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_ofakind2;

import java.util.Random;

/**
 *
 * @author barrymolina
 */
public class Dice {

    Random p = new Random();

    private final int NUM_FACES = 6;
	private final int NUM_DICE = 5;

    int[] values;
    
	public Dice() {
		values = new int[NUM_DICE];
		rollDice();
	}

    public int[] getValues() {
        return values;
    }
    public void rollDice() {
        for (int x = 0; x < values.length; x++) {
            values[x] = p.nextInt(NUM_FACES) + 1;
        }
    }
	@Override
	public String toString() {
		String str = ""; 
		for (int i = 0; i < values.length; i++) {
			str += "[" + values[i] + "]";
		}
		return str;
	}
	
}
