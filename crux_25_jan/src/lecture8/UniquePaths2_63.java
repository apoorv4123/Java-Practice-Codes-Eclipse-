package lecture8;

public class UniquePaths2_63 {

	public static void main(String[] args) {

//		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] obstacleGrid = { { 1 } };

//		System.out.println(up2rec(obstacleGrid, 0, 0));

//		int[][] strg = new int[obstacleGrid.length][obstacleGrid[0].length];
//		System.out.println(up2td(obstacleGrid, 0, 0, strg));

		System.out.println(up2bu(obstacleGrid));

	}

	public static int up2rec(int[][] obstacleGrid, int cr, int cc) {

		if (cr == obstacleGrid.length || cc == obstacleGrid[0].length || obstacleGrid[cr][cc] == 1) {
			return 0;
		}

		if (cr == obstacleGrid.length - 1 && cc == obstacleGrid[0].length - 1) {
			return 1;
		}

		// right
		int r = up2rec(obstacleGrid, cr, cc + 1);

		// down
		int d = up2rec(obstacleGrid, cr + 1, cc);

		return r + d;

	}

	public static int up2td(int[][] obstacleGrid, int cr, int cc, int[][] strg) {

		if (cr == obstacleGrid.length || cc == obstacleGrid[0].length || obstacleGrid[cr][cc] == 1) {
			return 0;
		}

		if (cr == obstacleGrid.length - 1 && cc == obstacleGrid[0].length - 1) {
			return 1;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		// right
		int r = up2td(obstacleGrid, cr, cc + 1, strg);

		// down
		int d = up2td(obstacleGrid, cr + 1, cc, strg);

		strg[cr][cc] = r + d;

		return r + d;

	}

	public static int up2bu(int[][] obstacleGrid) {

		int[][] strg = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

//		strg[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1; don't do this here

		for (int row = strg.length - 2; row >= 0; row--) {
			for (int col = strg[0].length - 2; col >= 0; col--) {

				if (obstacleGrid[row][col] == 1) {
					continue;
				}

				if ((row == strg.length - 2 && col == strg[0].length - 2)) {
					strg[row][col] = 1;
					continue;
				}

				strg[row][col] = strg[row + 1][col] + strg[row][col + 1];

			}
		}
		return strg[0][0];
	}

}
