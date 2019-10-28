package leetcode;

public class M48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size - 1; i++) {
			for (int j = i; j < size - 1 - i; j++) {
				helper(matrix, i, j, size - 1);
			}
		}
    }
    
    public void helper(int[][] matrix, int row, int column, int size) {
    	int temp1 = matrix[column][size - row];
    	matrix[column][size - row] = matrix[row][column];
    	int temp2 = matrix[size - row][size - column];
    	matrix[size - row][size - column] = temp1;
    	temp1 = matrix[size - column][row];
    	matrix[size - column][row] = temp2;
    	matrix[row][column] = temp1;
    }
}
