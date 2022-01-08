package slidingWindow;

import java.util.ArrayList;

public class FirstNegativeInWindowSizeK {

	public static void main(String[] args) {

		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;

		ArrayList<Integer> negativeNosList = new ArrayList<>();

		int i = 0, j = 0;
		while (j < arr.length) {
			// Calculation
			if (arr[j] < 0) {
				negativeNosList.add(arr[j]);
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// 1. Obtain an answer from the calculations
				if (negativeNosList.isEmpty()) {
					System.out.print(0 + " ");
				} else {
					System.out.println(negativeNosList.get(0));
				}

				// 2. Slide the window
				if (arr[i] < 0) { // Handle the calculations regarding the current i before doing i++
					negativeNosList.remove(0);
				}
				i++; // we need to handle(remove) the calculations regarding the previous i
				j++; // j ki calculation is covered out of if condition(in the beginning of loop)
			}
		}
	}

}
