package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class FormMinimumNumber {

	static Scanner scn=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int t=scn.nextInt();
		ArrayList<String> al=new ArrayList<>();
		for(int i=0;i<t;i++) {
			String str=scn.next();
			al.add(str);
		}
		for(String val:al) {
			int num=1;
			while(val.length()!=0) {
				int dgt=onesDgt(num);
				num*=10;
				if(val.charAt(0)=='I') {
					dgt+=1;
					num+=dgt;
				}else {
					dgt-=1;
					num+=dgt;
				}
				val=val.substring(1);
			}
			System.out.println(num);
		}
		
	}
	public static int onesDgt(int n) {
		return n%10;
	}

}
