package miniProject3;

import java.util.Arrays;

/**
 * An array list to store strings.
 * 
 * @author Marcus
 */
public class ArrayStringList implements StringList {

	/**
	 * The items in the list.
	 */
	private String[] items = new String[0];
	
	/**
	 * Creates a new empty list.
	 */
	public ArrayStringList() {
		super();
	}

	public void addArrLength(int n){
		String[] newItems = new String[items.length+n];
		for(int i=0; i< items.length; i++){
			newItems[i]=items[i];
		}
		items=newItems;
	}

	@Override
	public void appendString(String text) {
		// TODO: implement
		boolean appended =  addElt(items, text);

		if(!appended){
			addArrLength(1);
			addElt(items,text);
			System.out.println(Arrays.toString(items));
		}

	}
	public boolean addElt(String[] items,String text){
		for(int i=0; i<items.length;i++){
			if(items[i]==null){
				items[i]=text;
				return true;
			}
		}
		return false;
	}

	@Override
	public String getStringAt(int i) {
		// TODO: implement
		if(i<=items.length-1){
			return items[i];
		}
		return null;
	}

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
		if(i>= items.length){
			System.out.println("Largest index is : " + (items.length-1));
		}else if(items[i]==null){
			items[i]= text;
		}else if(items[i]!=null){
			if(items[items.length-1]!=null){
				addArrLength(1);
			}
			for(int x= items.length-1; x>i;x--){
				items[x]=items[x-1];
			}
			items[i]=text;
		}
	}

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
		if(i>= items.length|| i<0 ){
			System.out.println("Index does not exist");
			return;
		}
		String[] other = new String[items.length];
		for(int x=0; x<items.length;x++){
			other[x]=items[x];
		}
		int n = list.countElements();
		addArrLength(n);
		int j=0;
		for(int x=i; x< i+list.countElements();x++){
			items[x]=list.getStringAt(j);
			j++;
		}
		int otherStart = i+n;
		for(int x=i;x< other.length;x++){
			items[otherStart]=other[x];
			otherStart++;
		}
	}

	@Override
	public String replaceStringAt(int i, String text) {
		// TODO: implement
		if(i>= items.length) throw new ArrayIndexOutOfBoundsException("Array out of bounds");
		String oldText=items[i];
		items[i]=text;
		return oldText;
	}
	
	@Override
	public String removeStringAt(int i) {
		// TODO: implement
		if(i>= items.length) throw new ArrayIndexOutOfBoundsException("Array out of bounds");
		String oldText=items[i];
		for(int x=i; x< items.length;x++){
			items[i]=items[i+1];
		}
		return oldText;
	}

	@Override
	public String getFirstString() {
		// TODO: implement
		return this.countElements()>0?items[0] :null;
	}

	@Override
	public String getLastString() {
		// TODO: implement
		return this.countElements()>0?items[items.length-1] :null;
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		ArrayStringList reversed = new ArrayStringList();
		reversed.addArrLength(items.length);
		int n= items.length-1;
		for(int i=0; i< items.length;i++){
			reversed.insertStringAt(i,items[n]);
			n--;
		}
		return reversed;
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		if(from>items.length)throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		for(int i=from; i< items.length; i++){
			if(text.equals(items[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int countElements() {
		return this.items.length;
	}

	@Override
	public String[] toStringArray() {
        return Arrays.copyOf(items,items.length);
	}

	public static void main(String[] args) {
		ArrayStringList a = new ArrayStringList();
		a.appendString("test");
		System.out.println(a.getStringAt(0));
		a.insertStringAt(0,"test2");
		System.out.println(Arrays.toString(a.items));
		ArrayStringList b = new ArrayStringList();
		b.appendString("A");
		b.appendString("B");
		a.insertStringListAt(1,b);
		System.out.println(Arrays.toString(a.items));
		System.out.println(Arrays.toString(b.items));
		StringList reversed= b.reverseStringList();
		System.out.println(Arrays.toString(reversed.toStringArray()));
	}
}
