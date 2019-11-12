package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class M279 {
	public int numSquares(int n) {
		int[] num = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			num[i] = i;
			for (int j = 1; i - j * j >= 0; j++)
				num[i] = Math.min(num[i], num[i - j * j] + 1);
		}
		return num[n];
	}

	/**
	 * 连通图，用队列
	 * 
	 * @param n
	 * @return
	 */
	public int numSquares2(int n) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
		queue.add(new Pair<Integer, Integer>(n, 0));
		boolean[] visited = new boolean[n + 1];
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.poll();
			int num = pair.getKey();
			int deep = pair.getValue();
			for (int i = 1; i * i <= num; i++) {
				if (i * i == num)
					return deep + 1;
				else if (!visited[num - i * i]) {
					queue.add(new Pair<Integer, Integer>(num - i * i, deep + 1));
					visited[num - i * i] = true;
				}
			}
		}
		return n;
	}
}
