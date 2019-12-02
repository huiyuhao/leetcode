package leetcode;

public class M1277 {
	public int countSquares(int[][] matrix) {
		int count = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (matrix[i][j] == 1 && !visited[i][j])
					count += count(matrix, visited, i, j);
		return count;
	}

	/**
	 * 考虑用递归做（改一下）
	 * @param matrix
	 * @param visited
	 * @param i
	 * @param j
	 * @return
	 */
	public int count(int[][] matrix, boolean[][] visited, int i, int j) {
		int len = Math.min(matrix.length - i - 1, matrix[0].length - j - 1);
		int count = 0;
		int k = 0;
		while (k <= len) {
			boolean flag = true;
			for (int r = i; r <= i + k; r++)
				if (matrix[r][j + k] != 1) {
					flag = false;
					break;
				}
			if (!flag)
				break;
			for (int c = j; c <= j + k; c++)
				if (matrix[i + k][c] != 1) {
					flag = false;
					break;
				}
			if (!flag)
				break;
			k++;
		}
		k--;
		// s <= k + 1是正方形内所有正方形的数量（包括自身和只占一格的最小正方形）
		for (int s = 1; s <= k + 1; s++)
			count += s * s;
		for (int r = i; r <= i + k; r++)
			for (int c = j; c <= j + k; c++)
				visited[r][c] = true;
		return count;
	}

	public static void main(String[] args) {
		M1277 m1277 = new M1277();
		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 1, 0, 1, 1 }, { 1, 0, 0, 1, 1 } };
		System.out.println(m1277.countSquares(matrix));

	}
}
