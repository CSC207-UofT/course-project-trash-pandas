package Music;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Creates a music object that can play music
 */
public class MusicHandler {
    Clip clip;
    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e) {
            System.out.println("Please Try Again");

        }
    }

    /**
     * Plays the music one time, useful for dialogue
     */
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    /**
     * loops the music
     */
    public void loop() {
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    /**
     * stops the music
     */
    public void stop() {
        clip.stop();
        clip.close();
    }

}
