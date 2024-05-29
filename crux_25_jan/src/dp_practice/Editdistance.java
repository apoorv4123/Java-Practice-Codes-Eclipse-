package dp_practice;

public class Editdistance {

	public static void main(String[] args) {
		
		System.out.println();

	}

	public static int edrec(String s1, String s2) {

		if(s1.length()==0 || s2.length()==0) {
			
		}
		
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (s1.charAt(0) == s1.charAt(0)) {
			ans = edrec(ros1, ros2);
		} else {
			ans = Math.min(edrec(ros1, s2), Math.min(edrec(s1, ros2), edrec(ros1, ros2)));
		}
		return ans;
		
	}

}