package coregamefiles;

import java.util.HashMap;

public class GameMap {

    // MAP
    private HashMap<String, HashMap<String, String>> rooms = new HashMap<>();

    private HashMap<String, String> atrium = new HashMap<String, String>();
    private HashMap<String, String> breakfastNook = new HashMap<String, String>();
    private HashMap<String, String> menagerie = new HashMap<String, String>();
    private HashMap<String, String> conservatory = new HashMap<String, String>();
    private HashMap<String, String> panicRoom = new HashMap<String, String>();

    private HashMap<String, String> fireSwamps = new HashMap<String, String>();
    private HashMap<String, String> hall = new HashMap<String, String>();
    private HashMap<String, String> diningRoom = new HashMap<String, String>();
    private HashMap<String, String> arcade = new HashMap<String, String>();
    private HashMap<String, String> observatory = new HashMap<String, String>();

    private HashMap<String, String> courtyard = new HashMap<String, String>();
    private HashMap<String, String> library = new HashMap<String, String>();
    private HashMap<String, String> garden = new HashMap<String, String>();
    private HashMap<String, String> laboratory = new HashMap<String, String>();
    private HashMap<String, String> kitchen = new HashMap<String, String>();


    //provide info for map
    public GameMap() {
        atrium.put("south", "Fire Swamps");
        atrium.put("east", "Breakfast Nook");
        atrium.put("item", "fighting skills");


        breakfastNook.put("east", "Menagerie");
        breakfastNook.put("west", "Atrium");
        breakfastNook.put("challenge", "Gold Beetles");
        breakfastNook.put("solution", "fighting skills");
        breakfastNook.put("solved", "false");
        breakfastNook.put("url", "https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ForestDay_6095_24.wav");

        menagerie.put("west", "Breakfast Nook");
        menagerie.put("south", "Dining Room");
        menagerie.put("secret", "Observatory");
        menagerie.put("item", "Rope");

        conservatory.put("south", "Arcade");
        conservatory.put("east", "Panic Room");
        conservatory.put("challenge", "Quick Sand");
        conservatory.put("solution", "Rope");
        conservatory.put("solved", "false");

        panicRoom.put("west", "Conservatory");
        panicRoom.put("south", "Observatory");
        panicRoom.put("item", "key");
        panicRoom.put("challenge", "ghost");
        panicRoom.put("solution", "Book of Spells");
        panicRoom.put("solved", "false");

        fireSwamps.put("north", "Atrium");
        fireSwamps.put("east", "Hall");
        fireSwamps.put("challenge", "Rodents of Unusual Size (ROUS)");
        fireSwamps.put("solution", "fighting skills");
        fireSwamps.put("solved", "false");

        hall.put("east", "Dining Room");
        hall.put("west", "Fire Swamps");
        hall.put("item", "Super Soaker");

        diningRoom.put("west", "Hall");
        diningRoom.put("east", "Arcade");
        diningRoom.put("north", "Menagerie");
        diningRoom.put("item", "Game Boy");

        arcade.put("west", "Dining Room");
        arcade.put("east", "Observatory");
        arcade.put("north", "Conservatory");
        arcade.put("south", "Library");
        arcade.put("challenge", "fire");
        arcade.put("solution", "Super Soaker");
        arcade.put("solved", "false");

        observatory.put("north", "Panic Room");
        observatory.put("west", "Arcade");
        observatory.put("item", "potion");
        observatory.put("secret", "Menagerie");

        courtyard.put("west", "Library");
        courtyard.put("item", "sword");
        courtyard.put("solution", "key");
        courtyard.put("challenge", "lock");
        courtyard.put("solved", "false");

        library.put("east", "Courtyard");
        library.put("west", "Garden");
        library.put("north", "Arcade");
        library.put("item", "Book of Spells");

        garden.put("east", "Library");
        garden.put("west", "Laboratory");
        garden.put("item", "True Love");

        laboratory.put("east", "Garden");
        laboratory.put("west", "Kitchen");
        laboratory.put("item", "Flux Capacitor");

        kitchen.put("east", "Laboratory");
        kitchen.put("challenge", "monster");
        kitchen.put("solution", "sword");
        kitchen.put("solved", "false");

        rooms.put("Atrium", atrium);
        rooms.put("Breakfast Nook", breakfastNook);
        rooms.put("Menagerie", menagerie);
        rooms.put("Conservatory", conservatory);
        rooms.put("Panic Room", panicRoom);

        rooms.put("Fire Swamps", fireSwamps);
        rooms.put("Hall", hall);
        rooms.put("Dining Room", diningRoom);
        rooms.put("Arcade", arcade);
        rooms.put("Observatory", observatory);

        rooms.put("Courtyard", courtyard);
        rooms.put("Library", library);
        rooms.put("Garden", garden);
        rooms.put("Laboratory", laboratory);
        rooms.put("Kitchen", kitchen);
    }

    public HashMap<String, HashMap<String, String>> getRooms() {
        return rooms;
    }
}
