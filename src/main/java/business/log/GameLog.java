package business.log;

import javax.swing.*;
import java.util.Date;
// -------------------------------------------------------------------------

/**
 * A scrollable textArea representing the game log. (i.e. moves made by each
 * player)
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class GameLog extends JScrollPane implements Log {

    public String message="";

    private JTextArea textArea;

    /**
     * Create a new ChessGameLog object.
     */
    public GameLog() {
        super(
                new JTextArea("", 5, 30),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea = ((JTextArea) this.getViewport().getView());
    }

    private static gui.ChessGameLog logInstance;

    public static gui.ChessGameLog getLogInstance() {
        if(logInstance == null){
            logInstance = new gui.ChessGameLog();
        }
        return logInstance;
    }

    /**
     * Adds a new line of text to the log.
     *
     * @param s the line of text to add
     */
    public void addToLog(String s) {

        message=message+new Date() + " - " + s+"\n";

        if (textArea.getText().length() > 0) {
            textArea.setText(textArea.getText() + "\n" + new Date() + " - "
                    + s);
        } else {
            textArea.setText(new Date() + " - " + s);
        }
    }

    /**
     * Clears the log.
     */
    public void clearLog() {
        textArea.setText("");

    }

    /**
     * Gets the most recent statement added to the log.
     *
     * @return String the most recent log statement
     */
    public String getLastLog() {

        int indexOfLastNewLine = textArea.getText().lastIndexOf("\n");
        if (indexOfLastNewLine < 0) {
            return textArea.getText();
        }
        return textArea.getText().substring(indexOfLastNewLine + 1);
    }

    public String toString(){
        return message;
    }

    public void clear() {
        message = new Date() +" - A new chess game has been started. Player 1 (white) will play against Player 2 (black). BEGIN!"+"\n";
    }

}
