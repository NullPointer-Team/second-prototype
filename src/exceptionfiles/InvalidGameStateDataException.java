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

public class InvalidGameStateDataException extends Exception {

    //ctor
    public InvalidGameStateDataException() {
        super("Your saved game data seems to be missing. Sorry. Please start over.");
    }

    public InvalidGameStateDataException(String message) {
        super(message);
    }
}
