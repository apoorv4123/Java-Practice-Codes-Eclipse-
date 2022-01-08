package slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithNoUniqueCharacters {

	public static void main(String[] args) {

		String s = "pwwkew";

		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0, j = 0;

		while (j < s.length()) {
			// Calculation
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			
			if(map.size() == j - i + 1) {
				max = Math.max(max, j - i + 1);
				j++;
			}else if(map.size() < j - i + 1) {
				while(map.size() < j - i + 1) {
					char ich = s.charAt(i);
					map.put(ich, map.get(ich) - 1);
					if(map.get(ich) == 0) {
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
