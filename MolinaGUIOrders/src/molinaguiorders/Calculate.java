/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molinaguiorders;

/**
 *
 * @author barry
 */
public class Calculate {

    double WIDGET10PRICE = 5.00;
    double WIDGET15PRICE = 7.50;
    double totalW10Price;
    double totalW15Price;
    
    public double calcOrderTotal(int item1, int item2) {
        double orderTotal = 0;
        totalW10Price = (item1 * WIDGET10PRICE);
        totalW15Price = (item2 * WIDGET15PRICE);
        orderTotal = totalW10Price + totalW15Price;

        return orderTotal;

    }
}
