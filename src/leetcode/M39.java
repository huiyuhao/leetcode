package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		backtrack(candidates, target, res, cur, 0);
		return res;
	}

	public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
		if (target == 0)
			res.add(new ArrayList<>(cur));
		if (target < 0)
			return;
		for (int i = index; i < candidates.length; i++) {
			target -= candidates[i];
			cur.add(candidates[i]);
			backtrack(candidates, target, res, cur, i);
			cur.remove(cur.size() - 1);
			target += candidates[i];
		}
	}
}
