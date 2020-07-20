package coregamefiles;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameRules gameRules = new GameRules();

    @Test
    void printRules() {
        System.setOut(new PrintStream(outContent));
        gameRules.printRules();
        String expectedOutput =  "To navigate from room to room, type these commands:\n" +
                "    \"go north\"\n" +
                "    \"go south\"\n" +
                "    \"go east\"\n" +
                "    \"go west\"\n" +
                "To retrieve items in a room, type 'get' followed by the name of the item, such as:\n" +
                "    \"get wand\"\n" +
                "       - or -   \n" +
                "    \"get coin\"\n" +
                "       - or -   \n" +
                "    \"get 'insert name of some item in the room'\"\n" +
                "To quit the game, type \"quit\"\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}