package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class M286 {
	public void wallsAndGates(int[][] rooms) {
		int row = rooms.length;
		if (row == 0)
			return;
		int col = rooms[0].length;
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (rooms[i][j] == 0)
					queue.add(new Integer[] { i, j });
		while (!queue.isEmpty()) {
			Integer[] site = queue.poll();
			int i = site[0];
			int j = site[1];
			int num = rooms[i][j];
			// 向左
			if (j > 0 && rooms[i][j - 1] == 2147483647) {
				rooms[i][j - 1] = num + 1;
				queue.add(new Integer[] { i, j - 1 });
			}
			// 向右
			if (j < col - 1 && rooms[i][j + 1] == 2147483647) {
				rooms[i][j + 1] = num + 1;
				queue.add(new Integer[] { i, j + 1 });
			}
			// 向上
			if (i > 0 && rooms[i - 1][j] == 2147483647) {
				rooms[i - 1][j] = num + 1;
				queue.add(new Integer[] { i - 1, j });
			}
			// 向下
			if (i < row - 1 && rooms[i + 1][j] == 2147483647) {
				rooms[i + 1][j] = num + 1;
				queue.add(new Integer[] { i + 1, j });
			}
		}
	}
}
