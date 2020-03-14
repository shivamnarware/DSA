package BinarySearchTree;

public class BinarySearchTreeClient {

	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50,60,70};
		BinarySearchTree bst=new BinarySearchTree(arr);
//		bst.display();
//		bst.printinrange(37, 67);
        bst.replacewithsumlarger();
        bst.display();
	}

}
