package lecture8;

public class UniqueBinarySearchTrees_CatalanNo_96 {

	public static void main(String[] args) {

		int n = 5;

		System.out.println(CNRec(n));
		System.out.println(CNtd(n, new int[n + 1]));
		System.out.println(CNbu(n));

	}

	public static int CNRec(int n) {

		if (n <= 1) {
			return 1;
		}

		int total = 0;

		for (int i = 1; i <= n; i++) {
			int l = CNRec(i - 1);
			int r = CNRec(n - i);

			int ans = l * r;
			total += ans;
		}
		return total;
	}

	public static int CNtd(int n, int[] strg) {

		if (n <= 1) {
			return 1;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int total = 0;

		for (int i = 1; i <= n; i++) {
			int l = CNtd(i - 1, strg);
			int r = CNtd(n - i, strg);

			int ans = l * r;
			total += ans;
		}

		strg[n] = total;

		return total;
	}

	public static int CNbu(int tn) {

		int[] strg = new int[tn + 1];

		strg[0] = strg[1] = 1;

		for (int n = 2; n <= tn; n++) {
			int total = 0;
			for (int i = 1; i <= n; i++) {
				
				int l = strg[i - 1];
				int r = strg[n - i];

				int ans = l * r;
				total += ans;
			}
			strg[n] = total;
		}
		return strg[tn];
	}

}