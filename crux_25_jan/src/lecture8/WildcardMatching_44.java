package lecture8;

public class WildcardMatching_44 {

	public static void main(String[] args) {

		String src = "adceb";
		String p = "*a********b";

//		System.out.println(WCMRec(src, p));
//		System.out.println(WCMvidx(src, p, 0, 0));
//		System.out.println(WCMtd(src, p, 0, 0, new int[src.length()][p.length()]));

		System.out.println(WCMbu(src, p));

	}

	public static boolean WCMRec(String src, String p) {

		if (src.length() == 0 && p.length() == 0) {
			return true;
		}
		if (src.length() != 0 && p.length() == 0) {
			return false;
		}
		if (src.length() == 0 && p.length() != 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char c1 = src.charAt(0);
		char c2 = p.charAt(0);

		String ros1 = src.substring(1);
		String ros2 = p.substring(1);

		boolean res;

		if (c1 == c2 || c2 == '?') {
			res = WCMRec(ros1, ros2);
		} else if (c2 == '*') {

			boolean blank = WCMRec(src, ros2);
			boolean sequence = WCMRec(ros1, p);

			res = blank || sequence;
		} else {// pattern aur source ka pehla character match nhi krta
			res = false;
		}

		return res;
	}

	public static boolean WCMvidx(String src, String p, int svidx, int pvidx) {

		if (svidx == src.length() && pvidx == p.length()) {
			return true;
		}
		if (svidx != src.length() && pvidx == p.length()) {
			return false;
		}
		if (svidx == src.length() && pvidx != p.length()) {
			for (int i = pvidx; i < p.length(); i++) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char c1 = src.charAt(svidx);
		char c2 = p.charAt(pvidx);

		boolean res;

		if (c1 == c2 || c2 == '?') {
			res = WCMvidx(src, p, svidx + 1, pvidx + 1);
		} else if (c2 == '*') {

			boolean blank = WCMvidx(src, p, svidx, pvidx + 1);
			boolean sequence = WCMvidx(src, p, svidx + 1, pvidx);

			res = blank || sequence;
		} else {// pattern aur source ka pehla character match nhi krta
			res = false;
		}

		return res;
	}

	public static boolean WCMtd(String src, String p, int svidx, int pvidx, int[][] strg) {

		if (svidx == src.length() && pvidx == p.length()) {
			return true;
		}
		if (svidx != src.length() && pvidx == p.length()) {
			return false;
		}
		if (svidx == src.length() && pvidx != p.length()) {
			for (int i = pvidx; i < p.length(); i++) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (strg[svidx][pvidx] != 0) {
			return strg[svidx][pvidx] == 2 ? true : false;
		}

		char c1 = src.charAt(svidx);
		char c2 = p.charAt(pvidx);

		boolean res;

		if (c1 == c2 || c2 == '?') {
			res = WCMtd(src, p, svidx + 1, pvidx + 1, strg);
		} else if (c2 == '*') {

			boolean blank = WCMtd(src, p, svidx, pvidx + 1, strg);
			boolean sequence = WCMtd(src, p, svidx + 1, pvidx, strg);

			res = blank || sequence;
		} else {// pattern aur source ka pehla character match nhi krta
			res = false;
		}

		strg[svidx][pvidx] = (res == true ? 2 : 1);

		return res;
	}

	public static boolean WCMbu(String src, String p) {

		int n = src.length();
		int m = p.length();

		int[][] strg = new int[n + 1][m + 1];

		for (int i = 0; i < strg.length; i++) {
			strg[i][m] = 1;
		}
		strg[n][m] = 2;
		for (int i = m - 1; i >= 0; i--) {
			if (p.charAt(i) == '*') {
				strg[n][i] = 2;
			} else {
				for (int j = i; j >= 0; j--) {
					strg[n][j] = 1;
				}
				break;
			}
		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				System.out.print(strg[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int row = n - 1; row >= 0; row--) {
			for (int col = m - 1; col >= 0; col--) {

				char c1 = src.charAt(row);
				char c2 = p.charAt(col);

				int res;

				if (c1 == c2 || c2 == '?') {
					res = strg[row + 1][col + 1];
				} else if (c2 == '*') {

					boolean blank = strg[row][col + 1] == 2 ? true : false;
					boolean sequence = strg[row + 1][col] == 2 ? true : false;

					res = (blank || sequence) ? 2 : 1;
				} else {// pattern aur source ka pehla character match nhi krta
					res = 1;
				}

				strg[row][col] = res;

			}
		}

		return strg[0][0] == 2 ? true : false;

	}

}