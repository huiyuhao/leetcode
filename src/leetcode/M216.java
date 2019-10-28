package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		backtrack(k, n, res, cur, 1);
		return res;
	}

	public void backtrack(int k, int n, List<List<Integer>> res, List<Integer> cur, int index) {
		if (n < 0)
			return;
		if (cur.size() == k && n == 0)
			res.add(new ArrayList<>(cur));
		for (int i = index; i < 10; i++) {
			n -= i;
			cur.add(i);
			backtrack(k, n, res, cur, i + 1);
			cur.remove(cur.size() - 1);
			n += i;
		}
	}
}
