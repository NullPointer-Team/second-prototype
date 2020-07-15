package coregamefiles;

import playerfiles.ComputerPlayer;
import playerfiles.HumanPlayer;

public class WinLoseTextArt {

    // This method will display the word art when the human player wins the game.
    // This will be used in both Basic and Advanced Game Engine
    void humanWinTextDisplay(HumanPlayer humanPlayer) {
        System.out.println("\n" + humanPlayer.getName() + " wins the Game!!!!!");
        System.out.println("\n" +
                "██    ██  ██████  ██    ██     ██     ██ ██ ███    ██ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██ ██ ████   ██ \n" +
                "  ████   ██    ██ ██    ██     ██  █  ██ ██ ██ ██  ██ \n" +
                "   ██    ██    ██ ██    ██     ██ ███ ██ ██ ██  ██ ██ \n" +
                "   ██     ██████   ██████       ███ ███  ██ ██   ████ \n" +
                "                                                      \n");
    }

    // This method will display the text when the computer player win the game.
    // This will be used in both Basic and Advanced Game Engine
    void humanLoseTextDisplay(ComputerPlayer computerPlayer) {
        System.out.println("\n" + ComputerPlayer.getName() + " wins the Game!!!!!");
        System.out.println("\n" +
                "██    ██  ██████  ██    ██     ██      ██████  ███████ ███████ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██    ██ ██      ██      \n" +
                "  ████   ██    ██ ██    ██     ██     ██    ██ ███████ █████   \n" +
                "   ██    ██    ██ ██    ██     ██     ██    ██      ██ ██      \n" +
                "   ██     ██████   ██████      ███████ ██████  ███████ ███████ \n" +
                "                                                               \n");
    }
}
