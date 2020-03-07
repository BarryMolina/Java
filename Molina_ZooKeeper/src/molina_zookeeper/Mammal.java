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
public class Mammal extends Animal {

	private String name;
	private double weight;
	private int dailyMealCount;

	public Mammal() {
	}

	public Mammal(String name, double weight, int dailyMealCount, String type, 
			int age, int animalIdNumber, String gender, String dietType, 
			String zooLocation) {

		super(type, age, animalIdNumber, gender, dietType, zooLocation);
		this.name = name;
		this.weight = weight;
		this.dailyMealCount = dailyMealCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getDailyMealCount() {
		return dailyMealCount;
	}

	public void setDailyMealCount(int dailyMealCount) {
		this.dailyMealCount = dailyMealCount;
	}
	
	@Override
	public String move() {
		return "Run, walk";
	}

	@Override
	public String toString() {
		
		return String.format("%18s: " + getType() +
				"\n%18s: " + getAge() +
				"\n%18s: " + getAnimalIdNumber() +
				"\n%18s: " + getGender() +
				"\n%18s: " + getDietType() +
				"\n%18s: " + getZooLocation() +
				"\n%18s: " + name +
				"\n%18s: %.0flbs" + 
				"\n%18s: " + dailyMealCount + "\n",
				"Animal Type", "Age", "ID Number", "Gender", "Diet Type",
				"Zoo Location", "Name", "Weight", weight, "Daily Meal Count");
	}
}
