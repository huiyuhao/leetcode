package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		// 用state = 0,1,2,3来表示将要向下拐，向左，向上，向右四个状态，起始是0，将要向下
		int state = 0;
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		// row表示横行数量，column表示竖列数量
		int row = matrix.length;
		int column = matrix[0].length;
		// 以下这四个变量是防止越界的
		int rowFlagBegin = 0, columnFlagBegin = 0;
		int rowFlagEnd = row - 1, columnFlagEnd = column - 1;
		int i = 0;
		int x = 0, y = 0;
		while (i < row * column) {
			res.add(matrix[x][y]);
			if (state == 0)
				if (y == columnFlagEnd) {
					x++;
					state = 1;
					rowFlagBegin++;
				} else
					y++;
			else if (state == 1)
				if (x == rowFlagEnd) {
					y--;
					state = 2;
					columnFlagEnd--;
				} else
					x++;
			else if (state == 2)
				if (y == columnFlagBegin) {
					x--;
					state = 3;
					rowFlagEnd--;
				} else
					y--;
			else if (state == 3)
				if (x == rowFlagBegin) {
					y++;
					state = 0;
					columnFlagBegin++;
				} else
					x--;
			i++;
		}
		return res;
	}

	/**
	 * 把上面的if列举换成了swith,看起来更清楚一些
	 * 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder2(int[][] matrix) {
		// 用state = 0,1,2,3来表示将要向下拐，向左，向上，向右四个状态，起始是0，将要向下
		int state = 0;
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		// row表示横行数量，column表示竖列数量
		int row = matrix.length;
		int column = matrix[0].length;
		// 以下这四个变量是防止越界的
		int rowFlagBegin = 0, columnFlagBegin = 0;
		int rowFlagEnd = row - 1, columnFlagEnd = column - 1;
		int i = 0;
		int x = 0, y = 0;
		while (i < row * column) {
			res.add(matrix[x][y]);
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
		return res;
	}
}
