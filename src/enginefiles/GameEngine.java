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

import coregamefiles.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class GameEngine {
    //setup fields
    public Boolean gameOver = false;
    //    private String currentRoom = "Atrium";
    private CurrentRoom currentRoom;
    private ArrayList<String> inventory;
    private Scanner input;
    private GameMap gameMap = new GameMap();
    private HashMap<CurrentRoom, HashMap<String, String>> rooms;


    /**
     * CTOR Section
     */
    public GameEngine() {
        //no-op ctor
    }


    public void playGame() {
        rooms = gameMap.rooms;
        inventory = new ArrayList<>();
        input = new Scanner(System.in);
        GameIntroduction.gameInformation();

        while (!gameOver) {
            showStatus();
            String[] moves = getUserCommand();
            executeUserCommand(moves);
            checkIfGameOver();
        }
    }

    /**
     * Begin Accessor Method Section
     * let's remove all this junk below, build objects out of them,
     * return necessary info, and access them here instead
     * example:
     *
     * in the top of this class, in the attributes/fields, have:
     *
     * private Inventory inventory;
     *
     * then down here have getters and setters like:
     *
     * public Inventory getInventory() {
     *     return inventory;
     * }
     * &
     * public void setInventory(Inventory inventory) {
     *     this.inventory = inventory;
     * }
     *
     * then in the CTOR above, have a no-op CTOR, and have
     * @param currentRoom
     */

    public void setCurrentRoom(CurrentRoom currentRoom) {
        this.currentRoom = currentRoom;
    }

    public CurrentRoom getCurrentRoom(){
        return currentRoom;
    }

    public void checkIfGameOver() {
        if (getCurrentRoom().toString().equals("Kitchen")) {
            if (inventory.contains("sword")) {
                WinLoseTextArt.winArt();
            } else {
                WinLoseTextArt.loseArt();
            }
            PlayAgainPrompt.playAgain();
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
            setCurrentRoom((rooms.get(currentRoom).get(command)));
        } else {
            System.out.println("You can\'t go that way!");
        }
    }

    public String[] getUserCommand() {
        String move = "";
        while (move.equals("")) {
            System.out.println("What do you want to do?");
            move = input.nextLine().trim();
        }
        if (move.toUpperCase().trim().equals("QUIT")) {
            GameMenu gameMenu = new GameMenu();
            gameMenu.startGame();
        }
        if (move.toUpperCase().trim().equals("RULES")) {
            GameRules.printRules();
        }

        return move.toLowerCase().split("\\s+", 2);
    }

    private void showStatus() {
        System.out.println(" -------------------- ");
        System.out.println("You are in the "+ currentRoom);
        showInventory();
        System.out.println("For game rules, type \"rules\"");
        System.out.println(" -------------------- ");
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


    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

}
