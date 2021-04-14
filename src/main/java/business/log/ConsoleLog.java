package business.log;

import java.util.Date;

import javax.swing.JComponent;

/**
 * ConsoleLog
 */
public class ConsoleLog extends JComponent implements Log{

    public String message="";

    @Override
    public void addToLog(String s) {

        message=message+new Date() + " - " + s+"\n";

        System.out.println(new Date() + " - " + s );

    }

    @Override
    public void clearLog() {
        message="";
        //System.out.println("Clear()");
        System.out.print("\033[H\033[2J");

    }

    @Override
    public String getLastLog() {
        // TODO Auto-generated method stub
        return "Retornando al pasado!";
    }

    public String toString(){
        return message;
    }
    public void clear(){
        message=new Date() +" - A new chess game has been started. Player 1 (white) will play against Player 2 (black). BEGIN!"+"\n";
    }
}
