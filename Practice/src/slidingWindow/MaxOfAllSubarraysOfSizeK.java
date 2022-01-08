package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		
		int[] nums = {1,3,-1,-3,5,8,5,4,6,6};
		int k = 3;
		
		int windowMax = Integer.MIN_VALUE;
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		int i = 0, j = 0;
		while(j < nums.length) {
			// Calculation
			while(!dq.isEmpty() && dq.peekLast() <= nums[j]) {
				dq.removeLast();
			}
			dq.addLast(nums[j]);
			if(j - i + 1 == k) {
				// 1. Obtain answer from previous calculation
				System.out.println(dq.peekFirst());
				// 2. Slide the window
				// Undo the calculations for current i
				if(nums[i] == dq.peekFirst()) {
					dq.removeFirst();
				}
				i++;
			}
			j++;
		}

	}

}
