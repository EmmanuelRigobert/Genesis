package com.uniindex;

public class Auto {
    private Marke marke;
    private int psZahl;
    private Farbe plaketteFarbe;
    private boolean gultigesTUV;
    private byte anzahlTuren;
    private Klasse klasse;
    private short bauJahr;
    private short hochstGeschwindigkeit;
    private Farbe farbe;
    private boolean hatKatalysator;
    private float price;
    private byte maxAnzahlPassagiere;
    private byte anzahlAktuellePassagiere;
    private int anzahlBefoerdertenPersonen;

    public boolean isNissan(){
        return this.marke.equals(Marke.NISSAN);
    }
    public boolean psIsGerade(){
        return this.psZahl%2==0;
    }
    public boolean hatGrunPakette(){
        return this.plaketteFarbe.equals(Farbe.GREEN);
    }
    public boolean hatTUV(){
        return this.gultigesTUV;
    }
    public boolean hatGrunPlakettKeinTUV(){
        return hatGrunPakette() && !hatTUV();
    }
    public boolean dreiOderFunfTuren(){
        return anzahlTuren==3 || anzahlTuren==5;
    }
    public boolean klassKeinwagenNach2008GrunPlakette(){
        return this.klasse.equals(Klasse.KLEINSTWAGEN) && this.bauJahr>2008 && hatGrunPakette();
    }
    public boolean mehrAls3Turenhochstgeschwindigkeit(){
        return anzahlTuren>3 && hochstGeschwindigkeit>=250;
    }
    public boolean Auto2004(){
        return this.bauJahr==2004;
    }
    public boolean hochstgeschwindigkeitPSZahl(){
        return hochstGeschwindigkeit/psZahl >=1.8;
    }
    public boolean costUndWeiter(){
        return (
                (this.price >15_000 && this.price<25_000)&&(this.klasse.equals(Klasse.KLEINSTWAGEN) && (this.farbe.equals(Farbe.RED)||this.farbe.equals(Farbe.GREEN)))
                || (this.marke.equals(Marke.VW)&& this.bauJahr<1978)
        );
    }
    public boolean katalysatorOderTUV(){
        return hatKatalysator ^ hatTUV();
    }
    public void einsteigen(){
        if(anzahlAktuellePassagiere<maxAnzahlPassagiere){
            anzahlAktuellePassagiere-=1;
        }else
            System.out.println("Auto ist voll");
    }
    public void aussteigen(){
        if(anzahlAktuellePassagiere>0){
            anzahlAktuellePassagiere-=1;
        }else
            System.out.println("Das Auto ist leer");
    }
    public int befoerdertePassagiere(){
        return anzahlBefoerdertenPersonen;
    }
    public void farbe(){
        switch(this.farbe){
            case BORDEAUX -> System.out.println("Tolles rot!");
            case KOBALT -> System.out.println("Schönes Blau");
            default -> System.out.println("Unbekannte Farbe");
        }
    }
}

enum Marke{
    NISSAN,
    BENZ,
    AUDI,
    VW
}
enum Farbe{
    GREEN,
    RED,
    BORDEAUX,
    KOBALT
}
enum Klasse{
    KLEINSTWAGEN,
    GROSSWAGEN
}
