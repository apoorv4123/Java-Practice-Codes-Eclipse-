package slidingWindow;

// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a contiguous subarray[numsl,numsl+1,...,numsr-1,numsr]
// of which the sum is greater than or equal to target.
// If there is no such subarray,return 0 instead.

public class Leetcode209 {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int k = 7;

		int winSum = 0, res = Integer.MAX_VALUE;

		int i = 0, j = 0;
		while (j < nums.length) {

			winSum += nums[j];

			if (winSum < k) {
				j++;
			} else if (winSum >= k) {
				while (winSum >= k) {
					res = Math.min(res, j - i + 1);
					winSum -= nums[i];
					i++;
				}
				j++;
			}

		}

		System.out.println(res);
	}

}
