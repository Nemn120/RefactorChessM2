package business.mediator;

import gui.ChessGameLog;
import gui.ChessGraveyard;

import javax.swing.*;

public class Fan {
    private Mediator mediator;
    private boolean isOn = false;

    public Fan(){}

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Fan(Mediator mediator) {
        this.mediator = mediator;
    }

    public void turnOn(ChessGraveyard panel, ChessGraveyard panel2){
        mediator.start(panel,panel2);
        isOn = true;
    }

    public void turnOff(ChessGraveyard panel,ChessGraveyard panel2){
        isOn = false;
        mediator.stop(panel,panel2);
    }

    public boolean getIsOn() {
        return isOn;
    }
}
