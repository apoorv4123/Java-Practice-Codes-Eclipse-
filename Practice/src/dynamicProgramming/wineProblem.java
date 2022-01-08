package dynamicProgramming;

public class wineProblem {

	public static void main(String[] args) {
		int[] wineBottles = { 2, 3, 5, 1, 4, 7, 2, 8, 1, 9, 3, 5, 2, 8 };
//		System.out.println(wineProblemRec(wineBottles, 1, 0, wineBottles.length - 1));
//		System.out.println(wineProblemTD(wineBottles, 1, 0, wineBottles.length - 1,
//				new int[wineBottles.length][wineBottles.length]));
//		System.out.println(wineProblemBU(wineBottles));

		System.out.println(wpRec(wineBottles, 1, 0, wineBottles.length - 1));
		System.out.println(
				wpTD(wineBottles, 1, 0, wineBottles.length - 1, new int[wineBottles.length][wineBottles.length]));
		System.out.println(wpBU(wineBottles));
	}

	public static int wineProblemRec(int[] arr, int year, int si, int ei) {
		if (si == ei) {
			return arr[si] * year;
		}
		int res = 0;
		// first bottlel̥
		int fb = wineProblemRec(arr, year + 1, si + 1, ei) + arr[si] * year;
		// last bottle
		int lb = wineProblemRec(arr, year + 1, si, ei - 1) + arr[ei] * year;
		res = Math.max(fb, lb);
		return res;
	}

	public static int wineProblemTD(int[] arr, int year, int si, int ei, int[][] strg) {
		if (si == ei) {
			return arr[si] * year;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int res = 0;
		// first bottle
		int fb = wineProblemTD(arr, year + 1, si + 1, ei, strg) + arr[si] * year;
		// last bottle
		int lb = wineProblemTD(arr, year + 1, si, ei - 1, strg) + arr[ei] * year;
		res = Math.max(fb, lb);
		strg[si][ei] = res;
		return res;
	}

	public static int wineProblemBU(int[] arr) {
		int[][] strg = new int[arr.length][arr.length];
		for (int slide = 0; slide < arr.length; slide++) {
			for (int si = 0; si <= arr.length - slide - 1; si++) {
				int ei = si + slide;
				int yr = arr.length - (ei - si + 1) + 1;
				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {
					int fst = strg[si + 1][ei] + arr[si] * yr;
					int lst = strg[si][ei - 1] + arr[ei] * yr;
					strg[si][ei] = Math.max(fst, lst);
				}
			}
		}
		return strg[0][arr.length - 1];
	}

	public static int wpRec(int[] arr, int yr, int si, int ei) {
		if (si > ei) {
			return 0;
		}

		// first
		int fItem = wpRec(arr, yr + 1, si + 1, ei) + arr[si] * yr;
		// last
		int lItem = wpRec(arr, yr + 1, si, ei - 1) + arr[ei] * yr;

		return Math.max(fItem, lItem);
	}

	public static int wpTD(int[] arr, int yr, int si, int ei, int[][] strg) {
		if (si > ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		// first
		int fItem = wpTD(arr, yr + 1, si + 1, ei, strg) + arr[si] * yr;
		// last
		int lItem = wpTD(arr, yr + 1, si, ei - 1, strg) + arr[ei] * yr;

		strg[si][ei] = Math.max(fItem, lItem);

		return Math.max(fItem, lItem);
	}

	public static int wpBU(int[] arr) {
		int[][] strg = new int[arr.length][arr.length];

		for (int slide = 0; slide < arr.length; slide++) {
			for (int si = 0; si <= arr.length - slide - 1; si++) {
				int ei = si + slide;
				int yr = arr.length - (ei - si + 1) + 1;
				if (si == ei) {
					strg[si][ei] = yr * arr[si];
				} else {
					int fst = strg[si + 1][ei] + yr * arr[si];
					int lst = strg[si][ei - 1] + yr * arr[ei];
					strg[si][ei] = Math.max(fst, lst);
				}
			}
		}
		return strg[0][arr.length - 1];
	}

}
