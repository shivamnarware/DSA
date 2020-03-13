/**
 * 
 */
package generictree;
import java.util.*;
/**
 * @author SHIVAM NARWARE
 *
 */
public class generictreeclient {
	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println("----------------");
		System.out.println(gt.size());
		System.out.println("----------------");
		System.out.println(gt.max());
		System.out.println("----------------");
		System.out.println(gt.height());
		System.out.println("----------------");
		System.out.println(gt.find(60));
		System.out.println("----------------");
//	    gt.mirror();
//		gt.linearize();
//		gt.preorder();
//		gt.levelorder();
//		gt.printAtlevel(1);
		gt.levelorderlevelwise();
		System.out.println("----------------");
		gt.levelorderlw2();
		System.out.println("----------------");
		gt.zigzagtraversal();
//	    gt.display();
		

	}

}
