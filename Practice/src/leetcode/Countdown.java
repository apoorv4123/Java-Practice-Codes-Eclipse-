package leetcode;

import java.util.Scanner;

public class Countdown {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int test = s.nextInt();

		while (test > 0) {

			int n = s.nextInt();
			int k = s.nextInt();
			int count = 0;
			int[] check = new int[k];
			int a = k;
			for (int i = 0; i < k; i++) {
				check[i] = a;
				a--;
			}
			boolean flag = false;

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {

				arr[i] = s.nextInt();
			}

			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == k) {

					for (int l = 1; l < check.length; l++) {
						++i;
						if (arr[i] != check[l]) {
							flag = false;
						} else {
							flag = true;
						}
					}
					if (flag == true) {
						count++;
					}
				}
				flag = false;
			}
			test--;
			System.out.println(count);
		}

	}

}