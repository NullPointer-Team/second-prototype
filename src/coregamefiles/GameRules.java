package coregamefiles;

import static coregamefiles.GameTextColors.*;

public class GameRules {

    // This method will prompt the user if they want to hear the rules for the game or not.
    public static void printRules() {
        System.out.println( getAnsiYellow() +
                "__________________________________________________________________________________\n" +
                "         _         \n" +
                " ___ _ _| |___ ___ \n" +
                "|  _| | | | -_|_ -|\n" +
                "|_| |___|_|___|___|\n" +
                "__________________________________________________________________________________\n" +
                getAnsiReset() +
                "To navigate from room to room, type these commands:\n" +
                "    \"go north\"\n" +
                "    \"go south\"\n" +
                "    \"go east\"\n" +
                "    \"go west\"\n" +
                "To retrieve items in a room, type 'get' followed by the name of the item, such as:\n" +
                "    \"get wand\"\n" +
                "       - or -   \n" +
                "    \"get coin\"\n" +
                "       - or -   \n" +
                "    \"get 'insert name of some item in the room'\"\n" +
                "To use an item in your inventory, type 'use' followed by the name of the item, such as:\n" +
                "    \"use potion\"\n" +
                "       - or -   \n" +
                "    \"use sword\"\n" +
                "To see the Maze Map, type \"map\"\n" +
                "To quit the game, type \"quit\"\n" +
                getAnsiYellow() +
                "__________________________________________________________________________________\n\n" +
                //getAnsiReset() +
                "HINT: Grab all the resources you can. You will need them on your journey as challenges come your way.\n" +
                "Happy exploring, Strange Adventurer. Good luck in your quest to return to reality!\n" +
                //getAnsiYellow() +
                "__________________________________________________________________________________\n\n" +
                getAnsiReset() );
    }
}
