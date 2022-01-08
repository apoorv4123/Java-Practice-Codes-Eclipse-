package slidingWindow;

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;
		int maxSum = 0, windowSum = 0;

		int i = 0, j = 0;

		while (j < arr.length) {
			// Calculation (exclusive of j)
			windowSum = windowSum + arr[j];
			if (j - i + 1 < k) { // Hit window size
				j++;
			} else if (j - i + 1 == k) { // Maintain window size
				// 1. Obtain an answer from the calculations
				maxSum = Math.max(maxSum, windowSum);

				// 2. Slide the window
				windowSum = windowSum - arr[i];// Handle the calculations regarding the current i before doing i++
												// bcoz i is going to be removed in next window
				i++; // we need to handle(remove) the calculations regarding the previous i
				j++; // j ki calculation is covered out of if condition(in the beginning of loop)
			}
		}
		System.out.println(maxSum);
	}

}
