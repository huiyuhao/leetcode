package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Week165 {
	public String tictactoe(int[][] moves) {
		int len = moves.length;
		if (len < 5)
			return "Pending";
		String[][] site = new String[3][3];
		int index = 0;
		while (index < 6 && index < len) {
			if (index % 2 == 0)
				site[moves[index][0]][moves[index][1]] = "X";
			else
				site[moves[index][0]][moves[index][1]] = "O";
			index++;
		}
		while (index < 9 && index < len && !getWin(site)) {
			if (index % 2 == 0)
				site[moves[index][0]][moves[index][1]] = "X";
			else
				site[moves[index][0]][moves[index][1]] = "O";
			index++;
		}
		if (index == 9 && !getWin(site))
			return "Draw";
		else if (index == len && !getWin(site))
			return "Pending";
		return index % 2 == 0 ? "B" : "A";
	}

	public boolean getWin(String[][] site) {
		String mid = site[1][1];
		String up = site[0][1];
		String down = site[2][1];
		String left = site[1][0];
		String right = site[1][2];
		String leftUp = site[0][0];
		String leftDown = site[2][0];
		String rightUp = site[0][2];
		String rightDown = site[2][2];
		if (mid != null && mid.equals(up) && mid.equals(down))
			return true;
		else if (mid != null && mid.equals(left) && mid.equals(right))
			return true;
		else if (mid != null && mid.equals(leftUp) && mid.equals(rightDown))
			return true;
		else if (mid != null && mid.equals(leftDown) && mid.equals(rightUp))
			return true;
		else if (left != null && left.equals(leftUp) && left.equals(leftDown))
			return true;
		else if (right != null && right.equals(rightUp) && right.equals(rightDown))
			return true;
		else if (up != null && up.equals(leftUp) && up.equals(rightUp))
			return true;
		else if (down != null && down.equals(leftDown) && down.equals(rightDown))
			return true;
		else
			return false;
	}

	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		List<Integer> res = new ArrayList<>();
		for (int big = 0; big <= cheeseSlices; big++) {
			int small = cheeseSlices - big;
			if (big * 4 + small * 2 == tomatoSlices) {
				res.add(big);
				res.add(small);
				break;
			}
		}
		return res;
	}

	public int countSquares(int[][] matrix) {
		int count = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (matrix[i][j] == 1 && !visited[i][j])
					count += count(matrix, visited, i, j);
		return count;
	}

	public int count(int[][] matrix, boolean[][] visited, int i, int j) {
		int len = Math.min(matrix.length - i - 1, matrix[0].length - j - 1);
		int count = 0;
		int k = 0;
		while (k <= len) {
			boolean flag = true;
			for (int r = i; r < i + k; r++)
				if (matrix[r][j + k] != 1) {
					flag = false;
					break;
				}
			if (!flag)
				break;
			for (int c = j; c < j + k; c++)
				if (matrix[i + k][c] != 1) {
					flag = false;
					break;
				}
			if (!flag)
				break;
			if (matrix[i + k][j + k] != 1)
				break;
			k++;
		}
		// s <= k + 1是正方形内所有正方形的数量（包括自身和只占一格的最小正方形）
		for (int s = 1; s <= k + 1; s++)
			count += s * s;
		for (int r = i; r <= i + k; r++)
			for (int c = 0; c <= j + k; c++)
				visited[r][c] = true;
		return count;
	}

	public static void main(String[] args) {
		Week165 week165 = new Week165();
		int[][] moves = { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 1 }, { 0, 2 }, { 2, 2 } };
		System.out.println(week165.tictactoe(moves));
	}
}
