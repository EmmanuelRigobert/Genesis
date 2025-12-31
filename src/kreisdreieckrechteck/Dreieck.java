package com.kreisdreieckrechteck;

public class Dreieck extends GeometrischeFigur {
    private float hoehe;
    private float laenge;

    public Dreieck(float hoehe, float laenge){
        this.hoehe = hoehe;
        this.laenge = laenge;
        berechneFlaeche();
    }

    @Override
    public void berechneFlaeche() {
        flaeche = 0.5 * hoehe * laenge;
    }
}
