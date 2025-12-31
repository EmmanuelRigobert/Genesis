package com.uniindex;

import java.awt.*;

public class kreisgerade {

    public static void main(String[] args) {
        Point point1 = new Point(1,3);
        if(isGerade(point1) && isKreis(point1)){
            System.out.println("Punkt (" + point1.x + "," + point1.y + ") ist gerade und kreis");
        }else if(isGerade(point1)){
            System.out.println("Punkt (" + point1.x + "," + point1.y + ") ist gerade");
        } else if(isKreis(point1)){
        System.out.println("Punkt (" + point1.x + "," + point1.y + ") ist kreis");
        }else
        System.out.println("Punkt (" + point1.x + "," + point1.y + ") ist weder gerade noch kreis");



    }

    public static boolean isGerade(Point point){
        return point.y == (2*point.x-2);
    }
    public static boolean isKreis(Point point){
        return Math.pow(point.x,2) + Math.pow(point.y,2) == 8;
    }
}
