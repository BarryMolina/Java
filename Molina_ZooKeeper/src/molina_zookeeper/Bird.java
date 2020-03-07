/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_zookeeper;

/**
 *
 * @author barrymolina
 */
public class Bird extends Animal {

	private boolean isTagged;
	private boolean isCarnivore;

	public Bird() {
	}

	public Bird(boolean isTagged, boolean isCarnivore, String type, int age, 
			int animalIdNumber, String gender, String dietType, 
			String zooLocation) {

		super(type, age, animalIdNumber, gender, dietType, zooLocation);
		this.isTagged = isTagged;
		this.isCarnivore = isCarnivore;
	}
	
	public boolean isIsTagged() {
		return isTagged;
	}

	public void setIsTagged(boolean isTagged) {
		this.isTagged = isTagged;
	}

	public boolean isIsCarnivore() {
		return isCarnivore;
	}

	public void setIsCarnivore(boolean isCarnivore) {
		this.isCarnivore = isCarnivore;
	}
	
	@Override
	public String move() {
		return "Fly";
	}

	@Override
	public String toString() {
		
		return String.format("%18s: " + getType() +
				"\n%18s: " + getAge() +
				"\n%18s: " + getAnimalIdNumber() +
				"\n%18s: " + getGender() +
				"\n%18s: " + getDietType() +
				"\n%18s: " + getZooLocation() +
				"\n%18s: " + isTagged +
				"\n%18s: " + isCarnivore + "\n",
				"Animal Type", "Age", "ID Number", "Gender", "Diet Type",
				"Zoo Location", "Tagged", "Carnivorous");
	}
}
