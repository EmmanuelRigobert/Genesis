package miniProject3;

import codeübung6.Demo;

import java.util.Arrays;

/**
 * A linked list to store strings.
 * 
 * @author Marcus
 */
public class LinkedStringList implements StringList {

	/**
	 * An item in the linked list.
	 * 
	 * @author Marcus
	 */
	public static class Item {

		/**
		 * The string stored in the item.
		 */
		private final String string;
		
		/**
		 * The next element in the list or
		 * null, if this is the last element.
		 */
		private Item next;

		private Item previous;
		
		/**
		 * Creates an item to store the string.
		 * 
		 * @param string The string to store.
		 */
		public Item(String string) {

			this.string = string;
		}
		
		/**
		 * Returns the string stored in the item.
		 * 
		 * @return The string stored in the item.
		 */
		public String getString() {
			return string;
		}
		
		/**
		 * Returns the next item in the list or
		 * null, if this is the last item.
		 * 
		 * @return The next item.
		 */
		public Item getNext() {
			return next;
		}

		/**
		 * Returns the previous item in the list or
		 * null, if this is the first item.
		 *
		 * @return The next item.
		 */
		public Item getPrevious() {
			return previous;
		}
		
		/**
		 * Sets the next item of the list.
		 * 
		 * @param next The value for the next item.
		 */
		public void setNext(Item next) {
			this.next = next;
		}

		/**
		 * Sets the prev item of the list.
		 *
		 * @param previous The value for the previous item.
		 */
		public void setPrevious(Item previous) {
			this.previous = previous;
		}
		
	}
	
	/**
	 * The head (i.e. first element) of the
	 * list or null, if the list is empty.
	 */
	private Item head;
	private int counter=0;
	
	/**
	 * Creates a new, empty list.
	 */
	public LinkedStringList() {
		super();
	}

	@Override
	public String getFirstString() {
		// check if empty
		if (head == null) return null;
		// else return string in first element
		return head.getString();
	}
	
	@Override
	public void appendString(String text) {
		// TODO: implement
		Item item = new Item(text);
		if(head==null){
			head=item;
			counter++;
			return;
		}
		Item lastItem=lastItem();
		lastItem.setNext(item);
		item.setPrevious(lastItem);
		counter++;
	}
	public Item lastItem(){
		Item oldItem=head;
		Item currentItem;
		for(int i=0; i<counter;i++){
			currentItem=oldItem.next;
			if(currentItem!=null){
				oldItem=currentItem;
			}
		}
		return oldItem;
	}

	@Override
	public String getStringAt(int i) {
		// TODO: implement
		return toStringArray()[i];
	}

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
		if(i>counter) throw new ArrayIndexOutOfBoundsException("Item does not exist");
		if(counter==0){
			head=new Item(text);
			counter++;
		}
		Item old=head;
		for(int j=0; j<counter;j++){
			if(j==i){
				Item currentItem = new Item(text);
				if(i==0){
					head=currentItem;
					currentItem.setNext(old);
					old.setPrevious(head);
					counter++;
					return;
				}
				old.getPrevious().setNext(currentItem);
				currentItem.setPrevious(old.getPrevious());
				currentItem.setNext(old);
				old.setPrevious(currentItem);
				counter++;
				return;
			}
			old=old.getNext();
		}
	}

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
		//Convert List to LinkedStringList
		String[] newItems = list.toStringArray();
		Item newHead = new Item(newItems[0]);
		Item newTail=newHead;
		for(int x=1; x<newItems.length;x++){
			Item newItem = new Item(newItems[x]);
			newItem.setPrevious(newTail);
			newTail.setNext(newItem);
			newTail=newTail.next;
		}
		//Fit new linkedList in old linkedList
		Item current=head;
		int numOfNewItems = newItems.length;
		if(i==0){
			head=newHead;
			newTail.setNext(current);
			current.setPrevious(newTail);
			counter +=numOfNewItems;
			return;
		}
		for(int x=1;x<counter;x++){
			current=current.getNext();
			if(i==x){
				current.getPrevious().setNext(newHead);
				newHead.setPrevious(current.getPrevious());
				newTail.setNext(current);
				current.setPrevious(newTail);
				counter +=numOfNewItems;
				return;
			}
		}

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
	public String getLastString() {
		// TODO: implement
		return counter>0?this.toStringArray()[this.toStringArray().length]: null;
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		return new LinkedStringList();
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		return -1;
	}

	@Override
	public int countElements() {
		return counter;
	}

	@Override
	public String[] toStringArray() {
		String[] list = new String[counter];
		Item current = head;
		for(int i=0; i<counter;i++){
			list[i]=current.getString();
			current=current.next;
		}
		return list;
	}

	public static void main(String[] args) {
		LinkedStringList list = new LinkedStringList();
		list.appendString("Text");
		list.appendString("Text2");
//		System.out.println(Arrays.toString(list.toStringArray()));
		System.out.println("Before: "+Arrays.toString(list.toStringArray()));
		list.insertStringAt(0,"inserted");
		System.out.println("After: "+Arrays.toString(list.toStringArray()));
		list.insertStringListAt(0,list);
		System.out.println("After: "+Arrays.toString(list.toStringArray()));


	}
	
}
