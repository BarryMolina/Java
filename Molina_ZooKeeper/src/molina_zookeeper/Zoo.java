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
public class Zoo {

	private Mammal lion = new Mammal("Simba", 200, 2, "Lion", 10, 957678, "male", 
			"carnivore", "Big cat field");
	
	private Mammal bear = new Mammal("Barrington", 245, 5, "Bear", 8, 989718, 
			"female", "omnivore", "Bear island");

	private Mammal elephant = new Mammal("Dumbo", 500, 3, "Elephant", 15, 944748, 
			"female", "herbivore", "Africa island");

	private Reptile snake = new Reptile(false, true, "snake", 5, 678944, "male", 
			"herbivore", "Grassy field house");

	private Reptile turtle = new Reptile(true, false, "turtle", 18, 605647, "male", 
			"herbivore", "Central pond");

	private Reptile gecko = new Reptile(false, true, "gecko", 15, 645033, "female", 
			"herbivore", "Tropical house");

	private Bird eagle = new Bird(true, true, "Eagle", 9, 3344448, "male", 
			"carnivore", "Building 53");
							

	private Bird finch = new Bird(false, false, "Finch", 3, 3940495, "female", 
			"herbivore", "Building 23");
						

	private Bird parrot = new Bird(true, false, "Parrot", 13, 345212, "male", 
			"herbivore", "Tropical village");
							
	
	private Mammal [] mammal = {lion, bear, elephant};
	private Reptile [] reptile = {snake, turtle, gecko};
	private Bird [] bird = {eagle, finch, parrot};

	private Animal [][] animal = {mammal, reptile, bird};

	private String [] animalClass = {"Mammal", "Reptile",  "Bird"};

	public Animal[][] getAnimal() {
		return animal;
	}

	public String[] getAnimalClass() {
		return animalClass;
	}
}
