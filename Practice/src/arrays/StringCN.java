package arrays;

import java.util.Arrays;

public class StringCN {

	public static void main(String[] args) {
		String str = "aaabbccccddfggggg";
		System.out.println(removeConsecutiveDuplicates(str));
		System.out.println(reverseEachWord("abc def ghi jkl"));
		System.out.println(stringStringCompression(str));
	}

	public static String removeConsecutiveDuplicates(String str) {
		String ans = "";
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				ans += str.charAt(i - 1);
			}
		}
		ans += str.charAt(str.length() - 1);
		return ans;
	}

	public static String reverseEachWord(String str) {
		int bi = 0;
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				for (int j = i - 1; j >= bi; j--) {
					ans += str.charAt(j);
				}
				bi = i;
				ans += ' ';
			}
		}
		for (int j = str.length() - 1; j > bi; j--) {
			ans += str.charAt(j);
		}
		return ans;
	}

	public static String stringStringCompression(String str) {
		String ans = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else if (str.charAt(i - 1) != str.charAt(i)) {
				ans += str.charAt(i - 1);
				if (count > 1) {
					ans += count;
				}
				count = 1;
			}
		}
		ans += str.charAt(str.length() - 1);
		if (count != 1) {
			ans += count;
		}
		return ans;
	}
}