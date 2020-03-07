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
public abstract class Animal {

	private String AnimalClassification;
	private String TagNumber;
	private String Gender;
	private String Location;

	public String getAnimalClassification() {
		return AnimalClassification;
	}

	public void setAnimalClassification(String AnimalClassification) {
		this.AnimalClassification = AnimalClassification;
	}

	public String getTagNumber() {
		return TagNumber;
	}

	public void setTagNumber(String TagNumber) {
		this.TagNumber = TagNumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	abstract String displayAll();
	
}
