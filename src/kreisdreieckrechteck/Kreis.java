package com.kreisdreieckrechteck;

public class Kreis extends GeometrischeFigur {
    private float radius;

    public Kreis(float radius){
        this.radius = radius;
        berechneFlaeche();
    }

    @Override
    public void berechneFlaeche() {
        flaeche = 0.5 * Math.pow(radius,2);
    }
}
