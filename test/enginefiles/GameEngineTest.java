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
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();;
    private PrintStream testOut;
    private PrintStream originalOut;

    @Test
    public void testGetUserCommand() {
        //String[] formattedCommands = gameEngine.getUserCommand();
    }

    @Test
    public void testPrint() {
        System.setOut(new PrintStream(outContent));
        System.out.print("test");
        String test = "test";
        assertEquals(test, outContent.toString());
    }


    @Test
    public void testGameEndingDefeat() {
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Kitchen");
        gameEngine.checkIfGameOver();
        String expectedOutput = "You lost!! You are dead. You are not alive\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGameEndingVictory() {
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("sword");
        System.setOut(new PrintStream(outContent));
        gameEngine.setCurrentRoom("Kitchen");
        gameEngine.setInventory(inventory);
        gameEngine.checkIfGameOver();
        String expectedOutput = "You won!! Good job!!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getCurrentRoom() {

    }

    @Test
    void setCurrentRoom() {
    }

    @Test
    void getInventory() {
    }

    @Test
    void setInventory() {
    }
}