/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

/**
 *
 * @author barry
 */
public class Cards {

    private final String DIR = "file:cardImages/";
    private String back = "backside.png";
    private int numCards;

    public Cards(int numCards) {
        this.numCards = numCards;
    }
    public String getBack() {
        return String.format(DIR + back);
    }
    
}
