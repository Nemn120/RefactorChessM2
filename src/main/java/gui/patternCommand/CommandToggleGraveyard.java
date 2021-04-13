package gui.patternCommand;

import gui.ChessPanel;

public class CommandToggleGraveyard implements ICommand {

    private MenuChessBarListenerActions menuBarListenerActions;
    private ChessPanel panel;

    public CommandToggleGraveyard(ChessPanel panel) {
        this.panel = panel;
        this.menuBarListenerActions = new MenuChessBarListenerActions(this.panel);
    }

    @Override
    public void execute() {
        this.menuBarListenerActions.toggleGraveyardHandler();
    }

}
