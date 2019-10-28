package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(nums);
		int len = nums.length;
		int n = (int) Math.pow(2, len);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((i >> j & 1) == 1)
					cur.add(nums[j]);
			}
			if (!res.contains(cur))
				res.add(new ArrayList<>(cur));
			cur.clear();
		}
		return res;
	}

	public static void main(String[] args) {
		M90 m90 = new M90();
		int[] nums = { 4, 4, 4, 1, 4 };
		System.out.println(m90.subsetsWithDup(nums));
	}
}
