package miniProject2;

public class Bishop implements Figure{

    @Override
    public Field[][] getMoves(int x, int y, int boardWidth, int boardHeight){
        Field[][] field = createField(boardWidth,boardHeight);
        makeMove(x,y,field,1);
        printMarks(field);
        printColor(field);

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

    public void makeMove(int x, int y, Field[][] field,int n){
        markY(x,y,field);
        markX(x,y,field);
        markY2(x,y,field);
        markX2(x,y,field);

    }
    public void markY(int x, int y,Field[][] field){
        if(y>=field[0].length|| x>=field.length)return;
        field[x][y].setMarked(true);
        markY(x+1,y+1,field);
    }
    public void markX(int x, int y,Field[][] field){
        if(y<0|| x<0)return;
        field[x][y].setMarked(true);
        markX(x-1,y-1,field);
    }
    public void markY2(int x, int y,Field[][] field){
        if(y<0|| x>=field.length)return;
        field[x][y].setMarked(true);
        markY2(x+1,y-1,field);
    }
    public void markX2(int x, int y,Field[][] field){
        if(y>=field[0].length|| x<0)return;
        field[x][y].setMarked(true);
        markX2(x-1,y+1,field);
    }


    public boolean hasField(int x, int y, Field[][] field){
        return (x>=0 && x<=field.length && y<=field[x].length && y>=0);
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
        Bishop b = new Bishop();
        b.getMoves(7,4,8,8);
    }
}
