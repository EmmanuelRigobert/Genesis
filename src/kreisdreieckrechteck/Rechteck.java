package com.kreisdreieckrechteck;

public class Rechteck extends GeometrischeFigur {
    private float laenge;
    private float breite;

    public Rechteck(float laenge, float breite){
        this.laenge= laenge;
        this.breite=breite;
        berechneFlaeche();
    }

    @Override
    public void berechneFlaeche(){
        flaeche = laenge * breite;
    }
}
