package codeübung6;

public class BetragOp extends SingleValueOp {

	public BetragOp() {
		super("Betrag");
	}
	
	@Override
	public int performOp(int zeile, int spalte, int wert, int zeilen, int spalten) {
		// return (wert < 0)?-wert:wert;
		return Math.abs(wert);
	}
	
}
