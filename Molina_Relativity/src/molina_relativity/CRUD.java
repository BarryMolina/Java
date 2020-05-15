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
    public PreparedStatement pstmt; 
    public Statement stmt; 
    public ResultSet rs;
    AstronautGUI gui;
    
    public CRUD(AstronautGUI gui) {
        System.out.println("In constructor");
        try {
          conn = DriverManager.getConnection(DB_URL);
        } 
        catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.conn != null) {
           System.out.println("***Connected To Database***");
        }
        this.gui = gui;      //assign gui object 
    }
   
    public void showTable() { 
        ArrayList<Astronaut> astronauts = getAstronauts();
        
        DefaultTableModel model = (DefaultTableModel) gui.getTblAstronaut().getModel(); 
        String[] titles = new String[]{"Number on Moon", "First Name", "Last Name", 
                                        "Apollo Number", "Year of Mission"};
        
        Object[][] astronautArray = new Object[astronauts.size()][titles.length]; 
        
        for(int i = 0; i < astronauts.size(); i++) {
            astronautArray[i][0] = astronauts.get(i).getNumberOnMoon();  
            astronautArray[i][1] = astronauts.get(i).getAstroFName();  
            astronautArray[i][2] = astronauts.get(i).getAstroLName();
            astronautArray[i][3] = astronauts.get(i).getApolloMissionNumber();
            astronautArray[i][4] = astronauts.get(i).getYearOfMission();
        }
        
        model.setDataVector(astronautArray, titles);
        gui.resetFields();
 
    }
            
    public void showRecord(Astronaut a) {
        ArrayList<Astronaut> astronauts = selectSpecificRecord(a);
        
        DefaultTableModel model = (DefaultTableModel) gui.getTblAstronaut().getModel(); 
        String[] titles = new String[]{"Number on Moon", "First Name", "Last Name", 
                                        "Apollo Number", "Year of Mission"};
        
        Object[][] astronautArray = new Object[astronauts.size()][titles.length]; 
        
        for(int i = 0; i < astronauts.size(); i++) {
            astronautArray[i][0] = astronauts.get(i).getNumberOnMoon();  
            astronautArray[i][1] = astronauts.get(i).getAstroFName();  
            astronautArray[i][2] = astronauts.get(i).getAstroLName();
            astronautArray[i][3] = astronauts.get(i).getApolloMissionNumber();
            astronautArray[i][4] = astronauts.get(i).getYearOfMission();
        }
        model.setDataVector(astronautArray, titles);
        gui.resetFields();
 
    }
    
    
    
    public ArrayList<Astronaut> getAstronauts() {
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        String astronautQuery = "SELECT * FROM ASTRONAUT";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(astronautQuery);
            Astronaut astro;
            
            while(rs.next()) {
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
        catch(SQLException e) {
            e.printStackTrace();
        }
                
        return astronauts;                      //return an array list of astronauts.
    }
         
    
    public void updateDb(Astronaut a)
    {
        String sql; 
        String columns = "";
        int changes = 0;

        if (a.getNumberOnMoon() == null) {
            gui.getLblMessage().setText("You must enter a value for Number On Moon");
        }
        else {
            if (a.getAstroFName() != null) {
                columns += "AstroFName = '" + a.getAstroFName() + "'";
                changes++;
            }
            if (a.getAstroLName() != null) {
                columns =  "AstroLName = '" + a.getAstroLName() + "'" + 
                            (changes > 0? ", " : "" ) + columns;
                changes++;
            }
            if (a.getApolloMissionNumber() != 0) {
                columns =  "ApolloMissionNumber = " + a.getApolloMissionNumber() + 
                            (changes > 0? ", " : "" ) + columns;
                changes++;
            }
            if (a.getYearOfMission() != null) {
                columns =  "YearOfMission = '" + a.getYearOfMission() + "'" + 
                            (changes > 0? ", " : "" ) + columns;
            }
            sql = String.format("UPDATE Astronaut SET %s WHERE NumberOnMoon = %s",
                    columns, a.getNumberOnMoon());
            System.out.println(sql);
     
            try {
                stmt = conn.createStatement();
                stmt.execute(sql);
            } 
            catch (SQLException e) {
                System.out.println("Didn't work");
                System.out.println(e.getMessage());
            }
        }
    }
    

    public ArrayList<Astronaut> selectSpecificRecord(Astronaut a) {
        int numberOnMoon;
        String firstName;
        String lastName;
        int missionNumber;
        String missionYear;
        int conditions = 0;
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        String sql = "SELECT * FROM Astronaut WHERE ";

        if (a.getNumberOnMoon() != null) {
            sql += "NumberOnMoon = " + a.getNumberOnMoon();
            conditions++;
        }
        if (a.getAstroFName() != null) {
            sql += (conditions > 0? " AND " : "" ) + "AstroFName = '" + a.getAstroFName() + "'";
            conditions++;
        }
        if (a.getAstroLName() != null) {
            sql += (conditions > 0? " AND " : "" ) + "AstroLName = '" + a.getAstroLName() + "'";
            conditions++;
        }
        if (a.getApolloMissionNumber() != 0) {
            sql += (conditions > 0? " AND " : "" ) + "ApolloMissionNumber = " + a.getApolloMissionNumber();
            conditions++;
        }
        if (a.getYearOfMission() != null) {
            sql += (conditions > 0? " AND " : "" ) + "YearOfMission = '" + a.getYearOfMission() + "'";
        }
        System.out.println(sql);
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
       
            while (rs.next()) {
                //set array elements to values from database
                numberOnMoon = rs.getInt("NumberOnMoon");
                firstName = rs.getString("AstroFName");
                lastName = rs.getString("AstroLName");
                missionNumber = rs.getInt("ApolloMissionNumber");
                missionYear = rs.getString("YearOfMission");

                astronauts.add(new Astronaut(numberOnMoon, firstName, lastName,
                                             missionNumber, missionYear));           //add a Astronaut object to array list
            }
            stmt.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return astronauts;
    }
    
    public void deleteDb(Astronaut a)
    {
        String sql = "DELETE FROM Astronaut WHERE ";
        int conditions = 0;

        if (a.getNumberOnMoon() != null) {
            sql += "NumberOnMoon = " + a.getNumberOnMoon();
            conditions++;
        }
        if (a.getAstroFName() != null) {
            sql += (conditions > 0? " AND " : "" ) + "AstroFName = '" + a.getAstroFName() + "'";
            conditions++;
        }
        if (a.getAstroLName() != null) {
            sql += (conditions > 0? " AND " : "" ) + "AstroLName = '" + a.getAstroLName() + "'";
            conditions++;
        }
        if (a.getApolloMissionNumber() != 0) {
            sql += (conditions > 0? " AND " : "" ) + "ApolloMissionNumber = " + a.getApolloMissionNumber();
            conditions++;
        }
        if (a.getYearOfMission() != null) {
            sql += (conditions > 0? " AND " : "" ) + "YearOfMission = '" + a.getYearOfMission() + "'";
        }
 
        try {
            
 
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    public void insertDb(Astronaut obj) {

        System.out.println("About to insert into table");
    
        System.out.println(obj.getAstroFName());
        System.out.println(obj.getAstroLName());
        System.out.println(obj.getApolloMissionNumber());
        System.out.println(obj.getYearOfMission());
        
        try {
            SQLString = "INSERT INTO Astronaut VALUES "
                    + "(?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, obj.getNumberOnMoon());
            pstmt.setString(2, obj.getAstroFName());
            pstmt.setString(3, obj.getAstroLName());
            pstmt.setInt(4, obj.getApolloMissionNumber());
            pstmt.setString(5, obj.getYearOfMission());
            pstmt.executeUpdate();
            pstmt.close(); 
    
        }
        catch(SQLException ex) {
            gui.getLblMessage().setText("You must enter a unique value for "
                    + "'Number On Moon'");
            System.out.println(ex);

        }
        catch(NullPointerException ex) {
            gui.getLblMessage().setText("You must enter a value for 'Number On Moon'");
            System.out.println("NullPointerException");
        }
    }
}
