package codeübung6;

public class Foobar {

	public static int x = 0; // es gibt ein x f�r die klasse
	public int y = 0;        // es gibt ein y pro objekt
	
	public Foobar() {
		x += 1;
		System.out.println("X ist: " + x);
		y += 1;
		System.out.println("Y ist: " + y);
	}
	
	public static void main(String[] args) {
		Foobar s = new Foobar(); // x = 1, y = 1 
		Foobar t = new Foobar(); // x = 2, y = 1
		int d = s.x; // Foobar.x weil s ein foobar ist
		int e = Foobar.x;
	}
	
}
