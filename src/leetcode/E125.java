package leetcode;

public class E125 {

	/*
	 * 设置左、右双指针，向中间判断； 跳过非数字字母的字符； 将字母全部转化为小写体，之后判断。
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return true;
		for (int i = 0, j = s.length() - 1; i <= j;) {
			char p = s.charAt(i);
			char q = s.charAt(j);
			// p不为数字或字符时i往后找到第一个符合条件
			if (!(p >= '0' && p <= '9' || p >= 'a' && p <= 'z' || p >= 'A' && p <= 'Z')) {
				i++;
				continue;
			}
			// p不为数字或字符时i往前找到第一个符合条件
			if (!(q >= '0' && q <= '9' || q >= 'a' && q <= 'z' || q >= 'A' && q <= 'Z')) {
				j--;
				continue;
			}
			// 当pq所指字符为数字和字母时才比较，如果字符或数字不相等立刻返回false
			// 内层p==q || (p-q==32||q-p==32&&(p>=65&&q>=65))判断的是否为数字或字符（不考虑大小写）且相等
			if (!(p == q || (p - q == 32 || q - p == 32 && (p >= 65 && q >= 65)))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

}
