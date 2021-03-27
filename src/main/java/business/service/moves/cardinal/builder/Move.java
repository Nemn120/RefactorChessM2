package business.service.moves.cardinal.builder;

import java.util.ArrayList;

import util.CardinalPoint;

public class Move {
    private ArrayList<Position> positions;

    public Move(ArrayList<Position> positions){
        this.positions = positions;
    }
    public ArrayList<Position> getPositions(){
        return positions;
    }
    public ArrayList<Position> getValidCells(){
        ArrayList<Position> cells = new ArrayList<Position>();
        for(int i=0;i<positions.size();i++){
            int row = positions.get(i).getRow();
            int column = positions.get(i).getCol();
            if(row>=0 && row<8 && column>=0 && column<8){
                cells.add(new Position(row,column));
            }
        }
        return cells;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move that = (Move) o;
        if(positions.size()!=that.positions.size()) return false;
        boolean eq = true;
        for(int i=0;i<positions.size();i++){
            if(!positions.get(i).equals(that.positions.get(i))){
                eq = false;break;
            }
        }
        return eq;
    }
    public static class Builder {
        private ArrayList<Position> positions;
        public Builder(){
            positions = new ArrayList<Position>();
        }
        private Position convertCardinalPointToIncrease(String cardinalPoint){
            int row=0;
            int col=0;
            switch(cardinalPoint){
                case CardinalPoint.NORTH: row=-1;col=0;break;
                case CardinalPoint.SOUTH: row=1;col=0;break;
                case CardinalPoint.EAST: row=0;col=1;break;
                case CardinalPoint.WEST: row=0;col=-1;break;
                case CardinalPoint.NORTHEAST: row=-1;col=1;break;
                case CardinalPoint.NORTHWEST: row=-1;col=-1;;break;
                case CardinalPoint.SOUTHEAST: row=1;col=1;break;
                case CardinalPoint.SOUTHWEST: row=1;col=-1;break;
            }
            return new Position(row,col);
        }
        public Builder addMove(String cardinalPoint, int numMoves){
            Position increase = convertCardinalPointToIncrease(cardinalPoint);
            Position lastPosition;
            if(!positions.isEmpty()){
                lastPosition = positions.get(positions.size() - 1);
            }  
            else{
                lastPosition = new Position();
            } 
            //agrega a la última posicion del movimiento anterior  
            //las posiciones relativas del nuevo movimiento
            for(int i=1;i<=numMoves;i++){
                positions.add(new Position(lastPosition.add(increase.mul(i))));     
            }
            return this;
        }
        public Builder addMove(Move move){
            positions.addAll(move.getPositions());
            return this;
        }
        public Builder addPosition(Position p){
            ArrayList<Position> newPositions = new ArrayList<Position>();
            for(int i=0;i<positions.size();i++){
                newPositions.add(positions.get(i).add(p));
            }
            positions = newPositions;
            return this;
        }
        public Builder addPosition(int row, int col){
            ArrayList<Position> newPositions = new ArrayList<Position>();
            for(int i=0;i<positions.size();i++){
                int newRow = positions.get(i).getRow()+row;
                int newCol = positions.get(i).getCol()+col;
                newPositions.add(new Position(newRow,newCol));
            }
            positions = newPositions;
            return this;
        }
        public Move build() {
            Move move = new Move(positions);
            positions = new ArrayList<Position>();
            return move;
        }
    }
}
