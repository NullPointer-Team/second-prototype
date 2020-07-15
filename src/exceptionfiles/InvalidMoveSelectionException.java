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

public class InvalidMoveSelectionException extends Exception {

    //ctor
    public InvalidMoveSelectionException() {
        super("Invalid move. Please type Rock, Paper or Scissors");
    }

    public InvalidMoveSelectionException(String message) {
        super(message);
    }
}
