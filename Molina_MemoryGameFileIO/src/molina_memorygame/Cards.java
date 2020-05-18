/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author barry
 */
public class Cards {

    private final String DIR = "file:cardImages/";
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
    private String back = "backside.png";
    private CardImage[][] cardsInPlay;
    private ArrayList<CardImage> pairs = new ArrayList<>();
    public Random rand = new Random();

    private int numCards;

    public Cards(int numCards, int numRows, int numCols) {
        this.numCards = numCards;
        cardsInPlay = new CardImage[numRows][numCols];
        fillPairs();
        fillCardsInPlay();
    }

    private void fillPairs() {
        CardImage newCard;
        while (pairs.size() < numCards) {
            newCard = new CardImage(DIR, deck[rand.nextInt(deck.length)]);
            if (!pairs.contains(newCard)) {
                pairs.add(newCard);
                pairs.add(newCard);
            }
        }
    }
    private void fillCardsInPlay() {
        for (int i = 0; i < cardsInPlay.length; i++) {
            for (int j = 0; j < cardsInPlay[i].length; j++) {
                cardsInPlay[i][j] = pairs.remove(rand.nextInt(pairs.size()));
            }
        }
    }
    
    public String getBack() {
        return DIR + back;
    }
    
//    public String getCardURL(int row, int col) {
//        return DIR + deck[cardsInPlay[row][col]];
//    }

//    public boolean cardsAreSame(int row1, int col1, int row2, int col2) {
//        boolean same = false;
//        if (cardsInPlay[row1][col1] == cardsInPlay[row2][col2]) {
//            same = true;
//        }
//        return same;
//    }
    
//    public int getUnique() {
//        return numCards / 2;
//    }
//    @Override
//    public String toString() {
//        String str = "";
//        for (int i : pairs) {
//            str += i + ", ";
//        }
//        return str;
//    }
    public Card getCard(int row, int col) {
        return cardsInPlay[row][col];
    }
    public CardImage getCardImage(int row, int col) {
        return cardsInPlay[row][col];
    }
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
