package arrays;

import java.util.ArrayList;

public class ArraySum {

	public static void main(String[] args) {
		int[] one = { 9, 9, 5, 8, 7, 2, 9, 0, 0, 3, 6 };
		int[] two = { 6, 7, 6, 8, 9, 9, 9, 9, 0 };
		long t1 = System.currentTimeMillis();
		System.out.println(sumof2arrays(one, two));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

	}

	public static ArrayList<Integer> sumof2arrays(int[] one, int[] two) {
		ArrayList<Integer> sum = new ArrayList<>();
		int i = one.length - 1;
		int j = two.length - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int psum = 0;
			if (i < 0) {
				psum = carry + two[j];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
					j--;
				}
			} else if (j < 0) {
				psum = carry + one[i];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
					i--;
				}
			} else {
				psum = carry + one[i] + two[j];
				if (psum % 10 == psum) {
					sum.add(0, psum);
				} else if (psum % 10 != psum) {
					sum.add(0, psum % 10);
					carry = psum / 10;
				}
				i--;
				j--;
			}
		}
		if (carry > 0) {
			sum.add(0, carry);
		}
		return sum;
	}
}