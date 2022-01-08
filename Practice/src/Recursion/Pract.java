package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Pract {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String str = s.next();
//		 System.out.println(count(str));
//		System.out.println(coinToss(3));
		System.out.println(kpc("145"));
	}

	public static char count(String str) {
		int count = 0;
		int ans = 0;
		char ch = '-';
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				count = 1;
				ans = 1;
			} else if (str.charAt(i) == str.charAt(i - 1) && i != 0) {
				count++;
				if (count > ans) {
					ans = count;
					ch = str.charAt(i);
				}
			} else if (str.charAt(i) != str.charAt(i - 1) && i != 0) {
				ans = count;
				count = 1;
			}
		}
		return ch;
	}

	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = coinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add('H' + val);
			mr.add('T' + val);
		}
		return mr;
	}

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

	public static ArrayList<String> kpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = kpc(ros);
		ArrayList<String> mr = new ArrayList<>();
		String code = getCode(ch);
		for (String val : rr) {
			for (int i = 0; i < code.length(); i++) {
				mr.add(code.charAt(i) + val);
			}
		}
		return mr;
	}
}