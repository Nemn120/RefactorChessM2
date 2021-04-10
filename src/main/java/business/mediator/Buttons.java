package business.mediator;

import gui.ChessGraveyard;

public class Buttons {
    private Mediator mediator;

    public Buttons(Mediator mediator) {
        this.mediator = mediator;
    }

    public void press(ChessGraveyard panel, ChessGraveyard panel2){
        mediator.press(panel,panel2);

    }
}
