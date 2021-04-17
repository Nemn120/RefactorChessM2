package business.visitor;

import business.pieces.*;

public interface Visitor {
    public void visitPawn(Pawn pawn);
    public void visitRook(Rook rook);
    public void visitBishop(Bishop bishop);
    public void visitKnight(Knight knight);
    public void visitKing(King king);
    public void visitQueen(Queen queen);
}
