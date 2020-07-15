package enginefiles;

import playerfiles.ComputerPlayer;
import playerfiles.HumanPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {

    private String currentRoom;
    private ArrayList<String> inventory;
    private Boolean gameOver = false;
    private Scanner input;

    public void playGame() {
        printIntroduction();
        createMap();
        currentRoom = "Dining Room";
        inventory = new ArrayList<String>();
        input = new Scanner(System.in);

        while (!gameOver) {
            showStatus();
            String move = "";
            while (move == "") {
                System.out.println("What do you want to do?");
                move = input.nextLine();
            }

            String[] moves = move.toLowerCase().split("\\s+");

            if (moves[0] == "go") {
                if (rooms.get(currentRoom).containsKey(moves[1])) {
                    currentRoom = moves[1];
                } else {
                    System.out.println("You can\'t go that way!");
                }
            }

            if (moves[0] == "get") {
                if (rooms.get(currentRoom).get("item") == moves[1]) {
                    inventory.add(moves[1]);
                    System.out.println(moves[1] + " acquired!!");
                } else {
                    System.out.println("That item is not available in this room!");
                }
            }

            if (rooms.get(currentRoom).containsKey("monster")) {
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
