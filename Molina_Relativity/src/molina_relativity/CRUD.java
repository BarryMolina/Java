/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_relativity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class CRUD {
    final String DB_URL = "jdbc:derby://localhost:1527/Relativity;user=sa;password=sa;create=true";
    String SQLString;
    Connection conn;
    /* PREPARED STATEMENT - is an object for sending SQL statements to the database.
       These statements are precompiled.
       It is a special statement derived from the more general class, Statement.
       If you want to execute a Statement object many times, 
       it usually reduces execution time to use a PreparedStatement object instead.*/
    public PreparedStatement pstmt; 
    public Statement stmt; 
    public ResultSet rs;
    AstronautGUI gui;
    
    public CRUD(AstronautGUI gui)
    {
        System.out.println("In constructor");
        try {
          conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.conn != null)
        {
           System.out.println("***Connected To Database***");
        }
        this.gui = gui;      //assign gui object 
    }
   
    public void showTable()
    {
        ArrayList<Astronaut> astronauts = getAstronauts();
        
        DefaultTableModel model = (DefaultTableModel) gui.getTblAstronaut().getModel();   //
        String[] titles = new String[]{"First Name", "Last Name", 
                                        "Apollo Number", "Year of Mission"};
        
        Object[][] astronautArray = new Object[astronauts.size()][4];        //num rows, num columns on coffee table
        
        for(int i = 0; i < astronauts.size(); i++)
        {
            astronautArray[i][0] = astronauts.get(i).getAstroFName();    //get item from arraylist
            astronautArray[i][1] = astronauts.get(i).getAstroLName();
            astronautArray[i][2] = astronauts.get(i).getApolloMissionNumber();
            astronautArray[i][3] = astronauts.get(i).getYearOfMission();
        }
        
        model.setDataVector(astronautArray, titles);
 
    }
            
    public void showRecord(Astronaut a)
    {
        ArrayList<Astronaut> astronauts = selectSpecificRecord(a);
        
        DefaultTableModel model = (DefaultTableModel) gui.getTblAstronaut().getModel();   //
        String[] titles = new String[]{"First Name", "Last Name", 
                                        "Apollo Mission Number", "Year of Mission"};
                                        
        Object[][] astronautArray = new Object[astronauts.size()][4];        //num rows, num columns on coffee table
        
        for(int i = 0; i < astronauts.size(); i++)
        {
            astronautArray[i][0] = astronauts.get(i).getAstroFName();    //get item from arraylist
            astronautArray[i][1] = astronauts.get(i).getAstroLName();
            astronautArray[i][2] = astronauts.get(i).getApolloMissionNumber();
            astronautArray[i][3] = astronauts.get(i).getYearOfMission();
        }
        
        model.setDataVector(astronautArray, titles);
 
    }
    
    
    
    public ArrayList<Astronaut> getAstronauts()
    {
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        String astronautQuery = "SELECT * FROM ASTRONAUT";
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(astronautQuery);
            Astronaut astro;
            
            while(rs.next())
            {
                astro = new Astronaut();       
                //set array elements to values from table
                
                astro.setNumberOnMoon(rs.getInt("NumberOnMoon"));
                astro.setAstroFName(rs.getString("AstroFName"));
                astro.setAstroLName(rs.getString("AstroLName"));
                astro.setApolloMissionNumber(rs.getInt("ApolloMissionNumber"));
                astro.setYearOfMission(rs.getString("YearOfMission"));

                astronauts.add(astro);           //add a Astronaut object to array list
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return astronauts;                      //return an array list of astronauts.
    }
         
    
//    public void updateDb(Astronaut obj)
//    {
//        String sql = "UPDATE COFFEE SET DESCRIPTION = ?, PRICE = ? WHERE PRODNUM = ?";
// 
//        try{
//            
//            pstmt = conn.prepareStatement(sql);
//            // set the corresponding param
//            pstmt.setString(1, obj.coffeeDescription);
//            pstmt.setDouble(2, obj.coffeePrice);
//            pstmt.setString(3, obj.coffeeProductNumber);
//            // execute the update statement
//            pstmt.executeUpdate();
//            conn.commit();
//            pstmt.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    

    public ArrayList<Astronaut> selectSpecificRecord(Astronaut a)
    {
        int numberOnMoon;
        String firstName;
        String lastName;
        int missionNumber;
        String missionYear;
        int conditions = 0;
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        String sql = "SELECT * FROM Astronaut WHERE ";

        if (a.getAstroFName() != null)
        {
            sql += "AstroFName = '" + a.getAstroFName() + "'";
            conditions++;
        }
        if (a.getAstroLName() != null)
        {
            sql += (conditions > 0? " AND " : "" ) + "AstroLName = '" + a.getAstroLName() + "'";
            conditions++;
        }
        if (a.getApolloMissionNumber() != 0)
        {
            sql += (conditions > 0? " AND " : "" ) + "ApolloMissionNumber = " + a.getApolloMissionNumber();
            conditions++;
        }
        if (a.getYearOfMission() != null)
        {
            sql += (conditions > 0? " AND " : "" ) + "YearOfMission = '" + a.getYearOfMission() + "'";
        }
        System.out.println(sql);
        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            rs = stmt.executeQuery("select * from Astronaut where AstroFName = 'Alan'");
       
            while (rs.next()) 
            {
                //set array elements to values from database
                numberOnMoon = rs.getInt("NumberOnMoon");
                firstName = rs.getString("AstroFName");
                lastName = rs.getString("AstroLName");
                missionNumber = rs.getInt("ApolloMissionNumber");
                missionYear = rs.getString("YearOfMission");

                astronauts.add(new Astronaut(numberOnMoon, firstName, lastName,
                                             missionNumber, missionYear));           //add a Astronaut object to array list
        }
  
        }catch (SQLException e) {
            System.out.println("There was a SQL error during SELECT; " + e);
        }
        
        try
        {
             stmt.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error closing SQL select statement " + e);
        }
        return astronauts;
    }
    
//    public void deleteDb(Astronaut obj)
//    {
//        String sql = "DELETE FROM COFFEE WHERE PRODNUM = ?";
// 
//        try{
//            
//            pstmt = conn.prepareStatement(sql);
// 
//            // set the corresponding param
//            pstmt.setString(1, obj.coffeeProductNumber);
//            // execute the delete statement
//            pstmt.executeUpdate();
//            conn.commit();
//            pstmt.close();
// 
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    
//    }
    
//    public void insertDb(Astronaut obj)
//    {
//        System.out.println("About to insert into table");
//    
//        System.out.println(obj.coffeeDescription);
//        System.out.println(obj.coffeePrice);
//        System.out.println(obj.coffeeProductNumber);
//        
//        try
//        {
//     
//            SQLString = "INSERT INTO Astronaut Values"
//                       + "(?, ?, ?)";
//            pstmt = conn.prepareStatement(SQLString);
//            pstmt.setString(1, obj.coffeeDescription);
//            pstmt.setString(2, obj.coffeeProductNumber);
//            pstmt.setDouble(3, obj.coffeePrice);
//            pstmt.executeUpdate();
//            conn.commit();
//            pstmt.close(); 
//    
//         }catch(SQLException ex)
//        {
//            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Error: " + ex.getMessage());
//        }
//
//    }
}
