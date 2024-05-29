package lecture8;

public class RodCutting {

	public static void main(String[] args) {

		int[] price = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };

		System.out.println(RCRec(price, price.length - 1));

		System.out.println(RCRec2(price, price.length - 1));

		System.out.println(RCtd(price, price.length - 1, new int[price.length]));

	}

	public static int RCRec(int[] price, int currlen) {

		if (currlen == 1) {
			return price[currlen];
		}

		int ans = price[currlen];

		for (int i = 1; i <= currlen / 2; i++) {

			int fp = RCRec(price, i);
			int sp = RCRec(price, currlen - i);

			ans = Math.max(ans, fp + sp);

		}

		return ans;

	}

	// yha base case lagane ki zaroorat he nhi hogi kyuki jab length 1 hogi tab max
	// will store price of 1 length rod and loop will not run, so max will return
	// price of rod of length 1
	public static int RCRec2(int[] price, int n) {

		int max = price[n];
		int left = 1;
		int right = n - 1;

		while (left <= right) {

			int fp = RCRec2(price, left);
			int sp = RCRec2(price, right);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}
		return max;
	}

	public static int RCtd(int[] price, int currlen, int[] strg) {

		if (currlen == 1) {
			return price[currlen];
		}

		if (strg[currlen] != 0) {
			return strg[currlen];
		}

		int ans = price[currlen];

		for (int i = 1; i <= currlen / 2; i++) {

			int fp = RCtd(price, i, strg);
			int sp = RCtd(price, currlen - i, strg);

			ans = Math.max(ans, fp + sp);

		}

		strg[currlen] = ans;

		return ans;

	}

	public static int RCbu(int[] price) {

		int[] strg = new int[price.length];

		strg[0] = price[0];
		strg[1] = price[1];

		for (int n = 2; n < strg.length; n++) {

			int max = price[n];
			int left = 1;
			int right = n - 1;

			while (left <= right) {

				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max) {
					max = total;
				}

				left++;
				right--;
			}

			strg[n] = max;
		}
		return strg[strg.length - 1];
	}

}