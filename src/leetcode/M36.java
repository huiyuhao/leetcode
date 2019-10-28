package leetcode;

import java.util.HashSet;
import java.util.Set;

public class M36 {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (set.contains(board[i][j]))
					return false;
				else
					set.add(board[i][j]);
			}
			set.clear();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[j][i] == '.')
					continue;
				if (set.contains(board[j][i]))
					return false;
				else
					set.add(board[j][i]);
			}
			set.clear();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = i * 3; k < i * 3 + 3; k++) {
					for (int l = j * 3; l < j * 3 + 3; l++) {
						if (board[k][l] == '.')
							continue;
						if (set.contains(board[k][l]))
							return false;
						else
							set.add(board[k][l]);
					}
				}
				set.clear();
			}
		}
		return true;
	}
}
