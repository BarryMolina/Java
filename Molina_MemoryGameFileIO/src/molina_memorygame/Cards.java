/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class creates and stores a 2-dimensional array of Card objects.
 */
public class Cards {

    // The directory the images are stored in.
    private final String DIR = "file:cardImages/";
    // A list of all the card file names.
    private final String[] deck = {
        "10_of_clubs.png",
        "10_of_diamonds.png",
        "10_of_hearts.png",
        "10_of_spades.png",
        "2_of_clubs.png",
        "2_of_diamonds.png",
        "2_of_hearts.png",
        "2_of_spades.png",
        "3_of_clubs.png",
        "3_of_diamonds.png",
        "3_of_hearts.png",
        "3_of_spades.png",
        "4_of_clubs.png",
        "4_of_diamonds.png",
        "4_of_hearts.png",
        "4_of_spades.png",
        "5_of_clubs.png",
        "5_of_diamonds.png",
        "5_of_hearts.png",
        "5_of_spades.png",
        "6_of_clubs.png",
        "6_of_diamonds.png",
        "6_of_hearts.png",
        "6_of_spades.png",
        "7_of_clubs.png",
        "7_of_diamonds.png",
        "7_of_hearts.png",
        "7_of_spades.png",
        "8_of_clubs.png",
        "8_of_diamonds.png",
        "8_of_hearts.png",
        "8_of_spades.png",
        "9_of_clubs.png",
        "9_of_diamonds.png",
        "9_of_hearts.png",
        "9_of_spades.png",
        "ace_of_clubs.png",
        "ace_of_diamonds.png",
        "ace_of_hearts.png",
        "ace_of_spades2.png",
        "jack_of_clubs2.png",
        "jack_of_diamonds2.png",
        "jack_of_hearts2.png",
        "jack_of_spades2.png",
        "king_of_clubs2.png",
        "king_of_diamonds2.png",
        "king_of_hearts2.png",
        "king_of_spades2.png",
        "queen_of_clubs2.png",
        "queen_of_diamonds2.png",
        "queen_of_hearts2.png",
        "queen_of_spades2.png"
    };
    // The file name of the card backside image.
    private String back = "backside.png";
    // A 2-dimentional array of cards that will be shown on the screen.
    private Card[][] cardsInPlay;
    // The list that cards will be randomly selected from to fill cardsInPlay.
    private ArrayList<Card> pairs = new ArrayList<>();
    // A random object used to select cards randomly.
    public Random rand = new Random();
    // The number of cards in play.
    private int numCards;

    /**
     * Execute necessary steps to fill cardsInPlay.
     * Get the total number of cards to put in play, create a suitable 
     * 2-dimensional array to hold them, fill an ArrayList with all the cards
     * and their matches, and then randomly select cards from that list to fill 
     * each element of the array.
     * @param numCards The total number of cards in the array.
     * @param numRows How many rows.
     * @param numCols How many columns.
     */
    public Cards(int numCards, int numRows, int numCols) {
        this.numCards = numCards;
        cardsInPlay = new Card[numRows][numCols];
        fillPairs();
        fillCardsInPlay();
    }

    /**
     * Fills an ArrayList with Card pairs.
     */
    private void fillPairs() {
        Card newCard;
        while (pairs.size() < numCards) {
            newCard = new Card(DIR, deck[rand.nextInt(deck.length)]);
            if (!pairs.contains(newCard)) {
                pairs.add(newCard);
                pairs.add(newCard);
            }
        }
    }
    /**
     * Fills the 2-dimensional Card array with cards randomly selected from 'pairs'.
     */
    private void fillCardsInPlay() {
        for (int i = 0; i < cardsInPlay.length; i++) {
            for (int j = 0; j < cardsInPlay[i].length; j++) {
                cardsInPlay[i][j] = pairs.remove(rand.nextInt(pairs.size()));
            }
        }
    }
    
    /**
     * Returns the path for card back image.
     * @return The path to the card backside image.
     */
    public String getBack() {
        return DIR + back;
    }
    /**
     * Returns the card stored at a specific row and column.
     * @param row The row of the card.
     * @param col The column of the card.
     * @return The Card object at the specified location.
     */
    public Card getCard(int row, int col) {
        return cardsInPlay[row][col];
    }
    /**
     * Lists every card in cardsInPlay.
     * @return A string of card file names.
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < cardsInPlay.length; i++) {
            for (int j = 0; j < cardsInPlay[i].length; j++) {
                str += cardsInPlay[i][j] + ", ";
            }
            str += "\n";
        }
        return str;
    }
}
