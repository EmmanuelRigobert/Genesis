package com.kreisdreieckrechteck;

public abstract class GeometrischeFigur {

    protected double flaeche;

    abstract void berechneFlaeche();
    public void ausgeber(){
        System.out.println("Flaeche: " + flaeche);
    }
}
