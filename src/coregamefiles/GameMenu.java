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

import exceptionfiles.InvalidGameMenuSelectionException;

import java.util.Scanner;

public class GameMenu {

    private static String name;

    // This will be the method to start the game.
    public void startGame() {
        displayMenuText();
        startGameMenu();

    }

//    private void enterNamePrompt() {
//        this.enterName();
//    }

    // This method will display the welcome messaging and game menu text.
    private void displayMenuText() {
        GameMenuTextArt.welcome();
        GameMenuTextArt.gameMenuDisplayText();
    }

    // This method will handle all of the user input logic and start the user specified game version.
    private void startGameMenu() {
        boolean isValid = false;
        BasicGameEngine basicGameEngine = new BasicGameEngine();
        AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
        Scanner userInput = new Scanner(System.in);
//        enterNamePrompt();
        while (!(isValid)) {
            try {
                switch (userInput.nextLine().toUpperCase()) {
                    case "BASIC":
                        basicGameEngine.playGame();
                        isValid = true;
                        break;
                    case "ADVANCED":
                        advancedGameEngine.playGame();
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

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        GameMenu.name = name;
    }
}
