package leetcode;

public class M153 {
	public int findMin(int[] nums) {
		if (nums[nums.length - 1] > nums[0] || nums.length == 1)
			return nums[0];
		return helper(nums, 0, nums.length - 1);
	}

	public int helper(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		if (mid == 0)
			return Math.min(nums[mid], nums[mid + 1]);
		if (nums[mid] > nums[mid - 1] && nums[mid] < nums[0])
			return helper(nums, left, mid - 1);
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[0])
			return helper(nums, mid + 1, right);
		return nums[mid];
	}

	public int helper2(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		if (nums[mid] > nums[mid + 1])
	        return nums[mid + 1];
		if (nums[mid - 1] > nums[mid])
	        return nums[mid];
		if (nums[mid] < nums[left])
			return helper2(nums, left, mid);
		if (nums[mid] > nums[right])
			return helper2(nums, mid + 1, right);
		return 0;
	}
}
