package dp_practice;

public class mazePath {

	public static void main(String[] args) {

		System.out.println(recmp(0, 0, 2, 2));

	}

	public static int recmp(int cc, int cr, int ec, int er) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cc == ec && cr == er) {
			return 1;
		}

		int ans = 0;

		// horizontal
		ans += recmp(cc + 1, cr, ec, er);
		// vertical
		ans += recmp(cc, cr + 1, ec, er);

		return ans;

	}
	
	

}
