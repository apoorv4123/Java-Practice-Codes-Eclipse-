package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class pairOfRoses {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
			int target = s.nextInt();
			traverse(arr, target);
			t--;
			System.out.println();
		}
	}

	public static void traverse(int[] arr, int target) {
		int n1 = 0;
		int n2 = 0;
		int d = 0;
		int ans1 = 0;
		int ans2 = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int nd = 0;
				if (arr[i] + arr[j] == target) {
					n1 = arr[i];
					n2 = arr[j];
					nd = n1 - n2;
					if (nd < 0) {
						nd = nd * -1;
					}
					ans1 = n1;
					ans2 = n2;
					if (d > nd) {
						d = nd;
						ans1 = n1;
						ans2 = n2;
					}
				}
			}
		}
		System.out.println("Deepak should buy roses whose prices are "+ans1 + " and " + ans2+".");
	}

}
