/*
 *      Stranger Game
 *      Team NullPointer (Team 5)
 *      https://github.com/NullPointer-Team
 *      Neill Perry (https://github.com/neillperry)
 *      Bruce West (https://github.com/BruceBAWest)
 *      Tapan Trivedi (https://github.com/tapantriv)
 *      TLG Learning: Capstone Project
 *      https://github.com/NullPointer-Team/prototype
 */

package enginefiles;

import coregamefiles.GameMapArt;
import coregamefiles.GameMapWhichRoom;
import coregamefiles.GameMapHashMap;
import exceptionfiles.InvalidGameMapScenarioException;

import java.util.HashMap;
import java.util.Map;

public class GameMapArtEngine  {
    //instantiate instance of GameMapWhichRoom class
    GameMapWhichRoom gameMapWhichRoom = new GameMapWhichRoom();

    /************************
     ************************
     * Constructor
     ************************
     ************************/
    public GameMapArtEngine() {
        GameMapHashMap gameMapHashMap = new GameMapHashMap();
        Map<String, HashMap<String, String>> rooms = gameMapHashMap.getRooms();
    }

    /************************
     ************************
     * Business Methods
     ************************
     ***********************/
    public void mapEngine() {
        try {
            switch ( gameMapWhichRoom.whichRoom() ) {
                case "MAP_ONE":
                    GameMapArt.map1();
                    break;
                case "MAP_TWO":
                    GameMapArt.map2();
                    break;
                case "MAP_THREE":
                    GameMapArt.map3();
                    break;
                case "MAP_FOUR":
                    GameMapArt.map4();
                    break;
                case "MAP_FIVE":
                    GameMapArt.map5();
                    break;
                case "MAP_SIX":
                    GameMapArt.map6();
                    break;
                case "MAP_SEVEN":
                    GameMapArt.map7();
                    break;
                case "MAP_EIGHT":
                    GameMapArt.map8();
                    break;
                case "MAP_NINE":
                    GameMapArt.map9();
                    break;
                case "MAP_TEN":
                    GameMapArt.map10();
                    break;
                case "MAP_ELEVEN":
                    GameMapArt.map11();
                    break;
                case "MAP_TWELVE":
                    GameMapArt.map12();
                    break;
                case "MAP_THIRTEEN":
                    GameMapArt.map13();
                    break;
                case "MAP_FOURTEEN":
                    GameMapArt.map14();
                    break;
                case "MAP_FIFTEEN":
                    GameMapArt.map15();
                    break;
                case "MAP_SIXTEEN":
                    GameMapArt.map16();
                    break;
                case "MAP_SEVENTEEN":
                    GameMapArt.map17();
                    break;
//                case "MAP_EIGHTEEN":
//                    GameMapArt.map18();
//                    break;
//                case "MAP_NINETEEN":
//                    GameMapArt.map19();
//                    break;
//                case "MAP_TWENTY":
//                    GameMapArt.map20();
//                    break;
                default:
                    throw new InvalidGameMapScenarioException();
            }
        } catch (InvalidGameMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }
}