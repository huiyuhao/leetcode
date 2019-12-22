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

	/**
	 * 看了题解，真的好
	 * @param matrix
	 * @return
	 */
	public int countSquares(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int sum = 0;
		int[][] temp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = matrix[i][j];
				else if (matrix[i][j] == 0)
					temp[i][j] = 0;
				else
					temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
				sum += temp[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Week165 week165 = new Week165();
		int[][] moves = { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 1 }, { 0, 2 }, { 2, 2 } };
		System.out.println(week165.tictactoe(moves));
	}
}
