package leetcode;

public class E190 {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int ans = 0;
		int i = 32;
		while (i > 0) {
			ans <<= 1;// ans����һλ����n�����һλŲ����
			ans += n & 1;// n��1�룬ȡ��n�����һλ������ans�����һλ
			n >>= 1;// n����һλ�����Ѿ�Ų��ans�е����һλ�ͷŵ�
			i--;
		}
		return ans;
	}
}
