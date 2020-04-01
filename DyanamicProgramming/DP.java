package DyanamicProgramming;

import java.util.Scanner;

public class DP {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		int strg[][] = new int[21][21];
//		System.out.println(mazepathR(0, 0, 15, 15));
//		System.out.println(mazepathTD(0, 0, 15, 15, strg));
//		System.out.println(mazepathBU(15, 15));
//		System.out.println(fibonacii(45));
//		int n = 45;
//		int strg[] = new int[n + 1];
//		System.out.println(fibonaciiBU(n, strg));
//		System.out.println(fibonaciiBU(25));
//		System.out.println(boardpath(0, 20));
//		int strg[] = new int[27];
//		System.out.println(boardpathTD(0, 4, strg));
//		System.out.println(boardpathBU(100));
//		int arr[] = { 2, 3, 5, 1, 4 };
//		String str1 = "baaabab";
//		String str2 = "ba*a?";

		// int strg[][] = new int[arr.length + 1][arr.length + 1];
//		System.out.println(MCM(arr, 0, arr.length-1));
//		System.out.println(MCMTD(arr, 0, arr.length - 1, strg));
//		System.out.println(MCMBU(arr, 0, arr.length - 1));
//		System.out.println(wineproblem(arr, 0, arr.length - 1, 1));
//		System.out.println(wineproblemBU(arr));
//		System.out.println(wildcardmatching(str1, str2));
//		int wt[] = { 10, 20, 30 };
//		int price[] = { 60, 100, 120 };
//		int cap = 50;
//		int strg[][] = new int[wt.length][cap + 1];
//		System.out.println(knapsackTD(wt, price, 0, cap, strg));
//		System.out.println(knapsackBU(wt, price, cap));

//		int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
//		System.out.println(rodcuttingBU(price, 8));
//		System.out.println(eggdrop(10, 2));
//		System.out.println(eggdropBU(10, 2));
//		System.out.println(numberofBST(2));
//		System.out.println(palindromiccuts("ababbc", 0, 5));
//		int[][] strg = new int[6][6];
//		System.out.println(palindromiccutsTD("ababbc", 0, 5, strg));
//		  Scanner scn=new Scanner(System.in);
//		  String str=scn.next();
//		  int T=scn.nextInt();
		System.out.println(palindromiccutsBU("abc", 0, 2));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int mazepathR(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {

			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int ch = mazepathR(cr + 1, cc, er, ec);
		int cv = mazepathR(cr, cc + 1, er, ec);

		return ch + cv;
	}

	public static int mazepathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {

			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ch = mazepathR(cr + 1, cc, er, ec);
		int cv = mazepathR(cr, cc + 1, er, ec);

		strg[cr][cc] = ch + cv;
		return ch + cv;
	}

	public static int mazepathBU(int er, int ec) {
		int strg[][] = new int[er + 2][ec + 2];
		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {
				if (r == er && c == ec) {
					strg[r][c] = 1;
				} else {
					strg[r][c] = strg[r + 1][c] + strg[r][c + 1];
				}
			}
		}
		return strg[0][0];

	}

	public static int fibonacii(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		int fn = fibonacii(n - 1) + fibonacii(n - 2);
		return fn;
	}

	public static int fibonaciiTD(int n, int[] strg) {
		if (n == 1 || n == 0) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fn = fibonaciiTD(n - 1, strg) + fibonaciiTD(n - 2, strg);
		strg[n] = fn;
		return fn;

	}

	public static int fibonaciiBU(int n) {
		int strg[] = new int[n + 1];
		strg[0] = 1;
		strg[1] = 1;
		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];

	}

	public static int boardpath(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardpath(curr + dice, end);
		}
		return c;
	}

	public static int boardpathTD(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardpath(curr + dice, end);
		}
		strg[curr] = c;
		return c;

	}

	public static int boardpathBU(int n) {
		int strg[] = new int[n + 6];
		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}
		return strg[0];
	}

	public static int MCM(int[] arr, int si, int ei) {
		if (si + 1 == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int lp = MCM(arr, si, k);
			int rp = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];
			int total = sw + lp + rp;
			if (min > total) {
				min = total;
			}

		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int strg[][]) {
		if (si + 1 == ei) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int lp = MCMTD(arr, si, k, strg);
			int rp = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];
			int total = sw + lp + rp;
			if (min > total) {
				min = total;
			}

		}
		strg[si][ei] = min;
		return min;
	}

	public static int MCMBU(int[] arr, int si, int ei) {
		int n = arr.length;
		int strg[][] = new int[n][n];
		for (int slide = 1; slide <= n - 2; slide++) {
			for (si = 0; si <= n - slide - 2; si++) {
				ei = slide + 1 + si;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int lp = strg[si][k];
					int rp = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];
					int total = sw + lp + rp;
					if (min > total) {
						min = total;
					}
				}
				strg[si][ei] = min;
			}

		}
		return strg[0][n - 1];

	}

	public static int wineproblem(int arr[], int si, int ei, int yr) {
		if (si == ei) {
			return arr[si] * yr;
		}
		int lp = wineproblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int rp = wineproblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(lp, rp);
		return ans;
	}

	public static int wineproblemTD(int arr[], int si, int ei, int strg[][]) {
		int yr = arr.length - ei + si;
		if (si == ei) {
			return arr[si] * yr;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int lp = wineproblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int rp = wineproblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(lp, rp);
		strg[si][ei] = ans;
		return ans;
	}

	public static int wineproblemBU(int arr[]) {
		int n = arr.length;
		int strg[][] = new int[n][n];
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = slide + si;
				int yr = n - ei + si;
				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {
					int lp = strg[si + 1][ei] + arr[si] * yr;
					int rp = strg[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(lp, rp);
					strg[si][ei] = ans;
				}
			}
		}
		return strg[0][n - 1];

	}

	public static boolean wildcardmatching(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;
		if (chs == chp || chp == '?') {
			ans = wildcardmatching(ros, rop);
		} else if (chp == '*') {
			ans = wildcardmatching(src, rop) || wildcardmatching(ros, pat);
		} else {
			ans = false;
		}

		return ans;

	}

	public static int wildcardmatchingTD(String src, String pat, int[][] strg) {

		if (strg[src.length()][pat.length()] != 0) {
			return strg[src.length()][pat.length()];
		}

		if (src.length() == 0 && pat.length() == 0) {
			return 2;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return 1;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return 1;
				}
			}

			return 2;

		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		int ans;
		if (chs == chp || chp == '?') {
			ans = wildcardmatchingTD(ros, rop, strg);
		} else if (chp == '*') {

			if (wildcardmatchingTD(src, rop, strg) == 2 || wildcardmatchingTD(ros, pat, strg) == 2)
				ans = 2;
			else
				ans = 1;
		} else {
			ans = 1;
		}

		strg[src.length()][pat.length()] = ans;

		return ans;

	}

	public static int knapsack(int wt[], int price[], int vidx, int cap) {
		if (wt.length == vidx) {
			return 0;
		}
		int exclude = knapsack(wt, price, vidx + 1, cap);
		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapsack(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];
		}
		int ans = Math.max(exclude, include);
		return ans;
	}

	public static int knapsackTD(int wt[], int price[], int vidx, int cap, int strg[][]) {
		if (wt.length == vidx) {
			return 0;
		}
		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int exclude = knapsackTD(wt, price, vidx + 1, cap, strg);
		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapsackTD(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];
		}
		int ans = Math.max(exclude, include);
		strg[vidx][cap] = ans;
		return ans;
	}

	public static int knapsackBU(int wt[], int price[], int cap) {
		int strg[][] = new int[wt.length + 1][cap + 1];
		for (int r = wt.length - 1; r >= 0; r--) {
			for (int c = 0; c <= cap; c++) {
				int exclude = strg[r + 1][c];
				int include = 0;
				if (c >= wt[r]) {
					include = strg[r + 1][c - wt[r]] + price[r];
				}
				int ans = Math.max(exclude, include);
				strg[r][c] = ans;
			}
		}
		return strg[0][cap];
	}

	public static int rodcutting(int price[], int n) {
		int left = 1;
		int right = n - 1;
		int max = price[n];
		while (left <= right) {
			int lp = rodcutting(price, left);
			int rp = rodcutting(price, right);
			int total = lp + rp;
			if (total > max) {
				max = total;
			}
			left++;
			right--;
		}
		return max;
	}

	public static int rodcuttingTD(int price[], int n, int strg[]) {
		if (strg[n] != 0) {
			return strg[n];
		}
		int left = 1;
		int right = n - 1;
		int max = price[n];
		while (left <= right) {
			int lp = rodcuttingTD(price, left, strg);
			int rp = rodcuttingTD(price, right, strg);
			int total = lp + rp;
			if (total > max) {
				max = total;
			}
			left++;
			right--;
		}
		strg[n] = max;
		return max;
	}

	public static int rodcuttingBU(int price[], int n) {
		int strg[] = new int[n + 1];
		int left = 1;
		int right = n - 1;
		int max = price[n];
		while (left <= right) {
			int lp = price[left];
			int rp = price[right];
			int total = lp + rp;
			if (total > max) {
				max = total;
			}
			left++;
			right--;
		}
		strg[n] = max;
		return strg[n];
	}

	public static int eggdrop(int floor, int eggs) {
		if (floor == 0 || floor == 1) {
			return floor;
		}
		if (eggs == 1) {
			return floor;
		}
		int min = Integer.MAX_VALUE;
		for (int f = 1; f <= floor; f++) {
			int eggbreak = eggdrop(f - 1, eggs - 1);
			int eggdoestnotbreak = eggdrop(floor - f, eggs);
			int ans = Math.max(eggbreak, eggdoestnotbreak) + 1;
			if (min > ans) {
				min = ans;
			}
		}
		return min;
	}

	public static int eggdropTD(int floor, int eggs, int strg[][]) {
		if (strg[floor][eggs] != 0) {
			return strg[floor][eggs];
		}
		if (floor == 0 || floor == 1) {
			return floor;
		}
		if (eggs == 1) {
			return floor;
		}
		int min = Integer.MAX_VALUE;
		for (int f = 1; f <= floor; f++) {
			int eggbreak = eggdropTD(f - 1, eggs - 1, strg);
			int eggdoestnotbreak = eggdropTD(floor - f, eggs, strg);
			int ans = Math.max(eggbreak, eggdoestnotbreak) + 1;
			if (min > ans) {
				min = ans;
			}
		}
		strg[floor][eggs] = min;
		return min;
	}

	public static int eggdropBU(int floors, int eggs) {
		int strg[][] = new int[floors + 1][eggs + 1];
		// one egg .
		for (int floor = 1; floor < strg.length; floor++) {
			strg[floor][1] = floor;
		}
		// one floor
		for (int egg = 1; egg < strg[0].length; egg++) {
			strg[1][egg] = 1;
		}
		for (int floor = 2; floor <= floors; floor++) {
			for (int egg = 2; egg <= eggs; egg++) {
				int min = Integer.MAX_VALUE;
				for (int f = 1; f <= floor; f++) {
					int eggbreak = strg[f - 1][eggs - 1];
					int eggdoestnotbreak = strg[floor - f][eggs];
					int ans = Math.max(eggbreak, eggdoestnotbreak) + 1;
					if (min > ans) {
						min = ans;
					}
				}
				strg[floor][egg] = min;
			}
		}
		return strg[floors][eggs];
	}

	public static int numberofBST(int n) {
		if (n <= 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int fp = numberofBST(i - 1);
			int sp = numberofBST(n - i);
			int total = fp * sp;
			ans += total;
		}
		return ans;
	}

	public static int numberofBSTTD(int n, int strg[]) {
		if (n <= 1) {
			return 1;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int fp = numberofBST(i - 1);
			int sp = numberofBST(n - i);
			int total = fp * sp;
			ans += total;
		}
		strg[n] = ans;
		return ans;
	}

	public static int numberofBSTBU(int n) {
		int strg[] = new int[n + 1];
		strg[0] = 1;
		strg[1] = 1;
		for (int i = 2; i <= strg.length; i++) {
			int ans = 0;
			for (int root = 1; root <= i; root++) {
				int fp = strg[root - 1];
				int sp = strg[n - root];
				int total = fp * sp;
				ans += total;

			}
			strg[i] = ans;
		}
		return strg[n];

	}

	public static int palindromiccuts(String str, int si, int ei) {
		if (isPalindrome(str, si, ei)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = palindromiccuts(str, si, k);
			int sp = palindromiccuts(str, k + 1, ei);
			int ans = fp + sp + 1;
			if (min > ans) {
				min = ans;
			}
		}
		return min;
	}

	private static boolean isPalindrome(String str, int si, int ei) {
		int left = si;
		int right = ei;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static int palindromiccutsTD(String str, int si, int ei, int strg[][]) {
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		if (isPalindrome(str, si, ei)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = palindromiccuts(str, si, k);
			int sp = palindromiccuts(str, k + 1, ei);
			int ans = fp + sp + 1;
			if (min > ans) {
				min = ans;
			}
		}
		strg[si][ei] = min;
		return min;
	}

	public static int palindromiccutsBU(String str, int sie, int eie) {
		int strg[][] = new int[eie+1 ][eie+1];
		for (int slide = 0; slide <= strg.length - 1; slide++) {
			for (int si = 0; si <= strg[0].length - slide - 1; si++) {
				int ei = slide + si;

				if (isPalindromeBU(str.substring(si, ei+1))) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = si; k <= ei - 1; k++) {
						int fp = strg[si][k];
						int sp = strg[k + 1][ei];
						int ans = fp + sp + 1;
						if (min > ans) {
							min = ans;
						}
						strg[si][ei] = min;
					}

				}
			}
		}
		return strg[sie][eie];

	}

	private static boolean isPalindromeBU(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
