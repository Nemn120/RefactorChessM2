package business.objectPool;

import business.factory.PieceChessFactory;
import business.pieces.ChessGamePiece;
import business.pieces.factory.PieceFactory;
import gui.board.ChessGameBoard;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectPool {

    private static ObjectPool poolInstance = null;
    private List<ChessGamePiece> _pool = new ArrayList<ChessGamePiece>();

    public static ObjectPool getInstance(String type, ChessGameBoard board,
                                         int row,
                                         int col,
                                         int color){
        if(poolInstance == null){
            poolInstance = new ObjectPool(type,board,row,col,color);
        }
        return poolInstance;
    }

    public ObjectPool(String type, ChessGameBoard board,
                      int row,
                      int col,
                      int color){

            _pool.add(getNewPiece(type,board,row,col,color));

    }

    public ChessGamePiece getNewPiece(String type, ChessGameBoard board,
                                      int row,
                                      int col,
                                      int color){
        ChessGamePiece piece = PieceFactory.createPiece(type,board,row,col,color);
        return piece;
    }

    public ChessGamePiece getPiece(String type, ChessGameBoard board,
                                   int row,
                                   int col,
                                   int color){
        if(_pool.size()>0){
            ChessGamePiece piece0 = _pool.get(_pool.size()-1);
            _pool.remove(piece0);
            return piece0;
        }else{
            ChessGamePiece piece1 = getNewPiece(type,board,row,col,color);
            return piece1;
        }
    }

    public void ReturnPiece(ChessGamePiece piece){
        _pool.add(piece);
    }


    /*

    private List<ChessGamePiece> reusables;
    private static ObjectPool instance;

    private ObjectPool(String type, ChessGameBoard board,
                       int row,
                       int col,
                       int color){
        reusables = new ArrayList<ChessGamePiece>();
        reusables.add(PieceFactory.createPiece(type,board,row,col,color));

    }

    public static ObjectPool getInstance(String type, ChessGameBoard board,
                                         int row,
                                         int col,
                                         int color){
        if(instance == null){
            instance = new ObjectPool(type,board,row,col,color);
        }
        return instance;
    }

    public ChessGamePiece acquireReusable(){
        ChessGamePiece piece = null;
        if(reusables.size()>0){
            piece = (ChessGamePiece) reusables.get(reusables.size()-1);
            reusables.remove(piece);

        }else{
            System.out.println("no hay instancias");
        }
        return piece;
    }

    public void releaseReusable(ChessGamePiece piece){
        if(reusables.contains(piece)==false){
            reusables.add(piece);
        }else{
            System.out.println("objeto duplicado");
        }
    }
    */


}
