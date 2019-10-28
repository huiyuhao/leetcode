package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 1) {
			res.add(nums[0]);
			return res;
		}
		if (nums.length == 2) {
			res.add(nums[0]);
			if (!res.contains(nums[1]))
				res.add(nums[1]);
			return res;
		}
		Arrays.sort(nums);
		int m = nums.length / 3;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
				if (count > m && !res.contains(nums[i]))
					res.add(nums[i]);
			} else
				count = 1;
		}
		return res;
	}

	/**
	 * 摩尔投票法的扩展（用于n/3）
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement2(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0 || nums == null)
			return res;
		int a = nums[0];
		int b = nums[0];
		int countA = 0;
		int countB = 0;
		for (int num : nums) {
			if (num == a) {
				countA++;
			} else if (num == b) {
				countB++;
			} else if (countA == 0) {
				a = num;
				countA++;
			} else if (countB == 0) {
				b = num;
				countB++;
			} else {
				countA--;
				countB--;
			}
		}
		countA = 0;
		countB = 0;
		for (int num : nums) {
			if (num == a)
				countA++;
			else if (num == b)
				countB++;
		}
		if (countA > nums.length / 3)
			res.add(a);
		if (countB > nums.length / 3)
			res.add(b);
		return res;
	}

	public static void main(String[] args) {
		M229 m229 = new M229();
		int[] nums = { 2, 2 };
		System.out.println(m229.majorityElement(nums));
	}
}
