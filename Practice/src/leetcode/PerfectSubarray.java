package leetcode;

import java.util.Scanner;

 class PerfectSubarray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		short test = s.nextShort();
		short c=1;

		while (test > 0) {

			int size = s.nextShort();
			short[] arr = new short[size];
			short count = 0;
			for (short i = 0; i < arr.length; i++) {
				arr[i] = s.nextShort();
			}

			short start = 0;
			int end = arr.length - 1;
			for (short si = start; si <= end; si++) {
				int sum = 0;
				for (int ei = si; ei < arr.length; ei++) {
					sum = sum + arr[ei];
					if(check(sum)) {
						count++;
					}
				}
			}
			System.out.println("Case #"+c+":"+count);
			test--;
			c++;
		}

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
