package enginefiles;

public class PrintMapEngine {
    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
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
     ************************/
    //TODO: first, create series of if statements to return ENUMS of diff maps
//    if( isAtriumVisited() && isBreakfastNookVisited()) {
//        return MapCase.MAPONE;
//    }


    //TODO: don't forget to create the ENUM class to define these cases

    //TODO: create a switch case that causes print-out of particular maps bases on conditions
    //condition cases are the ENUMS from above, so case MAPONE: //dosomething break;
    /*
    public void mapEngine() {
        try {
            switch (userInput.nextLine().toUpperCase().trim()) {
                case "MAPONE":
                    return GraphicMap.map1();
                    break;
                case "MAPTWO":
                    return GraphicMap.map2();
                    break;
                case "MAPTHREE":
                    return GraphicMap.map3();
                    break;
                case "MAPFOUR":
                    return GraphicMap.map4();
                    break;
                case "MAPFIVE":
                    return GraphicMap.map5();
                    break;
                case "MAPSIX":
                    return GraphicMap.map6();
                    break;
                case "MAPSEVEN":
                    return GraphicMap.map7();
                    break;
                case "MAPEIGHT":
                    return GraphicMap.map8();
                    break;
                default:
                    throw new InvalidMapScenarioException();
            }
        } catch (InvalidMapScenarioException e) {
            System.out.println(e.getMessage());
        }
    }
    */
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
        atriumVisited = atriumVisited;
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
