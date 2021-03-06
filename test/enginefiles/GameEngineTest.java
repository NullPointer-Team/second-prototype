package enginefiles;

import org.junit.jupiter.api.Test;

import static coregamefiles.GameTextColors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class GameEngineTest {

    private GameEngine gameEngine = new GameEngine();
    private String commands;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream testOut;
    private PrintStream originalOut;

    @Test
    public void testMoveToRoom_Failure() throws Exception {
        String north = "north";
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Menagerie");
        gameEngine.moveToRoom(north);
        String expectedOutput = "You can\'t go that way!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMoveToRoom_Success() {
        String east = "east";
        String west = "west";
        String south = "south";
        String north = "north";
        String secret = "secret";

        String atrium = "Atrium";
        String observatory = "Observatory";
        String nook = "Breakfast Nook";
        String hall = "Hall";
        String fireSwamps = "Fire Swamps";
        String diningRoom = "Dining Room";
        String menagerie = "Menagerie";


        gameEngine.setCurrentRoom(atrium);
        gameEngine.moveToRoom(east);
        assertEquals(gameEngine.getCurrentRoom(), nook);

        gameEngine.setCurrentRoom(atrium);
        gameEngine.moveToRoom(south);
        assertEquals(gameEngine.getCurrentRoom(), fireSwamps);

        gameEngine.setCurrentRoom(menagerie);
        gameEngine.moveToRoom(south);
        assertEquals(gameEngine.getCurrentRoom(), diningRoom);
        gameEngine.moveToRoom(north);
        assertEquals(gameEngine.getCurrentRoom(), menagerie);

        gameEngine.setCurrentRoom(menagerie);
        gameEngine.moveToRoom(secret);
        assertEquals(gameEngine.getCurrentRoom(), observatory);
        gameEngine.moveToRoom(secret);
        assertEquals(gameEngine.getCurrentRoom(), menagerie);

        gameEngine.setCurrentRoom(hall);
        gameEngine.moveToRoom(east);
        assertEquals(gameEngine.getCurrentRoom(), diningRoom);
        gameEngine.moveToRoom(west);
        assertEquals(gameEngine.getCurrentRoom(), hall);
    }

    @Test
    void testAcquireItem_Failure() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.acquireItem("potion");
        String expectedOutput = "A potion is not available in this room!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testAcquireItem_Success() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Hall");
        gameEngine.acquireItem("Super Soaker");
        String expectedOutput = "Super Soaker acquired!!\n";
        ArrayList<String> updatedInventory = gameEngine.getInventory();
        assertEquals(expectedOutput, outContent.toString());
        assertTrue(updatedInventory.contains("Super Soaker"));
        assertFalse(gameEngine.getCurrentRoom().contains("Super Soaker"));
    }

    @Test
    void testValidateAndExecuteUserCommand_InvalidInput() {
        String[] invalidMove = {"bad", "input"};
        System.setOut(new PrintStream(outContent));
        gameEngine.validateAndExecuteUserCommand(invalidMove);
        String expectedOutput = "I did not understand. Please re-enter your command.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateAndExecuteUserCommand_Go() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Library");
        String[] valid_moveToNewRoom = {"go", "west"};
        gameEngine.validateAndExecuteUserCommand(valid_moveToNewRoom);
        String expectedRoom = "Garden";
        assertEquals(gameEngine.getCurrentRoom(), expectedRoom);
    }

    @Test
    void testValidateAndExecuteUserCommand_Get() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Library");
        String[] valid_getNewItem = {"get", "Book of Spells"};
        gameEngine.validateAndExecuteUserCommand(valid_getNewItem);
        String expectedOutput = "Book of Spells acquired!!\n";
        ArrayList<String> updatedInventory = gameEngine.getInventory();
        assertTrue(updatedInventory.contains("Book of Spells"));
        assertEquals(expectedOutput, outContent.toString());
        assertFalse(gameEngine.getCurrentRoom().contains("Book of Spells"));
    }

    @Test
    void testValidateAndExecuteUserCommand_SecretSuccess() {
        System.setOut(new PrintStream(outContent));
        String observatory = "Observatory";
        String menagerie = "Menagerie";
        gameEngine.setCurrentRoom("Menagerie");
        String[] valid_secret = {"secret"};
        String expectedOutput = "Good job!! You successfully used the Secret Passage. Don\'t tell anyone else about it.\n";

        gameEngine.validateAndExecuteUserCommand(valid_secret);
        assertEquals(gameEngine.getCurrentRoom(), observatory);
        assertEquals(expectedOutput, outContent.toString());

        gameEngine.validateAndExecuteUserCommand(valid_secret);
        assertEquals(gameEngine.getCurrentRoom(), menagerie);
    }

    @Test
    void testValidateAndExecuteUserCommand_SecretUnavailable() {
        System.setOut(new PrintStream(outContent));
        String library = "Library";
        String[] invalidSecretCommand = {"secret"};
        gameEngine.setCurrentRoom(library);

        gameEngine.validateAndExecuteUserCommand(invalidSecretCommand);
        String expectedOutput = "There is no Secret Passageway in this Room. Keep Exploring!!\n";
        assertEquals(expectedOutput, outContent.toString());
        assertEquals(gameEngine.getCurrentRoom(), library);
    }

    @Test
    void testValidateAndExecuteUserCommand_Rules() {
        System.setOut(new PrintStream(outContent));
        String[] rules = {"rules"};
        gameEngine.validateAndExecuteUserCommand(rules);
        String expectedOutput = getAnsiYellow() + "__________________________________________________________________________________\n" +
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
                "       - or -   \n" +
                "    \"get coin\"\n" +
                "       - or -   \n" +
                "    \"get 'insert name of some item in the room'\"\n" +
                "To use an item in your inventory, type 'use' followed by the name of the item, such as:\n" +
                "    \"use potion\"\n" +
                "       - or -   \n" +
                "    \"use sword\"\n" +
                "To see the Maze Map, type \"map\"\n" +
                "To quit the game, type \"quit\"\n" +
                getAnsiYellow() +
                "__________________________________________________________________________________\n\n" +
                "HINT: Grab all the resources you can. You will need them on your journey as challenges come your way.\n" +
                "Happy exploring, Strange Adventurer. Good luck in your quest to return to reality!\n" +
                "__________________________________________________________________________________\n\n"
                + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShowStatus_ChallengeInRoom() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.showStatus();
        String expectedOutput = " -------------------- \n" +
                "You are in the Panic Room\n" +
                getAnsiRed() +
                "_________________________________________\n" +
                "                                         \n" +
                " █████  ██      ███████ ██████  ████████ \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "███████ ██      █████   ██████     ██    \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "██   ██ ███████ ███████ ██   ██    ██    \n" +
                "_________________________________________\n" +
                getAnsiReset() + "\n" + getAnsiRed() +
                "Oh no!! The Panic Room has a ghost.\n" +
                "And you don't have anything in your inventory to fight it with." + getAnsiReset() + "\n" +
                "You have " + getAnsiUnderscore() + getAnsiBold() + "nothing" + getAnsiReset() + " in your inventory\n" +
                "For game rules, type \"rules\"\n" +
                " -------------------- \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testShowInventory() {
        System.setOut(new PrintStream(outContent));
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Gold Beetle");
        inventory.add("sword");
        inventory.add("amulet");
        gameEngine.setInventory(inventory);
        gameEngine.showInventory();
        String expectedOutput = "In your inventory, you have:     \n" +
                "      - a Gold Beetle\n" +
                "      - a sword\n" +
                        "      - a amulet\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    void testListChallengeIfAny_Positive() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Conservatory");
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Gold Beetle");
        gameEngine.setInventory(inventory);

        gameEngine.listChallengeIfAny();
        String expectedOutput = getAnsiRed() +
                "_________________________________________\n" +
                "                                         \n" +
                " █████  ██      ███████ ██████  ████████ \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "███████ ██      █████   ██████     ██    \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "██   ██ ███████ ███████ ██   ██    ██    \n" +
                "_________________________________________\n" +
                getAnsiReset() + "\n" + getAnsiRed() + "Oh no!! The Conservatory has a Quick Sand.\n" +
              "You must defeat this challenge before you can continue your journey!" + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testListChallengeIfAny_Negative() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Breakfast Nook");

        gameEngine.listChallengeIfAny();
        String expectedOutput = getAnsiRed() +
                "_________________________________________\n" +
                "                                         \n" +
                " █████  ██      ███████ ██████  ████████ \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "███████ ██      █████   ██████     ██    \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "██   ██ ███████ ███████ ██   ██    ██    \n" +
                "_________________________________________\n" +
                getAnsiReset() + "\n" + getAnsiRed() + "Oh no!! The Breakfast Nook has a Gold Beetles.\n" +
                "And you don't have anything in your inventory to fight it with." + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSolveChallengeAttempt_Success() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Fire Swamps");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());

        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("fighting skills");
        gameEngine.setInventory(inventory);

        String correctItemForChallenge = "fighting skills";
        gameEngine.processChallengeAttempt(correctItemForChallenge);

        assertFalse(gameEngine.roomHasUnsolvedChallenge());
        assertEquals(gameEngine.getGuesses(), 3);
        assertEquals(gameEngine.getRooms().get("Fire Swamps").get("solved"), "true");
    }

    @Test
    void testSolveChallengeAttempt_Failure() {

        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Courtyard");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());

        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("sword");
        gameEngine.setInventory(inventory);

        String wrongItemForChallenge = "sword";
        gameEngine.processChallengeAttempt(wrongItemForChallenge);

        String expectedOutput = "Using the sword has no effect!\nYou have 2 guesses left. Try again!\n" +
                getAnsiBlue() +
                "Need a hint? try typing: \"hint\"" +
                getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());

        assertEquals(gameEngine.getGuesses(), 2);
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
    }

    @Test
    void testRoomHasUnsolvedChallenge_Positive() {
        gameEngine.setCurrentRoom("Panic Room");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Conservatory");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Arcade");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Courtyard");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Kitchen");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());
    }

    @Test
    void testRoomHasUnsolvedChallenge_Negative() {
        gameEngine.setCurrentRoom("Menagerie");
        assertFalse(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Observatory");
        assertFalse(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Library");
        assertFalse(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Garden");
        assertFalse(gameEngine.roomHasUnsolvedChallenge());
        gameEngine.setCurrentRoom("Laboratory");
        assertFalse(gameEngine.roomHasUnsolvedChallenge());
    }


    @Test
    void testValidateUseItem_NotInventory() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Menagerie");
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Sparkling Personality");
        gameEngine.setInventory(inventory);

        String itemNotInventory = "bazooka";
        gameEngine.printCantUseItem(itemNotInventory);
        String expectedOutput = "You don\'t have that item in your inventory!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUseItem_WrongRoom() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Laboratory");
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Winning Personality");
        gameEngine.setInventory(inventory);

        String itemInInventory = "Winning Personality";
        gameEngine.printCantUseItem(itemInInventory);
        String expectedOutput = "There is nothing to use your Winning Personality on. Continue to explore the maze.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_Go() {
        System.setOut(new PrintStream(outContent));
        String[] go = {"go"};
        gameEngine.validateUserChallengeSolution(go);
        String expectedOutput = "You can't leave the room until you solve the challenge!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_UseCorrectItem() {
        System.setOut(new PrintStream(outContent));
        String[] useCorrectItem = {"use", "fighting skills"};
        gameEngine.setCurrentRoom("Breakfast Nook");

        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("fighting skills");
        gameEngine.setInventory(inventory);

        gameEngine.validateUserChallengeSolution(useCorrectItem);
        String expectedOutput = getAnsiGreen() +
                "_____________________________________________________________\n" +
                "                                                             \n" +
                " ██████  ██████  ███████  █████  ████████                    \n" +
                "██       ██   ██ ██      ██   ██    ██                       \n" +
                "██   ███ ██████  █████   ███████    ██                       \n" +
                "██    ██ ██   ██ ██      ██   ██    ██                       \n" +
                " ██████  ██   ██ ███████ ██   ██    ██                       \n" +
                "                                                             \n" +
                "███████ ██    ██  ██████  ██████ ███████ ███████ ███████     \n" +
                "██      ██    ██ ██      ██      ██      ██      ██          \n" +
                "███████ ██    ██ ██      ██      █████   ███████ ███████     \n" +
                "     ██ ██    ██ ██      ██      ██           ██      ██     \n" +
                "███████  ██████   ██████  ██████ ███████ ███████ ███████     \n" +
                "                                                             \n" +
                "_____________________________________________________________\n" +
                getAnsiReset() + "\n" +
                getAnsiYellow() + getAnsiBold() +
                "You really stuck it to that beetle! So glad it didn't burrow into your brain!\n" +
                "Congrats on not dying!" + getAnsiReset() + "\nYou solved the challenge! Continue on your quest\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_UseInCorrectItemNotInInventory() {
        System.setOut(new PrintStream(outContent));
        String[] useWrongItem = {"use", "PowerPoint Skills"};
        gameEngine.setCurrentRoom("Breakfast Nook");

        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("sword");
        gameEngine.setInventory(inventory);

        gameEngine.validateUserChallengeSolution(useWrongItem);
        String expectedOutput = "You don\'t even have PowerPoint Skills in your inventory to use!\n" +
                "You have 2 guesses left. Try again!\n" +
                getAnsiBlue() +
                "Need a hint? try typing: \"hint\"" +
                getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_UseInCorrectItemNoEffect() {
        System.setOut(new PrintStream(outContent));
        String[] useWrongItem = {"use", "Perfect Attendance Record"};
        gameEngine.setCurrentRoom("Breakfast Nook");
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Perfect Attendance Record");
        gameEngine.setInventory(inventory);

        gameEngine.validateUserChallengeSolution(useWrongItem);
        String expectedOutput = "Using the Perfect Attendance Record has no effect!\n" +
                "You have 2 guesses left. Try again!\n" +
                getAnsiBlue() +
                "Need a hint? try typing: \"hint\"" +
                getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_Get() {
        System.setOut(new PrintStream(outContent));
        String[] get = {"get"};
        gameEngine.validateUserChallengeSolution(get);
        String expectedOutput = "You can't acquire new items until you solve the challenge!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_DoNotUnderstand() {
        System.setOut(new PrintStream(outContent));
        String[] get = {"Snickers"};
        gameEngine.validateUserChallengeSolution(get);
        String expectedOutput = "I did not understand. Please re-enter your command.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateUserChallengeSolution_Rules() {
        System.setOut(new PrintStream(outContent));
        String[] rules = {"rules"};
        gameEngine.validateUserChallengeSolution(rules);
        String expectedOutput = getAnsiYellow() + "__________________________________________________________________________________\n" +
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
                "       - or -   \n" +
                "    \"get coin\"\n" +
                "       - or -   \n" +
                "    \"get 'insert name of some item in the room'\"\n" +
                "To use an item in your inventory, type 'use' followed by the name of the item, such as:\n" +
                "    \"use potion\"\n" +
                "       - or -   \n" +
                "    \"use sword\"\n" +
                "To see the Maze Map, type \"map\"\n" +
                "To quit the game, type \"quit\"\n" +
                getAnsiYellow() +
                "__________________________________________________________________________________\n\n" +
                "HINT: Grab all the resources you can. You will need them on your journey as challenges come your way.\n" +
                "Happy exploring, Strange Adventurer. Good luck in your quest to return to reality!\n" +
                "__________________________________________________________________________________\n\n"
                + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}