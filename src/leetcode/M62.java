package leetcode;

public class M62 {
	/**
	 * 动态规划
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int[][] matrix = new int[m][n];
		int row = matrix.length;
		int column = matrix[0].length;
		for (int i = 0; i < row; i++) {
			matrix[i][0] = 1;
		}
		for (int j = 0; j < column; j++) {
			matrix[0][j] = 1;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				matrix[i][j] = sum(matrix, i, j);
			}
		}
		return matrix[row - 1][column - 1];
	}

	public int sum(int[][] matrix, int i, int j) {
		int res = 0;
		for (int k = 0; k <= i; k++) {
			res += matrix[k][j - 1];
		}
		return res;
	}

	/**
	 * 动态规划，在上面的基础上优化空间复杂度
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		int[] temp = new int[min];
		for (int i = 0; i < temp.length; i++)
			temp[i] = 1;
		for (int i = 1; i < max; i++)
			for (int j = min - 1; j >= 0; j--)
				temp[j] = sum(temp, j);
		return temp[min - 1];
	}

	public int sum(int[] temp, int j) {
		int res = 0;
		for (int k = 0; k <= j; k++)
			res += temp[k];
		return res;
	}

	/**
	 * 貌似不用调用函数,取当前点左侧和上方之和即可
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths3(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		int[] temp = new int[min];
		for (int i = 0; i < temp.length; i++)
			temp[i] = 1;
		for (int i = 1; i < max; i++)
			for (int j = 1; j < min; j++)
				temp[j] += temp[j - 1];
		return temp[min - 1];
	}

	public static void main(String[] args) {
		M62 m62 = new M62();
		System.out.println(m62.uniquePaths3(0, 4));
	}
}
