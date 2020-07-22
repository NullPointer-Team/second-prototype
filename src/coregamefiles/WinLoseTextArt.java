package coregamefiles;

import music.Music;

public class WinLoseTextArt {

    // This method will display the word art when the human player wins the game.
    // This will be used in both Basic and Advanced Game Engine
    public static void winArt() throws Exception {
        Music.win();
        System.out.println("You won!! Good job!!");
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
    public static void loseArt() throws Exception {
        Music.loseMusic();
        System.out.println("You lost!! You are dead. You are not alive");
        System.out.println("\n" +
                "██    ██  ██████  ██    ██     ██      ██████  ███████ ███████ \n" +
                " ██  ██  ██    ██ ██    ██     ██     ██    ██ ██      ██      \n" +
                "  ████   ██    ██ ██    ██     ██     ██    ██ ███████ █████   \n" +
                "   ██    ██    ██ ██    ██     ██     ██    ██      ██ ██      \n" +
                "   ██     ██████   ██████      ███████ ██████  ███████ ███████ \n" +
                "                                                               \n");
    }
}
