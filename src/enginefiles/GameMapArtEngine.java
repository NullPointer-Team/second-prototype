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
import coregamefiles.GameMapArtConditionEnum;
import coregamefiles.GameMapHashMap;
import exceptionfiles.InvalidGameMapScenarioException;

import java.util.HashMap;
import java.util.Map;

import static coregamefiles.GameMapArtConditionEnum.*;
import static coregamefiles.GameMapArtConditionEnum.MAP_SIXTEEN;

public class GameMapArtEngine  {

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
            switch ( whichRoom() ) {
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
                case "MAP_EIGHTEEN":
                    GameMapArt.map18();
                    break;
                case "MAP_NINETEEN":
                    GameMapArt.map19();
                    break;
                case "MAP_TWENTY":
                    GameMapArt.map20();
                    break;
                case "MAP_TWENTY_ONE":
                    GameMapArt.map21();
                    break;
                case "MAP_TWENTY_TWO":
                    GameMapArt.map22();
                    break;
                case "MAP_TWENTY_THREE":
                    GameMapArt.map23();
                    break;
                case "MAP_TWENTY_FOUR":
                    GameMapArt.map24();
                    break;
                case "MAP_TWENTY_FIVE":
                    GameMapArt.map25();
                    break;
                case "MAP_TWENTY_SIX":
                    GameMapArt.map26();
                    break;
                case "MAP_TWENTY_SEVEN":
                    GameMapArt.map27();
                    break;
                case "MAP_TWENTY_EIGHT":
                    GameMapArt.map28();
                    break;
                case "MAP_TWENTY_NINE":
                    GameMapArt.map29();
                    break;
                default:
                    throw new InvalidGameMapScenarioException();
            }
        } catch (InvalidGameMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }

    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    // boolean fields for each room on map
    private boolean atriumVisited = true;
    private boolean breakfastNookVisited = false;
    private boolean fireSwampVisited = false;
    private boolean hallVisited = false;
    private boolean menagerieVisited = false;
    private boolean diningRoomVisited = false;
    private boolean arcadeVisited = false;
    private boolean conservatoryVisited = false;
    private boolean panicRoomVisited = false;
    private boolean observatoryVisited = false;
    private boolean libraryVisited = false;
    private boolean courtyardVisited = false;
    private boolean gardenVisited = false;
    private boolean laboratoryVisited = false;
    private boolean kitchenVisited = false;

    //get the current room from game engine
    private String getTheRoom() {
        return GameEngine.getCurrentRoom();
    }

    public void roomHasBeenVisited() {
        String setVisit = getTheRoom();
        try {
            switch (setVisit.toLowerCase()) {
                case "atrium":
                    setAtriumVisited(true);
                    break;
                case "breakfast nook":
                    setBreakfastNookVisited(true);
                    break;
                case "menagerie":
                    setMenagerieVisited(true);
                    break;
                case "conservatory":
                    setConservatoryVisited(true);
                    break;
                case "panic room":
                    setPanicRoomVisited(true);
                    break;
                case "fire swamps":
                    setFireSwampVisited(true);
                    break;
                case "hall":
                    setHallVisited(true);
                    break;
                case "dining room":
                    setDiningRoomVisited(true);
                    break;
                case "arcade":
                    setArcadeVisited(true);
                    break;
                case "observatory":
                    setObservatoryVisited(true);
                    break;
                case "courtyard":
                    setCourtyardVisited(true);
                    break;
                case "library":
                    setLibraryVisited(true);
                    break;
                case "garden":
                    setGardenVisited(true);
                    break;
                case "laboratory":
                    setLaboratoryVisited(true);
                    break;
                case "kitchen":
                    setKitchenVisited(true);
                    break;
                default:
                    throw new InvalidGameMapScenarioException();
            }
        } catch (InvalidGameMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }

    private GameMapArtConditionEnum mapArtConditionEnum;

    /************************
     ************************
     * Business Methods
     ************************
     ***********************/
    //TODO: first, create series of if statements to return map art condition for mapEngine()
    public String whichRoom() {
        if (isAtriumVisited()) {
            mapArtConditionEnum = MAP_ONE;
        }
        if (isBreakfastNookVisited()) {
            mapArtConditionEnum = MAP_TWO;
        }
        if (isFireSwampVisited()) {
            mapArtConditionEnum = MAP_THREE;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited())) {
            mapArtConditionEnum = MAP_FOUR;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited())) {
            mapArtConditionEnum = MAP_FIVE;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited())) {
            mapArtConditionEnum = MAP_SIX;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited())) {
            mapArtConditionEnum = MAP_SEVEN;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited())) {
            mapArtConditionEnum = MAP_EIGHT;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isMenagerieVisited())) {
            mapArtConditionEnum = MAP_NINE;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited())) {
            mapArtConditionEnum = MAP_TEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited())) {
            mapArtConditionEnum = MAP_ELEVEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited())) {
            mapArtConditionEnum = MAP_TWELVE;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited())) {
            mapArtConditionEnum = MAP_THIRTEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_FOURTEEN;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_FIFTEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_SIXTEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_SEVENTEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isMenagerieVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_EIGHTEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited()) &&
                (isObservatoryVisited())) {
            mapArtConditionEnum = MAP_NINETEEN;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited()) &&
                (isConservatoryVisited())) {
            mapArtConditionEnum = MAP_TWENTY;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited()) &&
                (isObservatoryVisited())) {
            mapArtConditionEnum = MAP_TWENTY_ONE;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited()) &&
                (isConservatoryVisited())) {
            mapArtConditionEnum = MAP_TWENTY_TWO;
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isMenagerieVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_TWENTY_THREE;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited()) &&
                (isObservatoryVisited()) &&
                (isConservatoryVisited())) {
            mapArtConditionEnum = MAP_TWENTY_FOUR;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isMenagerieVisited())) {
            mapArtConditionEnum = MAP_TWENTY_FIVE;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isMenagerieVisited())) {
            mapArtConditionEnum = MAP_TWENTY_FIVE;
        }
        if ((isFireSwampVisited()) &&
                (isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited())) {
            mapArtConditionEnum = MAP_TWENTY_SIX;
        }
        if ((isFireSwampVisited()) &&
                (isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_TWENTY_SEVEN;
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isMenagerieVisited()) &&
                (isArcadeVisited())) {
            mapArtConditionEnum = MAP_TWENTY_EIGHT;
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited()) &&
                (isObservatoryVisited()) &&
                (isConservatoryVisited())) {
            mapArtConditionEnum = MAP_TWENTY_NINE;
        }
        return String.valueOf(mapArtConditionEnum);
    }

    /************************
     ************************
     * GETTERS & SETTERS
     ************************
     ************************/
    public boolean isAtriumVisited() {
        return atriumVisited;
    }

    public void setAtriumVisited(boolean atriumVisited) {
        this.atriumVisited = atriumVisited;
    }

    public boolean isBreakfastNookVisited() {
        return breakfastNookVisited;
    }

    public void setBreakfastNookVisited(boolean breakfastNookVisited) {
        this.breakfastNookVisited = breakfastNookVisited;
    }

    public boolean isFireSwampVisited() {
        return fireSwampVisited;
    }

    public void setFireSwampVisited(boolean fireSwampVisited) {
        this.fireSwampVisited = fireSwampVisited;
    }

    public boolean isHallVisited() {
        return hallVisited;
    }

    public void setHallVisited(boolean hallVisited) {
        this.hallVisited = hallVisited;
    }

    public boolean isMenagerieVisited() {
        return menagerieVisited;
    }

    public void setMenagerieVisited(boolean menagerieVisited) {
        this.menagerieVisited = menagerieVisited;
    }

    public boolean isDiningRoomVisited() {
        return diningRoomVisited;
    }

    public void setDiningRoomVisited(boolean diningRoomVisited) {
        this.diningRoomVisited = diningRoomVisited;
    }

    public boolean isArcadeVisited() {
        return arcadeVisited;
    }

    public void setArcadeVisited(boolean arcadeVisited) {
        this.arcadeVisited = arcadeVisited;
    }

    public boolean isConservatoryVisited() {
        return conservatoryVisited;
    }

    public void setConservatoryVisited(boolean conservatoryVisited) {
        this.conservatoryVisited = conservatoryVisited;
    }

    public boolean isPanicRoomVisited() {
        return panicRoomVisited;
    }

    public void setPanicRoomVisited(boolean panicRoomVisited) {
        this.panicRoomVisited = panicRoomVisited;
    }

    public boolean isObservatoryVisited() {
        return observatoryVisited;
    }

    public void setObservatoryVisited(boolean observatoryVisited) {
        this.observatoryVisited = observatoryVisited;
    }

    public boolean isLibraryVisited() {
        return libraryVisited;
    }

    public void setLibraryVisited(boolean libraryVisited) {
        this.libraryVisited = libraryVisited;
    }

    public boolean isCourtyardVisited() {
        return courtyardVisited;
    }

    public void setCourtyardVisited(boolean courtyardVisited) {
        this.courtyardVisited = courtyardVisited;
    }

    public boolean isGardenVisited() {
        return gardenVisited;
    }

    public void setGardenVisited(boolean gardenVisited) {
        this.gardenVisited = gardenVisited;
    }

    public boolean isLaboratoryVisited() {
        return laboratoryVisited;
    }

    public void setLaboratoryVisited(boolean laboratoryVisited) {
        this.laboratoryVisited = laboratoryVisited;
    }

    public boolean isKitchenVisited() {
        return kitchenVisited;
    }

    public void setKitchenVisited(boolean kitchenVisited) {
        this.kitchenVisited = kitchenVisited;
    }
}