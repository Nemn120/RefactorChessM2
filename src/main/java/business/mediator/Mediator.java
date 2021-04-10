package business.mediator;

import gui.ChessGameLog;
import gui.ChessGraveyard;

import javax.swing.*;

public class Mediator {
    private Fan fan;
    private Power power;
    private Buttons button;

    public Mediator(){}

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public Buttons getButton() {
        return button;
    }

    public void setButton(Buttons button) {
        this.button = button;
    }

    public Mediator(Fan fan, Power power) {
        this.fan = fan;
        this.power = power;
    }

    public void press(ChessGraveyard panel,ChessGraveyard panel2){
        if(fan.getIsOn()){
            fan.turnOff(panel,panel2);
        }
        else{
            fan.turnOn(panel,panel2);
        }
    }

    public void start(ChessGraveyard panel,ChessGraveyard panel2){
        power.turnOn(panel,panel2);
    }

    public void stop(ChessGraveyard panel,ChessGraveyard panel2){
        power.turnOff(panel,panel2);
    }

}
