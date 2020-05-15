  
package molina_relativity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BuildTables {
    //final String DB_URL = "jdbc:derby:Relativity;create=true";
    final String DB_URL = "jdbc:derby://localhost:1527/Relativity;user=sa;password=sa;create=true";
    
    public BuildTables()
    {
        try
        {
            //try this code
            //create a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL);
            
            dropTables(conn);
            
            buildAstronautTable(conn);
          
            
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
                
                stmt.execute("DROP TABLE Astronaut");
                System.out.println("Astronaut table dropped.");
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
    
    public static void buildAstronautTable(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();
            
            stmt.execute("CREATE Table Astronaut (" +
                    "NumberOnMoon INTEGER NOT NULL PRIMARY KEY," +
                    "AstroFName VARCHAR(25), " +
                    "AstroLName VARCHAR(25), " +
                    "ApolloMissionNumber INTEGER , " + 
                    "YearOfMission CHAR(4)" + 
                    ")");
            
            System.out.println("created coffee table");
            stmt.execute("INSERT INTO Astronaut " +
//                "(NumberOnMoon, AstroFName, AstroLName, ApolloMissionNumber, YearOfMission)" +
                "Values " +
                "(1, 'Neil', 'Armstrong', 11, '1969'), " +
                "(2, 'Buzz', 'Aldrin', 11, '1969'), " +
                "(3, 'Charles', 'Conrad', 12, '1969'), " +
                "(4, 'Alan', 'Bean', 12, '1969'), " +
                "(5, 'Alan', 'Shepard', 14, '1971'), " +
                "(6, 'Adgar', 'Mitchell', 14, '1971'), " +
                "(7, 'David', 'Scott', 15, '1971'), " +
                "(8, 'James', 'Irwin', 15, '1971'), " +
                "(9, 'John', 'Young', 16, '1972'), " +
                "(10, 'Charles', 'Duke', 16, '1972'), " +
                "(11, 'Gene', 'Ceman', 17, '1972'), " +
                "(12, 'Harrison', 'Schmitt', 17, '1972')");

            System.out.println("inserted Astronaut data");  
        }catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
