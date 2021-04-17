package business.memento;

import gui.board.BoardSquare;

public class Originator {

    private BoardSquare[][] estado;
    private int currentPlayer;

    public void setEstado(BoardSquare[][] estado) {
        this.estado = estado;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public BoardSquare[][] getEstado() {
        return estado;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public Memento guardar() {

        BoardSquare[][] temp=new BoardSquare[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    temp[i][j]=new BoardSquare(estado[i][j].getRow(),
                            estado[i][j].getColumn(),estado[i][j].getPieceOnSquare());
            }
        }
        return new Memento(temp,currentPlayer);
    }

    public void restaurar(Memento m) {
        this.estado = m.getEstado();
        this.currentPlayer = m.getCurrentPlayer();
    }

}
