package lecture8;

import java.util.Arrays;

public class DungeonGame_174 {

	public static void main(String[] args) {

		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		System.out.println(dgrec(dungeon, 0, 0, dungeon.length - 1, dungeon[0].length - 1));

		int[][] strg = new int[dungeon.length][dungeon[0].length];
		System.out.println(dgtd(dungeon, 0, 0, dungeon.length - 1, dungeon[0].length - 1, strg));

		// System.out.println(dgbu(dungeon));
		System.out.println(dgbu2(dungeon));
	}

	public static int dgrec(int[][] dungeon, int cr, int cc, int er, int ec) {

		if (cc == ec && cr == er) {
			return dungeon[cr][cc] < 0 ? 1 - dungeon[cr][cc] : dungeon[cr][cc];
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		// right
		int r = dgrec(dungeon, cr, cc + 1, er, ec);

		// down
		int d = dgrec(dungeon, cr + 1, cc, er, ec);

		int path = Math.min(r, d);

		int AmtYouShouldAlreadyHava = path - dungeon[cr][cc]; // amount you should have at that position

		if (AmtYouShouldAlreadyHava >= 1) {
			return AmtYouShouldAlreadyHava;
		} else {
			return 1;
		}
	}

	public static int dgtd(int[][] dungeon, int cr, int cc, int er, int ec, int[][] strg) {

		if (cc == ec && cr == er) {
			return dungeon[cr][cc] <= 0 ? 1 - dungeon[cr][cc] : 1;
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		// right
		int r = dgtd(dungeon, cr, cc + 1, er, ec, strg);

		// down
		int d = dgtd(dungeon, cr + 1, cc, er, ec, strg);

		int path = Math.min(r, d);

		int AmtYouShouldAlreadyHava = path - dungeon[cr][cc]; // amount you should have at that position
		int ans = 0;

		if (AmtYouShouldAlreadyHava >= 1) {
			ans = AmtYouShouldAlreadyHava;
		} else {
			ans = 1;
		}
		dungeon[cr][cc] = ans;
		return ans;
	}

	public static int dgbu(int[][] dungeon) {

		int m = dungeon.length;
		int[][] strg = new int[dungeon.length + 1][dungeon[0].length + 1];

		Arrays.fill(strg[m], Integer.MAX_VALUE);

		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = Integer.MAX_VALUE;
		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				System.out.print(strg[i][j] + "\t");
//			}
//			System.out.println();
//		}

		for (int row = strg.length - 2; row >= 0; row--) {
			for (int col = strg[0].length - 2; col >= 0; col--) {

				if (row == strg.length - 2 && col == strg[0].length - 2) {
					strg[row][col] = dungeon[row][col] <= 0 ? 1 - dungeon[row][col] : 1;
				} else {

					int r = strg[row][col + 1];
					int d = strg[row + 1][col];

					int path = Math.min(r, d);

					int AmtYouShouldAlreadyHava = path - dungeon[row][col]; // amount you should have at that position

					int ans;

					if (AmtYouShouldAlreadyHava >= 1) {
						ans = AmtYouShouldAlreadyHava;
					} else {
						ans = 1;
					}
					strg[row][col] = ans;

				}
			}
		}
		return strg[0][0];
	}

	public static int dgbu2(int[][] arr) {

		int[][] strg = new int[arr.length + 1][arr[0].length + 1];

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg[0].length - 1; col >= 0; col--) {

				if (row == strg.length - 2 && col == strg[0].length - 2) {
					strg[row][col] = arr[row][col] <= 0 ? -arr[row][col] + 1 : 1;
				} else if (row == strg.length - 1) {
					strg[row][col] = Integer.MAX_VALUE;
				} else if (col == strg[0].length - 1) {
					strg[row][col] = Integer.MAX_VALUE;
				} else {
					int r = strg[row][col + 1];
					int d = strg[row + 1][col];

					int path = Math.min(r, d);

					int AmtYouShouldAlreadyHava = path - arr[row][col]; // amount you should have at that position

					int ans;

					if (AmtYouShouldAlreadyHava >= 1) {
						ans = AmtYouShouldAlreadyHava;
					} else {
						ans = 1;
					}
					strg[row][col] = ans;

				}

			}
		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				System.out.print(strg[i][j] + "\t");
//			}
//			System.out.println();
//		}

		return strg[0][0];
	}

}