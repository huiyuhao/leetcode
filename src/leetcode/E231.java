package leetcode;

public class E231 {
	public boolean isPowerOfTwo(int n) {
		if (n == 1)
			return true;
		while (n != 0) {
			if (n == 2)
				return true;
			if (n % 2 != 0)
				return false;
			n /= 2;
		}
		return false;
	}

	/**
	 * 二进制下，2的幂只会有一位是‘1’。
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo2(int n) {
		if (n == Integer.MIN_VALUE)
			return false;
		String str = Integer.toBinaryString(n);
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				flag++;
			if (flag == 2)
				return false;
		}
		return flag == 1 ? true : false;
	}
	
	/**
	 * 大神的位运算
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo3(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
}
