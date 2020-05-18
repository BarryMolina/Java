/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.scene.image.Image;

/**
 *
 * @author barry
 */
public class Card {
    private String fileName;

    public Card(String fileName) {
        this.fileName = fileName;
    }

    public String getFName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        Card c;
        boolean equals = false;
        try {
            c = (Card) o;
            equals = (c.getFName() == fileName ? true : false);
        }
        catch (ClassCastException e) {
            System.out.println("Can't cast that: " + e.getMessage());
        }
        return equals;
    }
    @Override
    public String toString() {
        return fileName;
    }
}
