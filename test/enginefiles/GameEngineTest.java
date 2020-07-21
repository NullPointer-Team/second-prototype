package enginefiles;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    void testAcquireItem_NotAvailable() {
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
        String[] moves = {"bad", "input"};
        System.setOut(new PrintStream(outContent));
        gameEngine.validateAndExecuteUserCommand(moves);
        String expectedOutput = "I did not understand. Please re-enter your command.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testValidateAndExecuteUserCommand_ValidInput() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Library");
        String[] movesNewRoom = {"go", "west"};
        String[] movesGetItem = {"get", "Book of Spells"};
        gameEngine.validateAndExecuteUserCommand(movesGetItem);
        gameEngine.validateAndExecuteUserCommand(movesNewRoom);
        String expectedRoom = "Garden";
        String expectedOutput = "Book of Spells acquired!!\n";
        ArrayList<String> updatedInventory = gameEngine.getInventory();
        assertEquals(gameEngine.getCurrentRoom(), expectedRoom);
        assertTrue(updatedInventory.contains("Book of Spells"));
        assertEquals(expectedOutput, outContent.toString());
        assertFalse(gameEngine.getCurrentRoom().contains("Book of Spells"));
    }


    @Test
    void testShowStatus() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.showStatus();
        String expectedOutput = " -------------------- \n" +
                "You are in the Panic Room\n" +
                "Oh no!! The Panic Room has a ghost,\n" +
                "and you don't have anything in your inventory to fight it with.\n" +
                "You have nothing in your inventory\n" +
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
    void testListChallenge_Positive() {
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
    void testListChallenge_Negative() {
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
    void testSolveChallengeAttempt_Success() {
        gameEngine.setCurrentRoom("Fire Swamps");
        assertTrue(gameEngine.roomHasUnsolvedChallenge());

        String[] successfulMove = {"use", "fighting skills"};
    }

    @Test
    void testSolveChallengeAttempt_Failure() {

    }

    @Test
    void testRoomHasUnsolvedChallenge_Positive() {

    }

    @Test
    void testRoomHasUnsolvedChallenge_Negative() {

    }
}