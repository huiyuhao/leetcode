package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M5248 {
	public int numberOfSubarrays(int[] nums, int k) {
		int len = nums.length;
		int res = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++)
			if (nums[i] % 2 == 1)
				list.add(i);
		if (list.size() < k)
			return 0;
		int left = 0;
		int right = k - 1;
		while (right < list.size()) {
			if (left == 0 && right + 1 == list.size())
				res += (list.get(left) + 1) * (len - list.get(right));
			else if (left == 0)
				res += (list.get(left) + 1) * (list.get(right + 1) - list.get(right));
			else if (right + 1 == list.size())
				res += (list.get(left) - list.get(left - 1)) * (len - list.get(right));
			else
				res += (list.get(left) - list.get(left - 1)) * (list.get(right + 1) - list.get(right));
			left++;
			right++;
		}
		return res;
	}
	
	/**
	 * 大神二哥的解法
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numberOfSubarrays2(int[] nums, int k) {
		int[] sum = new int[];
		
	}

	public static void main(String[] args) {
		M5248 m5248 = new M5248();
		int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		System.out.println(m5248.numberOfSubarrays(nums, 2));
	}
}
