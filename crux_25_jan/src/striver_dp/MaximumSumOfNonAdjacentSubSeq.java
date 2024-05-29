package striver_dp;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentSubSeq {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 9 };
		System.out.println(recursion(0, arr));
		System.out.println(recursion2(arr.length - 1, arr));

		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(memoization2(arr.length - 1, arr, dp));

		System.out.println(tabulation(arr));
		
		System.out.println(spaceOptimization(arr));
	}

	// going from 0 to last index
	public static int recursion(int i, int[] arr) {
		if (i == arr.length - 1) {
			return arr[i];
		}
		if (i == arr.length) {
			return 0;
		}
		int include = recursion(i + 2, arr) + arr[i];
		int notInclude = recursion(i + 1, arr);
		return Math.max(include, notInclude);
	}

	// going from last index to 0
	public static int recursion2(int i, int[] arr) {
		if (i == 0) {
			return arr[i];
		}
		if (i < 0) {
			return 0;
		}
		int include = recursion2(i - 2, arr) + arr[i];
		int notInclude = recursion2(i - 1, arr);
		return Math.max(include, notInclude);
	}

	// going from last index to 0
	public static int memoization2(int i, int[] arr, int[] dp) {
		if (i == 0) {
			return arr[i];
		}
		if (i < 0) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int include = memoization2(i - 2, arr, dp) + arr[i];
		int notInclude = memoization2(i - 1, arr, dp);
		int ans = Math.max(include, notInclude);
		dp[i] = ans;
		return ans;
	}

	public static int tabulation(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n + 1];
		dp[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
//			int include = arr[i];
//			if(i + 2 <= n - 1) {
//				include += dp[i + 2];
//			}
			int include = dp[i + 2] + arr[i];
			int exclude = dp[i + 1];
			dp[i] = Math.max(include, exclude);
		}
		return dp[0];
	}
	
	public static int spaceOptimization(int[] arr) {
		int prev = arr[0];
		int prev2 = 0;
		
		for(int i = 1; i < arr.length ; i ++) {
			int curr = Math.max(prev2 + arr[i], prev);
			prev2 = prev;
			prev = curr;
		}
		return prev;
		
	}
}
