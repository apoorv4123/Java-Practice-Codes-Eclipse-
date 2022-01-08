package slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {

		String s = "aabacbebebe";
		int k = 3;

		HashMap<Character, Integer> map = new HashMap<>();

		int max = 0;

		int i = 0, j = 0;
		while (j < s.length()) {
			// Calculations
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				// Obtain answer from calculations
				max = Math.max(max, j - i + 1);
				j++;
			} else if (map.size() > k) {
				while (map.size() > k) {
					char ich = s.charAt(i); // character at ith position
					map.put(ich, map.get(ich) - 1);
					if (map.get(ich) == 0) {
						map.remove(ich);
					}
					i++;
				}
				j++;
			}
		}

		System.out.println(max);
	}

}
