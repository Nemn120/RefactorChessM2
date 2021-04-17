package gui;

import business.game.ChessGameEngine;
import business.interceptingfilter.*;
import business.log.Log;
import business.mediator.Buttons;
import business.mediator.Fan;
import business.mediator.Mediator;
import business.mediator.Power;
import gui.board.ChessGameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main panel of the Chess game.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessPanel extends JPanel implements ActionListener {
    private ChessMenuBar menuBar;
    private ChessGameBoard gameBoard;
    //private ChessGameLog gameLog;
    private Log gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    private Fan fan;
    private JButton b;

    private FilterManager filterManager;
    private MultiplayerFilter multiplayerFilter;

    public JButton getB() {
        return b;
    }

    public void setB(JButton b) {
        this.b = b;
    }

    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel() {
        this.setLayout(new BorderLayout());
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        playerOneGraveyard = new ChessGraveyard("Jugador 1 cementerio");
        playerTwoGraveyard = new ChessGraveyard("Jugador 2 cementerio");

        this.add(menuBar, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);

        filterManager = new FilterManager(new Target());
        LogFilter logFilter = new LogFilter();
        filterManager.setFilter(logFilter);
        multiplayerFilter = new MultiplayerFilter();
        filterManager.setFilter(multiplayerFilter);

        Client clientChess = new Client();
        clientChess.setFilterManager(filterManager);
        clientChess.sendRequest();
        gameLog = logFilter.getGamelog();
        this.add( logFilter.getComponent(), BorderLayout.SOUTH);

        this.add(playerOneGraveyard, BorderLayout.WEST);
        this.add(playerTwoGraveyard, BorderLayout.EAST);
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.blue);
        b = new JButton("Cambiar color");
        b.setBounds(0, 500, 50, 50);
        playerOneGraveyard.add(b);
        b.addActionListener(this);
        gameEngine = new ChessGameEngine(gameBoard); // start the game

        menuBar.board=gameBoard;
        if(MultiplayerFilter.getNumberPlayer() != 0){
            if(MultiplayerFilter.getNumberPlayer() == 1){
                getGameEngine().runSocketServer();
            }
            if(MultiplayerFilter.getNumberPlayer() == 2){
                getGameEngine().runSocketClient();
            }
        }

        fan = new Fan();
    }

    /**
     * Gets the appropriate graveyard object for use in other classes.
     *
     * @param whichPlayer the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard(int whichPlayer) {
        if (whichPlayer == 1) {
            return playerOneGraveyard;
        } else if (whichPlayer == 2) {
            return playerTwoGraveyard;
        } else {
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b) {
            Mediator mediator = new Mediator();
            Buttons bn = new Buttons(mediator);
            Power power = new Power();
            fan.setMediator(mediator);
            mediator.setFan(fan);
            mediator.setPower(power);
            bn.press(playerOneGraveyard,playerTwoGraveyard);
        }
    }

    /**
     * Gets the logger object for use in other classes.
     *
     * @return ChessGameLog the ChessGameLog object
     */
    public Log getGameLog() {
        return gameLog;
    }

    /**
     * Gets the board object for use in other classes.
     *
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Gets the game engine object for use in other classes
     *
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine() {
        return gameEngine;
    }

    public MultiplayerFilter getMultiplayerFilter() {
        return multiplayerFilter;
    }
}



