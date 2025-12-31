package codeübung6;

public abstract class SingleValueOp implements IArrayOperation {

	String description;
	
	public SingleValueOp(String desc) {
		this.description = desc;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	
	@Override
	public void arrayOperation(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = performOp(i, j, array[i][j], array.length, array[i].length);
			}
		}		
	}
	
	public abstract int performOp(int zeile, int spalte, int wert, int zeilen, int spalten);

}
