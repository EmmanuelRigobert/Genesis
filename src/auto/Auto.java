package auto;

import java.util.Scanner;

public class Auto {
    private String marke;
    private String farbePlakette;
    private String farbe;
    private String klasse;
    private boolean gultigesTUV;
    private int anzahlDerTuren;
    private int baujahr;
    private int hoechstgeschwindigkeit;
    private int psZahl;
    private double preis;
    private int zahlKatalysator;
    private int totalPassagiere;
    private int maxPassagiere;
    private int ackPassagiere;

    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }

    public int getPsZahl() { return psZahl; }
    public void setPsZahl(int psZahl) { this.psZahl = psZahl; }

    public String getFarbePlakette() { return farbePlakette; }
    public void setFarbePlakette(String farbePlakette) { this.farbePlakette = farbePlakette; }

    public String getFarbe() { return farbe; }
    public void setFarbe(String farbe) { this.farbe = farbe; }

    public String getKlasse() { return klasse; }
    public void setKlasse(String klasse) { this.klasse = klasse; }

    public boolean isGultigesTUV() { return gultigesTUV; }
    public void setGultigesTUV(boolean gultigesTUV) { this.gultigesTUV = gultigesTUV; }

    public int getAnzahlDerTuren() { return anzahlDerTuren; }
    public void setAnzahlDerTuren(int anzahlDerTuren) { this.anzahlDerTuren = anzahlDerTuren; }

    public int getBaujahr() { return baujahr; }
    public void setBaujahr(int baujahr) { this.baujahr = baujahr; }

    public int getHoechstgeschwindigkeit() { return hoechstgeschwindigkeit; }
    public void setHoechstgeschwindigkeit(int hoechstgeschwindigkeit) { this.hoechstgeschwindigkeit = hoechstgeschwindigkeit; }

    public double getPreis() { return preis; }
    public void setPreis(double preis) { this.preis = preis; }

    public int getZahlKatalysator() { return zahlKatalysator; }
    public void setZahlKatalysator(int zahlKatalysator) { this.zahlKatalysator = zahlKatalysator; }


    public boolean isMarkeNissan() {
        return "Nissan".equalsIgnoreCase(this.marke);
    }

    public boolean isPsZahlGerade() {
        return this.psZahl % 2 == 0;
    }
    public void einsteigen(){
        if(ackPassagiere<maxPassagiere){
            ackPassagiere++;
        }else
            System.out.println("Car is full");
    }
    public void aussteigen(){
        if(ackPassagiere>0){
            ackPassagiere--;
        }else
            System.out.println("Car is empty");
    }

    public static Auto carRegister() {
        try (Scanner scanner = new Scanner(System.in)) {
          Auto auto = new Auto();

          System.out.print("Enter car mark: ");
          auto.setMarke(scanner.next());

          System.out.print("Enter car PS number: ");
          auto.setPsZahl(scanner.nextInt());

          System.out.print("Enter Plakette Farbe: ");
          auto.setFarbePlakette(scanner.next());

          System.out.print("Enter Farbe: ");
          auto.setFarbe(scanner.next());

          System.out.print("Enter Klasse: ");
          auto.setKlasse(scanner.next());

          System.out.print("Has gültiges TÜV (true/false): ");
          auto.setGultigesTUV(scanner.nextBoolean());

          System.out.print("Enter Anzahl der Türen: ");
          auto.setAnzahlDerTuren(scanner.nextInt());

          System.out.print("Enter Baujahr: ");
          auto.setBaujahr(scanner.nextInt());

          System.out.print("Enter Höchstgeschwindigkeit: ");
          auto.setHoechstgeschwindigkeit(scanner.nextInt());

          System.out.print("Enter Preis: ");
          auto.setPreis(scanner.nextDouble());

          System.out.print("Enter Anzahl der Katalysator: ");
          auto.setZahlKatalysator(scanner.nextInt());

          return auto;
        }
    }

    public void printStats() {
        System.out.println("Die Marke ist Nissan: " + isMarkeNissan());
        System.out.println("PS Zahl ist gerade: " + isPsZahlGerade());

        if ("grun".equalsIgnoreCase(farbePlakette) && !gultigesTUV) {
            System.out.println("Das Auto hat die grüne Plakette aber kein gültiges TÜV-Siegel");
        }
        if (anzahlDerTuren == 3 || anzahlDerTuren == 5) {
            System.out.println("Die Anzahl der Türen beträgt 3 oder 5.");
        }
        if ("Kleinstwagen".equalsIgnoreCase(klasse) && baujahr > 2008 && "grun".equalsIgnoreCase(farbePlakette)) {
            System.out.println("Das Auto ist ein Kleinstwagen, wurde nach 2008 gebaut und hat eine grüne Plakette.");
        }
        if (anzahlDerTuren > 3 && hoechstgeschwindigkeit >= 250) {
            System.out.println("Das Auto hat mehr als 3 Türen und erreicht mindestens 250 km/h.");
        }
        if (baujahr == 2004) {
            System.out.println("Das Baujahr ist 2004.");
        }
        if (hoechstgeschwindigkeit >= (1.8 * psZahl)) {
            System.out.println("Die Höchstgeschwindigkeit ist mindestens 1.8 mal so hoch wie die PS-Zahl.");
        }
        if ((preis >= 15000 && preis <= 25000) &&
                ("Kleinstwagen".equalsIgnoreCase(klasse) && (farbe.equalsIgnoreCase("rot") || farbe.equalsIgnoreCase("grun")))
                || ("VW".equalsIgnoreCase(marke) && baujahr < 1978)) {
            System.out.println("Das Auto erfüllt die speziellen Preis-, Klassen- und Farb- oder Markenbedingungen.");
        }
        if ((zahlKatalysator > 0) ^ gultigesTUV) {
            System.out.println("Das Auto hat entweder einen Katalysator oder einen gültigen TÜV (aber nicht beides).");
        }
        switch (farbe){
            case "Bordeaux":
                System.out.println("Tolles rot");
            case "Kobalt":
                System.out.println("Schönes Blau");
            default:
                System.out.println("Unbekannte Farbe");
        }
    }

    public static void main(String[] args) {
        Auto myAuto = Auto.carRegister();
        myAuto.printStats();
    }
}
