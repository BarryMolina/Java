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
 * This class stores a list of sorted score objects for each difficulty level.
 * It fills these lists by reading from text file and appends new scores to the file.
 */
public class Scores {

    // The filename containing scores.
    final String fileName = "scores.txt";

    // The location of the name on the score.
    private final int NAME_IDX = 0;
    // The location of the turn count on the score.
    private final int SCORE_IDX = 1;
    // The location of the difficulty level.
    private final int DIFFICULTY_IDX = 2;

    // A list of easy scores.
    private ArrayList<Score> easyScores = new ArrayList<Score>();
    // A list of medium scores.
    private ArrayList<Score> mediumScores = new ArrayList<Score>();
    // A list of hard scores.
    private ArrayList<Score> hardScores = new ArrayList<Score>();

    /**
     * Reads the score file and loads each score into the appropriate list.
     */
    public void fillScores() {
        // A Score variable to hold each score.
        Score score;
        // Each line read from the file
        String line;
        // A string array that each line will be parsed into
        String[] scoreArr;
        try {
            File file = new File(fileName);
            Scanner inFile = new Scanner(file);

            while (inFile.hasNext()) {
                line = inFile.nextLine();
                scoreArr = line.split(" ");
                score = new Score(scoreArr[NAME_IDX], Integer.parseInt(scoreArr[SCORE_IDX]));
                
                // Parse each score into the appropriate list
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
    /**
     * Appends a new score to the text file.
     * @param score The score to append.
     */
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
    /**
     * Clears the score file and adds some default values.
     */
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

    /**
     * Get easy scores.
     * @return Easy scores
     */
    public ArrayList<Score> getEasyScores() {
        return easyScores;
    }

    /**
     * Get medium scores.
     * @return Medium scores
     */
    public ArrayList<Score> getMediumScores() {
        return mediumScores;
    }

    /**
     * Get hard scores.
     * @return Hard scores
     */
    public ArrayList<Score> getHardScores() {
        return hardScores;
    }
    
    /**
     * Returns a string of all the scores.
     * @return All the scores
     */
    @Override
    public String toString() {
        return easyScores.toString() + "\n" +
                mediumScores.toString() + "\n" +
                hardScores.toString();
    }
}
