package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Six {
	public static String convert(String s, int numRows) {
		if (numRows == 0 || numRows == 1)
			return s;
		char[][] z = new char[numRows][s.length()/2+1];
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[i].length; j++) {
				z[i][j] = '0';
			}
		}
		int x = 0, y = 0, k = 0;
		String result = "";
		while(k < s.length()) {
			z[y][x] = s.charAt(k);
			k++;
			if ((k - 1) % (numRows - 1) == 0 && ((k - 1) / (numRows - 1)) % 2 == 1 && k != 1 && k < s.length()) {
				y--;
				x++;
				while (k % (numRows - 1) != 0 && k < s.length()) {
					z[y][x] = s.charAt(k);
					k++;
					y--;
					x++;
				}
			} else {
				y++;
			}
		}
		
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z[i].length; j++) {
				if(z[i][j] != '0') 
					result += z[i][j];
			}
		}
		result.replace(" ", "");
		return result;
	}
	
	public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
	
	public static void main(String[] args) {
		String s = "ABCDE";
		int numRows = 4;
		String result = convert2(s, numRows);
		System.out.println(result);
	}
}
