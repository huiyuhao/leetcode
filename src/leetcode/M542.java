package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class M542 {
	/**
	 * 广度优先
	 * 
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0)
					queue.add(new Integer[] { i, j });
				if (matrix[i][j] == 1)
					matrix[i][j] = 200;
			}
		}
		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int curLen = matrix[r][c];
			if (r >= 1 && matrix[r - 1][c] > curLen) {
				matrix[r - 1][c] = curLen + 1;
				queue.add(new Integer[] { r - 1, c });
			}
			if (r < row - 1 && matrix[r + 1][c] > curLen) {
				matrix[r + 1][c] = curLen + 1;
				queue.add(new Integer[] { r + 1, c });
			}
			if (c >= 1 && matrix[r][c - 1] > curLen) {
				matrix[r][c - 1] = curLen + 1;
				queue.add(new Integer[] { r, c - 1 });
			}
			if (c < col - 1 && matrix[r][c + 1] > curLen) {
				matrix[r][c + 1] = curLen + 1;
				queue.add(new Integer[] { r, c + 1 });
			}
		}
		return matrix;
	}

	/**
	 * 动态规划
	 * 
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix2(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return new int[0][0];
		int col = matrix[0].length;
		int[][] dist = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				dist[i][j] = 200;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (matrix[i][j] == 0)
					dist[i][j] = 0;
				else {
					if (i > 0)
						dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
					if (j > 0)
						dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
				}
		for (int i = row - 1; i >= 0; i--)
			for (int j = col - 1; j >= 0; j--) {
				if (i < row - 1)
					dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
				if (j < col - 1)
					dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
			}
		return dist;
	}
}
