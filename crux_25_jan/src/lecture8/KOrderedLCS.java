package lecture8;

import java.util.Arrays;

public class KOrderedLCS {

	public static void main(String[] args) {

		String s1 = "abchd";
		String s2 = "agcfd";

		int k = 2;

		System.out.println(kOrderedLCSRec(s1, s2, k, 0, 0));

		int[][][] strg = new int[k + 1][s1.length()][s2.length()];
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				Arrays.fill(strg[i][j], -1);
			}
		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				for (int l = 0; l < strg[0][0].length; l++) {
//					System.out.print(strg[i][j][l] + "\t");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}

		System.out.println(kOrderedLCStd(s1, s2, k, 0, 0, strg));

	}

	public static int kOrderedLCSRec(String s1, String s2, int k, int vidx1, int vidx2) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return 0;
		}

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2)) {
			ans = kOrderedLCSRec(s1, s2, k, vidx1 + 1, vidx2 + 1) + 1;
		} else {

			int o1 = kOrderedLCSRec(s1, s2, k, vidx1 + 1, vidx2);
			int o2 = kOrderedLCSRec(s1, s2, k, vidx1, vidx2 + 1);
			int o3 = 0;

			if (k >= 1) {
				o3 = kOrderedLCSRec(s1, s2, k - 1, vidx1 + 1, vidx2 + 1) + 1;
			}

			ans = Math.max(o1, Math.max(o2, o3));
		}

		return ans;

	}

	public static int kOrderedLCStd(String s1, String s2, int k, int vidx1, int vidx2, int[][][] strg) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return 0;
		}

		if (strg[k][vidx1][vidx2] != -1) {
			return strg[k][vidx1][vidx2];
		}

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2)) {
			ans = kOrderedLCStd(s1, s2, k, vidx1 + 1, vidx2 + 1, strg) + 1;
		} else {
			int o1 = kOrderedLCStd(s1, s2, k, vidx1 + 1, vidx2, strg);
			int o2 = kOrderedLCStd(s1, s2, k, vidx1, vidx2 + 1, strg);
			int o3 = 0;

			if (k > 0)
				o3 = kOrderedLCStd(s1, s2, k - 1, vidx1 + 1, vidx2 + 1, strg) + 1;

			ans = Math.max(o1, Math.max(o2, o3));
		}

		strg[k][vidx1][vidx2] = ans;

		return ans;
	}

	public static int kOrderedLCSBU(String s1, String s2, int tk) {
		int[][][] strg = new int[tk + 1][s1.length() + 1][s2.length() + 1];

		for (int k = 0; k <= tk; k++) {

			for (int row = s1.length() - 1; row >= 0; row--) {
				for (int col = s2.length() - 1; col >= 0; col--) {
					int ans = 0;

					if (s1.charAt(row) == s2.charAt(col)) {
						ans = strg[k][row + 1][col + 1] + 1;
					} else {
						int o1 = strg[k][row + 1][col];
						int o2 = strg[k][row][col + 1];
						int o3 = 0;

						if (k >= 1)
							o3 = strg[k - 1][row + 1][col + 1] + 1;

						ans = Math.max(o1, Math.max(o2, o3));
					}

					strg[k][row][col] = ans;

					return ans;
				}
			}
		}
		return strg[tk][0][0];
	}
}
