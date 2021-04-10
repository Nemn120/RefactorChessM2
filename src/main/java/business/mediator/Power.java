package business.mediator;

import gui.ChessGraveyard;

import java.awt.*;

public class Power {
    public void turnOn(ChessGraveyard panel,ChessGraveyard panel2){
        panel.setBackground(Color.GRAY);
        panel2.setBackground(Color.GRAY);
    }
    public void turnOff(ChessGraveyard panel,ChessGraveyard panel2){
        panel.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
    }
}
