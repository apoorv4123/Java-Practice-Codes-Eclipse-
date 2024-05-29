package lecture8;

import java.util.Arrays;

public class MinimumPathSum_64 {
// Yet to search for a better approach
	public static void main(String[] args) {

		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		int[][] strg = new int[grid.length][grid[0].length];
		System.out.println(mpstd(grid, 0, 0, strg));

		System.out.println(mpsbu(grid));

	}

	public static int mpstd(int[][] grid, int row, int col, int[][] strg) {

		if (row >= grid.length || col >= grid[0].length) {
			return Integer.MAX_VALUE;
		}

		if (row == grid.length - 1 && col == grid[0].length - 1) {
			return grid[row][col];
		}

		if (strg[row][col] != 0) {
			return strg[row][col];
		}

		// right
		int r = mpstd(grid, row, col + 1, strg);

		// down
		int l = mpstd(grid, row + 1, col, strg);

		int ans = Math.min(r, l) + grid[row][col];

		strg[row][col] = ans;

		return ans;
	}

	public static int mpsbu(int[][] grid) {

		int[][] strg = new int[grid.length + 1][grid[0].length + 1];

		Arrays.fill(strg[strg.length - 1], Integer.MAX_VALUE);
		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = Integer.MAX_VALUE;
		}

		for (int row = strg.length - 2; row >= 0; row--) {
			for (int col = strg[0].length - 2; col >= 0; col--) {

				if (row == strg.length - 2 && col == strg[0].length - 2) {
					strg[row][col] = grid[row][col];
					continue;
				}

				strg[row][col] = Math.min(strg[row + 1][col], strg[row][col + 1]) + grid[row][col];
			}

		}
		return strg[0][0];
	}

}