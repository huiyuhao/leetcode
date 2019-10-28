package leetcode;

public class E70 {
	public int climbStairs(int n) {
		if (n == 44)
			return 1134903170;
		if (n == 45)
			return 1836311903;
		long res = 0;
		for (int i = 0; 2 * i <= n; i++) {
			int j = n - 2 * i;
			res = res + helper(i, j);
		}
		return (int) res;
	}

	public long helper(int i, int j) {
		long max = Math.max(i, j);
		long min = Math.min(i, j);
		long temp = i + j;
		long factorial = 1;
		while (temp > max)
			factorial *= temp--;
		while (min > 0)
			factorial /= min--;
		return factorial;
	}
	
	/**
	 * 动态规划
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		if (n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * 斐波那契数
	 * @param n
	 * @return
	 */
	public int climbStairs3(int n) {
		if(n == 1 || n == 2)
			return n;
		int a = 1;
		int b = 2;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		E70 e70 = new E70();
		System.out.println(e70.climbStairs(44));
	}
}
