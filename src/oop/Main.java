package oop;

public class Main {
    public static void main(String[] args){
        GeometrischeFigur kreis1 = new Kreis(2);
        GeometrischeFigur dreieck1 = new Dreieck(2,2);
        System.out.println(kreis1.equals(kreis1));
    }
}
