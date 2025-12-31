package codeübung6;

public class ArrayCoordinator {

	int[][] array;
	
	public ArrayCoordinator(int[][] array) {
		this.array = array;
		printArray();
	}
	
	public int[][] getArray() {
		int[][] copy = new int[array.length][];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = new int[array[i].length];
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}
	
	public void performOperation(IArrayOperation op) {
		System.out.println("F�hre aus: " + op.getDescription());
		op.arrayOperation(array);
		printArray();
	}
	
	
	
	public void printArray() {
		for (int z = 0; z < array.length; z++) {
			System.out.print("|\t");
			int[] zeile = array[z];
			for (int s = 0; s < array[z].length; s++) {
				int spalte = zeile[s];
				System.out.print("" + spalte + "\t");
			}
			System.out.print("|\n");			
		}
	}
	
	
	public static void main(String[] args) {
		ArrayCoordinator c = new ArrayCoordinator(new int[3][3]);
		
	}

	
	
}
