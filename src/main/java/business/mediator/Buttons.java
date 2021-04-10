package business.mediator;

import gui.ChessGameLog;
import gui.ChessGraveyard;

import javax.swing.*;

public class Buttons {
    private Mediator mediator;

    public Buttons(Mediator mediator) {
        this.mediator = mediator;
    }

    public void press(ChessGraveyard panel, ChessGraveyard panel2, ChessGameLog log){
        mediator.press(panel,panel2,log);

    }
}
