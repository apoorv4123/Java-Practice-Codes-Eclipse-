package strings;

import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
//		int[] arr = takeInput();
//		int[] imd = new int[arr.length];
//		int q = scn.nextInt();
//		while (q > 0) {
//			int times = scn.nextInt();
//			times %= arr.length;
//			// System.out.println(times);
//			while (times > 0) {
//				int first = arr[arr.length - 1];
//				for (int i = arr.length - 1; i > 0; i--) {
//					imd[i] = arr[i - 1];
//				}
//				imd[0] = first;
//				times--;
//			}
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] += imd[i];
//			}
//			for (int val : arr) {
//				System.out.print(val + " ");
//			}
//			q--;
//		}
//		System.out.println(sum(arr) % 1000000007);
//		System.out.println(stringStringCompression("aaabbccgsss"));
	}

	public static int[] takeInput() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static int sum(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

//aaabbccgsss
	public static String stringStringCompression(String str) {
		String ans = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				ans += str.charAt(i - 1);
				if (count > 1) {
					ans += count;
				}
				count = 1;
			}
		}
		ans += str.charAt(str.length() - 1);
		if (count != 1) {
			ans += count;
		}
		return ans;
	}

}