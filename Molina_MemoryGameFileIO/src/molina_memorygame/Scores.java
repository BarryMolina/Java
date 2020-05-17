/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author barry
 */
public class Scores {

    final String fileName = "scores.txt";

    private final int NAME_IDX = 0;
    private final int SCORE_IDX = 1;
    private final int DIFFICULTY_IDX = 2;

    private ArrayList<Score> easyScores = new ArrayList<Score>();
    private ArrayList<Score> mediumScores = new ArrayList<Score>();
    private ArrayList<Score> hardScores = new ArrayList<Score>();

    public void fillScores() {
        Score score;
        String line;
        String[] scoreArr;
        try {
            File file = new File(fileName);
            Scanner inFile = new Scanner(file);

            while (inFile.hasNext()) {
                line = inFile.nextLine();
                scoreArr = line.split(" ");
                score = new Score(scoreArr[NAME_IDX], Integer.parseInt(scoreArr[SCORE_IDX]));
                
                if (scoreArr[DIFFICULTY_IDX].equalsIgnoreCase("HARD")) {
                    score.setDifficulty(DifficultyLevel.HARD);
                    hardScores.add(score);
                }
                else if (scoreArr[DIFFICULTY_IDX].equals("MEDIUM")) {
                    score.setDifficulty(DifficultyLevel.MEDIUM);
                    mediumScores.add(score);
                }
                else if (scoreArr[DIFFICULTY_IDX].equals("EASY")) {
                    score.setDifficulty(DifficultyLevel.EASY);
                    easyScores.add(score);
                }
            }
            inFile.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(easyScores);
        Collections.sort(mediumScores);
        Collections.sort(hardScores);
    }
    public void addScore(Score score) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            PrintWriter outFile = new PrintWriter(writer);
            outFile.println(score);
            outFile.close();
            
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void resetScores() {
        try {
            PrintWriter outFile = new PrintWriter(fileName);
            outFile.println("Barry 17 EASY");
            outFile.println("Lizzie 15 EASY");
            outFile.println("Baz 120 MEDIUM");
            outFile.close();
            
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Score> getEasyScores() {
        return easyScores;
    }

    public ArrayList<Score> getMediumScores() {
        return mediumScores;
    }

    public ArrayList<Score> getHardScores() {
        return hardScores;
    }
    
    @Override
    public String toString() {
        return easyScores.toString() + "\n" +
                mediumScores.toString() + "\n" +
                hardScores.toString();
        
    }
}
