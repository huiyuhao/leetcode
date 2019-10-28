package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		for (Integer num : nums)
			cur.add(num);
		backtrack(nums.length, set, cur, 0);
		res.addAll(set);
		return res;
	}

	public void backtrack(int n, Set<List<Integer>> set, List<Integer> cur, int first) {
		if (first == n)
			set.add(new ArrayList<>(cur));
		for (int i = first; i < n; i++) {
			Collections.swap(cur, first, i);
			backtrack(n, set, cur, first + 1);
			Collections.swap(cur, first, i);
		}
	}

	/**
	 * 这个方法就是先讲数组排序，然后对每一位设置一个标志，标记是否被使用，一旦出现两个相同的数字 而  后一个在前一个前面被调用，
	 * 就说明会重复，就要continue，跳过。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		boolean[] flag = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack2(flag, cur, res, nums);
		return res;
	}

	public void backtrack2(boolean[] flag, List<Integer> cur, List<List<Integer>> res, int[] nums) {
		if (cur.size() == nums.length)
			res.add(new ArrayList<>(cur));
		for (int i = 0; i < nums.length; i++) {
			if (flag[i])
				continue;
			if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])
				continue;
			flag[i] = true;
			cur.add(nums[i]);
			backtrack2(flag, cur, res, nums);
			cur.remove(cur.size() - 1);
			flag[i] = false;
		}
	}

	public static void main(String[] args) {
		M47 m47 = new M47();
		int[] nums = { 1, 1, 2 };
		System.out.println(m47.permuteUnique2(nums));
	}
}
