package auto;

public class ProgrammMuster {

    public ProgrammMuster() {
        System.out.println(verbindeString("A", "B"));
        System.out.println(aIstGleichB("a", "a"));
        System.out.println(aIstGleichB("a", "b"));
        System.out.println(aIstKleinerAlsB("a", "b"));
        System.out.println(aIstKleinerAlsB("a", "a"));
        System.out.println(aIstKleinerAlsB("b", "a"));
        System.out.print("Das Zeichen an position 3 ist: ");
        System.out.println(holeZeichenAnPosition(
                "Das Zeichen an position 3 ist: ", 3));
        System.out.println(ersetzeMitte("yaaaaaaaay:axaxaxaxa:yaaaaaaay", ':'));
        System.out.print("2+3 ist ");
        System.out.println(addition(2, 3));
        System.out.print("2-3 ist ");
        System.out.println(subtraktion(2, 3));
        System.out.print("2*3 ist ");
        System.out.println(multiplikation(2, 3));
        System.out.print("Die Quersumme von 420815 ist ");
        System.out.println(quersumme(420815));
        System.out.print("Bei 1 Euro Startkapital und 0.5% j�hrl. Zinsen ist man nach so vielen Jahren Million�r: ");
        System.out.println(millionaer(1.0, 0.5));
    }

    public static String verbindeString(String a, String b) {
        return a + b;
    }

    public static boolean aIstGleichB(String a, String b) {
        if (null != a)
            return a.equals(b);
        else
            return null == b;
    }

    public static boolean aIstKleinerAlsB(String a, String b) {
        if (null != a)
            return 0 > a.compareTo(b);
        else
            return false;
    }

    public static char holeZeichenAnPosition(String input, int position) {
        return input.charAt(position);
    }

    public static String ersetzeMitte(String input, char trenner) {
        int start = input.indexOf(trenner, 0);
        int stop = input.indexOf(trenner, start + 1);
        String subStr = input.substring(start + 1, stop);
        subStr = subStr.replace('a', 'X');
        return input.substring(0, start) + subStr
                + input.substring(stop + 1, input.length());
    }

    public static int addition(int a, int b){
        return a+b;
    }

    public static int subtraktion(int a, int b){
        return a-b;
    }

    public static int multiplikation(int a, int b){
        return a*b;
    }

    public static int quersumme(int a){
        int quersumme = 0;
        while(a != 0) {
            quersumme += a % 10;
            a /= 10;
        }
        return quersumme;
    }

    public static double millionaer(double startkapital, double zinssatz){
        //Zinsfaktor umrechnen
        double zinsfaktor = 1.0 + (zinssatz/100.0);

        //Auf das Jahr genaue iterative Lösung mit Zählschleife
        int jahre;
        for(jahre=0; startkapital < 1000000; jahre++) {
            startkapital *= zinsfaktor;
        }
        return jahre;
    }

    public static void main(String[] args) {
        ProgrammMuster test = new ProgrammMuster();
        ersetzeMitte("yaaaaaaaay:axaxaxaxa:yaaaaaaay",':');

    }



}
