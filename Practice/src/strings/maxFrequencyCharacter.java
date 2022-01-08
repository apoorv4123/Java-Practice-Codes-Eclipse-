package strings;

import java.util.Arrays;
import java.util.Scanner;

public class maxFrequencyCharacter {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		char[] charray=sortString(str);
		int freq=0,ans=0;
		char ch=charray[0];
		for(int i=1;i<charray.length;i++) {
			if(charray[i]!=charray[i-1]) {
				if(freq>ans) {
				ans=freq;
				ch=charray[i-1];}
			}else {
				freq++;
			}
		}
		System.out.println(ch);

	}
	public static char[] sortString(String str) {
		char[] ans=str.toCharArray() ;
		Arrays.sort(ans);
		return ans;
	}

}
