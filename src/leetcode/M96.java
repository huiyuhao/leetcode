package leetcode;

public class M96 {
	// 这个会超时，因为重复计算的东西没有记录下来
	public int numTrees(int n) {
		int res = 0;
		if (n == 0 || n == 1)
			return 1;
		for (int i = 1; i <= n; i++) {
			res += numTrees(i - 1) * numTrees(n - i);
		}
		return res;
	}

	// 动态规划，把计算出来的记录下来，以后还会复用
	public int numTrees2(int n) {
		int[] G = new int[n + 1];
		G[0] = 1;
		G[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}

	// 卡塔兰数(数学公式)
	public int numTrees3(int n) {
		long res = 1;
		for (int i = 0; i < n; i++) {
			res = res * 2 * (2 * i + 1) / (i + 2);
		}
		return (int) res;
	}
}
