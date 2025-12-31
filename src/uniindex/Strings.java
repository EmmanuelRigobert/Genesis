package com.uniindex;

import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        System.out.println(ersetzeMitte("yaaaaaaaay:axaxaxaxa:yaaaaaaay",':'));
    }
    public static String verbindeString(String a, String b){
        return a+b;
    }
    public static boolean aIstGleichB(String a, String b){
        return a.equals(b);
    }
    public static boolean aIstKleinerAlsB(String a, String b){
        return a.length()<b.length();
    }
    public static char holeZeichenAnPosition(String input, int position){
        return input.charAt(position);
    }
    public static String ersetzeMitte(String input, char trenner){
        String[] parts = input.split(String.valueOf(trenner));
        System.out.println(Arrays.toString(parts));
        String newPart = parts[1].replace('a','X');
        return parts[0]+newPart+parts[2];
    }
    public static int millionaer(double startkapital, double zinssatz){
        int ziel = 1_000_000;
        int jahre =0;
        while(startkapital<ziel){
            startkapital += (ziel*startkapital)/100;
            jahre++;
        }
        return jahre;
    }
}