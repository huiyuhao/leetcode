package leetcode;

public class M29 {
	/**
	 * 用减法，超时了
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		int res = 0;
		if (dividend >= 0 && divisor > 0) {
			while (dividend >= divisor) {
				dividend -= divisor;
				res++;
			}
			return res;
		} else if (dividend < 0 && divisor < 0) {
			while (dividend <= divisor) {
				dividend -= divisor;
				if(res >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				res++;
			}
			return res;
		} else if (dividend < 0 && divisor > 0) {
			divisor = -divisor;
			while (dividend <= divisor) {
				dividend -= divisor;
				res++;
			}
			return -res;
		} else {
			divisor = -divisor;
			while (dividend >= divisor) {
				dividend -= divisor;
				res++;
			}
			return -res;
		}
	}

	/**
	 * 用移位来做，正确的方法
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
		long test = 0;
		long temp = 0;
		int res = 0;
		boolean flag = (dividend ^ divisor) >= 0;
		long up = Math.abs((long)dividend);
		long down = Math.abs((long)divisor);
		for (int i = 31; i >= 0; i--) {
			test = up >> i;
			if(test >= down) {
				temp = down << i;
				res += 1 << i;
				up = up - temp;
			}	
		}
		res = flag ? res : -res;
		return res;
	}
	
	
	public static void main(String[] args) {
		M29 m29 = new M29();
		System.out.println(m29.divide2(1, 1));
	}
}
