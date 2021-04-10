package business.mediator;

import gui.ChessGameLog;
import gui.ChessGraveyard;

import javax.swing.*;
import java.awt.*;

public class Power {
    public void turnOn(ChessGraveyard panel,ChessGraveyard panel2) {
        panel.setBackground(Color.BLACK);
        panel2.setBackground(Color.BLACK);
        panel.name.setForeground(Color.WHITE);
        panel2.name.setForeground(Color.WHITE);
    }
    public void turnOff(ChessGraveyard panel,ChessGraveyard panel2){
        panel.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel.name.setForeground(Color.BLACK);
        panel2.name.setForeground(Color.BLACK);
    }
}
