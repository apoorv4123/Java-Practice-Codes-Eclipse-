package slidingWindow;

import java.util.HashMap;

public class CountSSWithAtMostKDistinctElements {

	public static void main(String[] args) {
		
		String str = "aabcbcdbca";
		int k = 2;
		int ans = 0;
		int i = 0, j = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(j < str.length()) {
			char jch = str.charAt(j);
			map.put(jch, map.getOrDefault(jch, 0) + 1);
			if(map.size() <= k) {
				ans += j - i + 1;
				j++;
				continue;
			}else if(map.size() > k) {
				while(map.size() > k) {
					char ich = str.charAt(i);
					map.put(ich, map.get(ich) - 1);
					if(map.get(ich) == 0) {
						map.remove(ich);
					}
					i++;
				}
				ans += j - i + 1;
				j++;
			}
		}
		System.out.println(ans);
	}

}
