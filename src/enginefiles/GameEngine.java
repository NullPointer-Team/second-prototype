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
    private static String currentRoom;
    private ArrayList<String> inventory;
    private Boolean gameOver;
    private Boolean gameWon;
    private Integer guesses;
    private Scanner input;
    private GameMapHashMap gameMapHashMap;
    private Map<String, HashMap<String, String>> rooms;


    /************************
     ************************
     * CONSTRUCTOR
     ************************
     ************************/
    public GameEngine() {
        gameOver = false;
        guesses = 3;
        gameMapHashMap = new GameMapHashMap();
        rooms = gameMapHashMap.getRooms();
        setCurrentRoom("Atrium");
        inventory = new ArrayList<String>();
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
            //playMusicIfAvailable();
            solveChallengeOrExplore();
            checkIfGameOver();
        }

        terminateGame();
    }


    /************************
     ************************
     * SHOW STATUS & HELPER METHODS
     ************************
     ************************/
    //lets you know what's what
    void showStatus() {
        System.out.println(" -------------------- ");
        System.out.println("You are in the "+ getCurrentRoom());
        listItemIfAvailable();
        listChallengeIfAny();
        showInventory();
        System.out.println("For game rules, type \"rules\"");
        System.out.println(" -------------------- ");
    }

    //this little guy tells you when there's an item in the room
    public void listItemIfAvailable() {
        if (rooms.get(getCurrentRoom()).containsKey("item") && !roomHasUnsolvedChallenge()) {
            System.out.println("Inside this room you can find a " + getAnsiRed() + getAnsiBold() + getAnsiUnderscore() + rooms.get(getCurrentRoom()).get("item") + getAnsiReset());
        }
    }

    public Boolean roomHasUnsolvedChallenge() {
        return rooms.get(getCurrentRoom()).containsKey("challenge") && rooms.get(getCurrentRoom()).get("solved").equals("false");
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


    /************************
     ************************
     * SOLVE OR EXPLORE METHOD
     ************************
     ************************/
    public void solveChallengeOrExplore() {
        if (roomHasUnsolvedChallenge()) {
            solveChallenge();
        } else {
            exploreRoom();
        }
    }


    /************************
     ************************
     * SOLVE CHALLENGE & HELPER METHODS
     ************************
     ************************/

    public void solveChallenge() {

            while (getGuesses() > 0 && rooms.get(getCurrentRoom()).get("solved").equals("false")) {
                String[] moves = getUserCommand();
                validateUserChallengeSolution(moves);
            }
    }

    public void validateUserChallengeSolution(String[] moves) {
        String command = moves[0].toLowerCase();
        String item = moves.length > 1 ? moves[1] : " ";

        switch(command) {
            case "go":
                System.out.println("You can't leave the room until you solve the challenge!");
                break;
            case "get":
                System.out.println("You can't acquire new items until you solve the challenge!");
                break;
            case "use":
                processChallengeAttempt(item);
                break;
            case "escape":
                //method that returns them to previoius room?
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

    //it's time to fight!
    public void processChallengeAttempt(String item) {

        String challengeSolution = rooms.get(getCurrentRoom()).get("solution").toLowerCase();

        if (challengeSolution.equals(item.toLowerCase())) {
            processSolvedChallenged();
        } else {
            processFailedChallengeAttempt(item);
        }
    }

    public void processSolvedChallenged() {
        greatSuccess();
        System.out.println("You solved the challenge! Continue on your quest");
        rooms.get(getCurrentRoom()).replace("solved", "true");
        setGuesses(3);
        showStatus();
    }

    public void processFailedChallengeAttempt(String item) {
        diminishGuessesByOne();
        String itemFailedStatement = isItemInInventory(item) ?
                "Using the " + item + " has no effect!" :
                "You don\'t even have " + item + " in your inventory to use!";

        System.out.println(itemFailedStatement);
        System.out.println("You have " + getGuesses() + " guesses left. Try again!");
    }

    /************************
     ************************
     * EXPLORE ROOM & HELPER METHODS
     ************************
     ************************/

    public void exploreRoom() {
        String[] moves = getUserCommand();
        validateAndExecuteUserCommand(moves);
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
                printCantUseItem(commandArgument);
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

    /************************
     ************************
     * VALIDATE & EXECUTE USER COMMAND & HELPER METHODS
     ************************
     ************************/
    //this dude lets you move room-to-room
    public void moveToRoom(String command) {
        if (rooms.get(getCurrentRoom()).containsKey(command.toLowerCase())) {
            setCurrentRoom(rooms.get(currentRoom).get(command));
        } else {
            System.out.println("You can't go that way!");
        }
    }

    //get the thing
    public void acquireItem(String item) {
        if (rooms.get(getCurrentRoom()).get("item").toLowerCase().equals(item.toLowerCase())) {
            inventory.add(item);
            rooms.get(currentRoom).remove("item");
            System.out.println(item + " acquired!!");
        } else {
            System.out.println("A " + item + " is not available in this room!");
        }
    }

    //this here fella uses an item or not
    public void printCantUseItem(String item) {
        String outputString = isItemInInventory(item) ?
                "There is nothing to use your " + item + " on. Continue to explore the maze." :
                "You don\'t have that item in your inventory!";

        System.out.println(outputString);
    }

    //do you have it in your satchel?
    public Boolean isItemInInventory(String item) {
        return inventory.contains(item);
    }


    /************************
     ************************
     * CHECK IF GAME IS OVER
     ************************
     ************************/
    //did you done gone and done won? or is you dead, and is you done?
    public void checkIfGameOver() {

        if (rooms.get("Kitchen").get("solved").equals("true")) {
            setGameWon();
            setGameOver();
        }

        if ((roomHasUnsolvedChallenge() && getInventory().isEmpty()) || (guesses < 1)){
            setGameLost();
            setGameOver();
        }

    }

    /************************
     ************************
     * TERMINATE GAME
     ************************
     ************************/

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

    /************************
     ************************
     * PLAY MUSIC
     ************************
     ************************/
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

    public void playMusicIfAvailable() throws Exception {

        if (rooms.get(getCurrentRoom()).containsKey("url")) {
            String urlToMusicFile = rooms.get(getCurrentRoom()).get("url");
            Music.playMusicIfAvailable(urlToMusicFile);
        }

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
    public static String getCurrentRoom() {
        return currentRoom;
    }

    //gotta set the new room somehow
    public void setCurrentRoom(String currentRoom)  {
        GameEngine.currentRoom = currentRoom;
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

    public void diminishGuessesByOne() { guesses = guesses - 1; }


    //getchyo gameOver
    public Boolean getGameOver() {
        return gameOver;
    }

    //setchyo gameOver
    public void setGameOver() {
        this.gameOver = true;
    }


    public void setGameWon() {
        this.gameWon = true;
    }

    public void setGameLost() {
        this.gameWon = false;
    }

    //room getter gets room
    public Map<String, HashMap<String, String>> getRooms() {
        return rooms;
    }

    //great success!
    public void greatSuccess() {
        GreatSuccessArt.success();
    }

    public void setGuesses(Integer guesses) {
        this.guesses = guesses;
    }

}
