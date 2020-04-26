/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createcoffeeshop;

import java.sql.*;


/**
 *
 * @author barry
 */
public class BuildDB {
    final String DB_URL = "jdbc:derby:CoffeeShopDatabase;create=true";

    public BuildDB() {
        try {
            //create a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL);

            dropTables(conn);

            buildCoffeeTable(conn);

            conn.commit();

            DisplayCoffeeShop d = new DisplayCoffeeShop(conn);

            conn.close();

        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        }
    }

    public void dropTables(Connection conn) {
        System.out.println("Checking for existing tables");
        
        try {
            Statement stmt = conn.createStatement();
            try { 
                stmt.execute("DROP TABLE Coffee");
                System.out.println("Coffee table dropped");
            }
            catch(SQLException ex) {
                //No need to report anything here
                //Table did not exist
            }
        }
        catch(SQLException ex) {
            System.out.println("Error: " + ex.getMessage());

        }
    }
    public void buildCoffeeTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Coffee (" +
                    "Description CHAR(25),"
                    + "ProdNum CHAR(10) NOT NULL PRIMARY KEY,"
                    + "Price DOUBLE"
                    + ")"
                    );

            System.out.println("Created Coffee table");

            //Insert rows
            stmt.execute("INSERT INTO Coffee VALUES "
                    + "('Bolivian Dark', '14-001', 8.95),"
                    + "('Columbian Dark', '14-002', 8.90),"
                    + "('Bolivian Medium ', '14-003', 8.95),"
                    + "('Columbian Light ', '14-004', 9.95)");
        }
        catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());

        }

    }
    
}
