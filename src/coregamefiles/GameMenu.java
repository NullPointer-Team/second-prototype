/*
 *      Stranger Game
 *      Team NullPointer (Team 5)
 *      https://github.com/NullPointer-Team
 *      Neill Perry (https://github.com/neillperry)
 *      Bruce West (https://github.com/BruceBAWest)
 *      Tapan Trivedi (https://github.com/tapantriv)
 *      TLG Learning: Capstone Project
 *      https://github.com/NullPointer-Team/prototype
 */

package coregamefiles;

import enginefiles.GameEngine;
import exceptionfiles.InvalidGameMenuSelectionException;

import java.util.Scanner;

/**
 * Game Menu is where you choose to begin or end game
 * gameMenu.startGame in the GameClient executes the game from here.
 */
public class GameMenu {

    GameEngine gameEngine = new GameEngine();
    Scanner userInput = new Scanner(System.in);

    // This method starts the game.
    public void startGame() {
        displayMenuText();
        startGameMenu();
    }

    // This method will display the welcome messaging and game menu text.
    private void displayMenuText() {
        GameMenuTextArt.welcome();
        GameMenuTextArt.gameMenuDisplayText();
        GameMenuTextArt.gameMenuPrompt();
    }

    // This method handles user input logic from game menu choices
    private void startGameMenu() {
        while (!gameEngine.gameOver) {
            try {
                switch (userInput.nextLine().toUpperCase().trim()) {
                    case "PLAY":
//                        gameEngine.gameOver = true;
                        gameEngine.playGame();
                        break;
                    case "EXIT":
                        gameEngine.gameOver = false;
                        GameMenuTextArt.goodbye();
                    default:
                        throw new InvalidGameMenuSelectionException();
                }
            } catch (InvalidGameMenuSelectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
