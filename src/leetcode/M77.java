package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		backtrack(n, k, res, cur, 1);
		return res;
	}

	public void backtrack(int n, int k, List<List<Integer>> res, List<Integer> cur, int index) {
		if (cur.size() == k)
			res.add(new ArrayList<>(cur));
		for (int i = index; i <= n; i++) {
			cur.add(i);
			backtrack(n, k, res, cur, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
}
