package arrays;

import java.util.Scanner;

public class IncreasingDecreasing {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int pre = s.nextInt();
		boolean isInc = false;
		boolean res = true;
		for (int i = 1; i < n; i++) {
			int curr = s.nextInt();
			if (curr > pre) {
				isInc = true;
			} else if (curr < pre && isInc) {
				res = false;
				break;
			} else if (curr == pre) {
				res = false;
				break;
			}
			pre = curr;
		}
		System.out.println(res);

	}

}
