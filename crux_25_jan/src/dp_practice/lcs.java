package dp_practice;

public class lcs {

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "agcfd";

		System.out.println(lcsrec(s1, s2, 0, 0));
		System.out.println(lcstd(s1, s2, 0, 0, new int[s1.length()][s2.length()]));
	}

	public static int lcsrec(String s1, String s2, int i1, int i2) {

		if (i1 == s1.length() || i2 == s2.length()) {
			return 0;
		}

		int ans = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			ans = lcsrec(s1, s2, i1 + 1, i2 + 1) + 1;
		} else {
			ans = Math.max(lcsrec(s1, s2, i1 + 1, i2), lcsrec(s1, s2, i1, i2 + 1));
		}
		return ans;
	}

	public static int lcstd(String s1, String s2, int i1, int i2, int[][] strg) {

		if (i1 == s1.length() || i2 == s2.length()) {
			return 0;
		}

		if (strg[i1][i2] != 0) {
			return strg[i1][i2];
		}

		int ans = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			ans = lcstd(s1, s2, i1 + 1, i2 + 1, strg) + 1;
		} else {
			ans = Math.max(lcstd(s1, s2, i1 + 1, i2, strg), lcstd(s1, s2, i1, i2 + 1, strg));
		}
		strg[i1][i2] = ans;
		return ans;
	}
	
}
