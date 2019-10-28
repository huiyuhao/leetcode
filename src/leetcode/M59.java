package leetcode;

public class M59 {
	public int[][] generateMatrix(int n) {
		int i = 0, state = 0, x = 0, y = 0;
		int rowFlagBegin = 0, columnFlagBegin = 0;
		int rowFlagEnd = n - 1, columnFlagEnd = n - 1;
		int[][] matrix = new int[n][n];
		while (i < n * n) {
			matrix[x][y] = i + 1;
			switch (state) {
			case 0:
				if (y == columnFlagEnd) {
					x++;
					state = 1;
					rowFlagBegin++;
				} else
					y++;
				break;
			case 1:
				if (x == rowFlagEnd) {
					y--;
					state = 2;
					columnFlagEnd--;
				} else
					x++;
				break;
			case 2:
				if (y == columnFlagBegin) {
					x--;
					state = 3;
					rowFlagEnd--;
				} else
					y--;
				break;
			case 3:
				if (x == rowFlagBegin) {
					y++;
					state = 0;
					columnFlagBegin++;
				} else
					x--;
				break;
			}
			i++;
		}
		return matrix;
	}
}
