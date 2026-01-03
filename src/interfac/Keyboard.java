package interfac;

            //Aufgabe 2
public class Keyboard implements Input,Memory{

	private int batteryCharge;
	private Character[] storage;

	public Keyboard() {
		storage = new Character[10];
		batteryCharge = 100;
	}

	@Override
	public void getInput(char input) {
		if(needsToCharge())return;
		for(int i=storage.length-1; i>0; i--){
			storage[i]=storage[i-1];
		}
		storage[0]=input;
		batteryCharge-=5;
	}

	@Override
	public Character getFirstChar() {
		if(needsToCharge())return null;
		Character popped= storage[0];
		for(int i=0; i<storage.length; i++){
			if(i==storage.length-1)continue;
			storage[i]=storage[i+1];
		}
		storage[storage.length-1]=null;
		batteryCharge-=4;
		return popped;
	}

	@Override
	public void emptyMemory() {
		if(needsToCharge())return;
		for(int i=0; i<storage.length; i++){
			storage[i]=null;
		}
		batteryCharge-=2;
	}

	@Override
	public boolean needsToCharge() {
		return batteryCharge<=10;
	}

	@Override
	public void charge() {
		if(batteryCharge<=80){
			batteryCharge+=20;
		}
	}
	// Zu bearbeitender Bereich: (Aufgaben 3-7)
	  
	
	//Ende des zu bearbeitenden Bereiches
}