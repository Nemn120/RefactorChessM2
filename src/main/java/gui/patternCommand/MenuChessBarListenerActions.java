package gui.patternCommand;

import gui.ChessPanel;

import javax.swing.*;
import java.awt.*;

public class MenuChessBarListenerActions {

    public ChessPanel panel;

    public MenuChessBarListenerActions(ChessPanel panel) {
        this.panel = panel;
    }

    public void aboutHandler() {
        JOptionPane.showMessageDialog(
                this.panel,
                "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                        + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT");
    }

    public void restartHandler() {
        (this.panel).getGameEngine().reset();
    }

    public void exitHandler() {
        JOptionPane.showMessageDialog(this.panel, "Thanks for leaving"
                + ", quitter! >:(");
        Component possibleFrame = this.panel;
        while (possibleFrame != null && !(possibleFrame instanceof JFrame)) {
            possibleFrame = possibleFrame.getParent();
        }
        JFrame frame = (JFrame) possibleFrame;
        frame.setVisible(false);
        frame.dispose();
    }

    public void toggleGraveyardHandler() {
        (this.panel).getGraveyard(1).setVisible(
                !(this.panel).getGraveyard(1).isVisible());
        (this.panel).getGraveyard(2).setVisible(
                !(this.panel).getGraveyard(2).isVisible());
    }

    public void toggleGameLogHandler() {
        (this.panel).getGameLog().setVisible(
                !(this.panel).getGameLog().isVisible());
        (this.panel).revalidate();
    }


}
