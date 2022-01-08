package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class HelpRamu {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		while (t > 0) {

			int[] cost = new int[4];
			for (int i = 0; i < cost.length; i++) {
				cost[i] = scn.nextInt();
			}
			// num of rickshaws
			int n = scn.nextInt();
			int[] rick = new int[n];
			// num of cabs
			int m = scn.nextInt();
			int[] cab = new int[m];
			// number of times ramu will use rickshaw number i
			for (int i = 0; i < n; i++) {
				rick[i] = scn.nextInt();
			}
			// number of times ramu will use cab number i
			for (int i = 0; i < m; i++) {
				cab[i] = scn.nextInt();
			}

			int s1 = 0, s2 = 0;

			for (int i = 0; i < rick.length; i++) {
				s1 += Math.min(rick[i] * cost[0], cost[1]);
			}
			s1 = Math.min(s1, cost[2]);

			for (int i = 0; i < cab.length; i++) {
				s2 += Math.min(cab[i] * cost[0], cost[1]);
			}
			s2 = Math.min(s2, cost[2]);

			int ans = Math.min(s1 + s2, cost[3]);

			System.out.println(ans);

//			1 3 7 19
//			2 3
//			2 5
//			4 4 4

//The total cost of rickshaws = min( min(2 * 1, 3) + min(5 * 1, 3), 7) = min(5, 7) = 5
//The total cost of cabs = min( min(4 * 1, 3) + min(4 * 1, 3) + min(4 * 1, 3) , 7) = min ( 9, 7) = 7
//Total final cost = min( totalCabCost + totalRickshawCost , c4) = min( 5 + 7, 19) = min ( 12, 19) = 12
//We print 12.
			t--;
		}

	}

}
