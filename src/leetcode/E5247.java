package leetcode;

public class E5247 {
	public int minimumSwap(String s1, String s2) {
		if (s1.length() != s2.length())
			return -1;
		int xy = 0;// s1里面是x,s2里是y
		int yx = 0;// s1里面是y,s2里是x
		int res = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i))
				continue;
			if (s1.charAt(i) == 'x')
				xy++;
			else
				yx++;
		}
		res += xy / 2;
		res += yx / 2;
		xy %= 2;
		yx %= 2;
		if (xy == 1 && yx == 1)
			return res + 2;
		else if (xy == 0 && yx == 0)
			return res;
		return -1;
	}

	public static void main(String[] args) {
		E5247 e5247 = new E5247();
		System.out.println(e5247.minimumSwap("xx", "yy"));

	}
}
