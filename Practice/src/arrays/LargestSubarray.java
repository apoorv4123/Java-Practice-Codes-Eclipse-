package arrays;

import java.util.Scanner;

public class LargestSubarray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ta = s.nextInt();
		while (ta > 0) {
			int count_0 = 0, count_1 = 0;
			int si = 0, ei = 0, flag = 0;
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					count_0++;
				} else if (arr[i] == 1) {
					count_1++;
				}
				if (count_0 == count_1) {
					flag = 1;
					ei = i;
				}
			}
			if (flag == 1)
				System.out.println(si + " " + ei);
			else
				System.out.println("None");
			ta--;
		}
	}

}
