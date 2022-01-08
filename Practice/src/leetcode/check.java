package leetcode;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(check(25));
		
	}
	
	public static boolean check(int n) {

		for (int i = 0; i <= n; i++) {

			if (i * i == n) {
				return true;
			}

		}
		return false;
	}

}
