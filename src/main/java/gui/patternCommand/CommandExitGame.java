package gui.patternCommand;

import gui.ChessPanel;


public class CommandExitGame implements ICommand{

    private MenuChessBarListenerActions menuBarListenerActions;
    private ChessPanel panel;

    public CommandExitGame(ChessPanel panel) {
        this.panel = panel;
        this.menuBarListenerActions = new MenuChessBarListenerActions(this.panel);
    }

    @Override
    public void execute() {
        this.menuBarListenerActions.exitHandler();
    }
}
