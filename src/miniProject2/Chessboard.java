package miniProject2;

/**
 * Implements a rectangular board with 
 * black and white fields.
 * 
 * @author Marcus
 */
public class Chessboard{

	/**
	 * The fields of the chess board. The first
	 * dimension references columns (x), the second
	 * dimension references rows (y).
	 */
	private Field[][] fields;
	
	/**
	 * Creates a chessboard with width 8 
	 * and height 8.
	 */
	// TODO: public default constructor
	public Chessboard(){
		this(8,8);
	}
	
	/**
	 * Creates a new chessboard with the specified
	 * width and height consisting of black and
	 * white fields in a checker pattern.
	 * 
	 * @param width The width (>= 0).
	 * @param height The height (>= 0).
	 */
	public Chessboard(int width, int height) {
		fields = new Field[width][height];
		for (int y = 0; y < height; y++) {
			// start every other row with a different color
			boolean white = (y % 2 == 0);
			for (int x = 0; x < width; x++) {
				if (white) {
					fields[x][y] = new WhiteField(x, y);
				} else {
					fields[x][y] = new BlackField(x, y);
				}
				// change the color for the next field in the row
				white = !white;
			}
		}
	}
	
	/**
	 * Determines whether the field with the specified
	 * index is part of the board.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return True if the board contains the field, false
	 * 	otherwise.
	 */
	// TODO: implement hasField
	public boolean hasField(int x, int y){
		return (x < fields.length && x >= 0 && y < fields[0].length && y>=0);
	}

	
	/**
	 * Returns the field at the specified x and y coordinate
	 * or null, if the board does not have the field.
	 * 
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return The field, if it is part of the board, or null
	 * 	otherwise.
	 */
	// TODO: implement getField
	public Field getField(int x, int y){
		if(hasField(x,y)){
			return fields[x][y];
		}
		return null;
	}
	
	/**
	 * Iterates over the fields of the board from
	 * line to line calls the visitor's nextField
	 * method for each field. Whenever the row 
	 * changes, the visitor's nextRow method is 
	 * called.
	 * 
	 * @param visitor The visitor to call.
	 */
	public void visitFields(Visitor visitor) {
		if (fields.length == 0) return; 
		for (int y = 0; y < fields[0].length; y++) {
			for (int x = 0; x < fields.length; x++) {
				visitor.nextField(fields[x][y]);
			}
			visitor.nextRow();
		}
	}
	
	/**
	 * Prints a compact string representation of the 
	 * board onto the console. The string representation
	 * highlights the marked fields.
	 */
	public void printMarks() {
		// TODO: implement me
		MarkPrinter markPrinter = new MarkPrinter();
		visitFields(markPrinter);
	}
	
	/**
	 * Prints a compact string representation of the board
	 * onto the console. The string representation
	 * highlights the colors of the fields.
	 */
	public void printColors() {
		// TODO: implement me
		ColorPrinter colorPrinter = new ColorPrinter();
		visitFields(colorPrinter);
	}

	/**
	 * Returns a (somewhat bloated) string representation
	 * of the board using the FieldStringifyer and the
	 * visit method.
	 */
	public String toString() {
		// TODO: implement me
		FieldStringifyer fieldStringifyer = new FieldStringifyer();
		visitFields(fieldStringifyer);
		return fieldStringifyer.getText();
	}
	
	/**
	 * Removes the marks from all fields by setting them to false.
	 */
	public void clearMarks() {
		// TODO: implement me
		visitFields(new Visitor(){
			@Override
			public void nextField(Field field) {
				field.setMarked(false);
			}

			@Override
			public void nextRow() {

			}

		});
	}


	
	/**
	 * Marks all fields that can be reached by a knight 
	 * at a particular position in n moves. 
	 * 
	 * If (x,y) is not on the board, nothing will be marked. 
	 * 
	 * If n is smaller than 0, nothing will be marked. If
	 * n is 0, only the field at (x,y) will be marked.
	 * 
	 * If n is 1, the method will mark the fields at
	 * (x+-1, y+-2) and (x+-2, y+-1).
	 * 
	 * @param x The x coordinate to start from.
	 * @param y The y coordinate to start from.
	 * @param n The number of moves of the knight.
	 */
	// TODO: Aufgabe 2
	public void markKnightMoves(int x, int y, int n){
		if(n<0)return;
		if(n==0){
			fields[x][y].setMarked(true);
			return;
		}

        if (hasField(x+2, y-1)) {
            fields[x+2][y-1].setMarked(true);
			markKnightMoves(x+2,y-1,n-1);
        }
		if (hasField(x+2, y+1)) {
			fields[x+2][y+1].setMarked(true);
			markKnightMoves(x+2,y+1,n-1);
		}
		if (hasField(x-2, y+1)) {
			fields[x-2][y+1].setMarked(true);
			markKnightMoves(x-2,y+1,n-1);
		}
		if (hasField(x-2, y-1)) {
			fields[x-2][y-1].setMarked(true);
			markKnightMoves(x-2,y-1,n-1);
		}
		if (hasField(x+1, y-2)) {
			fields[x+1][y-2].setMarked(true);
			markKnightMoves(x+1,y-2,n-1);
		}
		if (hasField(x+1, y+2)) {
			fields[x+1][y+2].setMarked(true);
			markKnightMoves(x+1,y+2,n-1);
		}
		if (hasField(x-1, y+2)) {
			fields[x-1][y+2].setMarked(true);
			markKnightMoves(x-1,y+2,n-1);
		}
		if (hasField(x-1, y-2)) {
			fields[x-1][y-2].setMarked(true);
			markKnightMoves(x-1,y-2,n-1);
		}
		if(n==1){
			fields[x][y].setMarked(true);
		}

    }
	public void markMoves(int x, int y, int n, Figure figure){
		if(n==0)return;
		Field[][] firstMark = figure.getMoves(x,y, fields.length, fields[0].length);
		for(int i=0; i<fields.length; i++){
			for(int j=0; j<fields[0].length; j++){
				if(firstMark[i][j].getMarked()){
					fields[i][j].setMarked(true);
				}
			}
		}
		for(int i=0; i<fields.length; i++){
			for(int j=0; j<fields[0].length; j++){
				if(firstMark[i][j].getMarked()){
					figure.makeMove(i,j,fields,n-1);
				}
			}
		}

	}
	
	
	public static void main(String[] args) {
		Chessboard b = new Chessboard();
		System.out.println("toString:");
		System.out.print(b.toString());
		System.out.println();
		System.out.println("printColors:");
		b.printColors();
		System.out.println();
		System.out.println("printMarks:");
		b.printMarks();


/*		countdown(5);
		System.out.println(sum(15));
		System.out.println(power(2,4));
		System.out.println(arraySum(new int[]{1,2,3,4},0));
		System.out.println(countChar("banana",'a'));
		System.out.println(reverse("hello"));
		System.out.println(fib(2));*/

		

		for (int i = 0; i < 2; i++) {
			System.out.println("markKnightMoves(3, 3, " +  i + ")");
			b.markKnightMoves(3, 3, i);
			b.printMarks();
			b.clearMarks();
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.println("markKnightMoves(0, 0, " +  i + ")");
			b.markKnightMoves(0, 0, i);
			b.printMarks();
			b.clearMarks();			
		}
		System.out.println("Marking moves: ");

		b.clearMarks();
		System.out.println("Knight: ");
		b.markMoves(1,0,1,new Knight());
		b.printMarks();

		b.clearMarks();
		System.out.println("Bishop: ");
		b.markMoves(2,0,1,new Bishop());
		b.printMarks();

		b.clearMarks();
		System.out.println("Rook: ");
		b.markMoves(0,0,1,new Rook());
		b.printMarks();


	}
	/*
	//Exercises to learn recursion

	public static void countdown(int n){
		if(n<1){
			return;
		}
		System.out.print(n + " ");
		countdown(n-1);
	}

	public static int sum(int n){
		if(n<=0){
			return 0;
		}
		return n + sum(n-1);
	}

	public static int power(int base, int exp){
		if(exp <=0){
			return 1;
		}
		return base* power(base,exp-1);
	}

	public static int arraySum(int[] arr, int index){
		if(index==arr.length){
			return 0;
		}
		return arr[index] + arraySum(arr,index+1);
	}

	public static int countChar(String s, char c){
		if(s == null) throw new IllegalArgumentException();
		if(s.isEmpty()){
			return 0;
		}
		int add = s.charAt(0)==c?1:0;
		return add + countChar(s.substring(1),c);
	}

	public static String reverse(String s){
		if(s == null) throw new IllegalArgumentException();
		if(s.isEmpty()) return "";
		return s.charAt(s.length() - 1) + reverse(s.substring(0,s.length()-1));
	}

	public static int fib(int n){
		if(n<=1){
			return n;
		}
		return fib(n-2) + fib(n-1);
	}*/

}
