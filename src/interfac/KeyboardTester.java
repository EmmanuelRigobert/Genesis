package interfac;

public class KeyboardTester {

	public static void main(String[] args) {
		
		Keyboard keyboard = new Keyboard();
		
		keyboard.getInput('i');
		keyboard.getInput('H');
		System.out.println("Deine Ausgabe:      "+ keyboard.getFirstChar()+keyboard.getFirstChar()+" "+keyboard.getFirstChar());
		System.out.println("Erwartete Ausgabe:  " + "Hi null");
		System.out.println("-------------------------------------------------------------------------------------------");
		
		char [] inputs = new char [] {'A','B','C','D','E','F','G','H','I','J'};
		
		for(int i=0; i<10;i++) {
			keyboard.getInput(inputs[i]);
		}
		keyboard.charge();
		System.out.println("Deine Ausgabe: ");
		for(int i=0; i<10;i++) {
			System.out.print(keyboard.getFirstChar()+" ");
		}
		System.out.println("\nErwartete Ausgabe: ");
		System.out.print("J I H G F E D C B A");
		System.out.println("\n-------------------------------------------------------------------------------------------");
		System.out.println("Tests zum BatterieStand:\n ");
		System.out.println("Deine Ausgabe: ");
		System.out.println(keyboard.needsToCharge());
		System.out.println("Erwartete Ausgabe: ");
		System.out.println("true\n");
		keyboard.getInput('1');
		System.out.println("Deine Ausgabe: ");
		System.out.println(keyboard.getFirstChar());
		System.out.println("Erwartete Ausgabe: ");
		System.out.println("null");
		
		for(int i=0;i<5;i++) {
			keyboard.charge();
		}
		
		System.out.println("\nDeine Ausgabe: ");
		System.out.println(keyboard.needsToCharge());
		System.out.println("Erwartete Ausgabe: ");
		System.out.println("false");
		
		System.out.println("-------------------------------------------------------------------------------------------");
		
		inputs = new char [] {'A','B','C','D','E','F','G','H','I','J','K','L'};
		
		for(int i=0; i<12;i++) {
			keyboard.getInput(inputs[i]);
		}
		keyboard.charge();
		keyboard.charge();
		keyboard.charge();
		System.out.println("Deine Ausgabe: ");
		for(int i=0; i<10;i++) {
			System.out.print(keyboard.getFirstChar()+" ");
		}
		System.out.println("\nErwartete Ausgabe: ");
		System.out.print("L K J I H G F E D C ");
		System.out.println("\n-------------------------------------------------------------------------------------------");
		System.out.println("Testen der Methode leereSpeicher():\n");
		for(int i=0; i<12;i++) {
			keyboard.charge();
			keyboard.getInput(inputs[i]);
		}
		keyboard.emptyMemory();
		System.out.println("Deine Ausgabe: ");
		for(int i=0; i<10;i++) {
			System.out.print(keyboard.getFirstChar()+" ");
		}
		System.out.println("\nErwartete Ausgabe: ");
		System.out.print("null null null null null null null null null null");
		System.out.println("\n-------------------------------------------------------------------------------------------");
	}

}
