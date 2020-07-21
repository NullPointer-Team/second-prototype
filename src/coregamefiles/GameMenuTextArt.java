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

import static coregamefiles.GameTextColors.*;

public class GameMenuTextArt extends GameMenu {
    /**
     * Game intro text Art
     * displays in main game menu
     */
    static void welcome() {
        System.out.println(getAnsiRed() + "\n" +
                "███████╗████████╗██████╗  █████╗ ███╗   ██╗ ██████╗ ███████╗██████╗ \n" +
                "██╔════╝╚══██╔══╝██╔══██╗██╔══██╗████╗  ██║██╔════╝ ██╔════╝██╔══██╗\n" +
                "███████╗   ██║   ██████╔╝███████║██╔██╗ ██║██║  ███╗█████╗  ██████╔╝\n" +
                "╚════██║   ██║   ██╔══██╗██╔══██║██║╚██╗██║██║   ██║██╔══╝  ██╔══██╗\n" +
                "███████║   ██║   ██║  ██║██║  ██║██║ ╚████║╚██████╔╝███████╗██║  ██║\n" +
                "╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝\n" +
                "                 ██████╗  █████╗ ███╗   ███╗███████╗                \n" +
                "                ██╔════╝ ██╔══██╗████╗ ████║██╔════╝                \n" +
                "                ██║  ███╗███████║██╔████╔██║█████╗                  \n" +
                "                ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                  \n" +
                "                ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                \n" +
                "                 ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                \n" +
                getAnsiReset());

        System.out.println("\n" +
                "           Built by Team NullPointer (Team 5)\n" +
                "           Neill Perry (https://github.com/neillperry)\n" +
                "           Bruce West (https://github.com/BruceBAWest)\n" +
                "           Tapan Trivedi (https://github.com/tapantriv)\n" +
                "           TLG Learning: Capstone Java Project\n" +
                "           https://github.com/NullPointer-Team");
    }

    /**
     * Game menu
     * displays in main game menu
     * when you first run game, or return to menu
     */
    static void gameMenuDisplayText() {
        System.out.println("\n" +
                "       _______________________________________________________\n" +
                "       |     ▄▄▌ ▐ ▄▄▄▄ ▄▄▌  ▄▄        ▌ ▄   ▄▄▄             |\n" +
                "       |     ██  █▌▐▀▄ ▀██  ▐█ ▌      ██ ▐███▀▄ ▀            |\n" +
                "       |     ██ ▐█▐▐▐▀▀ ██  ██ ▄▄▄█▀▄▐█ ▌▐▌▐█▐▀▀ ▄           |\n" +
                "       |     ▐█▌██▐█▐█▄▄▐█▌▐▐███▐█▌ ▐██ ██▌▐█▐█▄▄▌           |\n" +
                "       |      ▀▀▀▀ ▀ ▀▀▀ ▀▀▀ ▀▀▀ ▀█▄▀▀▀  █ ▀▀▀▀▀▀            |\n" +
                "       |                                                     |\n" +
                "       |  Welcome to Stranger Game, the Java Console Game!   |\n" +
                "       |  Please select an option from the choices below:    |\n" +
                "       |                                                     |\n" +
                "       |  Play the Game            [Command: Play]           |\n" +
                "       |  Exit this Program        [Command: Exit]           |\n" +
                "       |_____________________________________________________|\n");
    }

    static void gameMenuPrompt() {
        System.out.println("\n" + "Enter response below: ");
    }

    /**
     * Goodbye Message
     * displays when you exit game via main menu
     */
    static void goodbye() {
        printGoodbyeMessage();
        System.exit(0);
    }

    //the actual goodbye art that prints right above here in goodbye()
    static void printGoodbyeMessage() {
        System.out.println("Goodbye!  Thanks for playing.");
        System.out.println(getAnsiRed() + "\n" +
                "                                                           \n" +
                " ██████   ██████   ██████  ██████  ██████ ██    ██ ███████ \n" +
                "██       ██    ██ ██    ██ ██   ██ ██   ██ ██  ██  ██      \n" +
                "██   ███ ██    ██ ██    ██ ██   ██ ██████   ████   █████   \n" +
                "██    ██ ██    ██ ██    ██ ██   ██ ██   ██   ██    ██      \n" +
                " ██████   ██████   ██████  ██████  ██████    ██    ███████ \n" +
                "                                                           \n" +
                "                                                           \n" +
                getAnsiReset());
    }



}
