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
public class Reptile extends Animal {

	private boolean hasShell;
	private boolean livesIndoors;

	public Reptile() {
	}

	public Reptile(boolean hasShell, boolean livesIndoors, String type, int age, 
			int animalIdNumber, String gender, String dietType, 
			String zooLocation) {

		super(type, age, animalIdNumber, gender, dietType, zooLocation);
		this.hasShell = hasShell;
		this.livesIndoors = livesIndoors;
	}

	public boolean isHasShell() {
		return hasShell;
	}

	public void setHasShell(boolean hasShell) {
		this.hasShell = hasShell;
	}

	public boolean isLivesIndoors() {
		return livesIndoors;
	}

	public void setLivesIndoors(boolean livesIndoors) {
		this.livesIndoors = livesIndoors;
	}
	
	@Override
	public String move() {
		return "Crawl";
	}

	@Override
	public String toString() {
		
		return String.format("%18s: " + getType() +
				"\n%18s: " + getAge() +
				"\n%18s: " + getAnimalIdNumber() +
				"\n%18s: " + getGender() +
				"\n%18s: " + getDietType() +
				"\n%18s: " + getZooLocation() +
				"\n%18s: " + hasShell +
				"\n%18s: " + livesIndoors + "\n",
				"Animal Type", "Age", "ID Number", "Gender", "Diet Type",
				"Zoo Location", "Has Shell", "Lives Indoors");
	}
}
