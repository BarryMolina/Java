  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonescoffeejdbc;

import java.sql.*;

public class JonesCoffeeJDBC {
                                                                 
    public static void main(String[] args) {
        // TODO code application logic here
 
        MyGUIForm gui = new MyGUIForm();
        CRUD crud = new CRUD(gui);                 //pass crud a reference to gui
        gui.setCRUD(crud);                         //pass gui a reference to crud
        gui.setVisible(true);
    }
                           
}
