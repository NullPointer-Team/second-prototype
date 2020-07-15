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

public class InvalidPostGameSelection extends Exception {

    public InvalidPostGameSelection() {
        super("Invalid Menu Choice. Please type Yes, or Exit");
    }

    public InvalidPostGameSelection(String message) {
        super(message);
    }
}
