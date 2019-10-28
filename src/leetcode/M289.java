package leetcode;

public class M289 {
	/**
	 * 这个不是原地算法，注意二维数组的深拷贝和浅拷贝问题
	 * 
	 * @param board
	 */
	public void gameOfLife(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			res[i] = board[i].clone();
		}
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				int num = count(board, x, y);
				if (num < 2 || num > 3)
					res[x][y] = 0;
				else if (board[x][y] == 0 && num == 3)
					res[x][y] = 1;
//				else if (board[x][y] == 1 && (num == 3 || num == 2))
//					res[x][y] = 1;
//				else
//					res[x][y] = 0;
			}
		}
		for (int i = 0; i < row; i++) {
			board[i] = res[i].clone();
		}
	}

	public int count(int[][] board, int x, int y) {
		int row = board.length;
		int col = board[0].length;
		int num = 0;
		if (y + 1 < col && board[x][y + 1] == 1)
			num++;
		if (y - 1 >= 0 && board[x][y - 1] == 1)
			num++;
		if (x + 1 < row && y + 1 < col && board[x + 1][y + 1] == 1)
			num++;
		if (x + 1 < row && y - 1 >= 0 && board[x + 1][y - 1] == 1)
			num++;
		if (x - 1 >= 0 && y + 1 < col && board[x - 1][y + 1] == 1)
			num++;
		if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 1)
			num++;
		if (x + 1 < row && board[x + 1][y] == 1)
			num++;
		if (x - 1 >= 0 && board[x - 1][y] == 1)
			num++;
		return num;
	}

	/**
	 * 原地算法 状态机 
	 * 0->0 0; 
	 * 0->1 2; 
	 * 1->0 3;
	 * 1->1 1
	 * 
	 * @param board
	 */
	public void gameOfLife2(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				int num = count2(board, x, y);
				if ((num < 2 || num > 3) && board[x][y] == 1)
					board[x][y] = 3;
				else if (board[x][y] == 0 && num == 3)
					board[x][y] = 2;
			}
		}
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				if (board[x][y] == 3)
					board[x][y] = 0;
				else if (board[x][y] == 2)
					board[x][y] = 1;
			}
		}
	}

	public int count2(int[][] board, int x, int y) {
		int row = board.length;
		int col = board[0].length;
		int num = 0;
		if (y + 1 < col && (board[x][y + 1] == 1 || board[x][y + 1] == 3))
			num++;
		if (y - 1 >= 0 && (board[x][y - 1] == 1 || board[x][y - 1] == 3))
			num++;
		if (x + 1 < row && y + 1 < col && (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == 3))
			num++;
		if (x + 1 < row && y - 1 >= 0 && (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == 3))
			num++;
		if (x - 1 >= 0 && y + 1 < col && (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == 3))
			num++;
		if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == 3))
			num++;
		if (x + 1 < row && (board[x + 1][y] == 1 || board[x + 1][y] == 3))
			num++;
		if (x - 1 >= 0 && (board[x - 1][y] == 1 || board[x - 1][y] == 3))
			num++;
		return num;
	}

	public static void main(String[] args) {
		M289 m289 = new M289();
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		m289.gameOfLife2(board);
		int row = board.length;
		int col = board[0].length;
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				System.out.print(board[x][y]);
			}
			System.out.println();
		}
	}
}
