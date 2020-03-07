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
public class Sheep extends Animal {

	private String breed;
	private int age;
	private double salePrice;

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	@Override
	public String displayAll() {
		
		return String.format("%15s: " + getAnimalClassification() +
			   				"\n%15s: " + getTagNumber() + 
			   				"\n%15s: " + getGender() +
			   				"\n%15s: " + getLocation() + 
							"\n%15s: " + breed +
							"\n%15s: " + age +
							"\n%15s: $%.2f\n", 
							"Animal", "Tag Number", "Gender", "Location",
							"Breed", "Age", "Sale Price", salePrice);
	}
}
