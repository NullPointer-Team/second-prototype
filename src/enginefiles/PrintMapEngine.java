package enginefiles;

public class PrintMapEngine {
    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    //create boolean fields for each room on map
    private boolean atriumVisited = true;
    private boolean isBreakfastNookVisited = false;
    private boolean isFireSwampVisited = false;
    private boolean isHallVisited = false;
    private boolean isMenagerieVisited = false;
    private boolean isDiningRoomVisited = false;
    private boolean isArcadeVisited = false;
    private boolean isMConservatoryVisited = false;
    private boolean isPanicRoomVisited = false;
    private boolean isObservatoryVisited = false;
    private boolean isLibraryVisited = false;
    private boolean isCourtyardVisited = false;
    private boolean isGardenVisited = false;
    private boolean isLaboratoryVisited = false;
    private boolean isKitchenVisited = false;

    /************************
     ************************
     * Business Methods
     ************************
     ************************/
    //first, create series of if statements to return ENUMS of diff maps
//    if( isAtriumVisited() && isBreakfastNookVisited()) {
//        return MapCase.MAPONE;
//    }
    //TODO: don't forget to create the ENUM class to define these

    //create a switch case that causes print-out of particular maps bases on conditions
    //condition cases are the ENUMS from above, so case MAPONE: //dosomething break;


    /************************
     ************************
     * GETTERS & SETTERS
     ************************
     ************************/
    public boolean isAtriumVisited() {
        return atriumVisited;
    }

    public void setAtriumVisited(boolean atriumVisited) {
        atriumVisited = atriumVisited;
    }

    public boolean isBreakfastNookVisited() {
        return isBreakfastNookVisited;
    }

    public void setBreakfastNookVisited(boolean breakfastNookVisited) {
        isBreakfastNookVisited = breakfastNookVisited;
    }

    public boolean isFireSwampVisited() {
        return isFireSwampVisited;
    }

    public void setFireSwampVisited(boolean fireSwampVisited) {
        isFireSwampVisited = fireSwampVisited;
    }

    public boolean isHallVisited() {
        return isHallVisited;
    }

    public void setHallVisited(boolean hallVisited) {
        isHallVisited = hallVisited;
    }

    public boolean isMenagerieVisited() {
        return isMenagerieVisited;
    }

    public void setMenagerieVisited(boolean menagerieVisited) {
        isMenagerieVisited = menagerieVisited;
    }

    public boolean isDiningRoomVisited() {
        return isDiningRoomVisited;
    }

    public void setDiningRoomVisited(boolean diningRoomVisited) {
        isDiningRoomVisited = diningRoomVisited;
    }

    public boolean isArcadeVisited() {
        return isArcadeVisited;
    }

    public void setArcadeVisited(boolean arcadeVisited) {
        isArcadeVisited = arcadeVisited;
    }

    public boolean isMConservatoryVisited() {
        return isMConservatoryVisited;
    }

    public void setMConservatoryVisited(boolean MConservatoryVisited) {
        isMConservatoryVisited = MConservatoryVisited;
    }

    public boolean isPanicRoomVisited() {
        return isPanicRoomVisited;
    }

    public void setPanicRoomVisited(boolean panicRoomVisited) {
        isPanicRoomVisited = panicRoomVisited;
    }

    public boolean isObservatoryVisited() {
        return isObservatoryVisited;
    }

    public void setObservatoryVisited(boolean observatoryVisited) {
        isObservatoryVisited = observatoryVisited;
    }

    public boolean isLibraryVisited() {
        return isLibraryVisited;
    }

    public void setLibraryVisited(boolean libraryVisited) {
        isLibraryVisited = libraryVisited;
    }

    public boolean isCourtyardVisited() {
        return isCourtyardVisited;
    }

    public void setCourtyardVisited(boolean courtyardVisited) {
        isCourtyardVisited = courtyardVisited;
    }

    public boolean isGardenVisited() {
        return isGardenVisited;
    }

    public void setGardenVisited(boolean gardenVisited) {
        isGardenVisited = gardenVisited;
    }

    public boolean isLaboratoryVisited() {
        return isLaboratoryVisited;
    }

    public void setLaboratoryVisited(boolean laboratoryVisited) {
        isLaboratoryVisited = laboratoryVisited;
    }

    public boolean isKitchenVisited() {
        return isKitchenVisited;
    }

    public void setKitchenVisited(boolean kitchenVisited) {
        isKitchenVisited = kitchenVisited;
    }

}
