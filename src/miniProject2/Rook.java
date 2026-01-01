package miniProject2;

public class Rook implements Figure{

    @Override
    public Field[][] getMoves(int x, int y, int boardWidth, int boardHeight){
        Field[][] field = createBoard(boardWidth,boardHeight);
        makeMove(x,y,field,1);
//        printColor(field);
//        printMarked(field);

        return field;
    }


    public Field[][] createBoard(int boardWidth, int boardHeight){
        Field[][] field = new Field[boardWidth][boardHeight];
        for(int i=0; i< boardHeight; i++){
            boolean white = (i%2)==0;
            for(int j=0; j < boardWidth; j++){
                if(white){
                    field[j][i] = new WhiteField(j,i);
                }else{
                    field[j][i] = new BlackField(j,i);
                }
                white = !white;
            }
        }
        return field;
    }
    public void makeMove(int x, int y, Field[][] field,int n){
        if(n==0)return;
        markY(x,0,field, n);
        markX(0,y,field,n);

    }
    public void markY(int x, int y,Field[][] field, int n){
        if(y>=field[x].length)return;
        field[x][y].setMarked(true);
        markY(x,y+1,field,n);
        makeMove(x,y,field,n-1);
    }
    public void markX(int x, int y,Field[][] field,int n){
        if(x>=field.length)return;
        field[x][y].setMarked(true);
        markX(x+1,y,field,n);
        makeMove(x,y,field,n-1);
    }

    public void visitor(Visitor visitor, Field[][] fields){
        if(fields.length==0)return;
        for(Field[] fld: fields){
            for(Field fd: fld){
                visitor.nextField(fd);
            }
            visitor.nextRow();
        }
    }
    public boolean hasField(int x, int y, Field[][] field){
        return (x>=0 && x<field.length && y<field[x].length && y>=0);
    }
    public void printMarked(Field[][] fields){
        visitor(new MarkPrinter(),fields);
    }
    public void printColor(Field[][] fields){
        visitor(new ColorPrinter(),fields);
    }


    public static void main(String[] args) {
        Rook r = new Rook();
        System.out.println("Get Moves:");
        r.getMoves(0,0,8,8);
    }
}
