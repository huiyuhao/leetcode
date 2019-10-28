package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week156 {
	public boolean uniqueOccurrences(int[] arr) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] == arr[i - 1])
				sum++;
			else {
				if (set.contains(sum))
					return false;
				else
					set.add(sum);
				sum = 1;
			}
		}
		if (set.contains(sum))
			return false;
		return true;
	}

	public String removeDuplicates(String s, int k) {
		int i = 1;
		int nowSum = 1;
		int reSum = 1;
		int index = 0;
		String res = "";
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				nowSum++;
			} else {
				reSum = nowSum;
				nowSum = 1;
				if (reSum % k != 0) {
					index += reSum / k * k;
					res += s.substring(index, i);
				}
				index = i;
				reSum = 0;
			}
			i++;
		}
		if (nowSum % k != 0) {
			index += nowSum / k * k;
			res += s.substring(index, i);
		}
		if (res.length() != s.length())
			return removeDuplicates(res, k);
		return res;
	}

	public static void main(String[] args) {
		Week156 week156 = new Week156();
		System.out.println(week156.removeDuplicates("deeedbbcccbdaa", 3));
	}

}
