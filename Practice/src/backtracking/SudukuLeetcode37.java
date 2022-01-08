package backtracking;

import java.util.Scanner;

public class SudukuLeetcode37 {

	public static void main(String[] args) {

//		5 3 . . 7 . . . .
//		6 . . 1 9 5 . . .
//		. 9 8 . . . . 6 .
//		8 . . . 6 . . . 3
//		4 . . 8 . 3 . . 1
//		7 . . . 2 . . . 6
//		. 6 . . . . 2 8 .
//		. . . 4 1 9 . . 5
//		. . . . 8 . . 7 9

		char[][] board = new char[9][9];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = scn.next().charAt(0);
			}
		}
		char[][] result = new char[board.length][board[0].length];
		solveSudoku(0, 0, board, result);
	}

	public static void solveSudoku(int row, int col, char[][] board, char[][] result) {

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
//			display(board);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					result[i][j] = board[i][j];
				}
			}
			return;
		}

		if (board[row][col] != '.') {
			solveSudoku(row, col + 1, board, result);
			return;
		}

		for (int i = 1; i <= board.length; i++) {
			if (isItSafeToPlaceInACell(row, col, board, (char) (i + '0'))) {
				board[row][col] = (char) (i + '0');
				solveSudoku(row, col + 1, board, result);
				board[row][col] = '.';
			}
		}
	}

	public static boolean isItSafeToPlaceInACell(int row, int col, char[][] board, char ch) {
		// vertical column up
		for (int r = 0, c = col; r < board.length; r++) {
			if (board[r][c] == ch) {
				return false;
			}
		}
		// horizontal row left
		for (int r = row, c = 0; c < board[0].length; c++) {
			if (board[r][c] == ch) {
				return false;
			}
		}
		// in square
		int squareStartRow = row - row % 3;
		int squareStartCol = col - col % 3;
		for (int r = squareStartRow; r <= squareStartRow + 2; r++) {
			for (int c = squareStartCol; c <= squareStartCol + 2; c++) {
				if (board[r][c] == ch) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isItSafe(int[][] arr, int row, int col, int num) {

		if (isItSafeRow(arr, row, num) && isItSafeCol(arr, col, num) && isItSafeCell(arr, row, col, num)) {
			return true;
		}
		return false;
	}

	private static boolean isItSafeCol(int[][] arr, int col, int num) {
		for (int r = 0; r < arr.length; r++) {
			if (arr[r][col] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean isItSafeCell(int[][] arr, int row, int col, int num) {

		// block starting row
		int bsr = row - row % 3;
		// block starting column
		int bsc = col - col % 3;

		for (int r = bsr; r < bsr + 3; r++) {
			for (int c = bsc; c < bsc + 3; c++) {
				if (arr[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isItSafeRow(int[][] arr, int row, int num) {

		for (int c = 0; c < arr[0].length; c++) {
			if (arr[row][c] == num) {
				return false;
			}
		}
		return true;
	}

	public static void display(char[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
