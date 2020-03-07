/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_monstermash;

import java.io.InputStream;
import javax.sound.sampled.*;
/**
 *
 * @author barrymolina
 */
public class AudioAsync {
    public void playAudio(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.loop(0);
            clip.start();
            while (clip.getFrameLength() != clip.getFramePosition()) {
                // Wait for cry to finish
            }
            Thread.sleep(500); // Wait a bit more, just in case
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
