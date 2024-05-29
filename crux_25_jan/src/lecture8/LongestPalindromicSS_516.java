package lecture8;

public class LongestPalindromicSS_516 {

	public static void main(String[] args) {

		String str = "abacda";

//		System.out.println(lprec("abacd", ""));
		System.out.println(LPSSRec(str, 0, str.length() - 1));

		int[][] strg = new int[str.length()][str.length()];
		System.out.println(LPSStd(str, 0, str.length() - 1, strg));

		System.out.println(LPSSbu(str));

	}

	public static int LPSSRec(String str, int si, int ei) {

		if (si > ei) {
			return 0;
		}

		if (si == ei) {
			return 1;
		}

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei)) {
			ans = LPSSRec(str, si + 1, ei - 1) + 2;
		} else {
			int fp = LPSSRec(str, si + 1, ei);
			int sp = LPSSRec(str, si, ei - 1);
			ans = Math.max(fp, sp);
		}

		return ans;

	}

	public static int LPSStd(String str, int si, int ei, int[][] strg) {

		if (si > ei) {
			return 0;
		}

		if (si == ei) {
			return 1;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei)) {
			ans = LPSStd(str, si + 1, ei - 1, strg) + 2;
		} else {
			int fp = LPSStd(str, si + 1, ei, strg);
			int sp = LPSStd(str, si, ei - 1, strg);
			ans = Math.max(fp, sp);
		}

		strg[si][ei] = ans;

		return ans;

	}

	public static int LPSSbu(String str) {

		int n = str.length();

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si == ei) {
					strg[si][ei] = 1;
				} else {

					int ans = 0;

					if (str.charAt(si) == str.charAt(ei)) {
						ans = strg[si + 1][ei - 1] + 2;
					} else {
						int fp = strg[si + 1][ei];
						int sp = strg[si][ei - 1];
						ans = Math.max(fp, sp);
					}

					strg[si][ei] = ans;
				}

			}

		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				System.out.print(strg[i][j] + "\t");
//			}
//			System.out.println();
//		}

		return strg[0][n - 1];
	}

	// This method is not to be used, too much time consuming
	static int res = Integer.MIN_VALUE;

	public static int lprec(String ques, String ans) {

		if (ques.length() == 0) {
			if (isPalindrome(ans)) {
				if (ans.length() > res) {
					res = ans.length();
				}
			}
			return res;
		}

		// include
		int inc = lprec(ques.substring(1), ans + ques.charAt(0));

		// exclude
		int exc = lprec(ques.substring(1), ans);

		return Math.max(inc, exc);
	}

	public static boolean isPalindrome(String str) {
		int si = 0;
		int ei = str.length() - 1;
		while (si <= ei) {
			if (str.charAt(si) != str.charAt(ei)) {
				return false;
			}
			si++;
			ei--;
		}
		return true;
	}

}