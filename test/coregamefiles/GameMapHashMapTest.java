package coregamefiles;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameMapHashMapTest {
    private GameMapHashMap gameMapHashMap;
    private Map<String, HashMap<String, String>> rooms;
    private Set<String> allRooms;

    private HashMap<String, String> atrium;
    private HashMap<String, String> nook;
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

    private HashMap<String, String> foyer;

    @Before
    public void setUp() {
        gameMapHashMap = new GameMapHashMap();
        rooms = gameMapHashMap.getRooms();

        atrium = rooms.get("Atrium");
        nook = rooms.get("Breakfast Nook");
        menagerie = rooms.get("Menagerie");
        conservatory = rooms.get("Conservatory");
        panicRoom = rooms.get("Panic Room");

        fireSwamps = rooms.get("Fire Swamps");
        hall = rooms.get("Hall");
        diningRoom = rooms.get("Dining Room");
        arcade = rooms.get("Arcade");
        observatory = rooms.get("Observatory");

        courtyard = rooms.get("Courtyard");
        library = rooms.get("Library");
        garden = rooms.get("Garden");
        laboratory = rooms.get("Laboratory");
        kitchen = rooms.get("Kitchen");

        foyer = new HashMap<String, String>();
        foyer.put("challenge", "Post-Modernism");
        foyer.put("north", "Kitchen");
        foyer.put("item", "sense of one\'s own mortality");
    }

    @Test
    public void failToAddRoom_NumberOfRoomsUnchanged() {
        try {
            rooms.put("foyer", foyer);
            fail("Should have thrown Unsupported Operation Exception");
        } catch (UnsupportedOperationException exception) {
            allRooms = rooms.keySet();
            assertEquals(allRooms.size(), 15);
            assertTrue(exception.toString().equals(UnsupportedOperationException.class.getName()));
        }
    }

    @Test
    public void testRooms(){
        allRooms = rooms.keySet();
        assertEquals(allRooms.size(), 15);
        
        assertTrue(allRooms.contains("Atrium"));
        assertTrue(allRooms.contains("Breakfast Nook"));
        assertTrue(allRooms.contains("Menagerie"));
        assertTrue(allRooms.contains("Conservatory"));
        assertTrue(allRooms.contains("Panic Room"));

        assertTrue(allRooms.contains("Fire Swamps"));
        assertTrue(allRooms.contains("Hall"));
        assertTrue(allRooms.contains("Dining Room"));
        assertTrue(allRooms.contains("Arcade"));
        assertTrue(allRooms.contains("Observatory"));

        assertTrue(allRooms.contains("Courtyard"));
        assertTrue(allRooms.contains("Library"));
        assertTrue(allRooms.contains("Garden"));
        assertTrue(allRooms.contains("Laboratory"));
        assertTrue(allRooms.contains("Kitchen"));
    }

    @Test
    public void testAtrium() {
        atrium = rooms.get("Atrium");
        assertTrue(atrium.get("east").equals("Breakfast Nook"));
        assertTrue(atrium.get("south").equals("Fire Swamps"));
        assertTrue(atrium.get("item").equals("fighting skills"));
    }

    @Test
    public void testBreakfastNook() {
        nook = rooms.get("Breakfast Nook");
        assertTrue(nook.get("east").equals("Menagerie"));
        assertTrue(nook.get("west").equals("Atrium"));
        assertTrue(nook.get("challenge").equals("Gold Beetles"));
        assertTrue(nook.get("solution").equals("fighting skills"));
        assertTrue(nook.get("solved").equals("false"));
    }

    @Test
    public void testMenagerie() {
        menagerie = rooms.get("Menagerie");
        assertTrue(menagerie.get("west").equals("Breakfast Nook"));
        assertTrue(menagerie.get("south").equals("Dining Room"));
        assertTrue(menagerie.get("secret").equals("Observatory"));
        assertTrue(menagerie.get("item").equals("Rope"));
    }

    @Test
    public void testConservatory() {
        conservatory = rooms.get("Conservatory");
        assertTrue(conservatory.get("east").equals("Panic Room"));
        assertTrue(conservatory.get("south").equals("Arcade"));
        assertTrue(conservatory.get("challenge").equals("Quick Sand"));
        assertTrue(conservatory.get("solution").equals("Rope"));
        assertTrue(conservatory.get("solved").equals("false"));
    }

    @Test
    public void testPanicRoom() {
        panicRoom = rooms.get("Panic Room");
        assertTrue(panicRoom.get("west").equals("Conservatory"));
        assertTrue(panicRoom.get("south").equals("Observatory"));
        assertTrue(panicRoom.get("solution").equals("Book of Spells"));
        assertTrue(panicRoom.get("challenge").equals("ghost"));
        assertTrue(panicRoom.get("item").equals("key"));
        assertTrue(panicRoom.get("solved").equals("false"));
        assertTrue(panicRoom.get("url").equals("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_HumanBurp_CTE03_05_7.wav"));
    }

    @Test
    public void testFireSwamp() {
        fireSwamps = rooms.get("Fire Swamps");
        assertTrue(fireSwamps.get("north").equals("Atrium"));
        assertTrue(fireSwamps.get("east").equals("Hall"));
        assertTrue(fireSwamps.get("solution").equals("fighting skills"));
        assertTrue(fireSwamps.get("challenge").equals("Rodents of Unusual Size (ROUS)"));
        assertTrue(fireSwamps.get("solved").equals("false"));
        assertTrue(fireSwamps.get("url").equals("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ExplosionSharp_6048_97_1.wav"));
    }

    @Test
    public void testHall() {
        hall = rooms.get("Hall");
        assertTrue(hall.get("west").equals("Fire Swamps"));
        assertTrue(hall.get("east").equals("Dining Room"));
        assertTrue(hall.get("item").equals("Super Soaker"));
    }

    @Test
    public void testDiningRoom() {
        diningRoom = rooms.get("Dining Room");
        assertTrue(diningRoom.get("north").equals("Menagerie"));
        assertTrue(diningRoom.get("east").equals("Arcade"));
        assertTrue(diningRoom.get("west").equals("Hall"));
        assertTrue(diningRoom.get("item").equals("Game Boy"));
    }

    @Test
    public void testArcade() {
        arcade = rooms.get("Arcade");
        assertTrue(arcade.get("north").equals("Conservatory"));
        assertTrue(arcade.get("south").equals("Library"));
        assertTrue(arcade.get("east").equals("Observatory"));
        assertTrue(arcade.get("west").equals("Dining Room"));
        assertTrue(arcade.get("challenge").equals("fire"));
        assertTrue(arcade.get("solution").equals("Super Soaker"));
        assertTrue(arcade.get("solved").equals("false"));
    }

    @Test
    public void testObservatory() {
        observatory = rooms.get("Observatory");
        assertTrue(observatory.get("north").equals("Panic Room"));
        assertTrue(observatory.get("west").equals("Arcade"));
        assertTrue(observatory.get("item").equals("potion"));
        assertTrue(observatory.get("secret").equals("Menagerie"));
    }

    @Test
    public void testCourtyard() {
        courtyard = rooms.get("Courtyard");
        assertTrue(courtyard.get("challenge").equals("lock"));
        assertTrue(courtyard.get("solution").equals("key"));
        assertTrue(courtyard.get("west").equals("Library"));
        assertTrue(courtyard.get("solved").equals("false"));
    }

    @Test
    public void testLibrary() {
        library = rooms.get("Library");
        assertTrue(library.get("east").equals("Courtyard"));
        assertTrue(library.get("west").equals("Garden"));
        assertTrue(library.get("north").equals("Arcade"));
        assertTrue(library.get("item").equals("Book of Spells"));
    }

    @Test
    public void testGarden() {
        garden = rooms.get("Garden");
        assertTrue(garden.get("east").equals("Library"));
        assertTrue(garden.get("west").equals("Laboratory"));
        assertTrue(garden.get("item").equals("True Love"));
        assertTrue(garden.get("url").equals("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_ForestDay_6095_24.wav"));
    }

    @Test
    public void testLaboratory() {
        laboratory = rooms.get("Laboratory");
        assertTrue(laboratory.get("east").equals("Garden"));
        assertTrue(laboratory.get("west").equals("Kitchen"));
        assertTrue(laboratory.get("item").equals("Flux Capacitor"));
    }

    @Test
    public void testKitchen() {
        kitchen = rooms.get("Kitchen");
        assertTrue(kitchen.get("east").equals("Laboratory"));
        assertTrue(kitchen.get("solution").equals("sword"));
        assertTrue(kitchen.get("challenge").equals("monster"));
        assertTrue(kitchen.get("solved").equals("false"));
        assertTrue(kitchen.get("url").equals("https://www.videomaker.com/sites/videomaker.com/files/downloads/free-sound-effects/Free_HumanBurp_CTE03_05_7.wav"));
    }
}