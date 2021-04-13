package gui.patternCommand;

import gui.ChessPanel;

public class CommandRestartGame implements ICommand {
    private MenuChessBarListenerActions menuBarListenerActions;
    private ChessPanel panel;

    public CommandRestartGame(ChessPanel panel) {
        this.panel = panel;
        this.menuBarListenerActions = new MenuChessBarListenerActions(this.panel);
    }

    @Override
    public void execute() {
        this.menuBarListenerActions.restartHandler();
    }
}
