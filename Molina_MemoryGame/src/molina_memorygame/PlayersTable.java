/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.sql.*;

/**
 *
 * @author barry
 */
public class PlayersTable {
//    final String DB_URL = "jdbc:derby://localhost:1527/MemoryGameDB;user=sa;password=sa;create=true";
    final String DB_URL = "jdbc:derby:MemoryGameDB;create=true";

    public PlayersTable() {
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
        String sql = "CREATE TABLE Players (" +
                     "PlayerID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                     "Name VARCHAR(25))";
        stmt.execute(sql);
    }

    private void insertTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO Players (Name) VALUES " +
                     "('Barry'), " +
                     "('Lizzie'), " +
                     "('Baz')";
        stmt.execute(sql);
    }
    private void dropTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "DROP TABLE Players";
        try {
            stmt.execute(sql);
        }
        catch (SQLException e) {
            System.out.println("Table doesn't exist");
        }
    }
    
}
