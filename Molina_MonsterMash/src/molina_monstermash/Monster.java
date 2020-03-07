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
public class Monster {

	protected AudioAsync pas;
	private String sound = "./MonsterSound.wav";
	private String monsterType = "Generic Monster";
	private String name;
	private int scareFactor;
	private int size;
	private int speed;

	public Monster(){
		pas = new AudioAsync();
	};

	public Monster(String name, int scareFactor, int size,
					  int speed) {
		pas = new AudioAsync();

		this.name = name;
		this.scareFactor = scareFactor;
		this.size = size;
		this.speed = speed;
	}
	public String getMonsterType() {
		return monsterType;
	}
	public String getName() {
		return name;
	}
	public int getScareFactor() {
		return scareFactor;
	}
	public int getSize() {
		return size;
	}
	public int getSpeed() {
		return speed;
	}
	public int getPowerIndex() {
		return scareFactor + size + speed;
	}
	public void setMonsterType(String type) {
		monsterType = type;
	}
	public void setName(String n) {
		name = n;
	}
	public void setScareFactor(int factor) {
		scareFactor = factor;
	}
	public void setSize(int s) {
		size = s;
	}
	public void setSpeed(int s) {
		speed = s;
	}
	public void speak(){
        pas.playAudio(sound);
	}
	
}
