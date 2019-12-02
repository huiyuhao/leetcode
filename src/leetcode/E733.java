package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class E733 {
	/**
	 * 用队列
	 * 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int row = image.length;
		if (row == 0)
			return image;
		int col = image[0].length;
		int oldColor = image[sr][sc];
		if (oldColor == newColor)
			return image;
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] { sr, sc });
		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			image[r][c] = newColor;
			if (r >= 1 && image[r - 1][c] == oldColor)
				queue.add(new Integer[] { r - 1, c });
			if (r < row - 1 && image[r + 1][c] == oldColor)
				queue.add(new Integer[] { r + 1, c });
			if (c >= 1 && image[r][c - 1] == oldColor)
				queue.add(new Integer[] { r, c - 1 });
			if (c < col - 1 && image[r][c + 1] == oldColor)
				queue.add(new Integer[] { r, c + 1 });

		}
		return image;
	}

	/**
	 * 用递归
	 * 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
		int row = image.length;
		if (row == 0)
			return image;
		int col = image[0].length;
		int oldColor = image[sr][sc];
		if (oldColor == newColor)
			return image;
		return helper(image, sr, sc, newColor, image[sr][sc], row, col);
	}

	public int[][] helper(int[][] image, int r, int c, int newColor, int oldColor, int row, int col) {
		image[r][c] = newColor;
		if (r >= 1 && image[r - 1][c] == oldColor)
			image = helper(image, r - 1, c, newColor, oldColor, row, col);
		if (r < row - 1 && image[r + 1][c] == oldColor)
			image = helper(image, r + 1, c, newColor, oldColor, row, col);
		if (c >= 1 && image[r][c - 1] == oldColor)
			image = helper(image, r, c - 1, newColor, oldColor, row, col);
		if (c < col - 1 && image[r][c + 1] == oldColor)
			image = helper(image, r, c + 1, newColor, oldColor, row, col);
		return image;
	}

	public static void main(String[] args) {
		E733 e733 = new E733();
		int[][] image = {};
		System.out.println(e733.floodFill(image, 1, 1, 2));
	}
}
