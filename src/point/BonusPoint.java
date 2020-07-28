package point;

import enginefiles.GameEngine;
import music.Music;
//try to use OOP Concept so I do not have to repeat ANSI soI extends
public class BonusPoint extends Music {
    GameEngine game = new GameEngine();
    int point =0;
    public void gamePoint(){

            point = point+10;
            System.out.println(ANSI_GREEN +"Congratulations!!!!! You got Bonus "+ point +" Point."+ANSI_RESET);
        }

    }






