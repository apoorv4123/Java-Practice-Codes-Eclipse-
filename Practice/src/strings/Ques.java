package strings;

import java.util.Scanner;

public class Ques {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int size = scn.nextInt();
		int[] arr = makeArr(size);
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		int ops = scn.nextInt();
		while (ops > 0) {

			int x = scn.nextInt();
			x = x % arr.length;
			int i = 1;
			int[] add = res;
			while (i <= x) {
				int fst = arr[arr.length - 1];
				for (int j = arr.length - 1; j > 0; j--) {
					arr[j] = arr[j - 1];
				}
				arr[0] = fst;
				add = arr;
				i++;

			}
			for (int k = 0; k < arr.length; k++) {
				res[k] += add[k];
			}

			ops--;
		}

		System.out.println(sum(res) % 1000000007);

	}

	public static int[] makeArr(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static int sum(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

}