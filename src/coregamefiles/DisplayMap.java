package coregamefiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static coregamefiles.GameTextColors.*;


public class DisplayMap {

    private List<String> map;
    private List<List<String>> twoDimensionalMap;
    private List<String> rowOne;


    private String atrium;
    private String nook;
    private String menagerie;
    private String conservatory;
    private String panicRoom;

    private String fireSwamps;
    private String hall;
    private String diningRoom;
    private String arcade;
    private String observatory;

    private String kitchen;
    private String laboratory;
    private String garden;
    private String library;
    private String courtyard;

    private final String newLine = "\n";
    private final String sideBar = "|";
    private final String twentySpaces = "                        ";
    private final String twentyGreen = "████████████████████";
    private final String twentyDashes = "----------------------- ";
    private final String singleSpace = " ";

    public DisplayMap() {
        atrium = "     Atrium     ";
        nook = " Breakfast Nook ";
        menagerie = "    Menagerie   ";
        conservatory = "  Conservatory  ";
        panicRoom = "   Panic Room   ";

        fireSwamps = "   Fire Swamps  ";
        hall = "      Hall      ";
        diningRoom = "   Dining Room  ";
        arcade = "     Arcade     ";
        observatory = "   Observatory  ";

        kitchen = "     Kitchen    ";
        laboratory = "   Laboratory   ";
        garden = "     Garden     ";
        library = "     Library    ";
        courtyard = "    Courtyard   ";

        map = Arrays.asList(new String[]{atrium, nook, menagerie, conservatory, panicRoom, fireSwamps, hall, diningRoom, arcade, observatory, kitchen, laboratory, garden, library, courtyard});

        rowOne = Arrays.asList(panicRoom, atrium, nook, menagerie, conservatory);
        List<String> rowTwo = Arrays.asList(observatory, fireSwamps, hall, diningRoom, arcade);
        List<String> rowThree = Arrays.asList(courtyard, kitchen, laboratory, garden, library);

        twoDimensionalMap = new ArrayList<List<String>>();

        twoDimensionalMap.add(rowThree);
        twoDimensionalMap.add(rowTwo);
        twoDimensionalMap.add(rowOne);
    }


    public void printEntireMap() {
        int i = 0;
        while (i < 3) {
            printRow(twoDimensionalMap.get(i));
            i++;
        }
    }

    public void printRow(List<String> rowOfRooms) {
        int i = 1;
        while (i < 31) {
            String returnValue = "";
            int remainder = i % 5;
            if (i < 6) { returnValue = returnValue + twentyDashes; }

            else if ((i > 15) && (i < 21)) { returnValue =  printDiscoveredRow_Name(rowOfRooms.get(remainder)); }

            else { returnValue = returnValue + twentySpaces; }

            if (remainder == 0) { returnValue = returnValue + sideBar + newLine; }

            if (remainder < 5 ) { returnValue = sideBar + returnValue; }

            System.out.printf(returnValue);

            i++;
        }
    }



    public void testMath() {
        int i =1;
        while (i < 16) {
            String remainder = String.valueOf(i % 5);
            System.out.printf(remainder + singleSpace);
            if (i % 5 == 0 ) System.out.printf(newLine);
            i++;
        }
    }


    public void displayMapNames() {
        for (int i = 1; i < map.size() + 1; i++) {
            String room = map.get(i - 1);
            String addOn = i % 5 == 0 ? "\n" : " ";
            System.out.printf(room + addOn);

        }
    }

    public void displayTwoDimensionalMapNames() {

        for (List<String> row : twoDimensionalMap) {
            for (String room: row) {
                System.out.printf(room + " ");
            }
            System.out.printf("\n");
        }
    }



    private String printDiscoveredRow_Name(String roomName) {
        return "    " + roomName + "    ";
    }

}
