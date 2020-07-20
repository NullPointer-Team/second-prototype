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
    public void testMoveToRoom_Failure() {
        String east = "east";
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.moveToRoom(east);
        String expectedOutput = "You can\'t go that way!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMoveToRoom_Success() {
        String east = "east";
        String west = "west";
        String south = "south";
        String north = "north";

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
        gameEngine.moveToRoom(west);
        assertEquals(gameEngine.getCurrentRoom(), atrium);
        gameEngine.moveToRoom(south);
        assertEquals(gameEngine.getCurrentRoom(), fireSwamps);
        gameEngine.moveToRoom(north);
        assertEquals(gameEngine.getCurrentRoom(), atrium);

        gameEngine.moveToRoom(east);
        assertEquals(gameEngine.getCurrentRoom(), nook);
        gameEngine.moveToRoom(east);
        assertEquals(gameEngine.getCurrentRoom(), menagerie);
        gameEngine.moveToRoom(south);
        assertEquals(gameEngine.getCurrentRoom(), diningRoom);
        gameEngine.moveToRoom(west);
        assertEquals(gameEngine.getCurrentRoom(), hall);
        gameEngine.moveToRoom(east);
        assertEquals(gameEngine.getCurrentRoom(), diningRoom);
    }

    @Test
    void testAcquireItem_NotAvailable() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.acquireItem("potion");
        String expectedOutput = "That item is not available in this room!\n";
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
    }

    @Test
    void testExecuteUserCommand_Invalid() {
        String[] moves = {"test", "move"};
        System.setOut(new PrintStream(outContent));
        gameEngine.executeUserCommand(moves);
        String expectedOutput = "I did not understand. Please re-enter you command.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecuteUserCommand_Valid() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Library");
        String[] movesNewRoom = {"go", "west"};
        String[] movesGetItem = {"get", "Book of Spells"};
        gameEngine.executeUserCommand(movesGetItem);
        gameEngine.executeUserCommand(movesNewRoom);
        String expectedRoom = "Garden";
        String expectedOutput = "Book of Spells acquired!!\n";
        ArrayList<String> updatedInventory = gameEngine.getInventory();
        assertEquals(gameEngine.getCurrentRoom(), expectedRoom);
        assertTrue(updatedInventory.contains("Book of Spells"));
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    void testShowStatus() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Panic Room");
        gameEngine.showStatus();
        String expectedOutput = " -------------------- \n" +
                "You are in the Panic Room\n" +
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

}