package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		boolean[] flag = new boolean[candidates.length];
		backtrack(candidates, target, res, cur, 0, flag);
		return res;
	}

	public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index, boolean[] flag) {
		if (target == 0)
			res.add(new ArrayList<>(cur));
		if (target < 0)
			return;
		for (int i = index; i < candidates.length; i++) {
			if(i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1])
				continue;
			flag[i] = true;
			target -= candidates[i];
			cur.add(candidates[i]);
			backtrack(candidates, target, res, cur, i + 1, flag);
			cur.remove(cur.size() - 1);
			target += candidates[i];
			flag[i] = false;
		}
	}
	
	
	/**
	 * 因为这道题确定到后面的数时不会再回去用到前面的数，所以不用设置标志flag,
	 * 和47题不一样，那道题到后面的数的时候可能也会回去再用前面的数，但是又担心重复
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack2(candidates, target, res, cur, 0);
		return res;
	}

	public void backtrack2(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
		if (target == 0)
			res.add(new ArrayList<>(cur));
		if (target < 0)
			return;
		for (int i = index; i < candidates.length; i++) {
			if(i > index && candidates[i] == candidates[i - 1])
				continue;
			target -= candidates[i];
			cur.add(candidates[i]);
			backtrack2(candidates, target, res, cur, i + 1);
			cur.remove(cur.size() - 1);
			target += candidates[i];
		}
	}
}
