package gui;

import business.game.ChessGameEngine;
import business.log.ConsoleLog;
import business.log.FileLog;
import business.log.GameLog;
import business.log.Log;
import business.mediator.Buttons;
import business.mediator.Fan;
import business.mediator.Mediator;
import business.mediator.Power;
import gui.board.ChessGameBoard;
import gui.patternCompositeEntity.InfoAdvanceOfPlayer;

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

    public JButton getB() {
        return b;
    }

    public void setB(JButton b) {
        this.b = b;
    }

    private JButton b;
    private JButton infoPLayer1Button;
    private JButton infoPLayer2Button;

    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel() {
        this.setLayout(new BorderLayout());
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        //gameLog = ChessGameLog.getLogInstance();
        playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
        playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
        this.add(menuBar, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);

        //this.add(gameLog, BorderLayout.SOUTH);
        strategyLogger();

        this.add(playerOneGraveyard, BorderLayout.WEST);
        this.add(playerTwoGraveyard, BorderLayout.EAST);
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.blue);
        b = new JButton("Cambiar color");
        b.setBounds(0, 500, 50, 50);
        createButtonInfoFromPlayer();
        playerOneGraveyard.add(b);
        b.addActionListener(this);
        this.getInfoPLayer1Button().addActionListener(this);
        this.getInfoPLayer2Button().addActionListener(this);
        gameEngine = new ChessGameEngine(gameBoard); // start the game

        menuBar.board=gameBoard;
        fan = new Fan();
    }

    public void createButtonInfoFromPlayer() {
        this.setInfoPLayer1Button(new JButton("Ver progreso"));
        playerOneGraveyard.add(this.getInfoPLayer1Button());
        this.setInfoPLayer2Button(new JButton("Ver progreso"));
        playerTwoGraveyard.add(this.getInfoPLayer2Button());

    }

    public JButton getInfoPLayer1Button() {
        return infoPLayer1Button;
    }

    public void setInfoPLayer1Button(JButton infoPLayer1Button) {
        this.infoPLayer1Button = infoPLayer1Button;
    }

    public JButton getInfoPLayer2Button() {
        return infoPLayer2Button;
    }

    public void setInfoPLayer2Button(JButton infoPLayer2Button) {
        this.infoPLayer2Button = infoPLayer2Button;
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
        InfoAdvanceOfPlayer playerInfo = new InfoAdvanceOfPlayer();

        if (e.getSource() == b) {
            Mediator mediator = new Mediator();
            Buttons bn = new Buttons(mediator);
            Power power = new Power();
            fan.setMediator(mediator);
            mediator.setFan(fan);
            mediator.setPower(power);
            bn.press(playerOneGraveyard,playerTwoGraveyard);
        } else if(e.getSource() == this.getInfoPLayer1Button()) {
            int deadsWhite = playerOneGraveyard.getNumDeadsWhitePiece();
            playerInfo.showJframeInfoPlayer("Player 1", deadsWhite);
        } else if(e.getSource() == this.getInfoPLayer2Button()) {
            int deadsBlack = playerTwoGraveyard.getNumDeadsBlackPiece();
            playerInfo.showJframeInfoPlayer("Player 2", deadsBlack);
        }

    }

    public void strategyLogger(){
        int  i=0;
        do{
            i= Integer.parseInt( JOptionPane.showInputDialog(null, "                       Logs" +
                    "\n1.GameLog              2.ConsoleLog" +
                    "\n                     3.FileLog"));

            if (i == 1) {
                gameLog = new GameLog();
                this.add((GameLog) gameLog, BorderLayout.SOUTH);
            } else if (i == 2) {
                gameLog = new ConsoleLog();
                this.add((ConsoleLog) gameLog, BorderLayout.SOUTH);
            } else if (i == 3) {
                gameLog = new FileLog();
                this.add((FileLog) gameLog, BorderLayout.SOUTH);
            } else {
                JOptionPane.showMessageDialog(null, "Logger no valido!");
            }
        }while(i!= 1 && i!=2 && i!=3);
    }

}



