package codeübung6;

public class RandOp extends SingleValueOp{
	
	private int x;
	
	public RandOp(int x) {
		super("Rand " + x);
		this.x = x;
	}
	
	
	
	@Override
	public int performOp(int zeile, int spalte, int wert, int zeilen, int spalten) {
		if (zeile <= x || spalte <= x) return 0;
		if (zeile >= zeilen - 1 - x || spalte >= spalten - 1 - x) return 0;
		
		
		return wert;
		
	}

}
