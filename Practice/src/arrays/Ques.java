package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ques {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = s.nextInt();
//		}
//		Arrays.sort(arr);
//		int target = s.nextInt();
//		check(arr, target);
//		int[] nums1 = { 1, 2 };
//		int[] nums2 = { 3, 4 };
//		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static void check(int[] arr, int target) {
		int i = 0, k = 1, j = arr.length - 1;
		while (i < j) {
			if (arr[k] + arr[j] < target - arr[i]) {
				k++;
			} else if (arr[k] + arr[j] > target - arr[i]) {
				j--;
			} else {
				System.out.println(arr[i] + ", " + arr[k] + " and " + arr[j]);
				k++;
				j--;
			}
			if (k >= j) {
				i++;
				k = i + 1;
				j = arr.length - 1;
			}
		}
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] ans = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				ans[k] = nums1[i];
				i++;
			} else {
				ans[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (i < nums1.length) {
			ans[k] = nums1[i];
			i++;
			k++;
		}
		while (j < nums2.length) {
			ans[k] = nums2[j];
			j++;
			k++;
		}
		for (int val : ans) {
			System.out.print(val + " ");
		}
		if (ans.length % 2 != 0) {
			return ans[ans.length / 2];
		} else {
			double a = (ans[ans.length / 2] + ans[ans.length / 2 - 1]) / 2;
			return a;
		}

	}

}
