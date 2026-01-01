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

	public  <T> void arrayCopy(T[] source, T[] destination, int startIndex, int stopIndex){
		for(int i=startIndex; i<= stopIndex; i++){
			destination[i]=source[i];
		}
	}

	@Override
	public void appendString(String text) {
		// TODO: implement
		boolean appended =  addElt(items, text);

		if(!appended){
			String[] newItems = new String[items.length+1];
			arrayCopy( items, newItems,0, items.length-1);
			items=newItems;
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
		return null;
	}

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
	}

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
	}

	@Override
	public String replaceStringAt(int i, String text) {
		// TODO: implement
		return null;
	}
	
	@Override
	public String removeStringAt(int i) {
		// TODO: implement
		return null;
	}

	@Override
	public String getFirstString() {
		// TODO: implement
		return null;
	}

	@Override
	public String getLastString() {
		// TODO: implement
		return null;
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		return new ArrayStringList();
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		return -1;
	}

	@Override
	public int countElements() {
		return 1;
	}

	@Override
	public String[] toStringArray() {
		return new String[0];
	}

	public static void main(String[] args) {
		ArrayStringList a = new ArrayStringList();
		a.appendString("test");
	}
	
	
}
