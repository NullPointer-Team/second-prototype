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

package coregamefiles;

public class GameMapWhichRoom {

    //instantiate gameMapArtEngine here to set whichRoom conditions
//    GameMapArtEngine gameMapArtEngine = new GameMapArtEngine();
    RoomVisitTrackingEngine roomVisitTrackingEngine = new RoomVisitTrackingEngine();

    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    //mapArtCondition selection instantiation
    private String mapArtCondition;

    //TODO: first, create series of if statements to return map art condition for mapEngine()
    public String whichRoom() {
//        if (isAtriumVisited()) {
//            setMapArtCondition("MAP_ONE");
//        }
        if (isBreakfastNookVisited()) {
            setMapArtCondition("MAP_TWO");
        }
        if (isFireSwampVisited()) {
            setMapArtCondition("MAP_THREE");
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited())) {
            setMapArtCondition("MAP_FOUR");
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited())) {
            setMapArtCondition("MAP_FIVE");
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited())) {
            setMapArtCondition("MAP_SIX");
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited())) {
            setMapArtCondition("MAP_SEVEN");
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited())) {
            setMapArtCondition("MAP_EIGHT");
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited())) {
            setMapArtCondition("MAP_NINE");
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited())) {
            setMapArtCondition("MAP_TEN");
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited())) {
            setMapArtCondition("MAP_ELEVEN");
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited())) {
            setMapArtCondition("MAP_TWELVE");
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            setMapArtCondition("MAP_THIRTEEN");
        }
        if ((isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited())) {
            setMapArtCondition("MAP_FOURTEEN");
        }
        if ((isBreakfastNookVisited()) &&
                (isMenagerieVisited()) &&
                (isDiningRoomVisited()) &&
                (isHallVisited()) &&
                (isArcadeVisited())){
            setMapArtCondition("MAP_FIFTEEN");
        }
        if ((isBreakfastNookVisited()) &&
                (isFireSwampVisited()) &&
                (isHallVisited()) &&
                (isDiningRoomVisited()) &&
                (isArcadeVisited()))
            setMapArtCondition("MAP_SIXTEEN");
        return getMapArtCondition();
    }

    /************************
     ************************
     * GETTERS & SETTERS
     ************************
     ************************/
    //this getter is called in the GameMapArtEngine
    public String getMapArtCondition() {
        return mapArtCondition;
    }

    //this setter is used above in the whichRoom method to set room
    public void setMapArtCondition(String mapArtCondition) {
        this.mapArtCondition = mapArtCondition;
    }

    public boolean isAtriumVisited() {
        return roomVisitTrackingEngine.isAtriumVisited();
    }

    public boolean isBreakfastNookVisited() {
        return roomVisitTrackingEngine.isBreakfastNookVisited();
    }

    public boolean isFireSwampVisited() {
        return roomVisitTrackingEngine.isFireSwampVisited();
    }

    public boolean isHallVisited() {
        return roomVisitTrackingEngine.isHallVisited();
    }

    public boolean isMenagerieVisited() {
        return roomVisitTrackingEngine.isMenagerieVisited();
    }

    public boolean isDiningRoomVisited() {
        return roomVisitTrackingEngine.isDiningRoomVisited();
    }

    public boolean isArcadeVisited() {
        return roomVisitTrackingEngine.isArcadeVisited();
    }

    public boolean isConservatoryVisited() {
        return roomVisitTrackingEngine.isConservatoryVisited();
    }

    public boolean isPanicRoomVisited() {
        return roomVisitTrackingEngine.isPanicRoomVisited();
    }

    public boolean isObservatoryVisited() {
        return roomVisitTrackingEngine.isObservatoryVisited();
    }

    public boolean isLibraryVisited() {
        return roomVisitTrackingEngine.isLibraryVisited();
    }

    public boolean isCourtyardVisited() {
        return roomVisitTrackingEngine.isCourtyardVisited();
    }

    public boolean isGardenVisited() {
        return roomVisitTrackingEngine.isGardenVisited();
    }

    public boolean isLaboratoryVisited() {
        return roomVisitTrackingEngine.isLaboratoryVisited();
    }

    public boolean isKitchenVisited() {
        return roomVisitTrackingEngine.isKitchenVisited();
    }
}

