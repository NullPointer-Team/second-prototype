package coregamefiles;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GameMapTest {
    private GameMap gameMap;
    private HashMap<String, HashMap<String, String>> rooms;
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


    @Before
    public void setUp() {
        gameMap = new GameMap();
        rooms = gameMap.getRooms();

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
    }

    @Test
    public void testBreakfastNook() {
        nook = rooms.get("Breakfast Nook");
        assertTrue(nook.get("east").equals("Menagerie"));
        assertTrue(nook.get("west").equals("Atrium"));
    }

}