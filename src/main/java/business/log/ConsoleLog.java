package business.log;

import java.util.Date;

import javax.swing.JComponent;

/**
 * ConsoleLog
 */
public class ConsoleLog extends JComponent implements Log{

    @Override
    public void addToLog(String s) {

        System.out.println(new Date() + " - " + s );

    }

    @Override
    public void clearLog() {
        //System.out.println("Clear()");
        System.out.print("\033[H\033[2J");

    }

    @Override
    public String getLastLog() {
        // TODO Auto-generated method stub
        return "\nRetornando al pasado!";
    }


}
