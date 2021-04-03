package business.memento;

import gui.board.BoardSquare;

public class Originator {

    private BoardSquare[][] estado;

    public void setEstado(BoardSquare[][] estado) {
        this.estado = estado;
    }

    public BoardSquare[][] getEstado() {
        return estado;
    }

    public Memento guardar() {

        BoardSquare[][] temp=new BoardSquare[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //if(estado[i][j]!=null){
                    temp[i][j]=new BoardSquare(estado[i][j].getRow(),
                            estado[i][j].getColumn(),estado[i][j].getPieceOnSquare());
                //}else{
                //    temp[i][j]=null;
                //}

            }
        }

        return new Memento(temp);

    }

    public void restaurar(Memento m) {
        this.estado = m.getEstado();
    }

}
