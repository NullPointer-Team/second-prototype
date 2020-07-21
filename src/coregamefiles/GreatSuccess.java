package coregamefiles;

import static coregamefiles.GameTextColors.*;

public class GreatSuccess {
    public static void success() {
        System.out.println(getAnsiGreen() +
                "\n" +
                " ██████  ██████  ███████  █████  ████████                    \n" +
                "██       ██   ██ ██      ██   ██    ██                       \n" +
                "██   ███ ██████  █████   ███████    ██                       \n" +
                "██    ██ ██   ██ ██      ██   ██    ██                       \n" +
                " ██████  ██   ██ ███████ ██   ██    ██                       \n" +
                "                                                             \n" +
                "                                                             \n" +
                "███████ ██    ██  ██████  ██████ ███████ ███████ ███████     \n" +
                "██      ██    ██ ██      ██      ██      ██      ██          \n" +
                "███████ ██    ██ ██      ██      █████   ███████ ███████     \n" +
                "     ██ ██    ██ ██      ██      ██           ██      ██     \n" +
                "███████  ██████   ██████  ██████ ███████ ███████ ███████     \n" +
                "                                                             \n" +
                getAnsiReset());
    }
}
