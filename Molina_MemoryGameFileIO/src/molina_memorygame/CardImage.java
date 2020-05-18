/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.scene.image.Image;

/**
 *
 * @author barrymolina
 */
public class CardImage extends Card {
	private String directory;
    private Image image;

    public CardImage(String dir, String fileName) {
		super(fileName);
		this.directory = dir;
        image = new Image(this.getFName());
    }

    public Image getImage() {
        return image;
    }

	@Override
	public String getFName() {
		return directory + super.getFName();
	}
}
