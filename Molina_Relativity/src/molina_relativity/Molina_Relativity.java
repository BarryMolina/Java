/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_relativity;

/**
 *
 * @author barry
 */
public class Molina_Relativity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BuildTables b = new BuildTables();
        AstronautGUI gui = new AstronautGUI();
        CRUD crud;                 //pass crud a reference to gui
        crud = new CRUD(gui);
//        gui.doSomething();
        gui.setCRUD(crud);                         //pass gui a reference to crud
        gui.setVisible(true);
    }
    
}
