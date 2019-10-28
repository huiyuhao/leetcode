package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M78 {
	/**
	 * 幂集，位运算
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		int index = 0;
		while (index < Math.pow(2, len)) {
			String str = Integer.toBinaryString(index);
			int strLen = str.length();
			for (int i = 0; i < strLen; i++) {
				if (str.charAt(strLen - i - 1) == '1')
					cur.add(nums[i]);
			}
			res.add(new ArrayList<>(cur));
			cur.clear();
			index++;
		}
		return res;
	}

	/**
	 * 可以直接从后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int resSize = res.size();
			for (int j = 0; j < resSize; j++) {
				res.add(new ArrayList<>(res.get(j)));
				res.get(j).add(nums[i]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M78 m78 = new M78();
		int[] nums = { 1, 2, 3 };
		System.out.println(m78.subsets2(nums));
	}
}
