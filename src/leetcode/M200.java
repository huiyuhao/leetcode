package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class M200 {
	/**
	 * BFS 莫名的比DFS慢，但是时间复杂度是一样的
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int row = grid.length;
		if (row == 0)
			return 0;
		int col = grid[0].length;
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		int lands = 0;
		// 1走过后变2
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				while (!queue.isEmpty()) {
					Integer[] cur = queue.poll();
					int x = cur[0];
					int y = cur[1];
					// 向上
					if (y > 0 && grid[x][y - 1] == '1') {
						grid[x][y - 1] = 2;
						queue.add(new Integer[] { x, y - 1 });
					}
					// 向下
					if (y < col - 1 && grid[x][y + 1] == '1') {
						grid[x][y + 1] = 2;
						queue.add(new Integer[] { x, y + 1 });
					}
					// 向左
					if (x > 0 && grid[x - 1][y] == '1') {
						grid[x - 1][y] = 2;
						queue.add(new Integer[] { x - 1, y });
					}
					// 向右
					if (x < row - 1 && grid[x + 1][y] == '1') {
						grid[x + 1][y] = 2;
						queue.add(new Integer[] { x + 1, y });
					}
				}
				if (grid[i][j] == '1') {
					queue.add(new Integer[] { i, j });
					lands++;
				}
			}
		}
		return lands;
	}

	/**
	 * 做了一点微小的修改，但是毫无卵用
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands2(char[][] grid) {
		int row = grid.length;
		if (row == 0)
			return 0;
		int col = grid[0].length;
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		int lands = 0;
		// 1走过后变2
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					queue.add(new Integer[] { i, j });
					lands++;
					while (!queue.isEmpty()) {
						Integer[] cur = queue.poll();
						int x = cur[0];
						int y = cur[1];
						// 向上
						if (y > 0 && grid[x][y - 1] == '1') {
							grid[x][y - 1] = 2;
							queue.add(new Integer[] { x, y - 1 });
						}
						// 向下
						if (y < col - 1 && grid[x][y + 1] == '1') {
							grid[x][y + 1] = 2;
							queue.add(new Integer[] { x, y + 1 });
						}
						// 向左
						if (x > 0 && grid[x - 1][y] == '1') {
							grid[x - 1][y] = 2;
							queue.add(new Integer[] { x - 1, y });
						}
						// 向右
						if (x < row - 1 && grid[x + 1][y] == '1') {
							grid[x + 1][y] = 2;
							queue.add(new Integer[] { x + 1, y });
						}
					}
				}
			}
		}
		return lands;
	}

	/**
	 * DFS
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands3(char[][] grid) {
		int row = grid.length;
		if (row == 0)
			return 0;
		int col = grid[0].length;
		int lands = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					lands++;
					helper(grid, i, j);
				}
			}
		}
		return lands;
	}

	public void helper(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		helper(grid, i - 1, j);
		helper(grid, i + 1, j);
		helper(grid, i, j - 1);
		helper(grid, i, j + 1);
	}



	/**
	 * 并查集，真尼玛晕，这里面parent[]存的是每个节点的父节点，rank[]存的是父节点的深度。
	 * @author yanghao
	 *
	 */
	class UnionFind {
		int count; // # of connected components
		int[] parent;
		int[] rank;

		public UnionFind(char[][] grid) { // for problem 200
			count = 0;
			int m = grid.length;
			int n = grid[0].length;
			parent = new int[m * n];
			rank = new int[m * n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (grid[i][j] == '1') {
						parent[i * n + j] = i * n + j;
						++count;
					}
					rank[i * n + j] = 0;
				}
			}
		}

		public int find(int i) { // path compression
			if (parent[i] != i)
				parent[i] = find(parent[i]);
			return parent[i];
		}

		public void union(int x, int y) { // union with rank
			int rootx = find(x);
			int rooty = find(y);
			if (rootx != rooty) {
				if (rank[rootx] > rank[rooty]) {
					parent[rooty] = rootx;
				} else if (rank[rootx] < rank[rooty]) {
					parent[rootx] = rooty;
				} else {
					parent[rooty] = rootx;
					rank[rootx] += 1;
				}
				--count;
			}
		}

		public int getCount() {
			return count;
		}
	}
	public int numIslands5(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		UnionFind uf = new UnionFind(grid);
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					grid[r][c] = '0';
					if (r - 1 >= 0 && grid[r - 1][c] == '1') {
						uf.union(r * nc + c, (r - 1) * nc + c);
					}
					if (r + 1 < nr && grid[r + 1][c] == '1') {
						uf.union(r * nc + c, (r + 1) * nc + c);
					}
					if (c - 1 >= 0 && grid[r][c - 1] == '1') {
						uf.union(r * nc + c, r * nc + c - 1);
					}
					if (c + 1 < nc && grid[r][c + 1] == '1') {
						uf.union(r * nc + c, r * nc + c + 1);
					}
				}
			}
		}
		return uf.getCount();
	}

	public static void main(String[] args) {
		M200 m200 = new M200();
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '0', '0' }, { '1', '0', '1' } };
		System.out.println(m200.numIslands5(grid));
	}

}
