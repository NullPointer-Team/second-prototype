package coregamefiles;

import static coregamefiles.GameTextColors.*;

public class GreatSuccessArt {
    public static void success() {
        System.out.println(getAnsiGreen() +
                "_____________________________________________________________\n" +
                "                                                             \n" +
                " ██████  ██████  ███████  █████  ████████                    \n" +
                "██       ██   ██ ██      ██   ██    ██                       \n" +
                "██   ███ ██████  █████   ███████    ██                       \n" +
                "██    ██ ██   ██ ██      ██   ██    ██                       \n" +
                " ██████  ██   ██ ███████ ██   ██    ██                       \n" +
                "                                                             \n" +
                "███████ ██    ██  ██████  ██████ ███████ ███████ ███████     \n" +
                "██      ██    ██ ██      ██      ██      ██      ██          \n" +
                "███████ ██    ██ ██      ██      █████   ███████ ███████     \n" +
                "     ██ ██    ██ ██      ██      ██           ██      ██     \n" +
                "███████  ██████   ██████  ██████ ███████ ███████ ███████     \n" +
                "                                                             \n" +
                "_____________________________________________________________\n" +
                getAnsiReset());
    }
}
