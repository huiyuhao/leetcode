package leetcode;

public class M64 {
	/**
	 * 下面这个方法可以优化，在原数组上进行存储，就不用额外的空间了
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		if (row == 0 && column == 0)
			return 0;
		int[][] minSum = new int[row][column];
		minSum[0][0] = grid[0][0];
		for (int i = 1; i < row; i++)
			minSum[i][0] = minSum[i - 1][0] + grid[i][0];
		for (int j = 1; j < column; j++)
			minSum[0][j] = minSum[0][j - 1] + grid[0][j];
		for (int i = 1; i < row; i++)
			for (int j = 1; j < column; j++)
				minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
		return minSum[row - 1][column - 1];
	}
}
