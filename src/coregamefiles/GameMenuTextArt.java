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

public class GameMenuTextArt extends GameMenu {

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

    static void welcome() {
        System.out.println("\n" +
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
                "                 ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                \n");

        System.out.println("\n" +
                "           Built by Team NullPointer (Team 5)\n" +
                "           Neill Perry (https://github.com/neillperry)\n" +
                "           Bruce West (https://github.com/BruceBAWest)\n" +
                "           Tapan Trivedi (https://github.com/tapantriv)\n" +
                "           TLG Learning: Capstone Java Project\n" +
                "           https://github.com/NullPointer-Team");
    }

    static void goodbye() {
        System.out.println("Goodbye!  Thanks for playing.");
        System.out.println("\n" +
                " ██████   ██████   ██████  ██████  ██████ ██    ██ ███████ \n" +
                "██       ██    ██ ██    ██ ██   ██ ██   ██ ██  ██  ██      \n" +
                "██   ███ ██    ██ ██    ██ ██   ██ ██████   ████   █████   \n" +
                "██    ██ ██    ██ ██    ██ ██   ██ ██   ██   ██    ██      \n" +
                " ██████   ██████   ██████  ██████  ██████    ██    ███████ \n" +
                "                                                           \n" +
                "                                                           \n");
        System.exit(0);
    }
}
