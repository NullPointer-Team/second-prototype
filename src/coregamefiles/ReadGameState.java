package coregamefiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadGameState {

    //TODO: implement try/catch and custom exception to notify player when there is no saved game information;
    ///there will be at least a new blank game; this custom exception may be unnecessary – or at least, all we need to know
    //is when it can't load the saveGame.txt file for some reason. even a blank savedGame will play as a new game at beginning
    //loadData method loads saved state data
    public static void getGameState() {
        try {
            BufferedReader getGameState = new BufferedReader(new FileReader("saveGame.txt"));
            //TODO: create Boolean.parseBoolean(gameState.readLine()) for each room visit bool
            //consider breaking this method out and creating a new class file to store this in
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
