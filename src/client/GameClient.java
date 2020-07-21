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

package client;

import music.Music;
import coregamefiles.GameMenu;

public class GameClient {
    public static void main(String[] args) throws Exception {
        GameMenu gameMenu = new GameMenu();
        gameMenu.startGame();
    }
}
