/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

/**
 *
 * @author barry
 */
public class Score implements Comparable<Score> {

    private String name;
    private int score;
    private DifficultyLevel difficulty;

    public Score(String name, Integer score, DifficultyLevel difficulty) {
        this.name = name;
        this.score = score;
        this.difficulty = difficulty;
    }

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Score o) {
        return this.getScore().compareTo(o.getScore());

    }
    @Override
    public String toString() {
        return name + " " + score + " " + difficulty;
                
    }
    
}
