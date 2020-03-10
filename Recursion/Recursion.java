package Recursion;

import java.util.ArrayList;

public class Recursion {

	public static void main(String[] args) {
//		System.out.println(boardpath(0, 10));
//		System.out.println(mazepath(0, 0, 2, 2));
//		System.out.println(subsequence("abc"));
//		System.out.println(permution("abc"));
//		System.out.println(lowerupper("a1b2"));
//		validparenthesis(2, 0, 0, "");
//		permuatation("abac", "");
//		permutation2("abac", "");
		lexicocounting(0, 1000);

	}

	public static ArrayList<String> boardpath(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<String>();
		for (int dice = 1; dice <= 6 && dice + curr <= end; dice++) {
			ArrayList<String> rr = boardpath(curr + dice, end);
			for (String val : rr) {
				mr.add(dice + val);
			}
		}
		return mr;
	}

	public static ArrayList<String> mazepath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rrh = mazepath(cr + 1, cc, er, ec);
		for (String ans1 : rrh) {
			mr.add("H" + ans1);
		}
		ArrayList<String> rrv = mazepath(cr, cc + 1, er, ec);
		for (String ans2 : rrv) {
			mr.add("V" + ans2);
		}
		return mr;
	}

	public static ArrayList<String> subsequence(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = subsequence(ros);
		for (String ans : rr) {
			mr.add(ans);
			mr.add(ch + ans);
		}
		return mr;
	}

	public static ArrayList<String> permution(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = subsequence(ros);
		for (String ans : rr) {
			for (int i = 0; i <= ans.length(); i++) {
				String fans = ans.substring(0, i) + ch + ans.substring(i);
				mr.add(fans);
			}
		}
		return mr;

	}

	public static ArrayList<String> lowerupper(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rr = subsequence(ros);
		for (String ans : rr) {
			if (Character.isDigit(ch)) {
				mr.add(ch + ans);
			} else {
				mr.add(Character.toUpperCase(ch) + ans);
				mr.add(Character.toLowerCase(ch) + ans);
			}
		}
		return mr;
	}

	public static void validparenthesis(int n, int open, int close, String ans) {
		if (close == n && open == n) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || close > open) {
			return;
		}
		validparenthesis(n, open + 1, close, ans + "(");
		validparenthesis(n, open, close + 1, ans + ")");
	}

	public static void permutation1(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			permutation1(ros, ch + ans);

		}

	}

	public static void permutation2(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);
			boolean flag = true;
			for (int j = i + 1; j < ques.length(); j++) {
				if (ques.charAt(j) == ch) {
					flag = false;
				}
			}
			if (flag) {
				permutation2(ros, ch + ans);
			}
		}
	}

	public static void lexicocounting(int curr, int end) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		for (; i <= 9; i++) {
			lexicocounting(curr * 10 + i, end);
		}
	}
}