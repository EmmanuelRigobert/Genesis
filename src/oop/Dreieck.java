package oop;

public class Dreieck extends GeometrischeFigur{
    private int height;
    private int length;

    public Dreieck(int height, int length){
        this.height=height;
        this.length =length;
    }

    @Override
    public int calcArea(){
        return (length*height)/2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
