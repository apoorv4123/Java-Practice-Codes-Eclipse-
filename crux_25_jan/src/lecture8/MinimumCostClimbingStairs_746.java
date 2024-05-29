package lecture8;

public class MinimumCostClimbingStairs_746 {

	public static void main(String[] args) {

		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
//		int[] cost = { 10, 15, 20 };
		System.out.println(mccsrec(cost, 0));

		int[] strg = new int[cost.length];
		mccstd(cost, 0, strg);
		System.out.println(Math.min(strg[0], strg[1]));

		System.out.println(mccsbu(cost));
	}

	public static int mccsrec(int[] cost, int idx) {

		if (idx >= cost.length) {
			return 0;
		}

		// 1 step
		int one = mccsrec(cost, idx + 1);

		// 2 steps
		int two = mccsrec(cost, idx + 2);

		return Math.min(one, two) + cost[idx];

	}

	public static int mccstd(int[] cost, int idx, int[] strg) {

		if (idx >= cost.length) {
			return 0;
		}

		// 1 step
		int one = mccstd(cost, idx + 1, strg);

		// 2 steps
		int two = mccstd(cost, idx + 2, strg);

		int ans = Math.min(one, two) + cost[idx];

		strg[idx] = ans;

		return ans;

	}

	public static int mccsbu(int[] cost) {

		int[] strg = new int[cost.length + 2];
		for (int i = strg.length - 3; i >= 0; i--) {
			strg[i] = Math.min(strg[i + 1], strg[i + 2]) + cost[i];
		}
		return Math.min(strg[0], strg[1]);
	}

}
