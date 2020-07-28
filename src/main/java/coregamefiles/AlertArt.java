package coregamefiles;

import static coregamefiles.GameTextColors.getAnsiRed;
import static coregamefiles.GameTextColors.getAnsiReset;

public class AlertArt {

    public static void alert() {
        System.out.println(getAnsiRed() +
                "_________________________________________\n" +
                "                                         \n" +
                " █████  ██      ███████ ██████  ████████ \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "███████ ██      █████   ██████     ██    \n" +
                "██   ██ ██      ██      ██   ██    ██    \n" +
                "██   ██ ███████ ███████ ██   ██    ██    \n" +
                "_________________________________________\n" +
                getAnsiReset());
    }
}
