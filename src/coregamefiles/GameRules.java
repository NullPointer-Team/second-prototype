package coregamefiles;

import java.util.Scanner;

public class GameRules {

    // This method will prompt the user if they want to hear the rules for the game or not.
    public static void printRules() {
        System.out.println(
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
                "To quit the game, type \"quit\"");
    }
}
