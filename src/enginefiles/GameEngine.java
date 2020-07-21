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

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class GameEngine {

    //these are our fields. we're like farmers, but not
    private String currentRoom;
    private ArrayList<String> inventory;
    public Boolean gameOver;
    public Boolean gameWon;
    public Integer guesses;
    public Boolean isPlayerMobile;
    private Scanner input;
    private GameMap gameMap;
    private HashMap<String, HashMap<String, String>> rooms;

    //i think this is a CTOR, maybe
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

    //do you like to play games?
    public void playGame() {
        GameIntroduction.gameInformation();

        while (!gameOver) {
            showStatus();
            String[] moves = getUserCommand();
            validateUserCommand(moves);
            checkIfGameOver();
        }

        terminateGame();
    }

    //did you done gone and done won? or is you dead, and is you done?
    public void checkIfGameOver() {
        if (currentRoom.equals("Kitchen") && rooms.get(currentRoom).get("solved").equals("true")) {
            gameWon = true;
            gameOver = true;
        }

        if (guesses < 1) {
            gameWon = false;
            gameOver = true;
        }
    }

    //whatcha wanna do?
    public void terminateGame() {
        if (gameWon) {
            WinLoseTextArt.winArt();
        } else {
            WinLoseTextArt.loseArt();
        }
        PlayAgainPrompt.playAgain();
    }

    public void validateUserCommand(String[] moves) {
        String command = moves[0].toLowerCase();
        String commandArgument = moves.length > 1 ? moves[1] : " ";

        switch(command) {
            case "go":
                moveToRoom(commandArgument);
                break;
            case "get":
                acquireItem(commandArgument);
                break;
            case "use":
                validateUseItem(commandArgument);
                break;
            case "quit":
                GameMenu gameMenu = new GameMenu();
                gameMenu.startGame();
                break;
            case "rules":
                getRules();
                break;
            default:
                System.out.println("I did not understand. Please re-enter your command.");
        }

    }
    //this little guy tells you when there's an item in the room
    public void listItem() {
        if (rooms.get(currentRoom).containsKey("item") && !roomHasUnsolvedChallenge()) {
            System.out.println("Inside this room you can find a " + rooms.get(currentRoom).get("item"));
        }
    }

    public void listChallenge() {
        if (roomHasUnsolvedChallenge()) {
            System.out.println("Oh no!! The " + currentRoom + " has a " + rooms.get(currentRoom).get("challenge"));
            System.out.println("You must defeat this challenge before you can continue your journey!");
        }
    }

    //retrieve rules from GameRules for above case: "rules"
    public void getRules() {
        GameRules.printRules();
    }

    //this here fella retrieves an item in a room
    public void validateUseItem(String item) {

        if (!roomHasUnsolvedChallenge()) {
            System.out.println("There is nothing to use your " + item + " on. Continue to explore the maze.");
        } else if (!itemInInventory(item)) {
            System.out.println("You don\'t have that item in your inventory!");
            guesses--;
        } else {
            solveChallengeAttempt(item);
        }
    }

    //it's time to fight!
    public void solveChallengeAttempt(String item) {

        String challengeSolution = rooms.get(currentRoom).get("solution").toLowerCase();

        if (challengeSolution.equals(item.toLowerCase())) {
            System.out.println("You solved the challenge! Continue on your quest");
            rooms.get(currentRoom).replace("solved", "true");
            isPlayerMobile = true;
            guesses = 3;
        } else {
            guesses--;
            System.out.println("Using the " + item + " has no effect!");
            System.out.println("You have " + guesses + " guesses left. Try again!");
        }

    }

    //do you have it in your satchel?
    public Boolean itemInInventory(String item) {
        return inventory.contains(item);
    }

    //get the thing
    public void acquireItem(String commandArgument) {
        if (rooms.get(currentRoom).get("item").toLowerCase().equals(commandArgument.toLowerCase())) {
            inventory.add(commandArgument);
            rooms.get(currentRoom).remove("item");
            System.out.println(commandArgument + " acquired!!");
        } else {
            System.out.println("A " + commandArgument + " is not available in this room!");
        }
    }

    //this dude lets you move room-to-room
    public void moveToRoom(String command) {
        if (rooms.get(currentRoom).containsKey(command.toLowerCase()) && isPlayerMobile) {
            setCurrentRoom(rooms.get(currentRoom).get(command));
        } else if (!isPlayerMobile) {
            System.out.println("You can't leave the room until you solve the challenge!");
        } else {
            System.out.println("You can't go that way!");
        }
    }

    //this pardner prompts the player for precepts (lol... it gets commands)
    public String[] getUserCommand() {
        String command = "";
        while (command.equals("")) {
            System.out.println("What do you want to do?");
            command = input.nextLine().trim();
        }

        return command.toLowerCase().split("\\s+", 2);
    }

    //lets you know what's what
    void showStatus() {
        System.out.println(" -------------------- ");
        System.out.println("You are in the "+ currentRoom);
        listItem();
        listChallenge();
        showInventory();
        System.out.println("For game rules, type \"rules\"");
        System.out.println(" -------------------- ");
    }

    //what's in the box?! What's in the box?!
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
        isPlayerMobile = !roomHasUnsolvedChallenge();
    }

    public Boolean roomHasUnsolvedChallenge() {
        if (rooms.get(currentRoom).containsKey("challenge") && rooms.get(currentRoom).get("solved").equals("false")) {
            return true;
        }

        return false;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

}
