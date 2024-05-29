package dp_practice;

public class boardPath {

	public static void main(String[] args) {
		
		System.out.println(recbp(30));

	}

	public static int recbp(int target) {

		if (target == 0) {
			return 1;
		}
		if (target < 0) {
			return 0;
		}

		int ans = 0;
		for (int dice = 1; dice <= 6; dice++) {
			ans += recbp(target - dice);
		}
		return ans;

	}
	
	

}
