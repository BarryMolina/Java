/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.sql.*;

public class ScoresTable {

    final String DB_URL = "jdbc:derby://localhost:1527/MemoryGameDB;user=sa;password=sa;create=true";

    public ScoresTable() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            dropTable(conn);
            buildTable(conn);
            insertTable(conn);
            conn.close();
            System.out.println("Success");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void buildTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE Scores (" +
                     "ScoreID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                     "Name VARCHAR(25), " +
                     "Difficulty VARCHAR(6) NOT NULL, " +
                     "Score INTEGER NOT NULL)";
        stmt.execute(sql);
    }
    private void insertTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO Scores (Name, Difficulty, Score) VALUES " +
//                     "('Barry', 'EASY', 3), " +
//                     "('Barry', 'EASY', 30), " +
                     "('Lizzie', 'MEDIUM', 54), " +
//                     "('Lizzie', 'MEDIUM', 67), " +
                     "('Barry', 'HARD', 104), " +
//                     "('Barry', 'HARD', 89), " +
                     "('Baz', 'EASY', 27)";
        stmt.execute(sql);
    }
    private void dropTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DROP TABLE Scores";
        try {
            stmt.execute(sql);
        }
        catch (SQLException e) {
            System.out.println("Table doesn't exist");
        }
    }
    
}
