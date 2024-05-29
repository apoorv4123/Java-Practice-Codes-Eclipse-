package lecture8;

import java.util.Arrays;

public class Mixtures {

	public static void main(String[] args) {

		int[] arr = { 40, 60, 20, 50 };

		System.out.println(MixturesRec(arr, 0, arr.length - 1));

		int[][] strg = new int[arr.length][arr.length];
		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(Mixturestd(arr, 0, arr.length - 1, strg));

		System.out.println(Mixturesbu(arr));

	}

	public static int MixturesRec(int[] arr, int si, int ei) {

		if (ei == si) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k < ei; k++) {

			int fp = MixturesRec(arr, si, k);
			int sp = MixturesRec(arr, k + 1, ei);

			int sw = newClr(arr, si, k) * newClr(arr, k + 1, ei);

			int totalSmokeProduced = fp + sp + sw;

			if (totalSmokeProduced < min) {
				min = totalSmokeProduced;
			}

		}
		return min;
	}

	public static int newClr(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

	public static int Mixturestd(int[] arr, int si, int ei, int[][] strg) {

		if (ei == si) {
			return 0;
		}

		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k < ei; k++) {

			int fp = Mixturestd(arr, si, k, strg);
			int sp = Mixturestd(arr, k + 1, ei, strg);

			int sw = newClr(arr, si, k) * newClr(arr, k + 1, ei);

			int totalSmokeProduced = fp + sp + sw;

			if (totalSmokeProduced < min) {
				min = totalSmokeProduced;
			}

		}

		strg[si][ei] = min;

		return min;
	}

	public static int Mixturesbu(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 0; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				if (si == ei) {
					strg[si][ei] = 0;
				} else {

					int min = Integer.MAX_VALUE;

					for (int k = si; k < ei; k++) {

						int fp = strg[si][k];
						int sp = strg[k + 1][ei];

						int sw = newClr(arr, si, k) * newClr(arr, k + 1, ei);

						int totalSmokeProduced = fp + sp + sw;

						if (totalSmokeProduced < min) {
							min = totalSmokeProduced;
						}
					}
					strg[si][ei] = min;
				}
			}
		}
		return strg[0][n - 1];
	}

}
