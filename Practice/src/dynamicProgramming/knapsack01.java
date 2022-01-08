package dynamicProgramming;

public class knapsack01 {

	public static void main(String[] args) {
		int[] wt = {1,3,4,5};
		int[] pr = {1,4,5,7};
		int cap = 7;
		System.out.println(k01Rec(wt, pr, 0, cap));
		
		System.out.println(k01TD(wt, pr, 0, cap, new int[wt.length][cap + 1]));
		
	}
	
	public static int k01Rec(int[] wt, int[] pr, int vidx, int cap) {
		if(vidx == wt.length || cap == 0) {
			return 0;
		}
		if(wt[vidx] > cap) {
			return 0;
		}
		int ans = 0;
		// Include
		int inc = k01Rec(wt, pr, vidx + 1, cap - wt[vidx]) + pr[vidx];
		// Not Include
		int ninc = k01Rec(wt, pr, vidx + 1, cap);
		
		ans = Math.max(inc, ninc);
		return ans;
	}
	
	public static int k01TD(int[] wt, int[] pr, int vidx, int cap, int[][] strg) {
		if(vidx == wt.length || cap == 0) {
			return 0;
		}
		if(wt[vidx] > cap) {
			return 0;
		}
		
		if(strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		
		int ans = 0;
		// Include
		int inc = k01TD(wt, pr, vidx + 1, cap - wt[vidx], strg) + pr[vidx];
		// Not Include
		int ninc = k01TD(wt, pr, vidx + 1, cap, strg);
		
		ans = Math.max(inc, ninc);
		
		strg[vidx][cap] = ans;
		
		return ans;
	}
	
	public static int k01BU(int[] wt, int[] pr, int cap) {
		int[][] strg = new int[wt.length + 1][cap + 1];
	}

}
