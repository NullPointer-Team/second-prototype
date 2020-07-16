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

public class GameMenu {



    /**
     * gameMenu.startGame in the GameEngineClient starts the game from here.
     * This will be the method to start the game.
     */
    public void startGame() {
        displayMenuText();
        startGameMenu();
    }

    //could be used to prompt for user name, then store in-memory for later use
//    private void enterNamePrompt() {
//        this.enterName();
//    }

    // This method will display the welcome messaging and game menu text.
    private void displayMenuText() {
        GameMenuTextArt.welcome();
        GameMenuTextArt.gameMenuDisplayText();
    }

    //DONE: Implement the GameEngine playGame method here, make it run
    // This method will handle all of the user input logic from game menu choice,
    // and start the game.
    private void startGameMenu() {
        boolean isValid = false;
        GameEngine gameEngine = new GameEngine();
        Scanner userInput = new Scanner(System.in);
        while (!(isValid)) {
            try {
                switch (userInput.nextLine().toUpperCase()) {
                    case "PLAY":
                        gameEngine.playGame();
                        isValid = true;
                        break;
                    case "EXIT":
                        isValid = true;
                        GameMenuTextArt.goodbye();
                    default:
                        throw new InvalidGameMenuSelectionException();
                }
            } catch (InvalidGameMenuSelectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    //create and store player name for game
//    public void enterName() {
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("\nPlease enter your name: ");
//        name = userInput.nextLine();
//        System.out.println("Username has been set to: " + getName());
//    }


}
