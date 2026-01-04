package recursion;

public class BinaryTree {

	BinaryTreeNode top;

	public BinaryTree() {
		top = null;
	}

	/*
	 * BEGINN des zu implementierenden Bereichs
	 */

	// Aufgabe 1
	public void insert(int number) {
//		if(exist(top,number))return;
		top = insert(top,number);
	}
	public BinaryTreeNode insert(BinaryTreeNode current, int number){
		if(current==null)return new BinaryTreeNode(number);
		if(number<current.getNumber())current.smaller=insert(current.smaller,number);
		if(number>current.getNumber())current.larger=insert(current.larger,number);
		return current;
	}
	public boolean exist(BinaryTreeNode current, int number){
		if(current==null)return false;
		if(number < current.getNumber())return exist(current.smaller,number);
		if(number> current.getNumber())return exist(current.larger,number);
		return true;
	}

	// Aufgabe 2
	public int maxDepth() {
		return maxDepth(top);
	}
	public int maxDepth(BinaryTreeNode current){
		if(current==null)return 0;
		int left = maxDepth(current.smaller);
		int right = maxDepth(current.larger);
		int deeper = left>=right?left:right;
		return 1 + deeper;
	}

	// Aufgabe 3
	public int sumOfElements() {
		return sumOfElements(top);
	}
	public int sumOfElements(BinaryTreeNode current){
		if(current==null)return 0;
		int left = sumOfElements(current.smaller);
		int right = sumOfElements(current.larger);
		return current.getNumber() + left + right;
	}

	// Aufgabe 4
	public void deleteNumber(int number) {
		if(top==null)return;

	}
	public void deleteNumber(BinaryTreeNode current, int number){

	}

	/*
	 * ENDE des zu implementierenden Bereichs
	 */

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(2);
		tree.insert(17);
		tree.insert(-3);
		tree.insert(8);
		tree.insert(20);
		tree.insert(4);
		tree.insert(4);
		System.out.println(tree.maxDepth());
		System.out.println(tree.sumOfElements());
	}
}
