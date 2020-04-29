/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_relativity;

/**
 *
 * @author barry
 */
public class Astronaut {


    private int NumberOnMoon;
    private String astroFName;
    private String astroLName;
    private int apolloMissionNumber;
    private String yearOfMission;

    public Astronaut() {
        this.astroLName = null;
        this.astroLName = null;
        this.apolloMissionNumber = 0;
        this.yearOfMission = null;
    }

    public Astronaut(int NumberOnMoon, String astroFName, String astroLName, int apolloMissionNumber, String yearOfMission) {
        this.NumberOnMoon = NumberOnMoon;
        this.astroFName = astroFName;
        this.astroLName = astroLName;
        this.apolloMissionNumber = apolloMissionNumber;
        this.yearOfMission = yearOfMission;
    }

    public int getNumberOnMoon() {
        return NumberOnMoon;
    }

    public void setNumberOnMoon(int NumberOnMoon) {
        this.NumberOnMoon = NumberOnMoon;
    }

    public String getAstroFName() {
        return astroFName;
    }

    public void setAstroFName(String astroFName) {
        this.astroFName = astroFName;
    }

    public String getAstroLName() {
        return astroLName;
    }

    public void setAstroLName(String astroLName) {
        this.astroLName = astroLName;
    }

    public int getApolloMissionNumber() {
        return apolloMissionNumber;
    }

    public void setApolloMissionNumber(int apolloMissionNumber) {
        this.apolloMissionNumber = apolloMissionNumber;
    }

    public String getYearOfMission() {
        return yearOfMission;
    }

    public void setYearOfMission(String yearOfMission) {
        this.yearOfMission = yearOfMission;
    }
}
