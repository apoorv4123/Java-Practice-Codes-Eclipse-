package lecture8;

import java.util.Arrays;

public class LCS3Strings {

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "agcfd";
		String s3 = "ad";

		System.out.println(LCS3(s1, s2, s3, 0, 0, 0));

		int[][][] strg = new int[s1.length()][s2.length()][s3.length()];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				Arrays.fill(strg[i][j], -1);
			}
		}

		System.out.println(LCS3td(s1, s2, s3, 0, 0, 0, strg));

		System.out.println(LCS3bu(s1, s2, s3));
	}

	public static int LCS3(String s1, String s2, String s3, int i1, int i2, int i3) {

		if (i1 == s1.length() || i2 == s2.length() || i3 == s3.length()) {
			return 0;
		}

		int ans;

		if ((s1.charAt(0) == s2.charAt(0)) && (s2.charAt(0) == s3.charAt(0))) {
			ans = LCS3(s1, s2, s3, i1 + 1, i2 + 1, i3 + 1) + 1;
		} else {
			int one = LCS3(s1, s2, s3, i1 + 1, i2, i3);
			int two = LCS3(s1, s2, s3, i1, i2 + 1, i3);
			int three = LCS3(s1, s2, s3, i1, i2, i3 + 1);

			ans = Math.max(one, Math.max(two, three));

		}

		return ans;

	}

	public static int LCS3td(String s1, String s2, String s3, int i1, int i2, int i3, int[][][] strg) {

		if (i1 == s1.length() || i2 == s2.length() || i3 == s3.length()) {
			return 0;
		}

		if (strg[i1][i2][i3] != -1) {
			return strg[i1][i2][i3];
		}

		int ans;

		if ((s1.charAt(0) == s2.charAt(0)) && (s2.charAt(0) == s3.charAt(0))) {
			ans = LCS3td(s1, s2, s3, i1 + 1, i2 + 1, i3 + 1, strg) + 1;
		} else {
			int one = LCS3td(s1, s2, s3, i1 + 1, i2, i3, strg);
			int two = LCS3td(s1, s2, s3, i1, i2 + 1, i3, strg);
			int three = LCS3td(s1, s2, s3, i1, i2, i3 + 1, strg);

			ans = Math.max(one, Math.max(two, three));

		}

		strg[i1][i2][i3] = ans;

		return ans;

	}

	public static int LCS3bu(String s1, String s2, String s3) {

		int a = s1.length();
		int b = s2.length();
		int c = s3.length();

		int[][][] strg = new int[a + 1][b + 1][c + 1];

		for (int s1l = a - 1; s1l >= 0; s1l--) {
			for (int s2l = b - 1; s2l >= 0; s2l--) {
				for (int s3l = c - 1; s3l >= 0; s3l--) {

					int ans;

					if ((s1.charAt(s1l) == s2.charAt(s2l)) && (s2.charAt(s2l) == s3.charAt(s3l))) {
						ans = strg[s1l + 1][s2l + 1][s3l + 1] + 1;
					} else {
						int one = strg[s1l + 1][s2l][s3l];
						int two = strg[s1l][s2l + 1][s3l];
						int three = strg[s1l][s2l][s3l + 1];

						ans = Math.max(one, Math.max(two, three));

					}

					strg[s1l][s2l][s3l] = ans;

				}
			}
		}
		return strg[0][0][0];
	}
}
