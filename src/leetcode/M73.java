package leetcode;

public class M73 {
	/**
	 * ���ö���洢�ռ�
	 * ����һ�к͵�һ����Ϊ��־�����Ǳ��л��г���0�����һ�к͵�һ����Ӧλ�ñ�0��
	 * �ӵڶ��к͵ڶ��п�ʼ������0
	 * ��Ϊ��һ�к͵�һ����Ϊ��־�����Ե�һ�к͵�һ�еĸ�0�����
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		boolean x = false, y = false;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				x = true;
				break;
			}
		}
		for (int j = 0; j < col; j++) {
			if (matrix[0][j] == 0) {
				y = true;
				break;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < row; i++) {
			if (matrix[i][0] == 0) {
				setZeroRow(matrix, i);
			}
		}
		for (int j = 1; j < col; j++) {
			if (matrix[0][j] == 0) {
				setZeroCol(matrix, j);
			}
		}
		if (x)
			setZeroCol(matrix, 0);
		if (y)
			setZeroRow(matrix, 0);
	}

	public void setZeroRow(int[][] matrix, int x) {
		int col = matrix[0].length;
		for (int i = 0; i < col; i++) {
			matrix[x][i] = 0;
		}
	}

	public void setZeroCol(int[][] matrix, int y) {
		int row = matrix.length;
		for (int i = 0; i < row; i++) {
			matrix[i][y] = 0;
		}
	}

	public static void main(String[] args) {
		M73 m73 = new M73();
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		m73.setZeroes(matrix);
	}
}
