package dynamicProgramming;

public class mazePath {

	public static void main(String[] args) {
//		System.out.println(mazePathRec(0, 0, 100, 100));
//		System.out.println(mazePathTD(0, 0, 2, 2, new int[3][3 ]));
		System.out.println(mazePathBU(100, 100));
	}

	public static int mazePathRec(int cr, int cc, int er, int ec) {
		if(cr == er && cc == ec) {
			return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		return mazePathRec(cr, cc + 1, er, ec) + mazePathRec(cr + 1, cc, er, ec);
	}
	

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if(cr == er && cc == ec) {
			return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		if(strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ans = mazePathTD(cr, cc + 1, er, ec, strg) + mazePathTD(cr + 1, cc, er, ec, strg);
		strg[cr][cc] = ans;
		return ans;
	}
	
	public static int mazePathBU(int er, int ec) {
		int[][] strg = new int[er + 2][ec + 2];
		strg[er][ec] = 1;
		for(int row = er ; row>=0;row--) {
			for(int col = ec;col >=0;col--) {
				if(row == er && col == ec) {
					strg[row][col] = 1;
				}else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}
		for(int[] arr:strg) {
			for(int val:arr) {
				System.out.print(val +" ");
			}
			System.out.println();
		}
		return strg[0][0];
	}
	
}
