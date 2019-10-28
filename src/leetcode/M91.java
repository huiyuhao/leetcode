package leetcode;

public class M91 {
	/**
	 * 判断条件真乱，优化一下吧
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 1 && s.charAt(0) != '0')
			return 1;
		if (s.charAt(0) == '0' || s.charAt(0) > '0' + 2 && s.charAt(1) == '0')
			return 0;
		int[] count = new int[len];
		count[0] = 1;
		if (s.charAt(0) == '0' + 1 && s.charAt(1) > '0'
				|| s.charAt(0) == '0' + 2 && s.charAt(1) <= '0' + 6 && s.charAt(1) > '0')
			count[1] = 2;
		else
			count[1] = 1;
		for (int i = 2; i < len; i++) {
			if (s.charAt(i) == '0' && (s.charAt(i - 1) > '0' + 2 || s.charAt(i - 1) == '0'))
				return 0;
			else if (s.charAt(i) == '0')
				count[i] = count[i - 2];
			else if (s.charAt(i - 1) == '0' + 1 && s.charAt(i) > '0'
					|| s.charAt(i - 1) == '2' && s.charAt(i) <= '0' + 6)
				count[i] = count[i - 1] + count[i - 2];
			else
				count[i] = count[i - 1];
		}
		return count[len - 1];
	}

	public static void main(String[] args) {
		M91 m91 = new M91();
		System.out.println(m91.numDecodings("170"));
	}
}
