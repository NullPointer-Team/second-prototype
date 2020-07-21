package coregamefiles;

import enginefiles.GameEngine;
import exceptionfiles.InvalidPostGameSelection;

import java.util.Scanner;

public class PlayAgainPrompt {

    public static void playAgain() {
        playAgainFeedback();
    }

    /**
     * this method prompts the player after playing a game, or quitting a game, whether they
     * want to play again, or exit, which returns them to the main menu
     */
    private static void playAgainFeedback() {
        boolean isValid = false;

        System.out.println("Would you like to replay the game?\n" +
                "Type \"Yes\" to replay, or type \"Exit\" to return to menu.");
        GameEngine gameEngine = new GameEngine();
        Scanner gameSelection = new Scanner(System.in);

        //prompt if they want to play again or exit
        while (!(isValid)) {
            try {
                switch (gameSelection.nextLine().toUpperCase().trim()) {
                    case "YES":
                        gameEngine.playGame();
                        isValid = true;
                        break;
                    case "EXIT":
                        GameMenu gameMenu = new GameMenu();
                        gameMenu.startGame();
                        isValid = true;
                        break;
                    default:
                        throw new InvalidPostGameSelection();
                }
            }
            catch(InvalidPostGameSelection e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
