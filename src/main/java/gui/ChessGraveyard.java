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
    private String title;
    private Observable wp;
    private Referee bascunian;
    /**
     * Create a new ChessGraveyard object.
     *
     * @param title the title of the graveyard
     */
    public ChessGraveyard(String title) {
        this.title = title;
        this.add(new JLabel(title));
        this.setLayout(new GridLayout(8, 0));
        if(this.title=="Player 1's graveyard"){
            this.wp = new WhitePieces();
            this.bascunian = new Referee(wp);
            this.wp.attach(bascunian);
        }
        if(this.title=="Player 2's graveyard"){
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
        }
        if(piece.getColorOfPiece().getColor()==0){
            ((BlackPieces) this.wp).addNewDeadPiece(piece);
        }
        JLabel pieceLabel = new JLabel();
        pieceLabel.setIcon(piece.getImage());
        this.add(pieceLabel);
    }

    public int quiereRendirse(int currentPlayer){
        JOptionPane p = new JOptionPane();
        int rendirse = 3;
        if(this.getBascunian().getDeadPieces()==2){
            rendirse=p.showConfirmDialog(null, "Quieres rendirte jugador " + currentPlayer + "?");
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
