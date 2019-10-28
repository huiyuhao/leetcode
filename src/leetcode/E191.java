package leetcode;

public class E191 {
	public int hammingWeight(int n) {
		String s = Integer.toBinaryString(n);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				res++;
		}
		return res;
	}

	/**
	 * 位运算，使用 位掩码 来检查数字各位 位掩码 1 的二进制为 0000 0000 0000 0000 0000 0000 0000 0001
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeight2(int n) {
		int mask = 1;
		int res = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0)
				res++;
			mask <<= 1;
		}
		return res;
	}
	
	/**
	 * 位运算的小技巧，非常巧妙，根本想不到
	 * 这里关键的想法是对于任意数字n，将n和n−1做与运算，会把最后一个1的位变成0
	 * @param n
	 * @return
	 */
	public int hammingWeight3(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}
}
