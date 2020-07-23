package enginefiles;

import coregamefiles.GameMapArt;
import coregamefiles.GameMapArtConditionEnum;
import coregamefiles.GameMapHashMap;
import exceptionfiles.InvalidGameMapScenarioException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static coregamefiles.GameMapArtConditionEnum.*;

public class TrackingEngine {
    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/


    // boolean fields for each room on map
    private ArrayList<String> userLocationTrack;
    private ArrayList<String> userObtainSkill;
    private ArrayList<String> userUsedSkill;
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
    TrackingEngine() {
        GameMapHashMap gameMapHashMap = new GameMapHashMap();
        Map<String, HashMap<String, String>> rooms = gameMapHashMap.getRooms();

        userLocationTrack=new ArrayList<String>();
        userObtainSkill = new ArrayList<String>();
        userUsedSkill = new ArrayList<String>();
    }

    /************************

     * Business Methods
     ************************

     * @return*/

    private String getTheRoom() {
        return GameEngine.getCurrentRoom();
    }

    void userVisited() {
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
        // I am  using logic of Bruce, if user visit to room set as room
        //after that add in userLocationTrack ArrayList
        //Looping through it and print it
        if (setVisit.equals(true)){

            userLocationTrack.add(getTheRoom());
            for (String userLocation:userLocationTrack){
                System.out.println("You have visited "+userLocation);

            }

        }
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
