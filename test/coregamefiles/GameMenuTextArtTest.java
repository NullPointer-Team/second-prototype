package coregamefiles;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static coregamefiles.GameTextColors.getAnsiRed;
import static coregamefiles.GameTextColors.getAnsiReset;
import static org.junit.jupiter.api.Assertions.*;

class GameMenuTextArtTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameMenuTextArt gameMenuTextArt = new GameMenuTextArt();

    @Test
    void testWelcome() {
        System.setOut(new PrintStream(outContent));
        gameMenuTextArt.welcome();

        String expectedOutput = getAnsiRed() + "\n" +
                "███████╗████████╗██████╗  █████╗ ███╗   ██╗ ██████╗ ███████╗██████╗ \n" +
                "██╔════╝╚══██╔══╝██╔══██╗██╔══██╗████╗  ██║██╔════╝ ██╔════╝██╔══██╗\n" +
                "███████╗   ██║   ██████╔╝███████║██╔██╗ ██║██║  ███╗█████╗  ██████╔╝\n" +
                "╚════██║   ██║   ██╔══██╗██╔══██║██║╚██╗██║██║   ██║██╔══╝  ██╔══██╗\n" +
                "███████║   ██║   ██║  ██║██║  ██║██║ ╚████║╚██████╔╝███████╗██║  ██║\n" +
                "╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝\n" +
                "                 ██████╗  █████╗ ███╗   ███╗███████╗                \n" +
                "                ██╔════╝ ██╔══██╗████╗ ████║██╔════╝                \n" +
                "                ██║  ███╗███████║██╔████╔██║█████╗                  \n" +
                "                ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                  \n" +
                "                ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                \n" +
                "                 ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                \n" + getAnsiReset() + "\n\n" +
                "           Built by Team NullPointer (Team 5)\n" +
                "           Neill Perry (https://github.com/neillperry)\n" +
                "           Bruce West (https://github.com/BruceBAWest)\n" +
                "           Tapan Trivedi (https://github.com/tapantriv)\n" +
                "           TLG Learning: Capstone Java Project\n" +
                "           https://github.com/NullPointer-Team\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testGameMenuDisplayText() {
        System.setOut(new PrintStream(outContent));
        gameMenuTextArt.gameMenuDisplayText();

        String expectedOutput = "\n" +
                "       _______________________________________________________\n" +
                "       |     ▄▄▌ ▐ ▄▄▄▄ ▄▄▌  ▄▄        ▌ ▄   ▄▄▄             |\n" +
                "       |     ██  █▌▐▀▄ ▀██  ▐█ ▌      ██ ▐███▀▄ ▀            |\n" +
                "       |     ██ ▐█▐▐▐▀▀ ██  ██ ▄▄▄█▀▄▐█ ▌▐▌▐█▐▀▀ ▄           |\n" +
                "       |     ▐█▌██▐█▐█▄▄▐█▌▐▐███▐█▌ ▐██ ██▌▐█▐█▄▄▌           |\n" +
                "       |      ▀▀▀▀ ▀ ▀▀▀ ▀▀▀ ▀▀▀ ▀█▄▀▀▀  █ ▀▀▀▀▀▀            |\n" +
                "       |                                                     |\n" +
                "       |  Welcome to Stranger Game, the Java Console Game!   |\n" +
                "       |  Please select an option from the choices below:    |\n" +
                "       |                                                     |\n" +
                "       |  Play the Game            [Command: Play]           |\n" +
                "       |  Exit this Program        [Command: Quit]           |\n" +
                "       |_____________________________________________________|\n\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void gameMenuPrompt() {
        System.setOut(new PrintStream(outContent));
        gameMenuTextArt.gameMenuPrompt();

        String expectedOutput = "\nEnter response below: \n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintGoodbyeMessage() {
        System.setOut(new PrintStream(outContent));
        gameMenuTextArt.printGoodbyeMessage();

        String expectedOutput = "Goodbye!  Thanks for playing.\n" + getAnsiRed() + "\n" +
                "___________________________________________________________\n" +
                "                                                           \n" +
                " ██████   ██████   ██████  ██████  ██████ ██    ██ ███████ \n" +
                "██       ██    ██ ██    ██ ██   ██ ██   ██ ██  ██  ██      \n" +
                "██   ███ ██    ██ ██    ██ ██   ██ ██████   ████   █████   \n" +
                "██    ██ ██    ██ ██    ██ ██   ██ ██   ██   ██    ██      \n" +
                " ██████   ██████   ██████  ██████  ██████    ██    ███████ \n" +
                "                                                           \n" +
                "___________________________________________________________\n" + getAnsiReset() + "\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}