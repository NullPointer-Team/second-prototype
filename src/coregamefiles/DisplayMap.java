package coregamefiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static coregamefiles.GameTextColors.*;


public class DisplayMap {

    private List<String> map;
    private List<List<String>> twoDimensionalMap;
    private List<String> rowOne;
    private String[] sortedRooms;


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

    private String hidden;

    private final String newLine = "\n";
    private final String sideBar = "|";
    private final String twentySpaces = "                        ";
    private final String twentyGreen = "█████████████████████████";
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


        sortedRooms = new String[]{"   Panic Room   ", "     Atrium     ", " Breakfast Nook ", "    Menagerie   ", "  Conservatory  ",
                "   Observatory  ", "   Fire Swamps  ", "      Hall      ", "   Dining Room  ", "     Arcade     ",
                "    Courtyard   ", "     Kitchen    ", "   Laboratory   ", "     Garden     ", "     Library    "};

        rowOne = Arrays.asList(panicRoom, atrium, nook, menagerie, conservatory);
        List<String> rowTwo = Arrays.asList(observatory, fireSwamps, hall, diningRoom, arcade);
        List<String> rowThree = Arrays.asList(courtyard, kitchen, laboratory, garden, library);

        twoDimensionalMap = new ArrayList<List<String>>();

        twoDimensionalMap.add(rowThree);
        twoDimensionalMap.add(rowTwo);
        twoDimensionalMap.add(rowOne);
    }





    public void testprintEntireMap() {
        int i = 0;
        String[] subarray;
        System.out.println(getAnsiGreen());
        while (i < 11) {
            subarray = Arrays.asList(sortedRooms).subList(i, i+5).toArray(new String[0]);
            testprintRow(subarray);
            i+=5;
        }
        testPrintBottomBorder(Arrays.asList(sortedRooms).subList(10, 15).toArray(new String[0]));

        System.out.println(getAnsiReset());
    }

    public void testprintRow(String[] rowOfRooms) {
        int i = 1;
        while (i < 31) {
            String buildNormalString = "";
            int remainder = i % 5;
            String roomName = rowOfRooms[remainder];

            //create Top Border
            if (i < 6) { buildNormalString = buildNormalString + twentyDashes; }

            // create middle Name Plate
            else if ((i > 15) && (i < 21)) { buildNormalString =  printDiscoveredRow_Name(roomName); }

            // create empty space
            else { buildNormalString = buildNormalString + twentySpaces; }

            // add side bar and start new line when reach the end
            if (remainder == 0) { buildNormalString = buildNormalString + sideBar + newLine; }

            // add a Left Side Bar to everything
            buildNormalString = sideBar + buildNormalString;

            String returnValue = roomName.trim().equals("hidden") ? twentyGreen: buildNormalString;

            System.out.printf(returnValue);

            i++;
        }
    }


    public void testPrintBottomBorder(String[] lastRow) {
        int i=1;
        while (i < 6) {
            int remainder = i % 5;
            String roomName = lastRow[remainder];
            String buildNormalString = "";
            //int remainder = i % 5;
            buildNormalString = buildNormalString + sideBar + twentyDashes;

            if (i==5) buildNormalString = buildNormalString + sideBar;

            String returnValue = roomName.trim().equals("hidden") ? twentyGreen: buildNormalString;

            System.out.printf(returnValue);

            i++;
        }
    }




    public void printLastRow(List<String> lastRow) {
        int i=1;
        while (i < 6) {
            String returnValue = "";
            //int remainder = i % 5;
            returnValue = returnValue + sideBar + twentyDashes;

            if (i==5) returnValue = returnValue + sideBar;

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

    public void printEntireMap() {
        int i = 0;
        while (i < 3) {
            printRow(twoDimensionalMap.get(i));
            i++;
        }
        printLastRow(twoDimensionalMap.get(2));
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

    private String printDiscoveredRow_Name(String roomName) {
        return "    " + roomName + "    ";
    }

}
