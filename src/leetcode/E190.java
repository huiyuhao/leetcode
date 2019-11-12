package leetcode;

public class E190 {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int ans = 0;
		int i = 32;
		while (i > 0) {
			ans <<= 1;// ans左移一位，给n的最后一位挪个窝
			ans += n & 1;// n和1与，取出n的最后一位，放在ans的最后一位
			n >>= 1;// n右移一位，把已经挪到ans中的最后一位释放掉
			i--;
		}
		return ans;
	}
}
