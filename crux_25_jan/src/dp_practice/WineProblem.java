package dp_practice;

public class WineProblem {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 1, 4 };
		System.out.println(wprec(arr, 0, arr.length - 1, 1));
		System.out.println(wprec2(arr, 0, arr.length - 1));
		System.out.println(wptd(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(wpbu(arr));
	}

	public static int wprec(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return yr * arr[si];
		}

		// first
		int fst = wprec(arr, si + 1, ei, yr + 1) + yr * arr[si];
		// last
		int lst = wprec(arr, si, ei - 1, yr + 1) + yr * arr[ei];

		return Math.max(fst, lst);
	}

	public static int wprec2(int[] arr, int si, int ei) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		int fst = wprec2(arr, si + 1, ei) + yr * arr[si];
		int lst = wprec2(arr, si, ei - 1) + yr * arr[ei];

		return Math.max(fst, lst);

	}

	public static int wptd(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int fst = wptd(arr, si + 1, ei, strg) + yr * arr[si];
		int lst = wptd(arr, si, ei - 1, strg) + yr * arr[ei];

		int ans = Math.max(fst, lst);

		strg[si][ei] = ans;

		return ans;

	}

	public static int wpbu(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];
		for (int slide = 0; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int yr = n - (ei - si + 1) + 1;
				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {
					int fst = strg[si + 1][ei] + arr[si] * yr;
					int lst = strg[si][ei - 1] + arr[ei] * yr;
					strg[si][ei] = Math.max(fst, lst);
				}
			}
		}
		return strg[0][n - 1];
	}

}
