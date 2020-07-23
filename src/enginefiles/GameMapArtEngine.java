package enginefiles;

import coregamefiles.GameMapArt;
import coregamefiles.GameMapArtConditionEnum;
import coregamefiles.GameMapHashMap;
import exceptionfiles.InvalidGameMapScenarioException;

import java.util.HashMap;
import java.util.Map;

import static coregamefiles.GameMapArtConditionEnum.*;

public class GameMapArtEngine {
    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    //map enum selection instantiation
    private GameMapArtConditionEnum mapArtConditionEnum;

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

    /************************
     ************************
     * Constructor
     ************************
     ************************/
    GameMapArtEngine() {
        GameMapHashMap gameMapHashMap = new GameMapHashMap();
        Map<String, HashMap<String, String>> rooms = gameMapHashMap.getRooms();
    }

    /************************
     ************************
     * Business Methods
     ************************
     ***********************
     * @return*/
    //get the current room from game engine
    private String getTheRoom() {
        return GameEngine.getCurrentRoom();
    }

    void roomHasBeenVisited() {
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
                case "conservator":
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

    //TODO: first, create series of if statements to return ENUMS of diff maps
    private String whichRoom() {
        if (atriumVisited) {
            mapArtConditionEnum = MAP_ONE;
        }
        if (breakfastNookVisited) {
            mapArtConditionEnum = MAP_TWO;
        }
        if (fireSwampVisited) {
            mapArtConditionEnum = MAP_THREE;
        }
        if ((breakfastNookVisited) &&
                (menagerieVisited)) {
            mapArtConditionEnum = MAP_FOUR;
        }
        if ((fireSwampVisited) &&
                (hallVisited)) {
            mapArtConditionEnum = MAP_FIVE;
        }
        if ((breakfastNookVisited) &&
                (fireSwampVisited)) {
            mapArtConditionEnum = MAP_SIX;
        }
        if ((breakfastNookVisited) &&
                (menagerieVisited) &&
                (diningRoomVisited)) {
            mapArtConditionEnum = MAP_SEVEN;
        }
        return String.valueOf(mapArtConditionEnum);
    }

    //DONE: don't forget to create the ENUM class to define these cases
    // WILL NEED TO ADD MORE ENUMS FOR THIS, I ONLY HAVE 10 RIGHT NOW

    //TODO: create a switch case that causes print-out of particular maps bases on conditions
    //condition cases are the ENUMS from above, so case MAPONE: //dosomething break;
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
                default:
                    throw new InvalidGameMapScenarioException();
            }
        } catch (InvalidGameMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }

    //DONE: create the above custom exception class in the exception files

    //TODO: create corresponding ANSI maps for each switch case above
    //^in progress

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