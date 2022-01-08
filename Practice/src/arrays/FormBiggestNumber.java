package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FormBiggestNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		while (test > 0) {
			int size = s.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
			//int[] arr= {1, 34, 3, 98, 9, 76, 45, 4 };
			int[] narr = new int[arr.length];
			Arrays.sort(arr);
			for (int i = arr.length - 1; i >= 0; i--) {
				narr[arr.length - 1 - i] = arr[i];
			}
			for (int i = 0; i < narr.length - 1; i++) {
				for (int j = 0; j < narr.length - 1 - i; j++) {
//					if (msb(narr[j]) < msb(narr[j + 1])) {
//						int temp = narr[j];
//						narr[j] = narr[j + 1];
//						narr[j + 1] = temp;
//					}
//					else if(msb(narr[j]) == msb(narr[j + 1])) {
//						if(narr[j]<narr[j+1]) {
//							int temp = narr[j];
//							narr[j] = narr[j + 1];
//							narr[j + 1] = temp;
//						}
//					}
					
				}
			}
			for (int i=0;i<narr.length;i++) {
				System.out.print(narr[i]);
			}
			test--;
		}
	}
	public static int msb(int n) {
		int digit = 0;
		while (n > 0) {
			digit = n % 10;
			n = n / 10;
		}
		return digit;
	}
}