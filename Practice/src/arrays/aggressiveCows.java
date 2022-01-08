package arrays;

import java.util.Scanner;

public class aggressiveCows {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int C = s.nextInt();
		int[] stall = new int[N];
		for (int i = 0; i < stall.length; i++) {
			stall[i] = s.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for (int val : stall) {
			if (val > max) {
				max = val;
			}
		}
		int[] barn = new int[max + 1];
		for (int i = 0; i < barn.length; i++) {
			barn[i] = 0;
			for (int j = 0; j < stall.length; j++) {
				if (stall[j] == i) {
					barn[i] = 1;
					break;
				}
			}
		}
//		for(int val:barn) {
//			System.out.print(val+" ");
//		}
		int st = 0, ed = 0, diff = 0, flag = 0;
		for (int idx = 0; idx < barn.length; idx++) {
			if (barn[idx] == 1 && flag == 0) {
				st = idx;
				ed = idx;
				flag = 1;
			} else if (barn[idx] == 1 && flag == 1) {
				st = ed;
				ed = idx;
				if (diff < ed - st) {
					diff = ed - st - 1;
				}
			}
		}
		System.out.println(diff);
	}
}
