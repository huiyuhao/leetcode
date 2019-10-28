package leetcode;

public class M74 {
	/**
	 * �о���΢������Щ ִ����ʱ :1 ms, ������ Java �ύ�л�����98.11%���û� �ڴ����� :39.4 MB, ������ Java
	 * �ύ�л�����83.30%���û�
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return false;
		int row = matrix.length;
		int column = matrix[0].length;
		for (int i = 0; i < row - 1; i++) {
			if (matrix[i][0] <= target && target < matrix[i + 1][0]) {
				for (int j = 0; j < column; j++) {
					if (matrix[i][j] == target)
						return true;
				}
			}
		}
		if (target <= matrix[row - 1][column - 1]) {
			for (int j = 0; j < column; j++) {
				if (matrix[row - 1][j] == target)
					return true;
			}
		}
		return false;
	}

	/**
	 * �ö��ֲ���
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return false;
		int row = matrix.length;
		int column = matrix[0].length;
		int left = 0, right = row * column - 1;
		int tr = 0, tc = 0, mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			tr = mid / column;
			tc = mid % column;
			if (matrix[tr][tc] > target)
				right = mid - 1;
			else if (matrix[tr][tc] < target)
				left = mid + 1;
			else
				return true;
		}
		return false;
	}

	/**
	 * powcai�Ķ��ֲ��ң��߽�ֵ����ĺܺ�
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix3(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = row * col;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (matrix[mid / col][mid % col] < target)
				left = mid + 1;
			else
				right = mid;
		}
		return (left < row * col && matrix[left / col][left % col] == target);
	}

	/**
	 * һ������Ľⷨ�������׶�������û��֮ǰ���ַ����죬Ҫ��ʱ2ms
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix4(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target == matrix[row][col])
				return true;
			else if (target > matrix[row][col])
				row++;
			else
				col--;
		}
		return false;
	}
}
