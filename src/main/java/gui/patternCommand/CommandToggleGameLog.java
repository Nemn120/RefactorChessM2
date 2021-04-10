package gui.patternCommand;

import gui.ChessPanel;

public class CommandToggleGameLog implements ICommand{

    private MenuChessBarListenerActions menuBarListenerActions;
    private ChessPanel panel;

    public CommandToggleGameLog(ChessPanel panel) {
        this.panel = panel;
        this.menuBarListenerActions = new MenuChessBarListenerActions(this.panel);
    }

    @Override
    public void execute() {
        this.menuBarListenerActions.toggleGameLogHandler();
    }
}
