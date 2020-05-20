/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

/**
 * This class stores information about each game that is played.
 * This class implements the Comparable interface so that Score objects can be sorted.
 */
public class Score implements Comparable<Score> {

    // The player's name.
    private String name;
    // The number of turns taken to find all the matches.
    private int score;
    // The difficulty level selected.
    private DifficultyLevel difficulty;

    /**
     * Takes a name, score, and difficulty level and creates a Score object.
     * @param name The player name.
     * @param score The number of turns.
     * @param difficulty Difficulty level selected.
     */
    public Score(String name, Integer score, DifficultyLevel difficulty) {
        this.name = name;
        this.score = score;
        this.difficulty = difficulty;
    }

    /**
     * Takes a name and score to create a Score object.
     * @param name The player name.
     * @param score The number of turns.
     */
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Gets the player name for this score.
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's score.
     * @return The score.
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Gets the difficulty level played at for this score.
     * @return This score's difficulty level.
     */
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty level for this score.
     * @param difficulty The difficulty level for this score.
     */
    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Compares two Score objects based on their score fields.
     * @param o The score being compared
     * @return A negative integer, zero, or a positive integer depending on whether this Score is lower, the same, or higher than another Score.
     */
    @Override
    public int compareTo(Score o) {
        return this.getScore().compareTo(o.getScore());
    }
    /**
     * Returns a String that includes the player name, score, and difficulty for this Score.
     * @return a String that includes the player name, score, and difficulty for this Score.
     */
    @Override
    public String toString() {
        return name + " " + score + " " + difficulty;
                
    }
    
}
