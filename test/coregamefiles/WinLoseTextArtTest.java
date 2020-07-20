package coregamefiles;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class WinLoseTextArtTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private WinLoseTextArt winLoseTextArt = new WinLoseTextArt();

    @Test
    void winArt() {
        System.setOut(new PrintStream(outContent));
        WinLoseTextArt.winArt();
        String expectedOutput = "You won!! Good job!!\n\n" +
                "██    ██  ██████  ██    ██     ██     ██ ██ ███    ██ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██ ██ ████   ██ \n" +
                "  ████   ██    ██ ██    ██     ██  █  ██ ██ ██ ██  ██ \n" +
                "   ██    ██    ██ ██    ██     ██ ███ ██ ██ ██  ██ ██ \n" +
                "   ██     ██████   ██████       ███ ███  ██ ██   ████ \n" +
                "                                                      \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void loseArt() {
        System.setOut(new PrintStream(outContent));
        WinLoseTextArt.loseArt();
        String expectedOutput = "You lost!! You are dead. You are not alive\n\n" +
                "██    ██  ██████  ██    ██     ██      ██████  ███████ ███████ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██    ██ ██      ██      \n" +
                "  ████   ██    ██ ██    ██     ██     ██    ██ ███████ █████   \n" +
                "   ██    ██    ██ ██    ██     ██     ██    ██      ██ ██      \n" +
                "   ██     ██████   ██████      ███████ ██████  ███████ ███████ \n" +
                "                                                               \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}