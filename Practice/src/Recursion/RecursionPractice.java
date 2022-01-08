package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionPractice {

	public static void main(String args[]) {
//		int[] arr = { 10, 20, 30, 70, 50, 30, 30, 60 };
//		System.out.println(maxArr(arr, 0));
//		System.out.println(firstIndex(arr, 0, 30));
//		System.out.println(lastIndex(arr, 0, 30));
//		for (int val : allIndices(arr, 0, 30, 0)) {
//			System.out.print(val + " ");
//		}
//		System.out.println(getPermutations("abc"));
//
//		printPermutations("abc", "");
//		printBoardPath(0, 10, "");
//		Scanner s = new Scanner(System.in);
//		int test = s.nextInt();
//		while (test > 0) {
//			String ques = s.next();
//			genBinaryStrings(ques, "");
//			test--;
//		}
	}

	public static void genBinaryStrings(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		if (ch == '1' || ch == '0') {
			genBinaryStrings(roq, ans + ch);
		} else if (ch == '?') {
			genBinaryStrings(roq, ans + '0');
			genBinaryStrings(roq, ans + '1');
		}
	}

	public static int maxArr(int[] arr, int idx) {
		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int rr = maxArr(arr, idx + 1);
		return Math.max(arr[idx], rr);
	}

	public static int firstIndex(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		if (arr[idx] == item) {
			return idx;
		}
		int rr = firstIndex(arr, idx + 1, item);
		return rr;
	}

	public static int lastIndex(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		int rr = lastIndex(arr, idx + 1, item);
		if (arr[idx] == item && rr == -1) {
			return idx;
		}
		return rr;
	}

	public static int[] allIndices(int[] arr, int idx, int item, int count) {
		if (idx == arr.length) {
			int[] rr = new int[count];
			return rr;
		}
		if (arr[idx] == item) {
			int[] rr = allIndices(arr, idx + 1, item, count + 1);
			rr[count] = idx;
			return rr;
		} else {
			int[] rr = allIndices(arr, idx + 1, item, count);
			return rr;
		}
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getPermutations(str.substring(1));
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + str.charAt(0) + val.substring(i));
			}
		}
		return mr;
	}

	public static void printPermutations(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			printPermutations(str.substring(0, i) + str.substring(i + 1), ans + ch);
		}
	}

	public static void printBoardPath(int curr, int target, String ans) {
		if (curr == target) {
			System.out.println(ans);
			return;
		}
		if (curr > target) {
			return;
		}
		for (int i = 1; i <= 6; i++) {
			printBoardPath(curr + i, target, ans + i);
		}
	}
}