package business.mediator;

import gui.ChessGameLog;
import gui.ChessGraveyard;

import javax.swing.*;
import java.awt.*;

public class Power {
    public void turnOn(ChessGraveyard panel,ChessGraveyard panel2, ChessGameLog log){
        panel.setBackground(Color.GRAY);
        panel2.setBackground(Color.GRAY);
        log.setBackground(Color.GRAY);
        log.textArea.setBackground(Color.GRAY);
    }
    public void turnOff(ChessGraveyard panel,ChessGraveyard panel2, ChessGameLog log){
        panel.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        log.setBackground(Color.GRAY);
        log.textArea.setBackground(Color.WHITE);
    }
}
