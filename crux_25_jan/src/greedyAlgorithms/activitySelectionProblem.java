package greedyAlgorithms;

public class activitySelectionProblem {
// Leetcode 452. Minimum Number of Arrows to Burst Balloons
	public static void main(String[] args) {

		int[] start = { 8, 3, 5, 5, 1, 0 };
		int[] finish = { 9, 4, 9, 7, 2, 6 };
//		Arrays.sort(finish);
//
//		int ans = 1, previousactivity = finish[0];
//		for (int i = 1; i < start.length; i++) {
//			if (start[i] >= previousactivity) {
//				previousactivity = finish[i - 1];
//				ans++;
//			}
//		}
//		System.out.println(ans);
		
		activitySelectionProblem a = new activitySelectionProblem();
		Pair[] arr = new Pair[start.length];
		for (int i = 0; i < start.length; i++) {
			arr[i] = a.new Pair(start[i], finish[i]);
		}
		insertionSort(arr);
		for (int i = 0; i < start.length; i++) {
			System.out.println(arr[i].st + " " + arr[i].en);
		}
	}

	public static void insertionSort(Pair[] arr) {

		for (int counter = 1; counter <= arr.length - 1; counter++) {

			Pair val = arr[counter];

			int j = counter - 1;
			while (j >= 0 && arr[j].en > val.en) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}
	}

	class Pair {
		int st;
		int en;

		public Pair(int st, int en) {
			this.st = st;
			this.en = en;
		}
	}

}