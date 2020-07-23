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
import music.Music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static coregamefiles.GameTextColors.*;


public class GameEngine {

    /************************
     ************************
     *THESE ARE OUR FIELDS
     ************************
     ************************/
    private String currentRoom;
    private ArrayList<String> inventory;
    private ArrayList<String> userLocationTrack;
    private ArrayList<String> userGetObject;
    private ArrayList<String> userUsedObject;
    private Boolean gameOver;
    private Boolean gameWon;
    private Integer guesses;
    private Boolean isPlayerMobile;
    private Scanner input;
    private GameMap gameMap;
    private Map<String, HashMap<String, String>> rooms;
//    private String userLocationTrack[]  = {};

//    private String userGetObject[]  = {};
//    private String userUsedObject[]  = {};


    /************************
     ************************
     * CONSTRUCTOR
     ************************
     ************************/
    public GameEngine() {
        gameOver = false;
        guesses = 3;
        isPlayerMobile = true;
        gameMap = new GameMap();
        rooms = gameMap.getRooms();
        setCurrentRoom("Atrium");
        inventory = new ArrayList<String>();
        userLocationTrack = new ArrayList<String>();
        userGetObject = new ArrayList<String>();
        userUsedObject= new ArrayList<String>();
        input = new Scanner(System.in);
    }


    /************************
     ************************
     * BUSINESS METHODS
     * **********************
     ************************/
    //do you like to play games?
    //the here's the actual playGame method that... plays the game
    public void playGame() throws Exception {
        GameIntroduction.gameInformation();

        while (!gameOver) {
            showStatus();
            String[] moves = getUserCommand();
            validateAndExecuteUserCommand(moves);
            checkIfGameOver();
        }

        terminateGame();
    }

    //did you done gone and done won? or is you dead, and is you done?
    public void checkIfGameOver() {
        if (rooms.get("Kitchen").get("solved").equals("true")) {
            gameWon = true;
            gameOver = true;
        }

        if ((roomHasUnsolvedChallenge() && getInventory().isEmpty()) || (guesses < 1)){
            listChallengeIfAny();
            gameWon = false;
            gameOver = true;
        }

    }



    // getchyo win or lose art here
    public void terminateGame() throws Exception {
        if (gameWon) {
            WinLoseTextArt.winArt();
            //if User win winner Music will be played
            Music.win();
        } else {
            WinLoseTextArt.loseArt();
            //If user lose, teasing music will be played
            Music.loseMusic();
        }
        PlayAgainPrompt.playAgain();
    }

    public void validateAndExecuteUserCommand(String[] moves) {
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
        if (rooms.get(getCurrentRoom()).containsKey("item") && !roomHasUnsolvedChallenge()) {
            System.out.println("Inside this room you can find a " + getAnsiRed() + getAnsiBold() + getAnsiUnderscore() + rooms.get(getCurrentRoom()).get("item") + getAnsiReset());
        }
    }

    //this widget tells you if you fight or die!!!
    public void listChallengeIfAny() {
        if (roomHasUnsolvedChallenge()) {
            AlertArt.alert();
            String challengeInstruction = getInventory().isEmpty()
                    ? "And you don't have anything in your inventory to fight it with."
                    : "You must defeat this challenge before you can continue your journey!";

            System.out.println(getAnsiRed() + "Oh no!! The " +
                    getCurrentRoom() + " has a " +
                    rooms.get(getCurrentRoom()).get("challenge") + ".\n" +
                    challengeInstruction + getAnsiReset());
        }
    }

    // This url key comes from GamMap
    public void playMusicIfUrl() throws Exception {
        if (rooms.get(getCurrentRoom()).containsKey("url")) {
            Music.monster(rooms.get(getCurrentRoom()).get("url"));
        }
        else if (rooms.get(getCurrentRoom()).containsKey("url")){
            Music.atriumMusic(rooms.get(getCurrentRoom()).get("url"));

        }
        else if (rooms.get(getCurrentRoom()).containsKey("url")){
            Music.fireMusic(rooms.get(getCurrentRoom()).get("url"));
        }
        else if (rooms.get(getCurrentRoom()).containsKey("url")){
            Music.gardenMusic(rooms.get(getCurrentRoom()).get("url"));
        }
        else if (rooms.get(getCurrentRoom()).containsKey("url")){
            Music.fireSwampMusic(rooms.get(getCurrentRoom()).get("url"));

        }
        else if(rooms.get(getCurrentRoom()).containsKey("url")){
            Music.panicMusic(rooms.get(getCurrentRoom()).get("url"));
        }
    }

    //this here fella uses an item or not
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

        String challengeSolution = rooms.get(getCurrentRoom()).get("solution").toLowerCase();
        if (challengeSolution.equals(item.toLowerCase())) {
            greatSuccess();
            System.out.println("You solved the challenge! Continue on your quest");
            rooms.get(getCurrentRoom()).replace("solved", "true");
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
        if (rooms.get(getCurrentRoom()).get("item").toLowerCase().equals(commandArgument.toLowerCase())) {
            inventory.add(commandArgument);
            inventory.add(userGetObject);
            rooms.get(currentRoom).remove("item");
            System.out.println(commandArgument + " acquired!!");
        } else {
            System.out.println("A " + commandArgument + " is not available in this room!");
        }
    }

    //this dude lets you move room-to-room
    public void moveToRoom(String command) {
        if (rooms.get(getCurrentRoom()).containsKey(command.toLowerCase()) && isPlayerMobile) {
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
        System.out.println("You are in the "+ getCurrentRoom());
        listItem();
        listChallengeIfAny();
        showInventory();
        System.out.println("For game rules, type \"rules\"");
        System.out.println(" -------------------- ");
    }

    //what's in the box?! What's in the box?!
    void showInventory() {
        if (getInventory().isEmpty()) {
            System.out.println("You have " + getAnsiUnderscore() + getAnsiBold() + "nothing" + getAnsiReset() + " in your inventory");
        } else {
            System.out.println("In your inventory, you have:     ");
            for (String item: inventory) {
                System.out.println("      - a " + item);
            }
        }
    }

    public Boolean roomHasUnsolvedChallenge() {
        return rooms.get(getCurrentRoom()).containsKey("challenge") && rooms.get(getCurrentRoom()).get("solved").equals("false");
    }

    /************************
     ************************
     * GETTERS & SETTERS
     ************************
     ************************/
    //retrieve rules from GameRules for above case: "rules"
    public void getRules() {
        GameRules.printRules();
    }

    //pretty obvs, this here method gets the current room
    public String getCurrentRoom(){
        return currentRoom;
    }

    //gotta set the new room somehow
    public void setCurrentRoom(String currentRoom)  {
        this.currentRoom = currentRoom;
        isPlayerMobile = !roomHasUnsolvedChallenge();
    }

    //getchyo inventory
    public ArrayList<String> getInventory() {
        return inventory;
    }

    //setchyo inventory
    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    //getchyo guesses
    public Integer getGuesses() {
        return guesses;
    }

    //getchyo gameOver
    public Boolean getGameOver() {
        return gameOver;
    }

    //setchyo gameOver
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    //getchyo isPlayerMobile
    public Boolean getPlayerMobile() {
        return isPlayerMobile;
    }

    //room getter gets room
    public Map<String, HashMap<String, String>> getRooms() {
        return rooms;
    }

    //great success!
    public void greatSuccess() {
        GreatSuccessArt.success();
    }

}
