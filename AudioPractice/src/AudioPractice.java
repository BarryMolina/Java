
//not sure why but this only runs when in the default package folder

import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioStream;
import sun.audio.*;

public class AudioPractice {
    
    public static void main(String[] args) {
     
        String fileName = "/step.wav";
        PlayAudio pa = new PlayAudio();
        pa.playAudio(fileName);                     //plays the step audio
        pa.goToSleep();
        fileName = "/monstermoan.wav";
        pa.playAudio(fileName);
        
        
        fileName = "/monstermoan.wav";
        AudioAsync pas = new AudioAsync();
        pas.playAudio(fileName);
        
        fileName = "/chomp3.wav";
        pas.playAudio(fileName);
        
        fileName = "/jack.wav";
        pas.playAudio(fileName);
        
        fileName = "/pig.wav";
        pas.playAudio(fileName);
   }  
   
}

class PlayAudio 
{
   
    InputStream inputStream;
    public void playAudio(String fileName)                      
    {
        try 
        {
            inputStream = getClass().getResourceAsStream(fileName);
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void goToSleep()
    {
        try
        {
            Thread.sleep(12000);
        }
            catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
}