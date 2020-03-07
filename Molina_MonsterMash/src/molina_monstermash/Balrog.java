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
public class Balrog extends Monster{

	private String weapon = "Fire whip";
	private String sound = "./BalrogSound.wav";
	private String type = "Balrog";
	
	public Balrog() {
		setMonsterType(type);
	}

	public Balrog(String name, int scareFactor, int size, int speed) {

		super(name, scareFactor, size, speed);
		setMonsterType(type);
	}
	
	@Override
	public void speak() {
		pas.playAudio(sound);
	}

	public void grab() {
		System.out.println("The Balrog lashes out his whip, grabbing "
				+ "your leg and\npulling you to your doom");
	}
	
}
