package backtracking;

public class QueenProblems {

	public static void main(String[] args) {
//		queenCombinationQueenRespect1D(2, 0, new boolean[4], "", 0);
//		System.out.println();
//		queenCombinationBoxRespect1D(2, 0, 0, new boolean[4], "");
//		queenCombinationBoxRespect2D(0, 0, 2, 0, "", new boolean[2][3]);
//		queenCombinations2DKill(0, 0, 2, 0, "", new boolean[2][3]);
//		System.out.println();
//		queenCombinations2DKill(new boolean[2][3], 0, 0, 0, 2, "");
//		System.out.println();
		NQueens1A(new boolean[4][4], 0, 0, 4, 0, "");
		System.out.println();
		NQueens2(new boolean[4][4], 0, 4, 0, "");
	}

	public static void queenPermutations1D(int tq, int qpsf, String ans) {

	}

	public static void queenCombinationQueenRespect1D(int tq, int qpsf, boolean[] arr, String ans, int lvb) {

		if (tq == qpsf) {
			System.out.print(ans + "  ");
			return;
		}

		for (int box = lvb; box < arr.length; box++) {
			if (!arr[box]) {
				arr[box] = true;
				queenCombinationQueenRespect1D(tq, qpsf + 1, arr, ans + "q" + qpsf + "b" + box + " ", box);
				arr[box] = false;
			}
		}
	}

	public static void queenCombinationBoxRespect1D(int idx, int tq, int qpsf, boolean[] box, String ans) {

	}

	public static void queenCombinationBoxRespect2D(int row, int col, int tq, int qpsf, String ans, boolean[][] box) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col == box[0].length) {
			row++;
			col = 0;
		}
		if (row == box.length) {
			return;
		}
		queenCombinationBoxRespect2D(row, col + 1, tq, qpsf + 1, ans + row + "-" + col + " , ", box);
		queenCombinationBoxRespect2D(row, col + 1, tq, qpsf, ans, box);
	}

	public static void queenCombinations2DKill(int row, int col, int tq, int qpsf, String ans, boolean[][] box) {

		// positive bc
		if (tq == qpsf) {
			System.out.print(ans + " ");
			return;
		}
		// negative bc1
		if (col == box[0].length) {
			row++;
			col = 0;
		}
		// negative bc2
		if (row == box.length) {
			return;
		}

		// Place
		if (isItSafeToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			queenCombinations2DKill(row, col + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ")", box);
			box[row][col] = false;
		}

		// No place
		queenCombinations2DKill(row, col + 1, tq, qpsf, ans, box);

	}

	public static void queenCombinations2DKill(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {// positive bc
			System.out.print(ans + " ");
			return;
		}
		if (col == board[0].length) {// negative bc1
			row++;
			col = 0;
		}
		if (row == board.length) {// negative bc2
			return;
		}

		// Queen Placed
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;// prior preparation
			queenCombinations2DKill(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ")");
			board[row][col] = false;// undo
		}

		// Queen Not Placed
		queenCombinations2DKill(board, row, col + 1, qpsf, tq, ans);
	}

	public static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {

		// vertical upward row
		for (int r = row, c = col; r >= 0; r--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally left upward
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c]) {
				return false;
			}
		}
		// diagonally right upward
		for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
			if (board[r][c]) {
				return false;
			}
		}
		// horizontally left row
		for (int r = row, c = col; c >= 0; c--) {
			if (board[r][c]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isItSafeToPlaceQueen(boolean[][] box, int cr, int cc) {
		// diagonally left
		for (int r = cr, c = cc; r >= 0 && c >= 0; r--, c--) {
			if (box[r][c]) {
				return false;
			}
		}
		// horizontally left
		for (int r = cr, c = cc; c >= 0; c--) {
			if (box[r][c]) {
				return false;
			}
		}
		// vertically up
		for (int r = cr, c = cc; r >= 0; r--) {
			if (box[r][c]) {
				return false;
			}
		}
		// diagonally right
		for (int r = cr, c = cc; r >= 0 && c < box[0].length; r--, c++) {
			if (box[r][c]) {
				return false;
			}
		}
		return true;
	}

	public static void NQueens1A(boolean[][] box, int row, int col, int tq, int qpsf, String ans) {
		if(tq == qpsf) {
			System.out.println(ans +" ");
			return;
		}
		if(col == box[0].length) {
			row++;
			col = 0;
		}
		if(row == box.length) {
			return;
		}
		// place
		if(isItSafeToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			NQueens1A(box, row , col + 1, tq, qpsf + 1, ans +"("+row+","+col+")");
			box[row][col] = false;
		}
		// not place
		NQueens1A(box, row, col + 1, tq, qpsf, ans);
		
	}
	
	public static void NQueens1B(boolean[][] box, int row, int col, int tq, int qpsf, String ans) {
		if(tq == qpsf) {
			System.out.println(ans +" ");
			return;
		}
		if(col == box[0].length) {
			row++;
			col = 0;
		}
		if(row == box.length) {
			return;
		}
		// place
		if(isItSafeToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			NQueens1A(box, row , col + 1, tq, qpsf + 1, ans +"("+row+","+col+")");
			box[row][col] = false;
		}
		// not place
		NQueens1A(box, row, col + 1, tq, qpsf, ans);
		
	}
	
	public static void NQueens2(boolean[][] box, int row, int tq, int qpsf, String ans) {

		if (tq == qpsf) {
			System.out.println(ans + " ");
			return;
		}
		if (row == box.length) {
			return;
		}

		// queen placed
		for (int col = 0; col < box[0].length; col++) {
			if (isItSafeToPlaceQueen(box, row, col)) {
				box[row][col] = true;
				NQueens2(box, row + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ")");
				box[row][col] = false;
			}
		}

	}
}
