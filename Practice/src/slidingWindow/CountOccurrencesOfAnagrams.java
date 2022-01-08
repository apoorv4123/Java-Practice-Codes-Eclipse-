package slidingWindow;

import java.util.HashMap;

public class CountOccurrencesOfAnagrams {

	public static void main(String[] args) {

		String s = "aabaabaa";
		String ptr = "aaba";

//		HashMap<Character, Integer> ptrSet = new HashMap<Character, Integer>();
//		for (char ch : ptr.toCharArray()) {
//			ptrSet.put(ch, ptrSet.getOrDefault(ch, 0) + 1);
//		}
//
//		HashMap<Character, Integer> windowSet = new HashMap<Character, Integer>();
//		int i = 0, j = 0, k = ptr.length(), count = 0;
//
//		while (j < s.length()) {
//			// Calculation
//			char ch = s.charAt(j);
//			windowSet.put(ch, windowSet.getOrDefault(ch, 0) + 1);
//			if (j - i + 1 < k) {
//				j++;
//			} else if (j - i + 1 == k) {
////				System.out.println(i + "-" + j + "=" + s.substring(i, j + 1));
//				// 1. Obtain answer from calculation
////				System.out.println(windowSet + "-" + ptrSet + "=" + windowSet.equals(ptrSet));
//				if (windowSet.equals(ptrSet)) {
//					count++;
//				}
//				// 2. Slide window
//				int val = windowSet.remove(s.charAt(i)) - 1;
//				if (val == 0) {
//					continue;
//				} else {
//					windowSet.put(s.charAt(i), val);
//				}
//				i++;
//				j++;
//			}
//		}
//
//		System.out.println(count);

		System.out.println(solution(s, ptr));
	}

	public static int solution(String s, String ptr) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;

		for (char ch : ptr.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int count = map.size(), k = ptr.length();

		int i = 0, j = 0;
		while (j < s.length()) {
			System.out.print(i + "-" + j + " : " + s.substring(i, j + 1) + "--" + map);
			// Calculation
			char ch = s.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
//				System.out.println(" "+map);
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// 1. Obtain answer from calculations
				if (count == 0) {
//					System.out.println(i + "-" + j + " : " + s.substring(i, j + 1));
					ans++;
				}
				// 2. Slide the window
				char kch = s.charAt(i);
				if (map.containsKey(kch)) {
					map.put(kch, map.get(kch) + 1);
					if (map.get(kch) == 1) {
						count++;
					}
				}
				i++;
				j++;
			}
		}

		return ans;
	}

}
