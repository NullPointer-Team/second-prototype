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

package enginefiles;

import coregamefiles.GameMap;
import coregamefiles.GameIntroduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class GameEngine {

    private String currentRoom;
    private ArrayList<String> inventory;
    private Boolean gameOver = false;
    private Scanner input;
    private GameMap gameMap = new GameMap();
    private HashMap<String, HashMap<String, String>> rooms;

    public void playGame() {
        GameIntroduction.gameInformation();
        rooms = gameMap.rooms;
        currentRoom = "Dining Room";
        inventory = new ArrayList<String>();
        input = new Scanner(System.in);

        //TODO: fix rooms.get and showStatus method
        while (!gameOver) {
            //showStatus();
            String move = "";
            while (move == "") {
                System.out.println("What do you want to do?");
                move = input.nextLine();
            }

            String[] moves = move.toLowerCase().split("\\s+");

            if (moves[0].toLowerCase().equals("go")) {
                if (rooms.get(currentRoom).containsKey(moves[1])) {
                    currentRoom = rooms.get(currentRoom).get(moves[1]);
                    System.out.println("New room is " + currentRoom);
                } else {
                    System.out.println("You can\'t go that way!");
                }
            }

            if (moves[0].toLowerCase().equals("get")) {
                if (rooms.get(currentRoom).get("item").toLowerCase().equals(moves[1])) {
                    inventory.add(moves[1]);
                    System.out.println(moves[1] + " acquired!!");
                } else {
                    System.out.println("That item is not available in this room!");
                }
            }

            if (rooms.get(currentRoom).equals("Kitchen")) {
                if (inventory.contains("sword")) {
                    System.out.println("You won!! Good job!!");
                } else {
                    System.out.println("You lost!! You are dead. You are not alive");
                }
                gameOver = true;
            }
        }
    }

    public String getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

}
