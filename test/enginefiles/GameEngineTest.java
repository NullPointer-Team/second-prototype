package enginefiles;

import org.junit.After;
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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreSettings() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testGetUserCommand() {
        String[] formattedCommands = gameEngine.getUserCommand();
    }

    @Test
    public void testGameEnding() {
        gameEngine.setCurrentRoom("Kitchen");
        gameEngine.checkIfGameOver();
        assertEquals("You lost!! You are dead. You are not alive", outContent.toString());
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