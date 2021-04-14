package gui;

import business.log.GameLog;
import business.memento.Caretaker;
import business.memento.Originator;
import gui.board.BoardSquare;
import gui.board.ChessGameBoard;
import gui.patternCommand.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the north menu-bar that contains various controls for the game.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessMenuBar extends JMenuBar {

    private int PORT = 50000;
    public ChessGameBoard board;
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    /**
     * Create a new ChessMenuBar object.
     */
    public ChessMenuBar() {



        String[] menuCategories = {"File", "Options","Partida", "Help"};
        String[] menuItemLists =
                {"New game/restart,Exit", "Toggle graveyard,Toggle game log","Activar,Unirse,Guardar,Restaurar",
                        "About"};
        for (int i = 0; i < menuCategories.length; i++) {
            JMenu currMenu = new JMenu(menuCategories[i]);
            String[] currMenuItemList = menuItemLists[i].split(",");
            for (int j = 0; j < currMenuItemList.length; j++) {
                JMenuItem currItem = new JMenuItem(currMenuItemList[j]);
                currItem.addActionListener(new MenuListener());
                currMenu.add(currItem);
            }
            this.add(currMenu);
        }
    }

    /**
     * Listener for the north menu bar.
     *
     * @author Ben Katz (bakatz)
     * @author Myles David II (davidmm2)
     * @author Danielle Bushrow (dbushrow)
     * @version 2010.11.17
     */
    private class MenuListener implements ActionListener {

        /**
         * Takes an appropriate action based on which menu button is clicked
         *
         * @param event the mouse event from the source
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            ChessMenuBarInvoker invoker = new ChessMenuBarInvoker();
            ChessPanel parentChessPanel = (ChessPanel) getParent();

            String buttonName = ((JMenuItem) event.getSource()).getText();
            if (buttonName.equals("About")) {
                invoker.executeCommand(new CommandAboutGame(parentChessPanel));
            } else if (buttonName.equals("New game/restart")) {
                invoker.executeCommand(new CommandRestartGame(parentChessPanel));
            } else if (buttonName.equals("Toggle game log")) {
                toggleGameLogHandler();
                //invoker.executeCommand(new CommandToggleGameLog(parentChessPanel));
            } else if (buttonName.equals("Exit")) {
                invoker.executeCommand(new CommandExitGame(parentChessPanel));
            } else if (buttonName.equals("Guardar")) {

                originator.setEstado(board.getChessCells());
                caretaker.addMemento(originator.guardar());

                System.out.println("------------GUARDADO--------------");
                viewBoard(board.getChessCells());

                JOptionPane.showMessageDialog(null,"Tablero Guardado.");

            } else if (buttonName.equals("Restaurar")) {

                    int index=Integer.parseInt(JOptionPane.showInputDialog("Versiones disponibles: "+caretaker.getMementos().size()));
                    if(0<index && index <=caretaker.getMementos().size()) {
                        originator.restaurar(caretaker.getMemento(index - 1));
                        BoardSquare[][] temp = originator.getEstado();

                        System.out.println("------------RESTAURADO--------------");
                        viewBoard(temp);

                        restaurarGame(temp);

                        JOptionPane.showMessageDialog(null,"Version "+index+" restaurada.");

                    }else{
                        JOptionPane.showMessageDialog(null,"Version no disponible.");
                    }

            } else {
                if(buttonName.equals("Activar")){
                    System.out.println("ACTIVADO");

                    parentChessPanel.getGameEngine().runSocketServer();
                    JOptionPane.showMessageDialog( null,"Escuchado puerto: " + PORT);
                }else{
                    if(buttonName.equals("Unirse")){
                        String ipSelect = JOptionPane.showInputDialog("Ingrese IP a conectarse");
                        if(ipSelect != null){
                            parentChessPanel.getGameEngine().runSocketClient(ipSelect);
                            JOptionPane.showMessageDialog( null,"Conectando al puerto: " + PORT);
                        }
                    }else{
                        invoker.executeCommand(new CommandToggleGraveyard(parentChessPanel));
                    }
                }

            }
        }
    }

    /**
     * Takes an appropriate action if the about button is clicked.
     */
    private void aboutHandler() {
        JOptionPane.showMessageDialog(
                this.getParent(),
                "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                        + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT");
    }

    /**
     * Takes an appropriate action if the restart button is clicked.
     */
    public void restartHandler() {
        ((ChessPanel) this.getParent()).getGameEngine().reset();
    }

    private void restaurarGame(BoardSquare[][] boardSquare) {
        ((ChessPanel) this.getParent()).getGameEngine().restaurar(boardSquare);
    }

    /**
     * Takes an appropriate action if the exit button is clicked.
     * Uses Tony Allevato's code for exiting a GUI app without System.exit()
     * calls.
     */
    /*public void exitHandler() {
        JOptionPane.showMessageDialog(this.getParent(), "Thanks for leaving"
                + ", quitter! >:(");
        Component possibleFrame = this;
        while (possibleFrame != null && !(possibleFrame instanceof JFrame)) {
            possibleFrame = possibleFrame.getParent();
        }
        JFrame frame = (JFrame) possibleFrame;
        frame.setVisible(false);
        frame.dispose();
    }*/

    /**
     * Takes an appropriate action if the toggle graveyard button is clicked.
     */
    /*public void toggleGraveyardHandler() {
        ((ChessPanel) this.getParent()).getGraveyard(1).setVisible(
                !((ChessPanel) this.getParent()).getGraveyard(1).isVisible());
        ((ChessPanel) this.getParent()).getGraveyard(2).setVisible(
                !((ChessPanel) this.getParent()).getGraveyard(2).isVisible());
    }*/

    private void toggleGameLogHandler() {
        if (((ChessPanel) this.getParent()).getGameLog() instanceof GameLog) {

            ((GameLog) ((ChessPanel) this.getParent()).getGameLog())
                    .setVisible(!((GameLog) ((ChessPanel) this.getParent()).getGameLog()).isVisible());
            ((ChessPanel) this.getParent()).revalidate();
        }
    }

    public  void viewBoard(BoardSquare[][] board){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getPieceOnSquare()!=null){
                    System.out.print(" "+1);
                }else {
                    System.out.print(" "+0);
                }

            }
            System.out.println("");
        }
    }

}
