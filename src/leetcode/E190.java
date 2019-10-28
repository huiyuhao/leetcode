package leetcode;

public class E190 {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		String res = "";
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			int num = (int) s.charAt(i);
			res += String.valueOf(num);
		}
		int result = Integer.valueOf(res);
		return result;
	}
}
