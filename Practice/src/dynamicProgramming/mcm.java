package dynamicProgramming;

public class mcm {

	public static void main(String[] args) {
		int[] matrices = { 4, 2, 3, 5, 1 };
		System.out.println(mcmrec(matrices, 0, matrices.length - 1));
		int[][] strg = new int[matrices.length][matrices.length];
		for (int[] arr : strg) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = -1;
			}
		}
		System.out.println(mcmTD(matrices, 0, matrices.length - 1, strg));
		System.out.println(mcmBU(matrices));
	}

	public static int mcmrec(int[] matrices, int si, int ei) {
		if (ei - si == 1) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = mcmrec(matrices, si, k);
			int sp = mcmrec(matrices, k, ei);
			int res = fp + sp + matrices[si] * matrices[k] * matrices[ei];
			ans = Math.min(ans, res);
		}
		return ans;
	}

	public static int mcmTD(int[] matrices, int si, int ei, int[][] strg) {
		if (ei - si == 1) {
			return 0;
		}
		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}
		int ans = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = mcmTD(matrices, si, k, strg);
			int sp = mcmTD(matrices, k, ei, strg);
			int res = fp + sp + matrices[si] * matrices[k] * matrices[ei];
			ans = Math.min(ans, res);
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
		
		for(int[] arr : strg) {
			for(int a : arr) {
				System.out.print(a +" ");
			}
			System.out.println();
		}
		
		return strg[0][n -1];
	}

}
