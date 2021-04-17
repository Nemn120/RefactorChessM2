package gui;

import business.observer.BlackPieces;
import business.observer.Observable;
import business.observer.Referee;
import business.observer.WhitePieces;
import business.pieces.ChessGamePiece;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the graveyard where pieces lie after being captured.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessGraveyard extends JPanel {

    public static final String PLAYER1_GRAVEYARD = "Jugador 1 cementerio";
    public static final String PLAYER2_GRAVEYARD = "Jugador 2 cementerio";
    private String title;
    //private WhitePieces wp = new WhitePieces();
    //private Referee bascunian = new Referee(wp);
    private Observable wp;
    private Referee bascunian;
    public JLabel name;
    private int numDeadsBlackPiece = 0;
    private int numDeadsWhitePiece = 0;

    /**
     * Create a new ChessGraveyard object.
     *
     * @param title the title of the graveyard
     */
    public ChessGraveyard(String title) {
        this.title = title;
        name = new JLabel(title);
        this.add(name);
        this.setLayout(new GridLayout(8, 0));
        if(PLAYER1_GRAVEYARD.equals(this.title)){
            this.wp = new WhitePieces();
            this.bascunian = new Referee(wp);
            this.wp.attach(bascunian);
        }
        if(PLAYER2_GRAVEYARD.equals(this.title)){
            this.wp = new BlackPieces();
            this.bascunian = new Referee(wp);
            this.wp.attach(bascunian);
        }

    }

    /**
     * Adds a piece to the graveyard.
     *
     * @param piece the GamePiece to add
     */
    public void addPiece(ChessGamePiece piece) {
        piece.setPieceLocation(-1, -1);

        if(piece.getColorOfPiece().getColor()==1){
            ((WhitePieces) this.wp).addNewDeadPiece(piece);
            numDeadsWhitePiece = numDeadsWhitePiece + 1;
        }
        if(piece.getColorOfPiece().getColor()==0){
            ((BlackPieces) this.wp).addNewDeadPiece(piece);
            //this.setNumDeadsBlackPiece(this.getNumDeadsBlackPiece() + 1);
            numDeadsBlackPiece = numDeadsBlackPiece + 1;
        }
        JLabel pieceLabel = new JLabel();
        pieceLabel.setIcon(piece.getImage());
        this.add(pieceLabel);
    }

    public int quiereRendirse(int currentPlayer){
        int rendirse = 3;
        if(this.getBascunian().getDeadPieces()>10){ // CAMBIAR PARA RENDIRSE
            rendirse=JOptionPane.showConfirmDialog(null, "Quieres rendirte jugador " + currentPlayer + "?");
        }
        if(rendirse == 1 || rendirse == 2){
            rendirse = 3;
        }
        return rendirse;
    }

    /**
     * Removes all pieces from the graveyard.
     */
    public void clearGraveyard() {
        this.removeAll();
        this.wp = new WhitePieces();
        this.bascunian = new Referee(wp);
        this.wp.attach(bascunian);
        this.add(new JLabel(title));
    }

    public int getNumDeadsBlackPiece() {
        return numDeadsBlackPiece;
    }

    public void setNumDeadsBlackPiece(int numDeadsBlackPiece) {
        this.numDeadsBlackPiece = numDeadsBlackPiece;
    }

    public int getNumDeadsWhitePiece() {
        return numDeadsWhitePiece;
    }


    public void setNumDeadsWhitePiece(int numDeadsWhitePiece) {
        this.numDeadsWhitePiece = numDeadsWhitePiece;
    }

    public Observable getWp() {
        return wp;
    }

    public void setWp(WhitePieces wp) {
        this.wp = wp;
    }

    public Referee getBascunian() {
        return bascunian;
    }

    public void setBascunian(Referee bascunian) {
        this.bascunian = bascunian;
    }
}
