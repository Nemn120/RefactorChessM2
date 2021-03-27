package business.service.moves.cardinal.builder;

public class Position{
    private int row;
    private int col;
    
    public Position(){
        this.row=0;
        this.col=0;
    }
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public Position(Position p){
        this.row=p.row;
        this.col=p.col;
    }
    public Position add(Position p){
        return new Position(this.row + p.row,this.col + p.col);
    }
    public Position mul(int m){
        return new Position(this.row * m,this.col * m);
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    @Override
    public String toString() {
        return "("+row+","+col+")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return row == that.getRow() && col == that.getCol();
    }
}
