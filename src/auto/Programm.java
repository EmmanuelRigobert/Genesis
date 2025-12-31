package auto;

public class Programm {

	public Programm() {
		//Code zum testen (funktioniert erst sobald R�ckgabetypen richtig gesetzt wurden.)
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
		System.out.print("2+3 ist");
		System.out.println(addition(2, 3));
		System.out.print("2-3 ist");
		System.out.println(subtraktion(2, 3));
		System.out.print("2*3 ist");
		System.out.println(multiplikation(2, 3));
		System.out.print("Die Quersumme von 420815 ist ");
		System.out.println(quersumme(420815));
		System.out.print("Bei 1 Euro Startkapital und 0.5% j�hrl. Zinsen ist man nach so vielen Jahren Million�r: ");
		System.out.println(millionaer(1.0, 0.5));
		/*
		 * Ausgabe:
AB
true
false
true
false
false
Das Zeichen an position 3 ist:  
yaaaaaaaayXxXxXxXxXyaaaaaaay
2+3 ist 5
2-3 ist -1
2*3 ist 6
Die Quersumme von 420815 ist 20
Bei 1 Euro Startkapital und 0.5% j�hrl. Zinsen ist man nach so vielen Jahren Million�r: 2770
		 * */
		
	}

	public String verbindeString(String a, String b) {
		return a+b;
	}

	public boolean	aIstGleichB(String a, String b) {
		return a.equals(b);
	}

	public boolean aIstKleinerAlsB(String a, String b) {
        return a.compareTo(b) < 0;
	}

	public char holeZeichenAnPosition(String input, int position) {
		return input.charAt(position);
	}

	public String ersetzeMitte(String input, char trenner) {
		int start = input.indexOf(trenner,0);
		int end = input.indexOf(trenner,start+1);
		String subString = input.substring(start,end);
		subString = subString.replace('a','X');
		return input.substring(0,start) + subString + input.substring(end);
	}

	public int addition(int a, int b){
		return a+b;
	}

	public int subtraktion(int a, int b){
		return a -b;
	}

	public int multiplikation(int a, int b){
		return a*b;
	}

	public int quersumme(int a){
		int number;
		int sum=0;
		while(a>0){
			number = a%10;
			sum += number;
			a /=10;
		}
		return sum;
	}

	public int millionaer(double startkapital, double zinssatz){
		int jahre;
		double zinsfaktor = 1 + zinssatz/100;
		for(jahre=0; startkapital <= 1_000_000; jahre ++){
			startkapital += startkapital * zinsfaktor;
		}
		return jahre;
	}

	public static void main(String[] args) {

	}

}
