package leetcode;

public class H44 {
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0;
		while(j < p.length()) {
			if(p.charAt(j) == '*' || p.charAt(j) == '?')
				j++;
			else if(p.charAt(j) == s.charAt(i)) {
				i++;
				j++;
			}
			else
				i++;
		}
	}

	public void backtrack(String s, String p, int i, int j, int flag) {
		for (int k = 0; k < array.length; k++) {
			
		}
		
		if (p.charAt(j) == '*' || p.charAt(j) == '?')
			backtrack(s, p, i, j + 1, flag);
		else if (p.charAt(j) == s.charAt(i))
			backtrack(s, p, i + 1, j + 1, i);
		else if (p.charAt(j - 1) == '*')
			backtrack(s, p, i + 1, j, flag);
		else if (p.charAt(j - 1) == '?' && i - flag == 1)
			backtrack(s, p, i + 1, j, flag);
		else
			

	}
}
