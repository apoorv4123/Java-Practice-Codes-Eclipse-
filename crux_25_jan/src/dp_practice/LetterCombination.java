package dp_practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> main = new ArrayList<List<String>>();
		solveNQueens(n, 0, 0, new boolean[n][n], main, new ArrayList<String>());
		return main;
	}

	public static void solveNQueens(int n, int row, int col, boolean[][] board, List<List<String>> main,
			List<String> temp) {

		if (n == 0) {
			temp = new ArrayList<String>();
			for (int r = 0; r < board.length; r++) {
				String ans = "";
				for (int c = 0; c < board[0].length; c++) {

					if (board[r][c]) {
						ans += 'Q';
					} else {
						ans += ".";
					}

				}
				temp.add(ans);
			}
			main.add(new ArrayList<>(temp));
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// place
		if (canBePlaced(board, row, col)) {

			board[row][col] = true;
			solveNQueens(n - 1, row + 1, 0, board, main, temp);
			board[row][col] = false;

		}

		// don't place
		solveNQueens(n, row, col + 1, board, main, temp);
	}

	private static boolean canBePlaced(boolean[][] board, int row, int col) {

		// horizontal
		for (int r = row, c = col - 1; c >= 0; c--) {
			if (board[r][c]) {
				return false;
			}
		}

		// vertical
		for (int r = row - 1, c = col; r >= 0; r--) {
			if (board[r][c]) {
				return false;
			}
		}

		// diagonal 1
		for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c]) {
				return false;
			}
		}

		// diagonal 2
		for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c]) {
				return false;
			}
		}

		return true;
	}

}
