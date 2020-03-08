package Stack;

public class Stackclient {

	public static void main(String[] args) throws Exception {
//		Stack stack=new Stack();
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.push(40);
//		stack.push(40);
//		stack.push(40);
////		stack.pop();
//		stack.display();
		DynamicStack s = new DynamicStack();
		DynamicStack h = new DynamicStack();
		for (int i = 1; i < 10; i++) {
			s.push(10 * i);
		}
		s.display();
		System.out.println("------------------");
		actualreverse(s, h);
		s.display();
		int arr[] = { 20,7,25,15,17,4,2,35,10,20 };
		nextgreaterelement(arr);
//		int ans[] = nextgreaterelementinorder(arr);
		int  ans2[]=stockspan(arr);
		for (int x : ans2) {
			System.out.print(x + " ");
		}
	}

	public static void displayreverse(DynamicStack s) throws Exception {
		if (s.isEmpty()) {
			return;
		}
		int temp = s.pop();
		displayreverse(s);
		System.out.println(temp + " ");
		s.push(temp);
	}

	public static void actualreverse(DynamicStack s, DynamicStack h) throws Exception {
		if (s.isEmpty()) {
			if (h.isEmpty()) {
				return;
			}
			int temp1 = h.pop();
			actualreverse(s, h);
			s.push(temp1);
			return;
		}
		int temp = s.pop();
		h.push(temp);
		actualreverse(s, h);
	}

	public static void nextgreaterelement(int arr[]) throws Exception {
		DynamicStack stack = new DynamicStack();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				System.out.println(stack.pop() + "->" + arr[i]);
			}
			stack.push(arr[i]);

		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + "->-1");
		}
	}

	public static int[] nextgreaterelementinorder(int arr[]) throws Exception {
		DynamicStack stack = new DynamicStack();
		int narr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				narr[stack.pop()] = arr[i];
			}
			stack.push(i);

		}
		while (!stack.isEmpty()) {
			narr[stack.pop()] = -1;
		}
		return narr;
	}

	public static int[] stockspan(int arr[]) throws Exception {
		DynamicStack stack = new DynamicStack();
		int narr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				narr[i] = i + 1;
			} else {
				narr[i] = i - stack.peek();
			}
			stack.push(i);

		}

		return narr;

	}

}
