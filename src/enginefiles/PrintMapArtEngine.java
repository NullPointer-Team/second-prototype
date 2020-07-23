package enginefiles;

import coregamefiles.PrintMapArt;
import coregamefiles.PrintMapArtConditionEnum;
import exceptionfiles.InvalidMapScenarioException;

import static coregamefiles.PrintMapArtConditionEnum.MAP_TWO;

public class PrintMapArtEngine {
    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    //map enum selection instantiation
    private PrintMapArtConditionEnum mapArtConditionEnum;

    //create boolean fields for each room on map
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
     * Business Methods
     ************************
     ***********************
     * @return*/

//    if( isAtriumVisited() && isBreakfastNookVisited()) {
//        return MapCase.MAPONE;
//    }
    //get the current room from game engine
    private String getTheRoom() {
        //return GameEngine.getCurrentRoom();
        return "String";
    }

    private void roomHasBeenVisited() {
        String setVisit = getTheRoom();
        try {
            switch (setVisit.toUpperCase()) {
                case "Fire Swamp":
                    setFireSwampVisited(true);
                    break;
                case "Breakfast Nook":
                    setBreakfastNookVisited(true);
                    break;
                //KEEP ADDING CASES
                default:
                    throw new InvalidMapScenarioException();
            }
        } catch (InvalidMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO: first, create series of if statements to return ENUMS of diff maps
    private String whichRoom() {
        if (breakfastNookVisited) {
            mapArtConditionEnum = MAP_TWO;
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
                    PrintMapArt.map1();
                    break;
                case "MAP_TWO":
                    PrintMapArt.map2();
                    break;
                case "MAP_THREE":
                    PrintMapArt.map3();
                    break;
                case "MAP_FOUR":
                    PrintMapArt.map4();
                    break;
                case "MAP_FIVE":
                    PrintMapArt.map5();
                    break;
                case "MAP_SIX":
                    PrintMapArt.map6();
                    break;
                case "MAP_SEVEN":
                    PrintMapArt.map7();
                    break;
                case "MAP_EIGHT":
                    PrintMapArt.map8();
                    break;
                default:
                    throw new InvalidMapScenarioException();
            }
        } catch (InvalidMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO: create the above custom exception class in the exception files

    //TODO: create corresponding ANSI maps for each switch case above

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
