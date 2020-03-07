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
public abstract class Animal {
	
	private String type;
	private int age;
	private int animalIdNumber;
	private String gender;
	private String dietType;
	private String zooLocation;

	public Animal() {
	}

	public Animal(String type, int age, int animalIdNumber, String gender, 
			String dietType, String zooLocation) {

		this.type = type;
		this.age = age;
		this.animalIdNumber = animalIdNumber;
		this.gender = gender;
		this.dietType = dietType;
		this.zooLocation = zooLocation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAnimalIdNumber() {
		return animalIdNumber;
	}

	public void setAnimalIdNumber(int animalIdNumber) {
		this.animalIdNumber = animalIdNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

	public String getZooLocation() {
		return zooLocation;
	}

	public void setZooLocation(String zooLocation) {
		this.zooLocation = zooLocation;
	}
	
	abstract String move();
}
