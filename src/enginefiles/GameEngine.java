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

    private String currentRoom;
    private ArrayList<String> inventory;
    public Boolean gameOver;
    public Integer guesses;
    public Boolean isPlayerMobile;
    private Scanner input;
    private GameMap gameMap;
    private HashMap<String, HashMap<String, String>> rooms;

    public GameEngine() {
        gameOver = false;
        guesses = 3;
        isPlayerMobile = true;
        gameMap = new GameMap();
        rooms = gameMap.rooms;
        currentRoom = "Atrium";
        inventory = new ArrayList<String>();
        input = new Scanner(System.in);
    }


    public void playGame() {
        GameIntroduction.gameInformation();

        while (!gameOver) {
            showStatus();
            String[] moves = getUserCommand();
            executeUserCommand(moves);
            checkIfGameOver();
        }

        PlayAgainPrompt.playAgain();
    }

    public void checkIfGameOver() {
        if (currentRoom.equals("Kitchen")) {
            if (inventory.contains("sword")) {
                WinLoseTextArt.winArt();
            } else {
                WinLoseTextArt.loseArt();
            }
            PlayAgainPrompt.playAgain();
        }
    }

    public void terminateGame(Boolean wonGame) {
        if (wonGame) {
            WinLoseTextArt.winArt();
        } else {
            WinLoseTextArt.loseArt();
        }
        gameOver = true;
    }

    public void executeUserCommand(String[] moves) {
        String first_word = moves[0].toLowerCase();

        switch(first_word) {
            case "go":
                moveToRoom(moves[1]);
                break;
            case "get":
                acquireItem(moves[1]);
                break;
            case "use":
                useItem(moves[1]);
                break;
            case "quit":
                GameMenu gameMenu = new GameMenu();
                gameMenu.startGame();
                break;
            case "rules":
                GameRules.printRules();
                break;
            default:
                System.out.println("I did not understand. Please re-enter your command.");
        }

    }
    //this little guy tells you when there's an item in the room
    public void listItem() {
        rooms.get(currentRoom).get("item");
        System.out.println(rooms.get(currentRoom).get("item"));
    }

    //this here fella retreives an item in a room

    public void useItem(String item) {
        if (!itemInInventory(item)) {
            System.out.println("You don\'t have that item in your inventory!");
            guesses++;
        } else {
            solveChallengeAttempt(item);
        }
    }

    public void solveChallengeAttempt(String item) {

        if (rooms.get(currentRoom).get("solution").toLowerCase().equals(item.toLowerCase())) {
            System.out.println("You solved the challenge!");
            rooms.get(currentRoom).replace("solved", "true");
            isPlayerMobile = true;
            
        } else if (!itemInInventory(item)) {
            guesses--;
            System.out.println("You don\'t have that item in your inventory!");
            System.out.println("You have " + guesses + " more chance(s) left to solve this challenge.");

        } else if (guesses < 1) {
            // print out clue that is specific to the room, i.e., it would help to have a key!
            terminateGame(false);
        }
    }

    public Boolean itemInInventory(String item) {
        return inventory.contains(item);
    }

    public void acquireItem(String command) {
        if (rooms.get(currentRoom).get("item").toLowerCase().equals(command.toLowerCase())) {
            inventory.add(command);
            System.out.println(command + " acquired!!");
        } else {
            System.out.println("That item is not available in this room!");
        }
    }

    public void moveToRoom(String command) {
        if (rooms.get(currentRoom).containsKey(command.toLowerCase())) {
            currentRoom = rooms.get(currentRoom).get(command);
        } else {
            System.out.println("You can\'t go that way!");
        }
    }

    public String[] getUserCommand() {
        String command = "";
        while (command.equals("")) {
            System.out.println("What do you want to do?");
            command = input.nextLine().trim();
        }

        return command.toLowerCase().split("\\s+", 2);
    }

    void showStatus() {
        System.out.println(" -------------------- ");
        System.out.println("You are in the "+ currentRoom);
        System.out.println("This room has a(n) " + rooms.get(currentRoom).get("item"));
        showInventory();
        System.out.println("For game rules, type \"rules\"");
        System.out.println(" -------------------- ");
    }

    void showInventory() {
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
