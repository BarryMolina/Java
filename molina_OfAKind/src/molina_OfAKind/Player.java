/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_OfAKind;

/**
 *
 * @author barry
 */
public class Player {
    
    private String name;
	int[][] allScores;

    public Player(String name, int rounds, int dice) {
        this.name = name;
        allScores = new int[rounds][dice];
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        int total = 0;
        for (int round = 0; round < allScores.length; round++) {
            for (int die = 0; die < allScores[round].length; die++) {
                total += allScores[round][die];
            }
        }
        return total;
    }
    public void setScores(int round, int[] scores) {
        for (int die = 0; die < allScores[round].length; die++) {
            allScores[round][die] = scores[die];
        }
    }
    public void resetScores() {
        for (int round = 0; round < allScores.length; round++) {
            for (int die = 0; die < allScores[round].length; die++) {
                allScores[round][die] = 0;
            }
        }
    }
    public void roll(Dice d) {
        d.rollDice();

    }
}
