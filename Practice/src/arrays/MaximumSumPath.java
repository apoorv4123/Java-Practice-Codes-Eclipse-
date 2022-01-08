package arrays;

import java.util.Scanner;

public class MaximumSumPath {
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
//		int t = s.nextInt();
//		while (t > 0) {
//			int n1 = s.nextInt();
//			int n2 = s.nextInt();
//			int[] one = new int[n1];
//			int[] two = new int[n2];
//			for (int i = 0; i < one.length; i++) {
//				one[i] = s.nextInt();
//			}
//			for (int i = 0; i < two.length; i++) {
//				two[i] = s.nextInt();
//			}
		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };
		maxsumpath(one, two);

//		t--;
	}

	public static void maxsumpath(int[] one, int[] two) {
//		int sum1 = 0;
//		int sum2 = 0;
//		int ans = 0;
//		int flag = 0;
//		int i = 0, j = 0;
//		for (int i = 0; i < one.length; i++) {
//			sum1 += one[i];
//			int j = i;
//			if(ans==0) {
//				j=0;
//			}
//			int sum2 = 0;
//			while (j < two.length) {
//				sum2 += two[j];
//
//				if (one[i] == two[j]) {
//					if (sum1 > sum2) {
//						ans += sum1;
//					} else if (sum2 > sum1) {
//						ans += sum2;
//					} else {
//						ans += sum1;
//					}
//					sum1 = 0;
//					break;
//				}
//				j++;
//			}
//		}
//		System.out.println(ans);
		int i = 0;
		int j = 0;
		int sum1 = 0, sum2 = 0, ans = 0;
		while (i < one.length && j < two.length) {
			if (one[i] > two[j]) {
				sum1 += two[j];
				i++;

			} else if (one[i] < two[j]) {
				sum2 += one[i];
				j++;
			} else {
				ans += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		while (i < one.length) {
			ans += one[i];
			i++;
		}
		while (j < two.length) {
			ans += two[j];
			j++;
		}
		System.out.println(ans);
	}
}