package lecture8;

import java.util.Arrays;

public class UniquePaths_62 {

	public static void main(String[] args) {

		int m = 7;
		int n = 3;

		System.out.println(uprec(n - 1, m - 1));

		int[][] strg = new int[n][m];
		System.out.println(uptd(n - 1, m - 1, strg));

		System.out.println(upbu(n - 1, m - 1));
		System.out.println(upbuse(n - 1, m - 1));
	}

	public static int uprec(int er, int ec) {

		if (er < 0 || ec < 0) {
			return 0;
		}
		if (er == 0 && ec == 0) {
			return 1;
		}

		// right
		int r = uprec(er, ec - 1);

		// down
		int d = uprec(er - 1, ec);

		return r + d;
	}

	public static int uptd(int row, int col, int[][] strg) {

		if (row < 0 || col < 0) {
			return 0;
		}
		if (row == 0 && col == 0) {
			return 1;
		}

		if (strg[row][col] != 0) {
			return strg[row][col];
		}

		// right
		int r = uptd(row, col - 1, strg);

		// down
		int d = uptd(row - 1, col, strg);

		int ans = r + d;

		strg[row][col] = ans;

		return ans;
	}

	public static int upbu(int er, int ec) {

		int[][] strg = new int[er + 1][ec + 1];

		Arrays.fill(strg[strg.length - 1], 1);
		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = 1;
		}

		for (int row = strg.length - 2; row >= 0; row--) {
			for (int col = strg[0].length - 2; col >= 0; col--) {
				strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
			}
		}
		return strg[0][0];
	}

	public static int upbuse(int er, int ec) {

		int[] strg = new int[ec + 1];
		Arrays.fill(strg, 1);

		for (int slide = 1; slide <= er; slide++) {
			for (int col = strg.length - 2; col >= 0; col--) {
				strg[col] = strg[col + 1] + strg[col];
			}
		}
		return strg[0];
	}

}
