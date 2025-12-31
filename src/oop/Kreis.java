package oop;

import kreisgerade.Main;

public class Kreis extends GeometrischeFigur{
    private int radius;

    public Kreis(int radius){
        this.radius=radius;
    }

    public int getRadius(){
        return radius;
    }
    public void setRadius(int radius){
        this.radius=radius;
    }

    public int diameter(int radius){
        return radius*2;
    }

    @Override
    public int calcArea(){
        return (int)(Math.PI*radius*radius);
    }
}
