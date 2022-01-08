package divideAndConquer;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 2, 8, 1, 67, 23, 11, 0, 7, 44, 10, 9, 66, 77, 4, 8 };
		for (int val : mergeSort(arr, 0, arr.length - 1)) {
			System.out.print(val + " ");
		}
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}

		int mid = (low + high) / 2;
		int[] firstPart = mergeSort(arr, low, mid);
		int[] secondPart = mergeSort(arr, mid + 1, high);

		int[] mergedArray = mergeTwoSortedArrays(firstPart, secondPart);

		return mergedArray;
	}

	private static int[] mergeTwoSortedArrays(int[] firstPart, int[] secondPart) {
		int[] result = new int[firstPart.length + secondPart.length];
		int i = 0, j = 0, k = 0;
		while (i < firstPart.length && j < secondPart.length) {
			if (firstPart[i] < secondPart[j]) {
				result[k] = firstPart[i];
				i++;
				k++;
			} else {
				result[k] = secondPart[j];
				j++;
				k++;
			}
		}
		while (i < firstPart.length) {
			result[k] = firstPart[i];
			i++;
			k++;
		}
		while (j < secondPart.length) {
			result[k] = secondPart[j];
			j++;
			k++;
		}
		return result;
	}

}