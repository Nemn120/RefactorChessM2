package business.service.moves.pieces;


import util.ColorOfPiece;

import java.util.List;

public interface ICreateMove {

    List<?> createMove(int pieceRow, int pieceColumn, ColorOfPiece color);

}
