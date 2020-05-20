/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.scene.image.Image;

/**
 * This class creates a card object.
 */
public class Card {
    // An Image object set to the image for this card.
    private Image image;
    // The name of the image file name.
    private String fileName;

    /**
     * Creates an Image object that corresponds to this card.
     * @param dir The directory images are stored in.
     * @param fileName The name of the image file.
     */
    public Card(String dir, String fileName) {
        this.fileName = fileName;
        image = new Image(dir + fileName);
    }

    /**
     * Returns the Image object.
     * @return The Image object.
     */
    public Image getImage() {
        return image;
    }
    
    /**
     * Returns the image file name.
     * @return The file name.
     */
    public String getFName() {
        return fileName;
    }
     

    /**
     * Uses fileName to determine if two cards are the same.
     * @param o Another card.
     * @return Whether the cards are the same.
     */
    @Override
    public boolean equals(Object o) {
        // A Card variable to hold the card being compared.
        Card c;
        // Boolean variable to store whether the cards are the same.
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

    /**
     * Returns the file name.
     * @return The name of the image file.
     */
    @Override
    public String toString() {
        return fileName;
    }
}
