package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetcode78 {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,3}));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		subsets(nums, 0, new ArrayList<Integer>(), answer);
		
		return answer;
	}

	public static void subsets(int[] nums, int vidx, List<Integer> list, List<List<Integer>> answer) {
		if (vidx == nums.length) {
			answer.add(new ArrayList<>(list));
			return;
		}

		// won't contribute
		subsets(nums, vidx + 1, list, answer);
		
		// contribute
		list.add(nums[vidx]);
		subsets(nums, vidx + 1, list, answer);
		list.remove(list.size() - 1);
		
		return;
	}

}
