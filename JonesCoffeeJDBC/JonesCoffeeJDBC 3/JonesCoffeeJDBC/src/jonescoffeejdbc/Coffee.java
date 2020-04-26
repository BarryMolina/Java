/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonescoffeejdbc;

/**
 *
 * @author jonese53
 */
public class Coffee {

    String coffeeDescription;
    String coffeeProductNumber;
    Double coffeePrice; 

    public String getCoffeeDescription() {
        return coffeeDescription;
    }

    public void setCoffeeDescription(String coffeeDescription) {
        this.coffeeDescription = coffeeDescription;
    }

    public String getCoffeeProductNumber() {
        return coffeeProductNumber;
    }

    public void setCoffeeProductNumber(String coffeeProductNumber) {
        this.coffeeProductNumber = coffeeProductNumber;
    }

    public Double getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(Double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }
}
