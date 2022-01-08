package dynamicProgramming;

import java.util.Arrays;

public class editDistance {

	public static void main(String[] args) {
		String s1 = "abcdjxjvhqmgxmhcmhtchmcmhhchtmhc";
		String s2 = "agcfdbkqjxqcmctctddmdcydkctydkkdcmc";

		int[][] strg = new int[s1.length()][s2.length()];
		for (int[] store : strg) {
			Arrays.fill(store, -1);
		}

//		System.out.println(editDistanceRec(s1, s2, 0, 0));

		System.out.println(editDistanceTD(s1, s2, 0, 0, strg));
//		for (int[] a : strg) {
//			for (int b : a) {
//				System.out.print(b + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(EDTD(s1, s2, 0, 0, strg));
		
		System.out.println(editDistanceBU(s1, s2));

	}

	public static int editDistanceRec(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length()) {
			return Math.max(s1.length() - i1, s2.length() - i2);
		}
		int res = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			res = editDistanceRec(s1, s2, i1 + 1, i2 + 1);
		} else {
			int insert = editDistanceRec(s1, s2, i1 + 1, i2);
			int remove = editDistanceRec(s1, s2, i1, i2 + 1);
			int replace = editDistanceRec(s1, s2, i1 + 1, i2 + 1);
			res = Math.min(insert, Math.min(remove, replace)) + 1;
		}
		return res;
	}

	public static int editDistanceTD(String s1, String s2, int i1, int i2, int[][] strg) {
		if (i1 == s1.length() || i2 == s2.length()) {
			return Math.max(s1.length() - i1, s2.length() - i2);
		}
		if (strg[i1][i2] != -1) {
			return strg[i1][i2];
		}
		int res = 0;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			res = editDistanceTD(s1, s2, i1 + 1, i2 + 1, strg);
		} else {
			int insert = editDistanceTD(s1, s2, i1 + 1, i2, strg);
			int remove = editDistanceTD(s1, s2, i1, i2 + 1, strg);
			int replace = editDistanceTD(s1, s2, i1 + 1, i2 + 1, strg);
			res = Math.min(insert, Math.min(remove, replace)) + 1;
		}
		strg[i1][i2] = res;
		return res;
	}

	public static int editDistanceBU(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		for (int col = 0; col < strg[0].length; col++) {
			strg[strg.length - 1][col] = s2.length() - col;
		}
		for (int row = 0; row < strg.length - 1; row++) {
			strg[row][strg[0].length - 1] = s1.length() - row;
		}
		for (int row = strg.length - 2; row >= 0; row--) {
			for (int col = strg[0].length - 2; col >= 0; col--) {
				if(s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				}else {
					int insert = strg[row + 1][col];
					int remove = strg[row][col + 1];
					int replace = strg[row + 1][col + 1];
					strg[row][col] = Math.min(insert, Math.min(remove, replace)) + 1;
				}
			}
		}
		return strg[0][0];
	}

//	public class DP_EditDistance {
//
//		public static void main(String[] args) {
//
//			String s1 = "abcdjxjvhqmgxmhcmhtchmcmhhchtmhc";
//			String s2 = "agcfdbkqjxqcmctctddmdcydkctydkkdcmc";
//
//			int[][] strg = new int[s1.length()][s2.length()];
//			
//			for(int[] store : strg) {
//				Arrays.fill(store, -1);
//			}
//
////			System.out.println(EDRecursion(s1, s2));
////			System.out.println(EDRecursionVidx(s1, s2, 0, 0));
//			System.out.println(EDTD(s1, s2, 0, 0, strg));
//			System.out.println(EDBU(s1, s2));
//		}

	public static int EDRecursion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EDRecursion(ros1, ros2);
		} else {
			int i = EDRecursion(ros1, s2) + 1;
			int d = EDRecursion(s1, ros2) + 1;
			int r = EDRecursion(ros1, ros2) + 1;

			ans = Math.min(i, Math.min(d, r));
		}

		return ans;
	}

	public static int EDRecursionVidx(String s1, String s2, int vidx1, int vidx2) {

		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2 + 1);
		} else {
			int i = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2) + 1;
			int d = EDRecursionVidx(s1, s2, vidx1, vidx2 + 1) + 1;
			int r = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2 + 1) + 1;

			ans = Math.min(i, Math.min(d, r));
		}

		return ans;
	}

	public static int EDTD(String s1, String s2, int vidx1, int vidx2, int[][] strg) {

		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}

		if (strg[vidx1][vidx2] != -1) { // re-use
			return strg[vidx1][vidx2];
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EDTD(s1, s2, vidx1 + 1, vidx2 + 1, strg);
		} else {
			int i = EDTD(s1, s2, vidx1 + 1, vidx2, strg) + 1;
			int d = EDTD(s1, s2, vidx1, vidx2 + 1, strg) + 1;
			int r = EDTD(s1, s2, vidx1 + 1, vidx2 + 1, strg) + 1;

			ans = Math.min(i, Math.min(d, r));
		}

		strg[vidx1][vidx2] = ans; // fill

		return ans;
	}

	public static int EDBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (s1.length() == row || s2.length() == col) {
					strg[row][col] = Math.max(s1.length() - row, s2.length() - col);
				} else {
					char ch1 = s1.charAt(row);
					char ch2 = s2.charAt(col);

					int ans = 0;

					if (ch1 == ch2) {
						ans = EDTD(s1, s2, row + 1, col + 1, strg);
					} else {
						int i = EDTD(s1, s2, row + 1, col, strg) + 1;
						int d = EDTD(s1, s2, row, col + 1, strg) + 1;
						int r = EDTD(s1, s2, row + 1, col + 1, strg) + 1;

						ans = Math.min(i, Math.min(d, r));
					}

					strg[row][col] = ans;
				}
			}
		}

		return strg[0][0];
	}
}
