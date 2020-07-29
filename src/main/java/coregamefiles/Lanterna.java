package coregamefiles;
//CODE SAMPLE -->>>> https://www.programcreek.com/java-api-examples/index.php?api=com.googlecode.lanterna.screen.Screen

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TextColor;
import java.io.IOException;


public class Lanterna {

    private DefaultTerminalFactory defaultTerminalFactory;
    private Terminal terminal;
    private TextGraphics textGraphics;
    private Screen screen;

    public Lanterna() {
        defaultTerminalFactory = new DefaultTerminalFactory();
        terminal = null;

    }




    public void createMap(String room) {
        try {

            terminal = defaultTerminalFactory.createTerminal();
            terminal.enterPrivateMode();
            terminal.clearScreen();
            terminal.setCursorVisible(false);

            textGraphics = terminal.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.ANSI.RED);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

            textGraphics.putString(2, 1, "STRANGER THINGS - MAP", SGR.BOLD);
            terminal.flush();

            textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);
            textGraphics.drawLine(new TerminalPosition(53,3),new TerminalPosition(53,5), '|');
            textGraphics.drawLine(new TerminalPosition(55,3),new TerminalPosition(55,5), '|');
            textGraphics.drawLine(new TerminalPosition(57,3),new TerminalPosition(57,5), '|');
            textGraphics.drawLine(new TerminalPosition(59,3),new TerminalPosition(59,5), '|');
            textGraphics.drawLine(new TerminalPosition(61,3),new TerminalPosition(61,5), '|');
            textGraphics.drawLine(new TerminalPosition(63,3),new TerminalPosition(63,5), '|');

            textGraphics.drawLine(new TerminalPosition(53,2),new TerminalPosition(63,2), '_');
            textGraphics.drawLine(new TerminalPosition(53,6),new TerminalPosition(63,6), '-');

            //textGraphics.drawLine(new TerminalPosition(5,5),new TerminalPosition(5,9), '-');
            terminal.flush();
            //textGraphics.drawLine(new TerminalPosition(3,6),new TerminalPosition(3,13), '-');
            /*
            textGraphics.drawRectangle(new TerminalPosition(3,3), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(12,3), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(21,3), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(30,3), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(39,3), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(3,7), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(12,7), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(21,7), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(30,7), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(39,7), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(3,11), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(12,11), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(21,11), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(30,11), new TerminalSize(10, 5), '*');
            textGraphics.drawRectangle(new TerminalPosition(39,11), new TerminalSize(10, 5), '*');
            terminal.flush();
*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
