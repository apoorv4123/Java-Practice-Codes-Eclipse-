package slidingWindow;

public class LargestSubarrayOfSumK {

	public static void main(String[] args) {

		int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
		int k = 5;

		int i = 0, j = 0;
		int sum = 0, max = Integer.MIN_VALUE;

		while (j < arr.length) {
			// Calculation
			sum += arr[j];

			if (sum < k) {
				j++;
			} else if (sum == k) {
				max = Math.max(max, j - i + 1);
				j++;
			} else if (sum > k) {
				while (sum > k) {
					sum -= arr[i];
					i++;
				}
				j++;
			}
		}
		System.out.println(max);
	}

}
