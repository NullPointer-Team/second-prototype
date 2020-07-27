package music;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import javax.swing.Timer;
// This file for music  for every objects



public class Music {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    // this file for monster voice
    public static void monster(String room) throws Exception {
        //when user/Gamer enter in room where monster is there voice will be played and open up pop up
        URL url = new URL(room);

        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Monster.... fight, run or die!");
        });


    }
    public static void atriumMusic(String room) throws Exception {
        //when user/Gamer enter in atrium music will play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null,  " Welcome to Adventure Game!!!!");
        });

    }
    public static void panicMusic(String room) throws Exception {
        //when user/Gamer enter in garden relex music will play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "You are in " + room + " Panic? find your way!!!!");
        });

    }
    public static void fireSwampMusic(String room) throws Exception {
        //when user/Gamer enter in garden relex music will play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "You are in " + room + " Welcome to Adventure!!!!");
        });

    }
    public static void gardenMusic(String room) throws Exception {
        //when user/Gamer enter in garden relex music will play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "You are in Garden Relex!!!!");
        });

    }

    public static void playMusic(String room) throws Exception {
        //when user/Gamer enter in garden relex music will play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "You are in " + room + " Relex!!!!");
        });

    }
    public static void loseMusic() throws Exception {
        //when user/Gamer loose game , teasing music will play
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_CartoonHeadShake_4003_18_1.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        //added -1 not sure after playing with code if i use -1 some how it plying one time, but it is temp solution
        clip.loop(Clip.LOOP_CONTINUOUSLY-1);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "May I help you to find corner for cry?");

        });
//        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        System.out.println(ANSI_GREEN +"========= May I help you to find corner for cry? ================"+ANSI_RESET);

    }



    public static void fireMusic(String room) throws Exception {
        //when user/Gamer enter in room where Fire is there this sound will be play
        URL url = new URL(room);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Fire Save your self!");
        });


    }

    public static void playMusicIfAvailable(String urlForRoom) throws Exception {
        //when user/Gamer win there this sound will be play
        URL url = new URL(urlForRoom);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        Timer timer = new Timer(8000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.close();
            }
        });

        timer.setRepeats(false);
        timer.start();

    }

    public static void win() throws Exception {
        //when user/Gamer win there this sound will be play
        URL url = new URL("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_CrowdBooing_6013_82_2.wav");
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println( ANSI_WHITE_BACKGROUND +"Winner Winner Taco Dinner!!"+ ANSI_RESET);
        SwingUtilities.invokeLater(() -> {
            // Pop up will  display to user what user supposed to do.

            JOptionPane.showMessageDialog(null, "Winner winner Taco Dinner!");

        });


    }

    public static void main(String[] args) throws Exception {
        Music music = new Music();
        /*
        Uncomment below line to use,
        To do , while user navigate to diff room ,we going to call method
         */
//        music.monster();
//        music.garden();
//        music.fire();
        music.win();
    }

}
