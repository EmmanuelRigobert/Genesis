package kreisgerade;

public class Main {
    private double pointx;
    private double pointy;

    public boolean isGerade(double pointx, double pointy){
        return pointy==(2*pointx) - 2;
    }
    public boolean isKreis(double pointx, double pointy){
        return (pointx*pointx) + (pointy*pointy) == 8;
    }

    public void aussage(double pointx, double pointy, boolean isGerade, boolean isKreis){
        if(isGerade)
            System.out.println("Die Punkte " + pointx + " and " + pointy + " sind gerade");
        else
            System.out.println("Die Punkte " + pointx + " and " + pointy + " sind nicht gerade");
        if (isKreis)
            System.out.println("Die Punkte " + pointx + " and " + pointy + " sind kreis");
        else
            System.out.println("Die Punkte " + pointx + " and " + pointy + " sind nicht kreis");

    }


    public static void main(String[] args) {
        double pointx=6;
        double pointy=10;

        Main koordinaten = new Main();
        boolean isGerade = koordinaten.isGerade(pointx,pointy);
        boolean isKreis = koordinaten.isKreis(pointx,pointy);

        koordinaten.aussage(pointx,pointy,isGerade,isKreis);
    }
}