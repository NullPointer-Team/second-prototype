package coregamefiles;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static coregamefiles.GameTextColors.*;
import static org.junit.jupiter.api.Assertions.*;

class WinLoseTextArtTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private WinLoseTextArt winLoseTextArt = new WinLoseTextArt();

    @Test
    void testWinArt() {
        System.setOut(new PrintStream(outContent));
        WinLoseTextArt.winArt();
        String expectedOutput = "You won!! Good job!!\n" + getAnsiGreen() +
                "______________________________________________________\n" +
                "                                                      \n" +
                "██    ██  ██████  ██    ██     ██     ██ ██ ███    ██ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██ ██ ████   ██ \n" +
                "  ████   ██    ██ ██    ██     ██  █  ██ ██ ██ ██  ██ \n" +
                "   ██    ██    ██ ██    ██     ██ ███ ██ ██ ██  ██ ██ \n" +
                "   ██     ██████   ██████       ███ ███  ██ ██   ████ \n" +
                "                                                      \n" +
                "______________________________________________________\n" + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testLoseArt() {
        System.setOut(new PrintStream(outContent));
        WinLoseTextArt.loseArt();
        String expectedOutput = "You lost!! You are dead. You are not alive\n" + getAnsiRed() +
                "_______________________________________________________________\n" +
                "                                                               \n" +
                "██    ██  ██████  ██    ██     ██      ██████  ███████ ███████ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██    ██ ██      ██      \n" +
                "  ████   ██    ██ ██    ██     ██     ██    ██ ███████ █████   \n" +
                "   ██    ██    ██ ██    ██     ██     ██    ██      ██ ██      \n" +
                "   ██     ██████   ██████      ███████ ██████  ███████ ███████ \n" +
                "                                                               \n" +
                "_______________________________________________________________\n" + getAnsiReset() + "\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}