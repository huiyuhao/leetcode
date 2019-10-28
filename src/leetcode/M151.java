package leetcode;

public class M151 {
	/**
	 * 循环用太多了800ms
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		int left = 0, right = 0;
		char[] ca = s.toCharArray();
		for (int i = 1; i < ca.length; i++) {
			if (ca[i] == ' ' && ca[i - 1] != ' ') {
				right = i - 1;
				helper(ca, left, right);
				left = i;
			}
			if (ca[i] == ' ')
				left++;
		}
		for (int i = ca.length - 1; i >= 0; i--) {
			if (ca[i] == ' ')
				continue;
			right = i;
			helper(ca, left, right);
			break;
		}
		helper(ca, 0, ca.length - 1);
		String res = "";
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] == ' ' && (i == 0 || ca[i - 1] == ' '))
				continue;
			res += ca[i];
		}
		int index = res.length();
		for (int i = res.length() - 1; i >= 0; i--) {
			if (res.charAt(i) == ' ')
				index--;
			else
				break;
		}
		return res.substring(0, index);
	}

	public String reverseWords2(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.trim();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i < s.length() - 1 && s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
				j--;
				continue;
			}
			if (s.charAt(i) == ' ') {
				sb.append(s.substring(i + 1, j));
				sb.append(' ');
				j = i;
			}
		}
		sb.append(s.substring(0, j));
		return sb.toString();
	}

	public void helper(char[] ca, int left, int right) {
		while (left < right) {
			char temp = ca[left];
			ca[left] = ca[right];
			ca[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		M151 m151 = new M151();
		System.out.println(m151.reverseWords2("a good   example"));
	}
}
