package lecture8;

public class OutOfBoundaryPaths_576 {

	public static void main(String[] args) {

		int m = 1;
		int n = 3;
		int N = 3;
		System.out.println(oobprec(m, n, N, 0, 1));

		int[][][] strg = new int[m + 1][n + 1][N + 1];
		System.out.println(oobptd(m, n, N, 0, 1, strg));
	}

	public static int oobprec(int m, int n, int N, int i, int j) {

		if (i < 0 || j < 0 || i == m || j == n) {
			return 1;
		}
		if (N == 0) {
			return 0;
		}

		// up
		int u = oobprec(m, n, N - 1, i - 1, j);
		// down
		int d = oobprec(m, n, N - 1, i + 1, j);
		// left
		int l = oobprec(m, n, N - 1, i, j - 1);
		// right
		int r = oobprec(m, n, N - 1, i, j + 1);

		return u + d + l + r;
	}

	public static int oobptd(int m, int n, int N, int i, int j, int[][][] strg) {

		if (i < 0 || j < 0 || i == m || j == n) {
			return 1;
		}
		if (N == 0) {
			return 0;
		}

		if (strg[i][j][N] != 0) {
			return strg[i][j][N];
		}

		// up
		int u = oobptd(m, n, N - 1, i - 1, j, strg);
		// down
		int d = oobptd(m, n, N - 1, i + 1, j, strg);
		// left
		int l = oobptd(m, n, N - 1, i, j - 1, strg);
		// right
		int r = oobptd(m, n, N - 1, i, j + 1, strg);

		int ans = u + d + l + r;

		strg[i][j][N] = ans;

		return ans;
	}

}
