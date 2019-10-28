package leetcode;

public class M186 {
	/**
	 * ������С���ȷ�ת���ٶԴ�ķ�ת
	 * 
	 * @param s
	 */
	public void reverseWords(char[] s) {
		int left = 0, right = 0;
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) {
				right = i;
				while (left < right) {
					char temp = s[left];
					s[left] = s[right];
					s[right] = temp;
					left++;
					right--;
				}
				left = i + 1;
			}
			if (s[i] == ' ') {
				right = i - 1;
				while (left < right) {
					char temp = s[left];
					s[left] = s[right];
					s[right] = temp;
					left++;
					right--;
				}
				left = i + 1;
			}
		}
		left = 0;
		right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

	/**
	 * ��дһ��
	 * 
	 * @param s
	 */
	public void reverseWords2(char[] s) {
		int left = 0, right = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				right = i - 1;
				helper(s, left, right);
				left = i + 1;
			}
		}
		helper(s, left, s.length - 1);
		left = 0;
		right = s.length - 1;
		helper(s, left, right);
	}

	public void helper(char[] s, int left, int right) {
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {

	}

}
