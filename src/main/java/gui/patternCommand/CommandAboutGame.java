package gui.patternCommand;

import gui.ChessPanel;

public class CommandAboutGame implements ICommand {

    private MenuChessBarListenerActions menuBarListenerActions;
    private ChessPanel panel;

    public CommandAboutGame(ChessPanel panel) {
        this.panel = panel;
        this.menuBarListenerActions = new MenuChessBarListenerActions(this.panel);
    }

    @Override
    public void execute() {
        this.menuBarListenerActions.aboutHandler();
    }
}
