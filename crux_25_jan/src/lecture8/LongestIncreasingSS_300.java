package lecture8;

import java.util.Arrays;

public class LongestIncreasingSS_300 {

	public static void main(String[] args) {

//		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
//		int[] arr = { 0 };
		System.out.println(LISSBU(arr));

		System.out.println(LISSBUnlogn(arr));

	}

	public static int LISSBU(int[] arr) {

		if (arr.length == 0) {
			return 0;
		}

		int[] strg = new int[arr.length];

		Arrays.fill(strg, 1);

		int max = 1;

		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j] + 1);

					max = Math.max(max, strg[i]);
				}

			}
		}
		return max;
	}

	public static int LISSBUnlogn(int[] arr) {

		int[] le = new int[arr.length];

		le[0] = arr[0];
		int len = 1;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > le[len - 1]) {
				le[len] = arr[i];
				len++;
			} else {
				int idx = binarySearch(le, 0, len - 1, arr[i]);
				le[idx] = arr[i];
			}

//			System.out.print(arr[i] +" : ");
//			for(int val : le) {
//				System.out.print(val + " ");
//			}
//			System.out.println();

		}
		return len;

	}

	public static int binarySearch(int[] arr, int si, int ei, int item) {

		int low = si;
		int high = ei;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (item > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return low;

	}
}
