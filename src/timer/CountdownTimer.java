package timer;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    //this seconds for, if character goes to some room where there is fire or sand has to finish task
    int second= 31;
    Timer time= new Timer();
    TimerTask task = new TimerTask() {

        public void run() {
            second--;
            //need suggestion
            SwingUtilities.invokeLater(() -> {
                // Pop up will  display to user what user supposed to do.

                JOptionPane.showMessageDialog(null, "Second Left "+second);
            });
            System.out.println("Second Left "+second);
            //System will Display warning message at 15 Second
            if (second == 15){
                System.out.println("------------Your are running out of time----------------");

            }


            else if (second ==0 ){
                System.out.println("-----------Oops!!!! Time out----------");


                System.exit(0);
            }

        }
    };

    public void startTimer(){
        //Timer set for a second rate
        time.scheduleAtFixedRate(task,1000,1000);

    }

    public static void main(String[] args) {
        CountdownTimer count = new CountdownTimer();
        count.startTimer();
    }
}
