package com.kreisdreieckrechteck;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GeometrischeFigur kreis = new Kreis(4);
        GeometrischeFigur rechteck = new Rechteck(3000,2);
        GeometrischeFigur rechteck2 = rechteck;

        GeometrischeFigur dreieck = new Dreieck(2,3000);

        System.out.println(kreis.equals(dreieck));
        kreis.ausgeber();
        rechteck.ausgeber();
        dreieck.ausgeber();

        GeometrischeFigur[] geoArray = new GeometrischeFigur[3000];
        Random random = new Random();
        for(int i=0; i< geoArray.length;i++){
            int type = i%3;
            switch(type){
                case 0 -> geoArray[i]= new Kreis(1+random.nextInt(10)); //Generates number from 1 to 11 for radius
                case 1 -> geoArray[i]= new Rechteck(1+random.nextInt(10),1+random.nextInt(10));
                case 2 -> geoArray[i]= new Dreieck(1+random.nextInt(10),1+random.nextInt(10));
            }
        }
/*        for(int i=0; i< 5;i++){
            geoArray[i].ausgeber();
        }*/
        for(GeometrischeFigur figur:geoArray){
            if(figur instanceof Kreis){
                System.out.println("Figur ist Kreis. Flaeche: " + figur.flaeche);
            }else if(figur instanceof Rechteck){
                System.out.println("Figur ist Rechteck. Flaeche: " + figur.flaeche);
            }else{
                System.out.println("Figur ist Dreieck. Flaeche: " + figur.flaeche);
            }
        }

        System.out.println(rechteck.equals(rechteck2));
    }
}
