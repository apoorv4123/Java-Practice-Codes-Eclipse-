package stacks;

import java.util.Stack;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
		int[] nge = nextGreaterElement(arr);
		for(int val:nge) {
			System.out.print(val +" ");
		}
		
		System.out.println();
		slidingWindowMaximum(arr, 4, nge);
	}
	
	// in nge, indices of next greater element shall be stored
	public static int[] nextGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] nge = new int[arr.length];

		st.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;

		for (int i = arr.length - 2; i >= 0; i--) {

			// popping
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				st.pop();
			}

			// answer
			if (st.isEmpty()) {
				nge[i] = arr.length; // infinity, if no nge exists for current element
			} else {
				nge[i] = st.peek();
			}

			// push
			st.push(i);
		}
		return nge;
	}

	public static void slidingWindowMaximum(int[] arr, int k, int[] nge) {
		int j = 0;
		for(int i = 0 ; i <= arr.length - k ; i++) {
			// enter the loop to find the maximum of window starting at i
			if(j < i) {
				j = i;
			}
//			int j = i;
			while(nge[j] < i+ k) {
				j = nge[j];
			}
			System.out.print(arr[j] +" ");
		}
	}
}
