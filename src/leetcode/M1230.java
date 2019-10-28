package leetcode;

public class M1230 {
	public double probabilityOfHeads(double[] prob, int target) {
		int len = prob.length;
		double[][] matrix = new double[len][target + 1];
		matrix[0][0] = 1 - prob[0];
		if (target > 0)
			matrix[0][1] = prob[0];
		for (int i = 1; i < len; i++) {
			matrix[i][0] = matrix[i - 1][0] * (1 - prob[i]);
			for (int j = 1; j < target + 1; j++)
				matrix[i][j] = matrix[i - 1][j - 1] * prob[i] + matrix[i - 1][j] * (1 - prob[i]);
		}
		return matrix[len - 1][target];
	}

	public static void main(String[] args) {
		M1230 m1230 = new M1230();
		double[] prob = { 0.5, 0.5, 0.5, 0.5, 0.5 };
		System.out.println(m1230.probabilityOfHeads(prob, 0));
	}
}
