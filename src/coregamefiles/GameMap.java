package coregamefiles;

import java.util.HashMap;

public class GameMap {

    // MAP
    private HashMap<String, HashMap<String, String>> rooms = new HashMap<>();
    private HashMap<String, String> hall = new HashMap<String, String>();
    private HashMap<String, String> kitchen = new HashMap<String, String>();
    private HashMap<String, String> diningRoom = new HashMap<String, String>();
    private HashMap<String, String> garden = new HashMap<String, String>();

    //provide info for map
    private void createMap() {
        hall.put("south", "Kitchen");
        hall.put("east", "Dining Room");
        hall.put("item", "key");

        kitchen.put("north", "Hall");
        kitchen.put("east", "Garden");
        kitchen.put("item", "monster");

        diningRoom.put("west", "Hall");
        diningRoom.put("south", "Garden");
        diningRoom.put("item", "potion");

        garden.put("north", "Dining Room");
        garden.put("west", "Kitchen");
        garden.put("item", "sword");

        rooms.put("Kitchen", kitchen);
        rooms.put("Hall", hall);
        rooms.put("Dining Room", diningRoom);
        rooms.put("Garden", garden);
    }
}
