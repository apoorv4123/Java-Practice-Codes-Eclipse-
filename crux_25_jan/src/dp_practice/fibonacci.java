package dp_practice;

public class fibonacci {

	public static void main(String[] args) {
		int n = 50;
//		System.out.println(recfib(n));
		System.out.println(tdfib(n, new int[n + 1])); //-298632863
//		System.out.println(busefib(n));
	}

	public static int recfib(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = recfib(n - 1);
		int fibnm2 = recfib(n - 2);

		int fibn = fibnm1 + fibnm2;

		return fibn;
	}

	public static int tdfib(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fibnm1 = tdfib(n - 1, strg);
		int fibnm2 = tdfib(n - 2, strg);

		int fibn = fibnm1 + fibnm2;
		strg[n] = fibn;
		return fibn;
	}

	public static int busefib(int n) {

		int[] strg = new int[2];
		strg[1] = 1;
		for (int slide = 1; slide < n; slide++) {
			int intans = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = intans;
		}
		return strg[1];
	}

}