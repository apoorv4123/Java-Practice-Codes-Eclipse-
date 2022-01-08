package binarySearch;

public class AllocationMinNumberOfPages {

	public static void main(String[] args) {

		int[] books = { 10,50,100,100,50,100,100,100};
		int k = 5; // maximum students

		int totalNoOfPages = 0;
		int maxPages = 0;
		int ans = Integer.MAX_VALUE;

		for (int noOfPages : books) {
			totalNoOfPages += noOfPages;
			maxPages = Math.max(maxPages, noOfPages);
		}

		int start = maxPages, end = totalNoOfPages;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (isValid(books, k, mid)) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(ans);

	}

	public static boolean isValid(int[] arr, int k, int maxNoOfPages) {
		int readers = 1;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > maxNoOfPages) {
				readers++;
				sum = arr[i];
			}
			if (readers > k) {
				return false;
			}
		}

		return true;
	}
	
}
