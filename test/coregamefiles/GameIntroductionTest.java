package coregamefiles;

import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GameIntroductionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final GameIntroduction gameIntro = new GameIntroduction();

    @Test
    public void testWelcomeMessage() {
        System.setOut(new PrintStream(outContent));
        gameIntro.welcomeMessage();
        String expectedOutput = "Welcome to Stranger Game, a text-based Java console RPG game.  Please read the rules below:\n" +
                "Although the basic game has a lot of complexity to it, the rules to play it are simple.\n" +
                "You are trapped in a maze in a fantasy world, and in order to return to reality you must complete the game \n" +
                "before the portal closes. Navigate from room to room, collecting useful items and completing challenges \n" +
                "to unlock the portal. Hurry! The portal back to earth won't stay open long!\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testRuleDisplayMessage() {
        System.setOut(new PrintStream(outContent));
        gameIntro.printReadRulesQuestion();
        String expectedOutput = "\nWould you like to hear the rules of the game?\n" +
                "Type Y or Yes to hear the rules.\n" +
                "Type anything else to continue to the game.\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintRules() {
        System.setOut(new PrintStream(outContent));
        gameIntro.printRules();
        String expectedOutput = "__________________________________________________________________________________\n" +
                                "         _         \n" +
                                " ___ _ _| |___ ___ \n" +
                                "|  _| | | | -_|_ -|\n" +
                                "|_| |___|_|___|___|\n" +
                                "__________________________________________________________________________________\n" +
                                "To navigate from room to room, type these commands:\n" +
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
                                "To use an item in your inventory, type 'use' followed by the name of the item, such as:\n" +
                                "    \"use potion\"\n" +
                                "       - or -   \n" +
                                "    \"use sword\"\n" +
                                "To quit the game, type \"quit\"\n" +
                                "__________________________________________________________________________________\n\n" +
                                "Grab all the resources you can. You will need them on your journey as challenges come your way.\n" +
                                "Happy exploring, Strange Adventurer. Good luck in your quest to return to reality!\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}