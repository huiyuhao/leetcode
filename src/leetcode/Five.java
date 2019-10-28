package leetcode;

public class Five {
	public static String longestPalindrome(String s) {
		int len = s.length();
		String mostLong = null;
		int howLong = 0;
		if (len == 0 || len == 1) {
			mostLong = s;
		}
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				String str = String.valueOf(s.charAt(i));
				str += s.charAt(i + 1);
				StringBuilder sb = new StringBuilder(str);
				if (str.length() >= howLong) {
					howLong = str.length();
					mostLong = str;
				}
				for (int j = 1; j <= len / 2 && i + j + 1 < len && i - j >= 0; j++) {
					if (s.charAt(i - j) != s.charAt(i + j + 1)) {
						break;
					}
					sb.insert(0, s.charAt(i - j)).toString();
					sb.append(s.charAt(i + j + 1));
					str = sb.toString();
					if (str.length() > howLong) {
						howLong = str.length();
						mostLong = str;
					}
				}
			}
			String str = String.valueOf(s.charAt(i));
			StringBuilder sb = new StringBuilder(str);
			if (str.length() >= howLong) {
				howLong = str.length();
				mostLong = str;
			}
			for (int j = 1; j <= len / 2 && i + j < len && i - j >= 0; j++) {
				if (s.charAt(i - j) != s.charAt(i + j)) {
					break;
				}
				sb.insert(0, s.charAt(i - j)).toString();
				sb.append(s.charAt(i + j));
				str = sb.toString();
				if (str.length() > howLong) {
					howLong = str.length();
					mostLong = str;
				}
			}
		}
		return mostLong;
	}

	public static String longestPalindrome2(String s) {
		int len = s.length();
		String mostLong = null;
		int howLong = 0;
		int thisLen = 0;
		if (len == 0 || len == 1) {
			mostLong = s;
		}
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				String str = String.valueOf(s.charAt(i));
				str += s.charAt(i + 1);
				if (str.length() >= howLong) {
					howLong = str.length();
					mostLong = str;
				}
				for (int j = 1; j <= len / 2 && i + j + 1 < len && i - j >= 0; j++) {
					if (s.charAt(i - j) != s.charAt(i + j + 1)) {
						break;
					}
					thisLen = 2 * j + 2;
					if (thisLen > howLong) {
						howLong = thisLen;
						str = s.substring(i - j, i + j + 2);
						mostLong = str;
					}
				}
			}
			String str = String.valueOf(s.charAt(i));
			if (str.length() >= howLong) {
				howLong = str.length();
				mostLong = str;
			}
			for (int j = 1; j <= len / 2 && i + j < len && i - j >= 0; j++) {
				if (s.charAt(i - j) != s.charAt(i + j)) {
					break;
				}
				thisLen = 2 * j + 1;
				if (thisLen > howLong) {
					howLong = thisLen;
					str = s.substring(i - j, i + j + 1);
					mostLong = str;
				}
			}
		}
		return mostLong;
	}
	
	public static String longestPalindrome3(String s) {
		if(s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len -1) / 2;
				end = i + len / 2;
			}	
		}
		return s.substring(start, end + 1);
	}
	
	private static int expandAroundCenter(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left + 1;
	}
	
	public static void main(String[] args) {
		String s = "cc";
		String mostLong = longestPalindrome2(s);
		System.out.println(mostLong);
	}
}
