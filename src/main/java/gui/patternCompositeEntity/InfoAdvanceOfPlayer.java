package gui.patternCompositeEntity;

import gui.ChessGraveyard;

import javax.swing.*;
import java.awt.*;

public class InfoAdvanceOfPlayer {
    private CompositeEntity compositeEntity = new CompositeEntity();
    private String playerName;
    private int numDeadsPieces;

    public InfoAdvanceOfPlayer() {}

    public void showJframeInfoPlayer(String playerName, int deads) {
        this.setPlayerName(playerName);
        this.setNumDeadsPieces(deads);
        setDataOfPlayer();
    }

    public void setDataOfPlayer() {
        this.getCompositeEntity().setDataOfPlayers(this.getPlayerName(), this.getNumDeadsPieces());
        setMessageOfPlayer();
    }

    public void setMessageOfPlayer() {
        JOptionPane.showMessageDialog(null, this.getCompositeEntity().getData(),
                this.getPlayerName(), JOptionPane.INFORMATION_MESSAGE);
    }

    public CompositeEntity getCompositeEntity() {
        return compositeEntity;
    }

    public void setCompositeEntity(CompositeEntity compositeEntity) {
        this.compositeEntity = compositeEntity;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumDeadsPieces() {
        return numDeadsPieces;
    }

    public void setNumDeadsPieces(int numDeadsPieces) {
        this.numDeadsPieces = numDeadsPieces;
    }
}
