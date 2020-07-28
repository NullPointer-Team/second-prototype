package point;

import enginefiles.GameEngine;
import music.Music;

import java.util.ArrayList;
import java.util.List;

//try to use OOP Concept so I do not have to repeat ANSI so I extends
public class BonusPoint extends Music {
//    GameEngine game = new GameEngine();
    int point =0;
    List<Integer> totalPoint= new ArrayList<Integer>();

//    int points = totalPoint+point;

    public void gamePoint(){

            point = point+10;
            totalPoint.add(point);
//
//        System.out.println("Total Point:"+totalPoint);
            System.out.println(ANSI_GREEN +"Congratulations!!!!! You got Bonus "+ point +" Point."+ANSI_RESET);
     for(int point :totalPoint){
         System.out.println("Total Point:"+point);
     }
    }

    }






