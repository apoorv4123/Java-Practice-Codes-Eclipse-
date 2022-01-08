package stacks;

import java.util.Stack;

public class NextGreaterElementOnRight {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
		int[] res = solution1(arr);
		for (int val : res) {
			System.out.print(val + " ");
		}

		System.out.println();
		int[] res2 = solution2(arr);
		for (int val : res2) {
			System.out.print(val + " ");
		}
	}

	public static int[] solution1(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] nge = new int[arr.length];

		st.push(arr[arr.length - 1]);
		nge[arr.length - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			// popping
			while (!st.isEmpty() && st.peek() < arr[i]) {
				st.pop();
			}

			// answer
			if (st.isEmpty()) {
				nge[i] = -1;
			} else {
				nge[i] = st.peek();
			}

			// push
			st.push(arr[i]);
		}
		return nge;
	}

	public static int[] solution2(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] nge = new int[arr.length];

		st.push(0);

		for (int i = 1; i < arr.length; i++) {

			// pop & answer
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				nge[st.pop()] = arr[i];
			}

			// push
			st.push(i);

		}

		// stack mein vo values bachengi jinka nge nhi hai
		while (!st.isEmpty()) {
			nge[st.pop()] = -1;
		}
		
		return nge;
	}
}