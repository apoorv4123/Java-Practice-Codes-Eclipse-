package Recursion;

public class ArrandRec {

	public static void main(String[] args) {
		int[] arr = { 10, 30, 50, 40, 30, 30, 11 };
//		System.out.println(max(arr, 0));
//		System.out.println(firstIdx(arr, 0, 30));
//		System.out.println(lastIdx(arr, 0, 30));
//		for (int val : allIndices(arr, 0, 30, 0)) {
//			System.out.print(val + " ");
//		}
//		System.out.println(isPalindrome("namAn"));
		System.out.println(countPalindrome("abc"));
		System.out.println(count("aaabacbd"));
	}

	public static int max(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			return arr[idx];
		}
		int rr = max(arr, idx + 1);
		if (rr > arr[idx]) {
			return rr;
		}
		return arr[idx];
	}

	public static int firstIdx(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		if (arr[idx] == item) {
			return idx;
		}
		int rr = firstIdx(arr, idx + 1, item);
		return rr;
	}

	public static int lastIdx(int[] arr, int idx, int item) {
		if (idx == arr.length) {
			return -1;
		}
		int rr = lastIdx(arr, idx + 1, item);
		if (arr[idx] == item && rr == -1) {
			return idx;
		}
		return rr;
	}

	public static int[] allIndices(int[] arr, int idx, int item, int count) {
		if (idx == arr.length) {
			int[] br = new int[count];
			return br;
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

	public static int countPalindrome(String str) {
		int count = 0;
		for (int bi = 0; bi <= str.length() - 1; bi++) {
			for (int ei = bi + 1; ei <= str.length(); ei++) {
				String substr = str.substring(bi, ei);
				if (isPalindrome(substr)) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static char count(String str) {
		int count = 0;
		int ans = 0;
		char ch='-';
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				count = 1;
				ans = 1;
			} else if (str.charAt(i) == str.charAt(i - 1) && i != 0) {
				count++;
				if (count > ans) {
					ans = count;
					ch=str.charAt(i);
				}
			} else if (str.charAt(i) != str.charAt(i - 1) && i != 0) {
				ans=count;
				count = 1;
			}
		}
		return ch;
	}

}