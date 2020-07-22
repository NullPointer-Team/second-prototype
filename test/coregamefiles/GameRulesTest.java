package coregamefiles;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static coregamefiles.GameTextColors.*;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameRules gameRules = new GameRules();

    @Test
    void testPrintRules() {
        System.setOut(new PrintStream(outContent));
        gameRules.printRules();
        String expectedOutput =  getAnsiYellow() + "__________________________________________________________________________________\n" +
                "         _         \n" +
                " ___ _ _| |___ ___ \n" +
                "|  _| | | | -_|_ -|\n" +
                "|_| |___|_|___|___|\n" +
                "__________________________________________________________________________________\n" +
                getAnsiReset() +
                "To navigate from room to room, type these commands:\n" +
                "    \"go north\"\n" +
                "    \"go south\"\n" +
                "    \"go east\"\n" +
                "    \"go west\"\n" +
                "To retrieve items in a room, type 'get' followed by the name of the item, such as:\n" +
                "    \"get wand\"\n" +
                "      - or -    \n" +
                "    \"get coin\"\n" +
                "      - or -    \n" +
                "    \"get 'insert name of some item in the room'\"\n" +
                "To use an item in your inventory, type 'use' followed by the name of the item, such as:\n" +
                "    \"use potion\"\n" +
                "      - or -      \n" +
                "    \"use sword\" \n" +
                "To quit the game, type \"quit\"\n" +
                getAnsiYellow() +
                "__________________________________________________________________________________\n\n" +
                "Grab all the resources you can. You will need them on your journey as challenges come your way.\n" +
                "Happy exploring, Strange Adventurer. Good luck in your quest to return to reality!\n" +
                "__________________________________________________________________________________\n\n"
                + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}