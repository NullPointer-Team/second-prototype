package coregamefiles;

import static coregamefiles.GameTextColors.*;

public class GreatSuccessArt {
    public static void success() {
        System.out.println(getAnsiGreen() +
                "\n" +
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
                getAnsiReset());
    }
}
