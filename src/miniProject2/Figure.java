package miniProject2;

public interface Figure {
    Field[][] getMoves(int x, int y, int boardWidth, int boardHeight);
    void makeMove(int x, int y,Field[][] fields,int n);
    boolean hasField(int x,int y,Field[][] field);
}
