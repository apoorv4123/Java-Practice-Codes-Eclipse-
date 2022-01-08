package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode301 {

	public static void main(String[] args) {
		List<String> ans = new ArrayList<>();
		solution("()())()", 0, 0, 0, "", ans);
		int max = Integer.MIN_VALUE;
		for (String str : ans) {
			max = Math.max(max, str.length());
		}
		System.out.println(max);
		List<String> res = new ArrayList<>();
		for (String str : ans) {
			if (str.length() == max && !res.contains(str))
				res.add(str);
		}
		System.out.println(res);
	}

	static int i = 0;

	public static void solution(String s, int vidx, int st, int en, String sol, List<String> ans) {
		if (vidx == s.length()) {
			if (en == st)
				ans.add(sol);
			return;
		}

		if (en > st) {
			return;
		}

		char ch = s.charAt(vidx);
		// include
		if (ch == '(') {
			solution(s, vidx + 1, st + 1, en, sol + ch, ans);
		} else if (ch == ')') {
			solution(s, vidx + 1, st, en + 1, sol + ch, ans);
		} else {
			solution(s, vidx + 1, st, en, sol + ch, ans);
		}
		// not include
		solution(s, vidx + 1, st, en, sol, ans);
	}


}
