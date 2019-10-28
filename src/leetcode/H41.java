package leetcode;

import java.util.Arrays;

public class H41 {
	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		Arrays.sort(nums);
		if (nums[0] > 1 || nums[nums.length - 1] <= 0)
			return 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] <= 0 && nums[i] > 1)
				return 1;
			if (nums[i - 1] > 0 && nums[i] - nums[i - 1] > 1)
				return nums[i - 1] + 1;
		}
		return nums[nums.length - 1] + 1;
	}

	/**
	 * 桶排序（一个萝卜一个坑）
	 * 
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive2(int[] nums) {
		if (nums.length == 0)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1)
				continue;
			if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
				if (temp < i + 1)
					i = temp - 1;
				else
					i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return nums[nums.length - 1] + 1;
	}

	/**
	 * 简化了一下上面的版本，思路是一样的
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1)
				continue;
			while (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}
		}
		int i = 0;
		while (i < nums.length && nums[i] == i + 1)
			i++;
		return i + 1;
	}

	public static void main(String[] args) {
		H41 h41 = new H41();
		int[] nums = { 1, 2, 0 };
		h41.firstMissingPositive2(nums);
	}
}
