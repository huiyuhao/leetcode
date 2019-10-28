package leetcode;

import java.util.HashSet;
import java.util.Set;

public class E202 {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		while (!set.contains(n)) {
			sum = 0;
			set.add(n);
			while (n != 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1)
				return true;
			else
				n = sum;
		}
		return false;
	}

	public static void main(String[] args) {
		E202 e202 = new E202();
		int n = 19;
		System.out.println(e202.isHappy(n));
	}
}
