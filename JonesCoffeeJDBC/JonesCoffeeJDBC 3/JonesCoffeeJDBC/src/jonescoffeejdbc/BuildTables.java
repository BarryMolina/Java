  
package jonescoffeejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BuildTables {
    //final String DB_URL = "jdbc:derby:CoffeeDB;create=true";
    final String DB_URL = "jdbc:derby://localhost:1527/CoffeeDB;user=sa;password=sa;create=true";
    
    public BuildTables()
    {
        try
        {
            //try this code
            //create a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL);
            
            dropTables(conn);
            
            buildCoffeeTable(conn);
          
            
            conn.commit();
            
            //close the connection
            conn.close();
           
        }catch(Exception ex)
        {
           //if it fails do this
            System.out.println("Error: " + ex.getMessage());
        
        }
    }
    
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables");
        
        try
        {
            //get a statement object 
            Statement stmt = conn.createStatement();
            
            try
            {
                
                stmt.execute("DROP TABLE UnpaidOrder");
                System.out.println("UnpaidOrder table dropped.");
            } catch(SQLException ex)
            {
                //No need to report anything here
                //The table did not exist      
            }
            
            try
            {
                
                stmt.execute("DROP TABLE Customer");
                System.out.println("Customer table dropped.");
            } catch(SQLException ex)
            {
                //No need to report anything here
                //The table did not exist
            }
            
            try
            {
                stmt.execute("DROP TABLE Coffee");
                System.out.println("Coffee table dropped.");
            } catch(SQLException ex)
            {
                //No need to report anything here
                //The table did not exist
            }
            
        }catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static void buildCoffeeTable(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();
            
            stmt.execute("CREATE Table Coffee (" +
                    "Description CHAR(25), " +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " + 
                    ")");
            
            System.out.println("created coffee table");
            //Insert row #1
            stmt.execute("INSERT INTO Coffee Values ( " +
                         "'Bolivian Dark', " +
                         "'14-001', " +
                    "8.95)" );
            
            
            stmt.execute("INSERT INTO Coffee Values ( " +
                         "'Columbian Dark', " +
                         "'14-002', " +
                    "8.90)" );
            
            stmt.execute("INSERT INTO Coffee Values ( " +
                         "'Bolivian Medium', " +
                         "'14-003', " +
                    "8.95)" );
            
            stmt.execute("INSERT INTO Coffee Values ( " +
                         "'Columbian Light', " +
                         "'14-004', " +
                    "9.95)" );
            System.out.println("inserted coffee data");  
        }catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
