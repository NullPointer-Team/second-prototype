package coregamefiles;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static coregamefiles.GameTextColors.*;


public class DisplayMap {

    private final List<String> standardRoomList = new ArrayList<String>(Arrays.asList(
            "Panic Room",
            "Atrium",
            "Breakfast Nook",
            "Menagerie",
            "Conservatory",
            "Observatory",
            "Fire Swamps",
            "Hall",
            "Dining Room",
            "Arcade",
            "Courtyard",
            "Kitchen",
            "Laboratory",
            "Garden",
            "Library"));

    private final List<String> formattedRoomList = new ArrayList<String>(Arrays.asList(
                    "       Panic Room       ",
                    "         Atrium         ",
                    "     Breakfast Nook     ",
                    "        Menagerie       ",
                    "      Conservatory      ",

                    "       Observatory      ",
                    "       Fire Swamps      ",
                    "          Hall          ",
                    "       Dining Room      ",
                    "         Arcade         ",

                    "        Courtyard       ",
                    "         Kitchen        ",
                    "       Laboratory       ",
                    "         Garden         ",
                    "         Library        "));

    private final String newLine = "\n";
    private final String sideBar = "|";
    private final String twentySpaces = "                        ";
    private final String twentyGreen = "█████████████████████████";
    private final String twentyDashes = "----------------------- ";
    private final String singleSpace = " ";


    public void printMap(List<String> visitedRooms) {

        List<String> filteredArray = new ArrayList<String>();

         for (int i = 0; i < 15; i++) {
            String formattedVisitedRoom = visitedRooms.contains(standardRoomList.get(i)) ? formattedRoomList.get(i) : "hidden";
            filteredArray.add(formattedVisitedRoom);
        }

        String[] modifiedArray = filteredArray.toArray(new String[0]);
        printFilteredRoomArray(modifiedArray);
    }


    public void printFilteredRoomArray(String[] filteredRoomList) {
        int i = 0;
        System.out.println(getAnsiGreen());

        while (i < 11) {
            String[] subarray = Arrays.asList(filteredRoomList).subList(i, i+5).toArray(new String[0]);
            printRow(subarray);
            i+=5;
        }

        printBottomBorder(Arrays.asList(filteredRoomList).subList(10, 15).toArray(new String[0]));
        System.out.println(getAnsiReset());
    }

    public void printRow(String[] rowOfRooms) {
        int i = 1;
        while (i < 31) {
            String buildNormalString = "";
            int remainder = i % 5;
            String roomName = rowOfRooms[remainder];

            //create Top Border
            if (i < 6) { buildNormalString = buildNormalString + twentyDashes; }

            // create middle Name Plate
            else if ((i > 15) && (i < 21)) { buildNormalString =  roomName; }

            // create empty space
            else { buildNormalString = buildNormalString + twentySpaces; }

            // add a Left Side Bar to everything
            buildNormalString = sideBar + buildNormalString;

            // add a Right Side Bar if at the end of Row
            if (remainder == 0) { buildNormalString = buildNormalString + sideBar; }

            // check if Room name is "hidden", if so, set return string to line of boxes
            String returnValue = roomName.equals("hidden") ? twentyGreen: buildNormalString;

            // add side new line when reach the end
            if (remainder == 0) returnValue = returnValue + newLine;

            //print the row chunk
            System.out.printf(returnValue);

            i++;
        }
    }


    public void printBottomBorder(String[] lastRow) {
        int i=1;
        while (i < 6) {
            int remainder = i % 5;
            String roomName = lastRow[remainder];
            String buildNormalString = "";

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

            /*
            NEED TO WRITE SOME TESTS!!


        DisplayMap displayMap = new DisplayMap();

        List<String> visitedRooms = new ArrayList<String>();
        visitedRooms.add("Atrium");

        visitedRooms.add("Kitchen");
        visitedRooms.add("Fire Swamps");
        visitedRooms.add("Menagerie");
        visitedRooms.add("Courtyard");
        visitedRooms.add("Panic Room");

        visitedRooms.add("Breakfast Nook");
        visitedRooms.add("Observatory");
        visitedRooms.add("Library");
        visitedRooms.add("Garden");
        visitedRooms.add("Laboratory");
        visitedRooms.add("Conservatory");
        visitedRooms.add("Hall");
        visitedRooms.add("Dining Room");
        visitedRooms.add("Arcade");

        displayMap.printMap(visitedRooms);
*/



}
