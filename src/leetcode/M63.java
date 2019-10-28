package leetcode;

public class M63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		if (row != 0 && column != 0 && obstacleGrid[0][0] == 0)
			obstacleGrid[0][0] = 1;
		else
			return 0;
		for (int i = 1; i < row; i++) {
			if (obstacleGrid[i][0] != 1)
				obstacleGrid[i][0] = obstacleGrid[i - 1][0];
			else
				obstacleGrid[i][0] = 0;
		}
		for (int i = 1; i < column; i++) {
			if (obstacleGrid[0][i] != 1)
				obstacleGrid[0][i] = obstacleGrid[0][i - 1];
			else
				obstacleGrid[0][i] = 0;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (obstacleGrid[i][j] == 1)
					obstacleGrid[i][j] = 0;
				else
					obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
			}
		}
		return obstacleGrid[row - 1][column - 1];
	}

	public static void main(String[] args) {
		M63 m63 = new M63();
		int[][] obstacleGrid = { { 1,0 } };
		System.out.println(m63.uniquePathsWithObstacles(obstacleGrid));
	}
}
