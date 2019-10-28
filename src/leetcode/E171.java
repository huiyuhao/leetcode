package leetcode;

public class E171 {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int sum  = 0;
        for (int i = 0; i < chs.length; i++) {
			int temp = 1;
			for (int j = 1; j < chs.length - i; j++) {
				temp *= 26;
			}
			sum += (chs[i] - 'A' + 1) * temp;
		}
        return sum;
    }
}
