package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class E204 {
	/**
	 * 用哈希最后几个大用例超时了
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
		Set<Integer> set = new HashSet<>();
		for (int p = 2; p <= Math.sqrt(n); p++) {
			if (!set.contains(p)) {
				int index = p;
				while (p * index < n) {
					if (!set.contains(p * index))
						set.add(p * index);
					index++;
				}
			}
		}
		return n - 2 - set.size();

//		int num = 0;
//		LinkedList<Integer> res = new LinkedList<>();
//		for (int i = 2; i < n; i++) {
//			if (!set.contains(i)) {
//				num++;
//				res.add(i);
//			}
//		}
//		return num;
	}

	/**
	 * 用数组快一些
	 * @param n
	 * @return
	 */
	public int countPrimes2(int n) {
		if (n <= 2)
			return 0;
		boolean[] nums = new boolean[n];
		int count = 0;
		for (int i = 2; i * i < n; i++) {
			if (!nums[i]) {
				for (int j = i * i; j < n; j += i) {
					if (nums[j])
						continue;
					count++;
					nums[j] = true;
				}
			}
		}
		return n - count - 2;
	}

	public static void main(String[] args) {
		E204 e204 = new E204();
		e204.countPrimes(10);
	}
}
