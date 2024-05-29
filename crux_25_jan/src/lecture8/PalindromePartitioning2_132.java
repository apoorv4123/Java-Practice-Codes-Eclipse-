package lecture8;

import java.util.Arrays;

public class PalindromePartitioning2_132 {

	public static void main(String[] args) {

		String str = "abacd";
		int si = 0;
		int ei = str.length() - 1;
//		System.out.println(pprec(str, si, ei));

		int[][] strg = new int[str.length()][str.length()];

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}

		System.out.println(pptd(str, si, ei, strg));

		System.out.println(ppbu(str));

	}

	public static int pprec(String s, int si, int ei) {

		if (isPalindrome(s, si, ei)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = si; i <= ei - 1; i++) {

			int fp = pprec(s, si, i);
			int sp = pprec(s, i + 1, ei);

			int total = fp + sp + 1;

			if (total < min) {
				min = total;
			}

		}
		return min;
	}

	public static boolean isPalindrome(String s, int si, int ei) {

		if (si >= ei) {
			return true;
		}

		return s.charAt(si) == s.charAt(ei) && isPalindrome(s, si + 1, ei - 1);

	}

	public static int pptd(String s, int si, int ei, int[][] strg) {

		if (isPalindrome(s, si, ei)) {
			return 0;
		}

		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = pptd(s, si, k, strg);
			int sp = pptd(s, k + 1, ei, strg);

			int total = fp + sp + 1;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;

		return min;

	}

	public static int ppbu(String str) {

		int n = str.length();

		int[][] strg = new int[n][n];

		boolean[][] isPalArr = twodPalindromeInfo(str);

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (isPalArr[si][ei]) { // used instead of isPalindrome().
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si; k <= ei - 1; k++) {

						int fp = strg[si][k];
						int sp = strg[k + 1][ei];

						int total = fp + sp + 1;

						if (total < min) {
							min = total;
						}
					}
					strg[si][ei] = min;
				}
			}
		}
		return strg[0][strg[0].length - 1];
	}

	public static boolean[][] twodPalindromeInfo(String str) {

		int n = str.length();
		
		boolean[][] arr = new boolean[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si == ei) {
					arr[si][ei] = true;
				} else {
					if (str.charAt(si) == str.charAt(ei) && arr[si + 1][ei - 1]) {
						arr[si][ei] = true;
					}
				}
			}
		}

//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]+"\t");
//			}
//			System.out.println();
//		}
		return arr;

	}

}