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
public class Difficulty {

    private DifficultyLevel level;
    private String lvlName;
    private int gridRows;
    private int gridCols;
    private int screenSizeX;
    private int screenSizeY;
    private int cardHeight;
    private int cardWidth;

    private final int EASY_COLS = 6;
    private final int EASY_ROWS = 4;
    private final int MED_COLS = 8;
    private final int MED_ROWS = 6;
    private final int HARD_COLS = 12;
    private final int HARD_ROWS = 8;

    private final int EASY_X = 800;
    private final int EASY_Y = 620;
    private final int MED_X = 800;
    private final int MED_Y = 620;
    private final int HARD_X = 800;
    private final int HARD_Y = 620;

    private final int EASY_CARD_HEIGHT = 145;
    private final int EASY_CARD_WIDTH = 100;
    private final int MED_CARD_HEIGHT = 131;
    private final int MED_CARD_WIDTH = 90;
    private final int HARD_CARD_HEIGHT = 116;
    private final int HARD_CARD_WIDTH = 80;

    public Difficulty(DifficultyLevel level){
        this.level = level;
        setDifficulty();
    }

    private void setDifficulty() {
        switch (level) {
            case HARD:
                lvlName = "Hard";
                gridCols = HARD_COLS;
                gridRows = HARD_ROWS;
                screenSizeX = HARD_X;
                screenSizeY = HARD_Y;
                cardHeight = HARD_CARD_HEIGHT;
                cardWidth = HARD_CARD_WIDTH;
                break;
            case MEDIUM:
                lvlName = "Medium";
                gridCols = MED_COLS;
                gridRows = MED_ROWS;
                screenSizeX = MED_X;
                screenSizeY = MED_Y;
                cardHeight = MED_CARD_HEIGHT;
                cardWidth = MED_CARD_WIDTH;
                break;
            default:
                lvlName = "Easy";
                gridCols = EASY_COLS;
                gridRows = EASY_ROWS;
                screenSizeX = EASY_X;
                screenSizeY = EASY_Y;
                cardHeight = EASY_CARD_HEIGHT;
                cardWidth = EASY_CARD_WIDTH;
                break;
        }
    }

    public String getLvlName() {
        return lvlName;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public int getGridRows() {
        return gridRows;
    }

    public int getGridCols() {
        return gridCols;
    }

    public int getScreenSizeX() {
        return screenSizeX;
    }

    public int getScreenSizeY() {
        return screenSizeY;
    }

    public int getCardHeight() {
        return cardHeight;
    }

    public int getCardWidth() {
        return cardWidth;
    }
    
    public int getTotalCards() {
        return gridRows * gridCols;
    }
}
