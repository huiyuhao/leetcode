package leetcode;

public class E9 {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int temp = 0, c = x;
		while (c != 0) {
			temp = temp * 10 + c % 10;
			c /= 10;
		}
		return x == temp ? true : false;
	}

	public boolean isPalindrome2(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;
		int res = 0;
		while (x > res) {
			res = 10 * res + x % 10;
			x = x / 10;
		}
		return (res == x || x == res / 10);
	}

	public static void main(String[] args) {
		E9 e9 = new E9();
		int x = 121;
		e9.isPalindrome(x);
	}
}
