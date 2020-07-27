package coregamefiles;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static coregamefiles.GameTextColors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class DisplayMapTest {

    private DisplayMap display;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    List<String> visitedRooms;
    List<String> expectedRoomArray;
    private final List<String> formattedRoomList = new ArrayList<String>(Arrays.asList(
            "    Panic Room    ",
            "      Atrium      ",
            "  Breakfast Nook  ",
            "     Menagerie    ",
            "   Conservatory   ",

            "    Observatory   ",
            "    Fire Swamps   ",
            "       Hall       ",
            "    Dining Room   ",
            "      Arcade      ",

            "     Courtyard    ",
            "      Kitchen     ",
            "    Laboratory    ",
            "      Garden      ",
            "      Library     "));

    @Test
    void testFilterRoomsByVisited_AllRooms() {
        display = new DisplayMap();

        visitedRooms = new ArrayList<String>();
        visitedRooms.add("Panic Room");
        visitedRooms.add("Atrium");
        visitedRooms.add("Breakfast Nook");
        visitedRooms.add("Menagerie");
        visitedRooms.add("Conservatory");

        visitedRooms.add("Observatory");
        visitedRooms.add("Fire Swamps");
        visitedRooms.add("Hall");
        visitedRooms.add("Dining Room");
        visitedRooms.add("Arcade");

        visitedRooms.add("Courtyard");
        visitedRooms.add("Kitchen");
        visitedRooms.add("Laboratory");
        visitedRooms.add("Garden");
        visitedRooms.add("Library");


        List<String> expectedRoomArray = new ArrayList<String>();
        expectedRoomArray.add("    Panic Room    ");
        expectedRoomArray.add("      Atrium      ");
        expectedRoomArray.add("  Breakfast Nook  ");
        expectedRoomArray.add("     Menagerie    ");
        expectedRoomArray.add("   Conservatory   ");

        expectedRoomArray.add("    Observatory   ");
        expectedRoomArray.add("    Fire Swamps   ");
        expectedRoomArray.add("       Hall       ");
        expectedRoomArray.add("    Dining Room   ");
        expectedRoomArray.add("      Arcade      ");

        expectedRoomArray.add("     Courtyard    ");
        expectedRoomArray.add("      Kitchen     ");
        expectedRoomArray.add("    Laboratory    ");
        expectedRoomArray.add("      Garden      ");
        expectedRoomArray.add("      Library     ");

        String[] formattedExpectedArray = expectedRoomArray.toArray(new String[0]);
        String[] modifiedArray = display.filterRoomArraybyVisited(visitedRooms);
        assertArrayEquals(modifiedArray, formattedExpectedArray);
    }

    @Test
    void testFilterRoomsByVisited_ZeroRooms() {
        display = new DisplayMap();

        visitedRooms = new ArrayList<String>();

        List<String> expectedRoomArray = new ArrayList<String>();
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");

        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");

        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");

        String[] formattedExpectedArray = expectedRoomArray.toArray(new String[0]);
        String[] modifiedArray = display.filterRoomArraybyVisited(visitedRooms);
        assertArrayEquals(modifiedArray, formattedExpectedArray);
    }

    @Test
    void testFilterRoomsByVisited_SomeRooms() {
        display = new DisplayMap();

        visitedRooms = new ArrayList<String>();
        visitedRooms.add("Panic Room");
        visitedRooms.add("Kitchen");
        visitedRooms.add("Arcade");
        visitedRooms.add("Observatory");
        visitedRooms.add("Laboratory");
        visitedRooms.add("Breakfast Nook");
        visitedRooms.add("Garden");
        visitedRooms.add("Conservatory");
        visitedRooms.add("Fire Swamps");


        List<String> expectedRoomArray = new ArrayList<String>();
        expectedRoomArray.add("    Panic Room    ");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("  Breakfast Nook  ");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("   Conservatory   ");

        expectedRoomArray.add("    Observatory   ");
        expectedRoomArray.add("    Fire Swamps   ");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("hidden");
        expectedRoomArray.add("      Arcade      ");

        expectedRoomArray.add("hidden");
        expectedRoomArray.add("      Kitchen     ");
        expectedRoomArray.add("    Laboratory    ");
        expectedRoomArray.add("      Garden      ");
        expectedRoomArray.add("hidden");

        String[] formattedExpectedArray = expectedRoomArray.toArray(new String[0]);
        String[] modifiedArray = display.filterRoomArraybyVisited(visitedRooms);
        assertArrayEquals(modifiedArray, formattedExpectedArray);
    }

    @Test
    void testPrintMap_AllRoomsVisible() {
        display = new DisplayMap();

        visitedRooms = new ArrayList<String>();
        visitedRooms.add("Panic Room");
        visitedRooms.add("Atrium");
        visitedRooms.add("Breakfast Nook");
        visitedRooms.add("Menagerie");
        visitedRooms.add("Conservatory");

        visitedRooms.add("Observatory");
        visitedRooms.add("Fire Swamps");
        visitedRooms.add("Hall");
        visitedRooms.add("Dining Room");
        visitedRooms.add("Arcade");

        visitedRooms.add("Courtyard");
        visitedRooms.add("Kitchen");
        visitedRooms.add("Laboratory");
        visitedRooms.add("Garden");
        visitedRooms.add("Library");

        System.setOut(new PrintStream(outContent));
        display.printMap(visitedRooms);
        String expectedOutput= getAnsiYellow() + "\n" +

                /*
                "\n" +
                "                    ███    ███  █████  ███████ ███████     ███    ███  █████  ██████  \n" +
                "                    ████  ████ ██   ██    ███  ██          ████  ████ ██   ██ ██   ██ \n" +
                "                    ██ ████ ██ ███████   ███   █████       ██ ████ ██ ███████ ██████  \n" +
                "                    ██  ██  ██ ██   ██  ███    ██          ██  ██  ██ ██   ██ ██      \n" +
                "                    ██      ██ ██   ██ ███████ ███████     ██      ██ ██   ██ ██      \n" +
                */
                "  |------------------|------------------|------------------|------------------|------------------|\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |      Atrium      |  Breakfast Nook  |     Menagerie    |   Conservatory   |    Panic Room    |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |------------------|------------------|------------------|------------------|------------------|\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |    Fire Swamps   |       Hall       |    Dining Room   |      Arcade      |    Observatory   |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |------------------|------------------|------------------|------------------|------------------|\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |      Kitchen     |    Laboratory    |      Garden      |      Library     |     Courtyard    |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |                  |                  |                  |                  |                  |\n" +
                "  |------------------|------------------|------------------|------------------|------------------|" +
                getAnsiReset() +"\n";

        assertEquals(expectedOutput, outContent.toString());
    }

}