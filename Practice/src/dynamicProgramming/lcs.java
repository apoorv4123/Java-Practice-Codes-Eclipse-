package dynamicProgramming;

import java.util.List;

public class lcs {

	public static void main(String[] args) {
//		List<String> l1 = new ArrayList<>();
//		getSS("abcdio", 0,"", l1);
//		List<String> l2 = new ArrayList<>();
//		getSS("agcfdtyuio", 0,"", l2);
//		int ans = 0;
//		for(String s1:l1) {
//			for(String s2:l2) {
//				if(s1.equals(s2)) {
//					ans = Math.max(ans, s1.length());
//				}
//			}
//		}
//		System.out.println(ans);
		
//		System.out.println(lcsRec("abcdio", "agcfdtyuio"));
		
//		System.out.println(lcsRec2("abcdio", "agcfdtyuio", 0, 0));
		
		String s1 = "abcdio", s2 = "agcfdtyuio";
		int[][] strg = new int[s1.length()][s2.length()];
		for(int[] arr : strg) {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = -1;
			}
		}
		System.out.println(lcsTD(s1, s2, 0, 0, strg));
		
		System.out.println(lcsBU("abcdio", "agcfdtyuio"));
	}
	
	public static void getSS(String str, int vidx, String ans, List<String> list) {
		if(vidx == str.length()) {
			list.add(ans);
			return;
		}
		// include
		getSS(str, vidx + 1,ans + str.charAt(vidx), list);
		// not include
		getSS(str, vidx + 1, ans,list);
	}
	
	public static int lcsRec(String str1, String str2) {
		if(str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		int res = 0;
		if(str1.charAt(0) == str2.charAt(0)) {
			res += lcsRec(str1.substring(1), str2.substring(1)) + 1;
		}else {
			res += Math.max(lcsRec(str1.substring(1), str2) , lcsRec(str1, str2.substring(1)));
		}
		return res;
	}
	
	public static int lcsRec2(String s1, String s2, int i1, int i2) {
		if(i1 == s1.length() || i2 == s2.length()) {
			return 0;
		}
		int ans = 0;
		if(s1.charAt(i1) == s2.charAt(i2)) {
			ans += lcsRec2(s1, s2, i1 + 1, i2 + 1) + 1;
		}else {
			ans = Math.max(lcsRec2(s1, s2, i1 + 1, i2), lcsRec2(s1, s2, i1, i2 + 1));
		}
		return ans;
	}
	
	public static int lcsTD(String s1, String s2, int i1, int i2, int[][] strg) {
		if(i1 == s1.length() || i2 == s2.length()) {
			return 0;
		}
		if(strg[i1][i2] != -1) {
			return strg[i1][i2];
		}
		int ans = 0;
		if(s1.charAt(i1) == s2.charAt(i2)) {
			ans += lcsTD(s1, s2, i1 + 1, i2 + 1, strg) + 1;
		}else {
			ans = Math.max(lcsTD(s1, s2, i1 + 1, i2, strg), lcsTD(s1, s2, i1, i2 + 1, strg));
		}
		strg[i1][i2] = ans;
		return ans;
	}

	public static int lcsBU(String s1, String s2) {
		int[][] strg = new int[s1.length()  +1][s2.length() + 1];
		
		for(int i = s1.length() - 1; i >=0 ;i--) {
			for(int j = s2.length() - 1; j>=0 ; j--) {
				if(s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i+1][j+1] + 1;
				}else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}
		
//		for(int[] arr : strg) {
//			for(int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] +" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		return strg[0][0];
	}
}
