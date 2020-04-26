/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonescoffeejdbc;

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
    final String DB_URL = "jdbc:derby://localhost:1527/CoffeeDB;user=sa;password=sa;create=true";
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
    MyGUIForm gui;
    
    public CRUD(MyGUIForm gui)
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
        ArrayList<Coffee> coffees = getCoffees();
        
        DefaultTableModel model = (DefaultTableModel) gui.getJTable().getModel();   //
        String[] titles = new String[]{"Description", "Product Number", "Price"};
        Object[][] myCoffeeArray = new Object[coffees.size()][3];        //num rows, num columns on coffee table
        
        for(int i = 0; i < coffees.size(); i++)
        {
            myCoffeeArray[i][0] = coffees.get(i).getCoffeeDescription();    //get item from arraylist
            System.out.println(coffees.get(i).getCoffeeDescription());
            System.out.println(coffees.get(i).getCoffeeProductNumber());
            myCoffeeArray[i][1] = coffees.get(i).getCoffeeProductNumber();
            myCoffeeArray[i][2] = coffees.get(i).getCoffeePrice();
        }
        
        model.setDataVector(myCoffeeArray, titles);
 
    }
            
    public void showRecord(Coffee obj)
    {
        ArrayList<Coffee> coffees = selectSpecificRecord(obj);
        
        DefaultTableModel model = (DefaultTableModel) gui.getJTable().getModel();   //
        String[] titles = new String[]{"Description", "Product Number", "Price"};
        Object[][] myCoffeeArray = new Object[coffees.size()][3];        //num rows, num columns on coffee table
        
        for(int i = 0; i < coffees.size(); i++)
        {
            myCoffeeArray[i][0] = coffees.get(i).getCoffeeDescription();    //get item from arraylist
            System.out.println(coffees.get(i).getCoffeeDescription());
            System.out.println(coffees.get(i).getCoffeeProductNumber());
            myCoffeeArray[i][1] = coffees.get(i).getCoffeeProductNumber();
            myCoffeeArray[i][2] = coffees.get(i).getCoffeePrice();
        }
        
        model.setDataVector(myCoffeeArray, titles);
 
    }
    
    
    
    public ArrayList<Coffee> getCoffees()
    {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        String coffeeQuery = "SELECT * FROM COFFEE";
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(coffeeQuery);
            Coffee cof;
            
            while(rs.next())
            {
                cof = new Coffee();       
                //set array elements to values from table
                
                cof.setCoffeeDescription(rs.getString("DESCRIPTION"));
                cof.setCoffeeProductNumber(rs.getString("PRODNUM"));
                cof.setCoffeePrice(rs.getDouble("PRICE"));          
                coffees.add(cof);           //add a Coffee object to array list
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return coffees;                      //return an array list of coffees.
    }
         
    
    public void updateDb(Coffee obj)
    {
        String sql = "UPDATE COFFEE SET DESCRIPTION = ?, PRICE = ? WHERE PRODNUM = ?";
 
        try{
            
            pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, obj.coffeeDescription);
            pstmt.setDouble(2, obj.coffeePrice);
            pstmt.setString(3, obj.coffeeProductNumber);
            // execute the update statement
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public ArrayList<Coffee> selectSpecificRecord(Coffee cof)
    {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        String sql = "SELECT * FROM COFFEE WHERE PRODNUM = ?";
        try
        {
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cof.coffeeProductNumber); 
         
         ResultSet result = pstmt.executeQuery(); 
       
         if (result.next()) {
      
              //set array elements to values from database
                
            cof.setCoffeeDescription(result.getString("DESCRIPTION"));  //set the fields of the object
            cof.setCoffeeProductNumber(result.getString("PRODNUM"));
            cof.setCoffeePrice(result.getDouble("PRICE"));          
            coffees.add(cof);           //add a Coffee object to array list
 
        }
  
       }catch (SQLException e) {
           System.out.println("There was a SQL error during SELECT; " + e);
       }
        
       try
       {
            pstmt.close();
       }
       catch (SQLException e)
       {
           System.out.println("Error closing SQL select statement " + e);
       }
       return coffees;
    }
    
    public void deleteDb(Coffee obj)
    {
        String sql = "DELETE FROM COFFEE WHERE PRODNUM = ?";
 
        try{
            
            pstmt = conn.prepareStatement(sql);
 
            // set the corresponding param
            pstmt.setString(1, obj.coffeeProductNumber);
            // execute the delete statement
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    public void insertDb(Coffee obj)
    {
        System.out.println("About to insert into table");
    
        System.out.println(obj.coffeeDescription);
        System.out.println(obj.coffeePrice);
        System.out.println(obj.coffeeProductNumber);
        
        try
        {
     
            SQLString = "INSERT INTO Coffee Values"
                       + "(?, ?, ?)";
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setString(1, obj.coffeeDescription);
            pstmt.setString(2, obj.coffeeProductNumber);
            pstmt.setDouble(3, obj.coffeePrice);
            pstmt.executeUpdate();
            conn.commit();
            pstmt.close(); 
    
         }catch(SQLException ex)
        {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
