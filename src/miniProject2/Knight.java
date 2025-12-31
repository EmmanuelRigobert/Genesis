package miniProject2;

public class Knight implements Figure{

    @Override
    public Field[][] getMoves(int x, int y, int boardWidth, int boardHeight){
        Field[][] field = createField(boardWidth,boardHeight);
        makeMove(x,y,field,1);
//        printMarks(field);

        return field;
    }

    public Field[][] createField(int boardWidth, int boardHeight){
        Field[][] field = new Field[boardWidth][boardHeight];
        for(int y=0; y<boardHeight; y++){
            boolean white = (y%2)==0;
            for(int x=0; x<boardWidth; x++){
                if(white){
                    field[x][y]= new WhiteField(x,y);
                }else {
                    field[x][y] = new BlackField(x,y);
                }
                white = !white;
            }
        }

        return field;
    }
    public void makeMove(int x, int y, Field[][] fields,int n){
        if(n==0)return;
        fields[x][y].setMarked(true);

        if (hasField(x+2, y-1,fields)) {
            fields[x+2][y-1].setMarked(true);
            makeMove(x+2,y-1,fields,n-1);
        }
        if (hasField(x+2, y+1,fields)) {
            fields[x+2][y+1].setMarked(true);
            makeMove(x+2,y+1,fields,n-1);
        }
        if (hasField(x-2, y+1,fields)) {
            fields[x-2][y+1].setMarked(true);
            makeMove(x-2,y+1,fields,n-1);
        }
        if (hasField(x-2, y-1,fields)) {
            fields[x-2][y-1].setMarked(true);
            makeMove(x-2,y-1,fields,n-1);
        }
        if (hasField(x+1, y-2,fields)) {
            fields[x+1][y-2].setMarked(true);
            makeMove(x+1,y-2,fields,n-1);
        }
        if (hasField(x+1, y+2,fields)) {
            fields[x+1][y+2].setMarked(true);
            makeMove(x+1,y+2,fields,n-1);
        }
        if (hasField(x-1, y+2,fields)) {
            fields[x-1][y+2].setMarked(true);
            makeMove(x-1,y+2,fields,n-1);
        }
        if (hasField(x-1, y-2,fields)) {
            fields[x-1][y-2].setMarked(true);
            makeMove(x-1,y-2,fields,n-1);
        }

    }
    public boolean hasField(int x, int y, Field[][] field){
        return (x>=0 && x<field.length && y<field[x].length && y>=0);
    }
    public void visitor(Visitor visitor,Field[][] field){
        for(Field[] aField: field){
            for(Field fld: aField){
                visitor.nextField(fld);
            }
            visitor.nextRow();
        }
    }
    public void printMarks(Field[][] field){
        visitor(new MarkPrinter(),field);
    }
    public void printColor(Field[][] field){
        visitor(new ColorPrinter(),field);
    }

    public static void main(String[] args) {
        Knight k = new Knight();
        k.getMoves(0,0,8,8);
    }
}
