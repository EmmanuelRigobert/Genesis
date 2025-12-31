package oop;

public class Rechteck extends GeometrischeFigur{

    private int length;
    private int width;

    public Rechteck(int length, int width){
        this.length=length;
        this.width=width;
    }

    @Override
    public int calcArea(){
        return length*width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
