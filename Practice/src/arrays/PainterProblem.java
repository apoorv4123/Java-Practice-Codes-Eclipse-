package arrays;

import java.util.Scanner;

public class PainterProblem {

	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) {
		int k=s.nextInt();
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		if(k>=n) {
			System.out.println(max(arr, 0));
			
		}

	}
	public static int max(int[] arr,int idx) {
		if(idx==arr.length) {
			return Integer.MIN_VALUE;
		}
		int rr=max(arr,idx+1);
		if(rr>arr[idx]) {
			return rr;
		}
		return arr[idx];
	}

}
