package dp_practice;

public class Knapsack {

	public static void main(String[] args) {

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap = 7;
		System.out.println(knapsackRec(wt, price, 0, cap));

		int[][] strg = new int[wt.length][cap + 1];
		System.out.println(knapsacktd(wt, price, 0, cap, strg));

		System.out.println(knapsackbu(wt, price, cap));

	}

	public static int knapsackRec(int[] wt, int[] price, int vidx, int cap) {

		if (vidx == wt.length || cap == 0) {
			return 0;
		}

		int exclude = knapsackRec(wt, price, vidx + 1, cap);

		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapsackRec(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];
		}

		return Math.max(exclude, include);

	}

	public static int knapsacktd(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == wt.length || cap == 0) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int exclude = knapsacktd(wt, price, vidx + 1, cap, strg);

		int include = 0;
		if (cap >= wt[vidx]) {
			include = knapsacktd(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];
		}

		strg[vidx][cap] = Math.max(exclude, include);

		return Math.max(exclude, include);

	}

	public static int knapsackbu(int[] wt, int[] price, int cap) {

		int[][] strg = new int[wt.length + 1][cap + 1];

		for (int row = wt.length - 1; row >= 0; row--) { // vidx = row

			for (int col = 1; col <= cap; col++) { // cap = col

				int e = strg[row + 1][col];
				int i = 0;
				if (col >= wt[row]) {
					i = strg[row + 1][col - wt[row]] + price[row];
				}

				int ans = Math.max(e, i);
				strg[row][col] = ans;
			}
		}
		return strg[0][cap];
	}

}
