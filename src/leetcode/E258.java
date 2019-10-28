package leetcode;

public class E258 {
	public int addDigits(int num) {
		return helper(num);
	}

	public int helper(int num) {
		int res = 0;
		while (num != 0) {
			res += num % 10;
			num /= 10;
		}
		if (res / 10 != 0)
			return helper(res);
		return res;
	}

	/**
	 * 大神解法
	 * 
	 * @param num
	 * @return
	 */
	public int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}

	public static void main(String[] args) {
		E258 e258 = new E258();
		System.out.println(e258.addDigits(38));
	}
}
