package leetcode;

public class E58 {
	public int lengthOfLastWord(String s) {
		int num = 0, len = s.length();
		while (len > 1 && s.charAt(len - 1) == ' ')
			len--;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ')
				return num;
			else
				num++;
		}
		return num;
	}
	
	public int lengthOfLastWord2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		String[] word = s.trim().split(" ");
		return word[word.length -1].length();
	}
}
