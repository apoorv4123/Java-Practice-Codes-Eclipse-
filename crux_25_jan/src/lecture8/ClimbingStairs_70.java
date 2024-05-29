package lecture8;

public class ClimbingStairs_70 {

	public static void main(String[] args) {

		int n = 5;
		System.out.println(csrec(n));

		int[] strg = new int[n + 1];
		System.out.println(cstd(n, strg));
		System.out.println(csbu(n));
	}

	public static int csrec(int n) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		// 1 step
		int one = csrec(n - 1);

		// 2 step
		int two = csrec(n - 2);

		return one + two;
	}

	public static int cstd(int n, int[] strg) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		// 1 step
		int one = cstd(n - 1, strg);

		// 2 step
		int two = cstd(n - 2, strg);

		strg[n] = one + two;

		return one + two;
	}

	public static int csbu(int n) {

		int[] strg = new int[n + 1];
		strg[0] = strg[1] = 1;
		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

}
