/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createcoffeeshop;

import java.sql.*;

public class DisplayCoffeeShop {
    
    public DisplayCoffeeShop(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sql = "SELECT Description, Price "
                        + "From Coffee";
            ResultSet result = stmt.executeQuery(sql);

            System.out.println("================================");
            while(result.next()) {
                System.out.printf("%25s %.2f\n", result.getString("Description"),
                                                 result.getDouble("Price"));
            }
        }
        catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
    
}
