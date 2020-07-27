package timer;

import enginefiles.GameEngine;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    GameEngine game = new GameEngine();

    //this seconds for, if character goes to some room where there is fire or sand has to finish task
    int second= 31;
    Timer time= new Timer();
    TimerTask task = new TimerTask() {

        public void run() {
            second--;
            SwingUtilities.invokeLater(() -> {
                // Pop up will  display to user what user supposed to do.

                JOptionPane.showMessageDialog(null, "Second left "+second);

            });
//            System.out.println("Second Left "+second);
//            if (second == 15){
////                System.out.println("------------Your are running out of time----------------");
//
//            }
             if (second >1 ){
//                System.out.println("-----------Oops!!!! Time out----------");

                try {
                    game.setGameOver();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }

        }
    };

    public void startTimer(){
        time.scheduleAtFixedRate(task,1000,1000);

    }

    public static void main(String[] args) {
        CountdownTimer count = new CountdownTimer();
        count.startTimer();
    }
}
