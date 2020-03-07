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
public class Demogorgon extends Monster{

	private String state = "Upside Down";
	private String sound = "./DemogorgonSound.wav";
	private String type = "Demogorgon";

	public Demogorgon() {
		setMonsterType(type);
	}

	public Demogorgon(String name, int scareFactor, int size, int speed) {
					  
		super(name, scareFactor, size, speed);
		setMonsterType(type);
	}

	@Override
	public void speak() {
		pas.playAudio(sound);
	}
	
	public void createPortal() {
		System.out.println("The Demogorgon has escaped to the Upside Down");
	}
	
}
