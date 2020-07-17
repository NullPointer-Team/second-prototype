package music;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
// This file for music  for every objects



public class Music {
    // this file for monster voice
    public static void monster() throws Exception {
        //when user/Gamer enter in room where monster is there voice will be played and open up pop up
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Horror-Rhythm-Pattern_DRAME01036.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Monster.... fight, run or die!");
        });


    }
    public static void garden() throws Exception {
        //when user/Gamer enter in garden relex music will play
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ForestDay_6095_24.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "You are in Garden Relex!!!!");
        });


    }
    public static void fire() throws Exception {
        //when user/Gamer enter in room where Fire is there this sound will be play
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Horror-Rhythm-Pattern_DRAME01036.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Fire Save your self!");
        });


    }
    public static void win() throws Exception {
        //when user/Gamer win there this sound will be play
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_CrowdBooing_6013_82_2.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Winner winner Taco Dinner!");
        });


    }

    public static void main(String[] args) throws Exception {
        Music music = new Music();
//        music.monster();
//        music.garden();
//        music.fire();
        music.win();
    }
}
