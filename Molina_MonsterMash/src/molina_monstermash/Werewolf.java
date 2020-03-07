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
public class Werewolf extends Monster{
	
	private String transformAt = "Full Moon";
	private String sound = "./WerewolfSound.wav";
	private String type = "Werewolf";

	public Werewolf() {
		setMonsterType(type);
	}

	public Werewolf(String name, int scareFactor, int size, int speed) {
					  
		super(name, scareFactor, size, speed);
		setMonsterType(type);

	}
	@Override
	public void speak() {
		pas.playAudio(sound);
	}

	public void claw() {
		System.out.println("The Werewolf thrashes with his giant claws, "
				+ "dealing massive damage");
	}
}
