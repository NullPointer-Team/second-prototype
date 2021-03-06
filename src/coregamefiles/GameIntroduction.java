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

public class GameIntroduction {
    // This method will display the basic version of the game's rules and information.
    public static void gameInformation() {
        welcomeMessage();
        String userInput = ruleDisplaySelection();
        if (userInput.equals("Y") || userInput.equals("YES")) {
            printRules();
        }
    }

    static void printRules() {
        GameRules.printRules();
    }

    // This private method will prompt the user if they want to hear the rules for the game or not.
    static String ruleDisplaySelection() {
        printReadRulesQuestion();
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine().toUpperCase().trim();
    }

    static void printReadRulesQuestion() {
        System.out.println(
                "\nWould you like to hear the rules of the game?\n" +
                "Type Y or Yes to hear the rules.\n" +
                "Type anything else to continue to the game.\n");
    }

    // This method contains the welcome information text.
    static void welcomeMessage() {
        System.out.println(
                "Welcome to Stranger Game, a text-based Java console RPG game.  Please read the rules below:\n" +
                "Although the basic game has a lot of complexity to it, the rules to play it are simple.\n" +
                "You are trapped in a maze in a fantasy world, and in order to return to reality you must complete the game \n" +
                "before the portal closes. Navigate from room to room, collecting useful items and completing challenges \n" +
                "to unlock the portal. Hurry! The portal back to earth won't stay open long!\n");
    }
}
