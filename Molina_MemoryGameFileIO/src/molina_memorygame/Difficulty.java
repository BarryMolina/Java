/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

/**
 * This class stores information relating to the difficulty level selected.
 */
public class Difficulty {

    // The level selected by user.
    private DifficultyLevel level;
    // The name of the level formatted in normal casing.
    private String lvlName;
    // The number of rows for this difficulty.
    private int gridRows;
    // The number of columns for this difficulty.
    private int gridCols;
    // Initial screen size.
    private int screenSizeX;
    private int screenSizeY;

    // These variables store number of rows and columns for each difficulty level.
    private final int EASY_COLS = 6;
    private final int EASY_ROWS = 3;
    private final int MED_COLS = 10;
    private final int MED_ROWS = 4;
    private final int HARD_COLS = 13;
    private final int HARD_ROWS = 5;

    // These variables store initial screen sizes for each difficulty level.
    private final int EASY_X = 800;
    private final int EASY_Y = 620;
    private final int MED_X = 800;
    private final int MED_Y = 620;
    private final int HARD_X = 800;
    private final int HARD_Y = 620;

    /**
     * Accepts a DifficultyLevel enum and sets fields based on that value.
     * @param level The difficulty level selected by the user.
     */
    public Difficulty(DifficultyLevel level){
        this.level = level;
        setDifficulty();
    }

    /**
     * Sets fields depending on which difficulty level user selected.
     */
    private void setDifficulty() {
        // Switch on the DifficultyLevel enum to determine field values. 
        switch (level) {
            case HARD:
                lvlName = "Hard";
                gridCols = HARD_COLS;
                gridRows = HARD_ROWS;
                screenSizeX = HARD_X;
                screenSizeY = HARD_Y;
                break;
            case MEDIUM:
                lvlName = "Medium";
                gridCols = MED_COLS;
                gridRows = MED_ROWS;
                screenSizeX = MED_X;
                screenSizeY = MED_Y;
                break;
            default:
                lvlName = "Easy";
                gridCols = EASY_COLS;
                gridRows = EASY_ROWS;
                screenSizeX = EASY_X;
                screenSizeY = EASY_Y;
                break;
        }
    }

    /**
     * Returns the name of the level in normal casing.
     * @return The name of the level.
     */
    public String getLvlName() {
        return lvlName;
    }

    /**
     * Returns the difficulty level as enum.
     * @return DifficultyLevel enum.
     */
    public DifficultyLevel getLevel() {
        return level;
    }

    /**
     * Gets the number of rows for this difficulty.
     * @return The number of rows for this difficulty.
     */
    public int getGridRows() {
        return gridRows;
    }

    /**
     * Gets the number of columns for this difficulty.
     * @return The number of columns for this difficulty.
     */
    public int getGridCols() {
        return gridCols;
    }

    /**
     * Gets the initial screen width for this difficulty.
     * @return The initial screen width for this difficulty.
     */
    public int getScreenSizeX() {
        return screenSizeX;
    }

    /**
     * Gets the initial screen height for this difficulty.
     * @return The initial screen height for this difficulty.
     */
    public int getScreenSizeY() {
        return screenSizeY;
    }

    /**
     * Gets the total number of cards for this difficulty.
     * @return The total number of cards for this difficulty.
     */
    public int getTotalCards() {
        return gridRows * gridCols;
    }
}
