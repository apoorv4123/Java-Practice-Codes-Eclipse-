package slidingWindow;

public class Leetcode862 {

	public static void main(String[] args) {
		
		int[] arr = {2, -1, 2};
		int k = 3;
		int ans = -1, winSum = 0;
		
		int i = 0, j = 0;
		
		while(j < arr.length) {
			winSum += arr[j];
			if(winSum < k) {
				j++;
			}else if(winSum >= k) {
				ans = Math.min(ans, j - i + 1);
			}
		}

		System.out.println(ans);
	}

}
