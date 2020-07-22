package coregamefiles;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameMap {

    // MAP
    private Map<String, HashMap<String, String>> rooms;

    private HashMap<String, String> atrium;
    private HashMap<String, String> breakfastNook;
    private HashMap<String, String> menagerie;
    private HashMap<String, String> conservatory;
    private HashMap<String, String> panicRoom;

    private HashMap<String, String> fireSwamps;
    private HashMap<String, String> hall;
    private HashMap<String, String> diningRoom;
    private HashMap<String, String> arcade;
    private HashMap<String, String> observatory;

    private HashMap<String, String> courtyard;
    private HashMap<String, String> library;
    private HashMap<String, String> garden;
    private HashMap<String, String> laboratory;
    private HashMap<String, String> kitchen;


    //provide info for map
    public GameMap() {
        HashMap<String, HashMap<String, String>> temporaryMap = new HashMap<>();
        instantiateIndividualRooms();

        temporaryMap.put("Atrium", atrium);
        temporaryMap.put("Breakfast Nook", breakfastNook);
        temporaryMap.put("Menagerie", menagerie);
        temporaryMap.put("Conservatory", conservatory);
        temporaryMap.put("Panic Room", panicRoom);

        temporaryMap.put("Fire Swamps", fireSwamps);
        temporaryMap.put("Hall", hall);
        temporaryMap.put("Dining Room", diningRoom);
        temporaryMap.put("Arcade", arcade);
        temporaryMap.put("Observatory", observatory);

        temporaryMap.put("Courtyard", courtyard);
        temporaryMap.put("Library", library);
        temporaryMap.put("Garden", garden);
        temporaryMap.put("Laboratory", laboratory);
        temporaryMap.put("Kitchen", kitchen);

        rooms = Collections.unmodifiableMap(temporaryMap);
    }


    private void instantiateIndividualRooms() {
        atrium = new HashMap<String, String>();
        breakfastNook = new HashMap<String, String>();
        menagerie = new HashMap<String, String>();
        conservatory = new HashMap<String, String>();
        panicRoom = new HashMap<String, String>();

        fireSwamps = new HashMap<String, String>();
        hall = new HashMap<String, String>();
        diningRoom = new HashMap<String, String>();
        arcade = new HashMap<String, String>();
        observatory = new HashMap<String, String>();

        courtyard = new HashMap<String, String>();
        library = new HashMap<String, String>();
        garden = new HashMap<String, String>();
        laboratory = new HashMap<String, String>();
        kitchen = new HashMap<String, String>();


        atrium.put("south", "Fire Swamps");
        atrium.put("east", "Breakfast Nook");
        atrium.put("item", "fighting skills");

        breakfastNook.put("east", "Menagerie");
        breakfastNook.put("west", "Atrium");
        breakfastNook.put("challenge", "Gold Beetles");
        breakfastNook.put("solution", "fighting skills");
        breakfastNook.put("hint", "HINT: It would help if you knew how to fight...");
        breakfastNook.put("praise", "You really stuck it to that beetle! So glad it didn't burrow into your brain!\n" +
                "Congrats on not dying!");
        breakfastNook.put("solved", "false");
        breakfastNook.put("url", "https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ForestDay_6095_24.wav");

        menagerie.put("west", "Breakfast Nook");
        menagerie.put("south", "Dining Room");
        menagerie.put("secret", "Observatory");
        menagerie.put("item", "Rope");

        conservatory.put("south", "Arcade");
        conservatory.put("east", "Panic Room");
        conservatory.put("challenge", "Quick Sand");
        conservatory.put("hint", "HINT: How would Indiana Jones get out this one? Maybe you don't have a whip, but...");
        conservatory.put("solution", "Rope");
        conservatory.put("solved", "false");

        panicRoom.put("west", "Conservatory");
        panicRoom.put("south", "Observatory");
        panicRoom.put("item", "key");
        panicRoom.put("challenge", "ghost");
        panicRoom.put("hint", "HINT: Who you gonna call? You can't fight the metaphysical with physical objects, can you?");
        panicRoom.put("praise", "Nice Work! Who needs the Ghostbusters when wise wizards like you roam these halls?");
        panicRoom.put("solution", "Book of Spells");
        panicRoom.put("solved", "false");

        fireSwamps.put("north", "Atrium");
        fireSwamps.put("east", "Hall");
        fireSwamps.put("challenge", "Rodents of Unusual Size (ROUS)");
        fireSwamps.put("solution", "fighting skills");
        fireSwamps.put("hint", "HINT: Care for a bout of fisticuffs?");
        fireSwamps.put("praise", "Excellent fighting! You were a regular Dread Pirate Roberts with that rat!");
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
        arcade.put("hint", "HINT: Are you gonna fight fire with weapons? What puts out fire?");
        arcade.put("praise", "My hero! You put out the fire. Somebody call 9-1-1, cuz you looked HOT shooting that 80's" +
                "\nplastic water gun at that fire... lol.\nCongrats, you get to live for now.");
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
        courtyard.put("hint", "HINT: Do I have to say this? What opens locks?");
        courtyard.put("praise", "Do you even deserve praise for knowing how to use a key? Nice work, dingus.");
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
        kitchen.put("hint", "HINT: Would a knight fight a dragon with a super soaker? Or would he use a...");
        kitchen.put("praise", "Where did you even learn to wield a sword like that? Excellent work!!!\n" +
                "You live to see another day, and what is more, you are free to return to reality.\n" +
                "But will you even want to? They don't let you sleigh monsters with swords in reality.");
        kitchen.put("solution", "sword");
        kitchen.put("solved", "false");

    }


    public Map<String, HashMap<String, String>> getRooms() {
        return rooms;
    }
}
