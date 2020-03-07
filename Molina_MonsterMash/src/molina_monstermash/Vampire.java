/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_monstermash;

/**
 *
 * @author barrymolina
 */
public class Vampire extends Monster{

	private String food = "Blood";
	private String sound = "./EvilLaugh.wav";
	private String type = "Vampire";

	public Vampire() {
		setMonsterType(type);
	}

	public Vampire(String name, int scareFactor, int size, int speed) {
					 
		super(name, scareFactor, size, speed);
		setMonsterType(type);
	}

	@Override
	public void speak() {
		pas.playAudio(sound);
	}

	public void suckBlood() {
		System.out.println("The Vampire sucks his victim's blood, making him "
				+ "stronger and his opponent weaker");
	} 
	
}
