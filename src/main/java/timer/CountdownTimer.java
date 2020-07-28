package timer;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

    //this seconds for, if character goes to some room where there is fire or sand has to finish task
    int second= 31;
    Timer time= new Timer();
    TimerTask task = new TimerTask() {

        public void run() {
            second--;
            System.out.println("Second Left "+second);
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
        time.scheduleAtFixedRate(task,1000,1000);

    }

    public static void main(String[] args) {
        CountdownTimer count = new CountdownTimer();
        count.startTimer();
    }
}
