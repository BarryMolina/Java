/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;

/**
 *
 * @author barry
 */
public class Scores {

//    final String DB_URL = "jdbc:derby://localhost:1527/MemoryGameDB;user=sa;password=sa;create=true";
    final String DB_URL = "jdbc:derby:MemoryGameDB;create=true";

    private ArrayList<Score> easyScores = new ArrayList<Score>();
    private ArrayList<Score> mediumScores = new ArrayList<Score>();
    private ArrayList<Score> hardScores = new ArrayList<Score>();

    public void fillScores() {
        Score score;
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Scores";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                score = new Score(res.getString("Name"), res.getInt("Score"));
                if (res.getString("Difficulty").equals("HARD")) {
                    score.setDifficulty(DifficultyLevel.HARD);
                    hardScores.add(score);
                }
                else if (res.getString("Difficulty").equals("MEDIUM")) {
                    score.setDifficulty(DifficultyLevel.MEDIUM);
                    mediumScores.add(score);
                }
                else if (res.getString("Difficulty").equals("EASY")) {
                    score.setDifficulty(DifficultyLevel.EASY);
                    easyScores.add(score);
                }
            }
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(easyScores);
        Collections.sort(mediumScores);
        Collections.sort(hardScores);
    }
    public void addScore(Score score) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String sql = "INSERT INTO Scores (Name, Score, Difficulty) VALUES "
                    + "(?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, score.getName());
            pstmt.setInt(2, score.getScore());
            pstmt.setString(3, score.getDifficulty().toString());
            pstmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
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
