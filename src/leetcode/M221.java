package leetcode;

public class M221 {
	/**
	 * 动态规划
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int bigLen = 0;
		int[][] temp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = matrix[i][j] - '0';
				else if (matrix[i][j] == '0')
					temp[i][j] = 0;
				else
					temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
				if (temp[i][j] > bigLen)
					bigLen = temp[i][j];
			}
		}
		return bigLen * bigLen;
	}

	/**
	 * 动态规划，常规的空间优化
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalSquare2(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int bigLen = 0;
		int[] dp = new int[col];
		int pre = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int temp = dp[j];
				if (i == 0 || j == 0)
					dp[j] = matrix[i][j] - '0';
				else if (matrix[i][j] == '0')
					dp[j] = 0;
				else
					dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), pre) + 1;
				if (dp[j] > bigLen)
					bigLen = dp[j];
				pre = temp;
			}
		}
		return bigLen * bigLen;
	}

	public static void main(String[] args) {
		M221 m221 = new M221();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(m221.maximalSquare2(matrix));
	}
}
