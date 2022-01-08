package dynamicProgramming;

public class fibonacciSeries {

	public static void main(String[] args) {
		System.out.println(nthFibonacci(6));
		System.out.println(nthFibonacciTD(6, new int[7]));
		System.out.println(nthFibonacciBU(6));
	}
	
	public static int nthFibonacci(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		int nm1 = nthFibonacci(n - 1);
		int nm2 = nthFibonacci(n - 2);
		int res = nm1 + nm2;
		return res;
	}
	
	public static int nthFibonacciTD(int n, int[] arr) {
		if(n == 0 || n == 1) {
			return n;
		}
		if(arr[n] != 0) {
			return arr[n];
		}
		int nm1 = nthFibonacci(n - 1);
		int nm2 = nthFibonacci(n - 2);
		int res = nm1 + nm2;
		arr[n] = res;
		return res;
	}
	
	public static int nthFibonacciBU(int n) {
		int[] storage = new int[n+1];
		storage[1] = 1;
		for(int i = 2; i<storage.length  ;i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}
		return storage[storage.length - 1];
	}
}
