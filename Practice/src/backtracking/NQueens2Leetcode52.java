package backtracking;

public class NQueens2Leetcode52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalQueens(0, 0, 0, new boolean[4][4], ""));
		System.out.println(totalQueens2(0, new boolean[4][4]));
	}

	public static int totalQueens2(int row, boolean[][] board) {
		if(row == board.length) {
			return 1;
		}
		int res = 0;
		for(int col = 0;col < board[0].length;col++) {
			if(isItSafeToPlaceQueen(row, col, board)) {
				board[row][col] = true;
				res += totalQueens2(row + 1, board);
				board[row][col] = false;
			}
		}
		return res;
	}
	
	public static int totalQueens(int cr, int cc, int qpsf, boolean[][] board, String ans) {

		if (qpsf == board.length) {
			System.out.println(ans);
			return 1;
		}

		if (cc == board[0].length) {// negative bc1
			cr++;
			cc = 0;
		}
		if (cr == board.length) {// negative bc2
			return 0;
		}

		int res = 0;
		// place
		if (isItSafeToPlaceQueen(cr, cc, board)) {
			board[cr][cc] = true;
			res += totalQueens(cr + 1, 0, qpsf + 1, board, ans + cr + "-" + cc + " , ");
			board[cr][cc] = false;
		}
		// don't place
		res += totalQueens(cr, cc + 1, qpsf, board, ans);
		return res;
	}

	public static boolean isItSafeToPlaceQueen(int row, int col, boolean[][] board) {

		// vertically up
		for (int r = row, c = col; r >= 0; r--) {
			if (board[r][c]) {
				return false;
			}
		}
		// horizontally left
		for (int r = row, c = col; c >= 0; c--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally up(left)
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally up(right)
		for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c]) {
				return false;
			}
		}
		return true;
	}

}
