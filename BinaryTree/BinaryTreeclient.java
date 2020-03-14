package BinaryTree;

public class BinaryTreeclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 true 20 true 40 false false true 50 false false true 30 false true 60
		// false false
//		 BinaryTree bt=new BinaryTree();
//		 bt.display();
//		 System.out.println(bt.size());
//		 System.out.println("------------");
//		 System.out.println(bt.max());
//		 System.out.println("-------------");
//		 System.out.println(bt.heigth());
//		 System.out.println("-------------");
//		 System.out.println(bt.find(100));
//		 System.out.println("-------------");
//		 System.out.println(bt.diameter());
//		 System.out.println("-------------");
//		 System.out.println(bt.diameter2().diameter);
//		 System.out.println("-------------");
//		 System.out.println(bt.isbalanced());
//		 System.out.println("-------------");
//		 System.out.println(bt.isbalanced2().isbal);
//		 System.out.println("-------------");
//		 System.out.println(bt.deepestdepth().ht);
		int[] pre1 = { 10, 20, 40, 80, 90, 50, 30, 60, 100, 120, 70, 70 };
		int[] in1 = { 80, 40, 90, 20, 50, 10, 100, 60, 70, 120, 30, 70 };
		BinaryTree bt1 = new BinaryTree(pre1, in1);
//		bt1.display();
//		System.out.println("-----------------");
//		System.out.println(bt1.subtreesum());
		bt1.verticalorder();
	}

}
