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

import java.util.Scanner;

public class PlayerSetup {
    //fields
    private int lifeCount = 10;
    private static String name;

    /**
     * player setup business methods
     */
    private void enterNamePrompt() {
        this.enterName();
    }

    //this method creates and stores player name for game
    public void enterName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nPlease enter your name: ");
        name = userInput.nextLine();
        System.out.println("Username has been set to: " + getName());
    }

    /**
     * Getters and Setters for player setup logic
     */
    public static String getName() {
        return name;
    }

    public void setName(String name) {
        PlayerSetup.name = name;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }
}
