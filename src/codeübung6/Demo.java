package codeübung6;

public class Demo {

	public interface I {
		
	}
	
	public static class A {
		
	}
	
	public static class B extends A implements I {
		// jedes B ist auch ein A
		// jedes B ist auch ein I
		
		
		
	}
	
	public interface Comparable {
		public boolean isGreater(Comparable x);
	}
	
	
	public void sort() {
		Comparable[] a = new Comparable[10];
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				Comparable x = a[i];
				Comparable y = a[j];
				// wenn x > y dann
				if (x.isGreater(y)) {
					
				}
				
			}
			
		}
		
	}
	
	public void doit() {
	//	I i = new I(); // I ist ein interface, d.h. es kann so nicht instanziiert werden
		A a /** alles was hier drin steht MUSS mindestens A sein **/ = new A();
		B b /** alles was hier drin steht MUSS mindestens B sein **/ = new B();
		a = b;
		b = (B)a; // hier ist nicht sicher, dass a ein B ist 
		
		int z = 3;
		A c = (z==2)?(new B()):(new A());
		b = (B)c;
		
		
		// a = b ??
		// b = a ??
		
		
	}

	
	
	
}
