package leetcode;

public class M81 {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0 || nums == null)
			return false;
		int left = 0;
		int right = nums.length - 1;
		while (nums.length > 1 && left < right && nums[left] == nums[right])
			right--;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
				left = mid + 1;
			else if (target > nums[mid] && target < nums[0])
				left = mid + 1;
			else
				right = mid;
		}
		return left == right && nums[left] == target ? true : false;
	}

	public static void main(String[] args) {
		M81 m81 = new M81();
		int[] nums = { 1, 1 };
		int target = 0;
		boolean result = m81.search(nums, target);
		System.out.println(result);
	}
}
