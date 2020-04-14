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
    private int cardSize;

    private final int EASY_COLS = 4;
    private final int EASY_ROWS = 3;
    private final int MED_COLS = 6;
    private final int MED_ROWS = 4;
    private final int HARD_COLS = 8;
    private final int HARD_ROWS = 6;

    private final int EASY_X = 800;
    private final int EASY_Y = 620;
    private final int MED_X = 800;
    private final int MED_Y = 620;
    private final int HARD_X = 800;
    private final int HARD_Y = 620;

    private final int EASY_CARD = 100;
    private final int MED_CARD = 70;
    private final int HARD_CARD = 50;

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
                cardSize = HARD_CARD;
                break;
            case MEDIUM:
                lvlName = "Medium";
                gridCols = MED_COLS;
                gridRows = MED_ROWS;
                screenSizeX = MED_X;
                screenSizeY = MED_Y;
                cardSize = MED_CARD;
                break;
            default:
                lvlName = "Easy";
                gridCols = EASY_COLS;
                gridRows = EASY_ROWS;
                screenSizeX = EASY_X;
                screenSizeY = EASY_Y;
                cardSize = EASY_CARD;
                break;
        }
    }

    public String getLvlName() {
        return lvlName;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public int getGridRow() {
        return gridRows;
    }

    public int getGridCol() {
        return gridCols;
    }

    public int getScreenSizeX() {
        return screenSizeX;
    }

    public int getScreenSizeY() {
        return screenSizeY;
    }

    public int getCardSize() {
        return cardSize;
    }
    
    public int getTotalCards() {
        return gridRows * gridCols;
    }
    
    
}
