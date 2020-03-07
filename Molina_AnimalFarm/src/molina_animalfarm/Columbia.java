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
public class Columbia extends Sheep {
	
	private boolean isSold;

	public boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(boolean isSold) {
		this.isSold = isSold;
	}

	@Override
	public String displayAll() {
		return super.displayAll() + 
				String.format("%15s: " + isSold + "\n", "Sold");
	}
}
