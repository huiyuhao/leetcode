package leetcode;

import java.util.HashSet;
import java.util.Set;

public class H37 {

	/**
	 * 自己写的，不知道怎么就出不来，太乱了，找不到原因
	 * 
	 * @param board
	 */
	public void solveSudoku(char[][] board) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 1; i < 10; i++) {
			set.add((char) (i + '0'));
		}
		backtrack(board, 0, 0, set);
	}

	public boolean backtrack(char[][] board, int row, int column, Set<Character> set) { // 行 Row 列 Column
		Set<Character> saveSet = new HashSet<Character>();
		for (int i = 1; i < 10; i++) {
			saveSet.add((char) (i + '0'));
		}
		if (board[row][column] == '.') {
			for (int i = 0; i < 9; i++) {
				set.remove(board[row][i]);
			}
			for (int i = 0; i < 9; i++) {
				set.remove(board[i][column]);
			}
			for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
				for (int j = column / 3 * 3; j < column / 3 * 3 + 3; j++) {
					set.remove(board[i][j]);
				}
			}
			if (set.isEmpty())
				return false;
			for (Character ch : set) {
				board[row][column] = ch;
				if (column < 8) {
					if (backtrack(board, row, column + 1, saveSet))
						return true;
					else
						board[row][column] = '.';
				} else if (row < 8)
					if (backtrack(board, row + 1, 0, saveSet))
						return true;
					else
						board[row][column] = '.';
			}
		} else if (column < 8) {
			if (backtrack(board, row, column + 1, saveSet))
				return true;
		} else if (row < 8)
			if (backtrack(board, row + 1, 0, saveSet))
				return true;
		if (column != 8 || row != 8)
			return false;
		return true;
	}

	private void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 根据官方题解写的
	 * 
	 * @param board
	 */
	public void solveSudoku2(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int d = Character.getNumericValue(board[i][j]);
					placeNumber(d, i, j, board);
				}
			}
		}
		backtrack(0, 0, board);
	}

	int[][] rows = new int[9][10];
	int[][] columns = new int[9][10];
	int[][] boxes = new int[9][10];
	boolean sudukuSolved = false;

	public boolean couldPlace(int d, int row, int col) {
		int idx = row / 3 * 3 + col / 3;
		return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
	}

	public void placeNumber(int d, int row, int col, char[][] board) {
		int idx = row / 3 * 3 + col / 3;
		rows[row][d]++;
		columns[col][d]++;
		boxes[idx][d]++;
		board[row][col] = (char) (d + '0');
	}

	public void placeNextNumber(int row, int col, char[][] board) {
		if (row == 8 && col == 8)
			sudukuSolved = true;
		else if (col < 8)
			backtrack(row, col + 1, board);
		else if (row < 8)
			backtrack(row + 1, 0, board);
	}

	public void removeNumber(int d, int row, int col, char[][] board) {
		int idx = row / 3 * 3 + col / 3;
		rows[row][d]--;
		columns[col][d]--;
		boxes[idx][d]--;
		board[row][col] = '.';
	}

	public void backtrack(int row, int col, char[][] board) {
		if (board[row][col] == '.') {
			for (int d = 1; d < 10; d++) {
				if (couldPlace(d, row, col)) {
					placeNumber(d, row, col, board);
					placeNextNumber(row, col, board);
					if (!sudukuSolved)
						removeNumber(d, row, col, board);
				}
			}
		} else {
			placeNextNumber(row, col, board);
		}
	}

	public static void main(String[] args) {
		H37 h37 = new H37();
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		h37.solveSudoku2(board);
		h37.printBoard(board);
	}
}
