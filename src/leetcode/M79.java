package leetcode;

public class M79 {
	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int columns = board[0].length;
		boolean[][] used = new boolean[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (backtrack(board, word, i, j, 0, used))
					return true;
		return false;
	}

	public boolean backtrack(char[][] board, String word, int x, int y, int index, boolean[][] used) {
		char cur = word.charAt(index);
		if (index >= word.length() - 1 && board[x][y] == cur)
			return true;
		if (board[x][y] != cur)
			return false;
		int rows = board.length;
		int columns = board[0].length;
		used[x][y] = true;
		if (x > 0 && !used[x - 1][y])
			if (backtrack(board, word, x - 1, y, index + 1, used))
				return true;
		if (y < columns - 1 && !used[x][y + 1])
			if (backtrack(board, word, x, y + 1, index + 1, used))
				return true;
		if (x < rows - 1 && !used[x + 1][y])
			if (backtrack(board, word, x + 1, y, index + 1, used))
				return true;
		if (y > 0 && !used[x][y - 1])
			if (backtrack(board, word, x, y - 1, index + 1, used))
				return true;
		used[x][y] = false;
		return false;
	}

	public static void main(String[] args) {
		M79 m79 = new M79();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCB";
		if (m79.exist(board, word))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
