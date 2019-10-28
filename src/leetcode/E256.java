package leetcode;

public class E256 {
	public int minCost(int[][] costs) {
		if (costs.length == 0)
			return 0;
		int[] sum = new int[3];
		for (int i = 0; i < 3; i++)
			sum[i] = costs[0][i];
		for (int i = 1; i < costs.length; i++) {
			int temp0 = sum[0];
			int temp1 = sum[1];
			sum[0] = costs[i][0] + Math.min(sum[1], sum[2]);
			sum[1] = costs[i][1] + Math.min(temp0, sum[2]);
			sum[2] = costs[i][2] + Math.min(temp0, temp1);
		}
		return Math.min(Math.min(sum[0], sum[1]), sum[2]);
	}

	public static void main(String[] args) {
		E256 e256 = new E256();
		int[][] costs = { { 3, 5, 3 }, { 6, 17, 6 }, { 7, 13, 18 }, { 9, 10, 18 } };
		System.out.println(e256.minCost(costs));
	}
}
