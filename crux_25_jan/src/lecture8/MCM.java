package lecture8;

public class MCM {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 3, 2, 4, 1 };
		System.out.println(MCMrec(arr, 0, arr.length - 1));

		int[][] strg = new int[arr.length - 1][arr.length];
		System.out.println(MCMtd(arr, 0, arr.length - 1, strg));
		
		System.out.println(mcmBU(arr));

	}

	public static int MCMrec(int[] arr, int si, int ei) {

		if (ei == si + 1) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int res1 = MCMrec(arr, si, k);
			int res2 = MCMrec(arr, k, ei);

			int res = res1 + res2 + arr[si] * arr[k] * arr[ei];

			if (res < ans) {
				ans = res;
			}
		}
		return ans;
	}

	public static int MCMtd(int[] arr, int si, int ei, int[][] strg) {

		if (ei == si + 1) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int ans = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int res1 = MCMtd(arr, si, k, strg);
			int res2 = MCMtd(arr, k, ei, strg);

			int res = res1 + res2 + arr[si] * arr[k] * arr[ei];

			if (res < ans) {
				ans = res;
			}
		}

		strg[si][ei] = ans;

		return ans;
	}
	
	public static int mcmBU(int[] matrices) {
		int n = matrices.length;
		int[][] strg = new int[n][n];
		for(int slide = 1;slide<matrices.length; slide++) {
			for(int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if(ei - si == 1) {
					continue;
				}
				int ans = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int fp = strg[si][k];
					int sp = strg[k][ei];
					int res = fp + sp + matrices[si] * matrices[k] * matrices[ei];
					ans = Math.min(ans, res);
				}
				strg[si][ei] = ans;
			}
		}
		
//		for(int[] arr : strg) {
//			for(int a : arr) {
//				System.out.print(a +" ");
//			}
//			System.out.println();
//		}
		
		return strg[0][n -1];
	}


}
