package coregamefiles;

import static coregamefiles.GameTextColors.*;

public class WinLoseTextArt {

    // This method will display the word art when the human player wins the game.
    // This will be used in both Basic and Advanced Game Engine
    public static void winArt() {
        System.out.println("You won!! Good job!!");
        System.out.println(getAnsiGreen() +
                "______________________________________________________\n" +
                "                                                      \n" +
                "██    ██  ██████  ██    ██     ██     ██ ██ ███    ██ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██ ██ ████   ██ \n" +
                "  ████   ██    ██ ██    ██     ██  █  ██ ██ ██ ██  ██ \n" +
                "   ██    ██    ██ ██    ██     ██ ███ ██ ██ ██  ██ ██ \n" +
                "   ██     ██████   ██████       ███ ███  ██ ██   ████ \n" +
                "                                                      \n" +
                "______________________________________________________\n" +
                getAnsiReset());
    }

    // This method will display the text when the computer player win the game.
    // This will be used in both Basic and Advanced Game Engine
    public static void loseArt() {
        System.out.println("You lost!! You are dead. You are not alive");
        System.out.println(getAnsiRed() +
                "_______________________________________________________________\n" +
                "                                                               \n" +
                "██    ██  ██████  ██    ██     ██      ██████  ███████ ███████ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██    ██ ██      ██      \n" +
                "  ████   ██    ██ ██    ██     ██     ██    ██ ███████ █████   \n" +
                "   ██    ██    ██ ██    ██     ██     ██    ██      ██ ██      \n" +
                "   ██     ██████   ██████      ███████ ██████  ███████ ███████ \n" +
                "                                                               \n" +
                "_______________________________________________________________\n" +
                getAnsiReset());
    }
}
