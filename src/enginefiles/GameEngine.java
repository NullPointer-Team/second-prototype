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
        currentRoom = "Atrium";
        inventory = new ArrayList<String>();
        input = new Scanner(System.in);

        //TODO: fix rooms.get and showStatus method
        while (!gameOver) {
            showStatus();
            String[] moves = getUserCommand();
            executeUserCommand(moves);
            checkIfGameOver();
        }
    }

    public void checkIfGameOver() {
        if (currentRoom.equals("Kitchen")) {
            if (inventory.contains("sword")) {
                System.out.println("You won!! Good job!!");
            } else {
                System.out.println("You lost!! You are dead. You are not alive");
            }
            gameOver = true;
        }
    }

    private void executeUserCommand(String[] moves) {
        if (moves[0].toLowerCase().equals("go")) {
            moveToRoom(moves[1]);
        }

        if (moves[0].toLowerCase().equals("get")) {
            acquireItem(moves[1]);
        }
    }

    private void acquireItem(String command) {
        if (rooms.get(currentRoom).get("item").toLowerCase().equals(command.toLowerCase())) {
            inventory.add(command);
            System.out.println(command + " acquired!!");
        } else {
            System.out.println("That item is not available in this room!");
        }
    }

    private void moveToRoom(String command) {
        if (rooms.get(currentRoom).containsKey(command.toLowerCase())) {
            currentRoom = rooms.get(currentRoom).get(command);
        } else {
            System.out.println("You can\'t go that way!");
        }
    }

    public String[] getUserCommand() {
        String move = "";
        while (move.equals("")) {
            System.out.println("What do you want to do?");
            move = input.nextLine();
        }
        if (move.toUpperCase().equals("QUIT")) {
            gameOver = true;
        }

        return move.toLowerCase().split("\\s+", 2);
    }

    private void showStatus() {
        System.out.println(" -------------------- ");
        System.out.println("You are in the "+ currentRoom);
        showInventory();
    }

    private void showInventory() {
        if (getInventory().isEmpty()) {
            System.out.println("You have nothing in your inventory");
        } else {
            System.out.println("In your inventory, you have:     ");
            for (String item: inventory) {
                System.out.println("      - a " + item);
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
