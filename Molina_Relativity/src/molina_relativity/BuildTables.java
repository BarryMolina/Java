  
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
                    "NumberOnMoon INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY"
                    + "(START WITH 1, INCREMENT BY 1)," +
                    "AstroFName VARCHAR(25), " +
                    "AstroLName VARCHAR(25), " +
                    "ApolloMissionNumber INTEGER , " + 
                    "YearOfMission CHAR(4)" + 
                    ")");
            
            System.out.println("created coffee table");
            //Insert row #1
            stmt.execute("INSERT INTO Astronaut " +
                "(AstroFName, AstroLName, ApolloMissionNumber, YearOfMission)" +
                "Values " +
                "('Neil', 'Armstrong', 11, '1969'), " +
                "('Buzz', 'Aldrin', 11, '1969'), " +
                "('Charles', 'Conrad', 12, '1969'), " +
                "('Alan', 'Bean', 12, '1969'), " +
                "('Alan', 'Shepard', 14, '1971'), " +
                "('Adgar', 'Mitchell', 14, '1971'), " +
                "('David', 'Scott', 15, '1971'), " +
                "('James', 'Irwin', 15, '1971'), " +
                "('John', 'Young', 16, '1972'), " +
                "('Charles', 'Duke', 16, '1972'), " +
                "('Gene', 'Ceman', 17, '1972'), " +
                "('Harrison', 'Schmitt', 17, '1972')");

            System.out.println("inserted Astronaut data");  
        }catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
