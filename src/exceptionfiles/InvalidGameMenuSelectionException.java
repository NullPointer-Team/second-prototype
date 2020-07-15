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

public class InvalidGameMenuSelectionException extends Exception {

    //ctor
    public InvalidGameMenuSelectionException() {
        super("Invalid Menu Choice. Please type Basic, Advanced or Exit");
    }

    public InvalidGameMenuSelectionException(String message) {
        super(message);
    }
}
