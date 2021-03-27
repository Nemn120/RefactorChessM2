package business.service.moves.cardinal.abstractFactoryCardinal;

import business.service.moves.cardinal.CalculateCardinalMove;
import gui.board.ChessGameBoard;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.List;

public abstract class CreateMoveCardinal {

    public abstract List<CalculateCardinalMove> getInstance(int pieceRow, int pieceColumn, ColorOfPiece color, String ... cardinalPoints);
}
