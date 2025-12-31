package codeübung6;

public class ModuloOp extends SingleValueOp{

	int x;
	
	public ModuloOp(int x) {
		super("Modulo " + x);
		this.x = x;
	}

	@Override
	public int performOp(int zeile, int spalte, int wert, int zeilen, int spalten) {
		return wert % x;
	}
}
