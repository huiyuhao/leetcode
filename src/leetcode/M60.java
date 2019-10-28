package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M60 {
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		int res = 0;
		while (n > 1) {
			int temp = 1;
			for (int i = 1; i < n; i++)
				temp *= i;
			int index = k / temp;
			k %= temp;
			if (k == 0) {
				index--;
				res = res * 10 + list.get(index);
				list.remove(index);
				while (!list.isEmpty()) {
					res = res * 10 + list.get(list.size() - 1);
					list.remove(list.size() - 1);
				}
				return String.valueOf(res);
			}
			n--;
			res = res * 10 + list.get(index);
			list.remove(index);
		}
		res = res * 10 + list.get(0);
		return String.valueOf(res);
	}

	public String getPermutation2(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		StringBuilder sb = new StringBuilder();
		while (n > 1) {
			int temp = 1;
			for (int i = 1; i < n; i++)
				temp *= i;
			int index = k / temp;
			k %= temp;
			if (k == 0) {
				index--;
				sb.append(list.get(index));
				list.remove(index);
				while (!list.isEmpty()) {
					sb.append(list.get(list.size() - 1));
					list.remove(list.size() - 1);
				}
				return sb.toString();
			}
			n--;
			sb.append(list.get(index));
			list.remove(index);
		}
		sb.append(list.get(0));
		return sb.toString();
	}

	public static void main(String[] args) {
		M60 m60 = new M60();
		System.out.println(m60.getPermutation2(3, 6));
	}
}
