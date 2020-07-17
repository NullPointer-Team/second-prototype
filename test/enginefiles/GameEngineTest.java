package enginefiles;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {
    private GameEngine gameEngine;
    private String commands;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;
    private PrintStream originalOut;
    private PrintStream originalErr;

    @Before
    public void setUp() {
        gameEngine = new GameEngine();
        commands = "go east";
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalErr = System.err;
    }

    @Test
    public void testGetUserCommand() {
        String[] formattedCommands = gameEngine.getUserCommand();
    }

    @Test
    void getCurrentRoom() {
        System.out.println(gameEngine.getCurrentRoom());
        assertTrue(gameEngine.getCurrentRoom().equals("Atrium"));
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