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

public class InvalidMapScenarioException extends Exception {

    public InvalidMapScenarioException() {
        super("There seems to be a problem with your map.\n" +
                "Being that this is a haunted maze, looks like you'll have to find your own way!");
    }

    public InvalidMapScenarioException(String message) {
        super(message);
    }
}
