package Recursion;

import java.util.*;

public class RecursionQuestions {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(power(2, 5));
		System.out.println(fibonacci(8));

		System.out.println(getSubsequences("abc"));
		System.out.println(getPermutations("abc"));

		System.out.println(getMazePath(0, 0, 2, 2));
		System.out.println(getBoardPath(0, 6));
		
		validParenthesis(3, 0, 0, "");
	}

	public static int factorial(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static int power(int a, int b) {// a^b
		if (b == 0) {
			return 1;
		}
		return a * power(a, b - 1);
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static ArrayList<String> getSubsequences(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add(" ");
			return br;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getSubsequences(ros);

		for (String s : rr) {
			mr.add(s);
			mr.add(ch + s);
		}

		return mr;

	}

	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add(" ");
			return br;
		}
		ArrayList<String> rr = coinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();
		for (String s : rr) {
			mr.add("T" + s);
			mr.add("H" + s);
		}
		return mr;
	}

	public static ArrayList<String> getPermutations(String ques) {
		if (ques.length() == 1) {
			ArrayList<String> br = new ArrayList<String>();
			br.add(ques);
			return br;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getPermutations(ros);

		for (String s : rr) {
			for (int i = 0; i <= s.length(); i++) {
				mr.add(s.substring(0, i) + ch + s.substring(i));
			}
		}
		return mr;
	}

	public static ArrayList<String> getBoardPath(int current, int target) {

		if (current == target) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (current > target) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int i = 1; i <= 6; i++) {
			ArrayList<String> rr = getBoardPath(current + i, target);
			for (String s : rr) {
				mr.add(i + s);
			}
		}

		return mr;

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> hm = getMazePath(cr, cc + 1, er, ec);
		ArrayList<String> vm = getMazePath(cr + 1, cc, er, ec);

		ArrayList<String> mr = new ArrayList<String>();

		for (String s : hm) {
			mr.add("H" + s);
		}

		for (String s : vm) {
			mr.add("V" + s);
		}

		return mr;
	}
//	
//	public static ArrayList<String> getKPC(){
//		
//	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void printPermutations(String ques, String res) {

	}

	public static void validParenthesis(int n, int count_open, int count_close, String ans) {

		if (count_open > n || count_close > count_open) {
			return;
		}
		
		if (count_close == n && count_open == n) {
			System.out.println(ans);
			return;
		}

		validParenthesis(n, count_open + 1, count_close, ans + "(");
		validParenthesis(n, count_open, count_close + 1, ans + ")");

	}
	
	public static void lexicoPrinting(int max, int curr) {
		
	}

}