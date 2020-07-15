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

package exceptionfiles;

public class InvalidAdvancedMoveSelectionException extends Exception {

    //ctor
    public InvalidAdvancedMoveSelectionException() {
        super("Invalid move. Please type Rock, Paper, Scissors, Lizard, Spock");
    }

    public InvalidAdvancedMoveSelectionException(String message) {
        super(message);
    }
}
