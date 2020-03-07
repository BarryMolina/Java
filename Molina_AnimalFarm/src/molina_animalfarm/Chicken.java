/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_animalfarm;

/**
 *
 * @author barrymolina
 */
public class Chicken extends Animal {

	private String eggColor;
	private int eggCount;

	public String getEggColor() {
		return eggColor;
	}

	public void setEggColor(String eggColor) {
		this.eggColor = eggColor;
	}

	public int getEggCount() {
		return eggCount;
	}

	public void setEggCount(int eggCount) {
		this.eggCount = eggCount;
	}

	@Override
	public String displayAll() {
		
		return String.format("%15s: " + getAnimalClassification() +
			   				"\n%15s: " + getTagNumber() + 
			   				"\n%15s: " + getGender() +
			   				"\n%15s: " + getLocation() + 
							"\n%15s: " + eggColor +
							"\n%15s: " + eggCount + "\n", 
							"Animal", "Tag Number", "Gender", "Location",
							"Egg Color", "Egg Count");
	}
}
