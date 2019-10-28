package leetcode;

public class E69 {
	public int mySqrt(int x) {
		return (int) Math.sqrt(x);
	}

	public int mySqrt2(int x) {
		long result = helper(0, x, x);
		return (int) result;
	}

	public long helper(long begin, long end, int x) {
		if (end < begin)
			return end;
		long mid = (begin + end) / 2;
		long temp = mid * mid;
		if (temp > x)
			return helper(begin, mid - 1, x);
		if (temp < x)
			return helper(mid + 1, end, x);
		return mid;
	}

	/**
	 * 牛顿迭代法
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt3(int a) {
		long x = a;
		while (x * x > a)
//			x = x / 2 + a / 2 / x;   这个是不行的，有一点误差
			x = (x + a / x) / 2;
		return (int) x;
	}

}
