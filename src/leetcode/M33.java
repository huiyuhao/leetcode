package leetcode;

public class M33 {
	/**
	 * 第一次的思路真是崎岖
	 * 
	 * @param args
	 */
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums[0] == target)
			return 0;
		int left = 0, right = nums.length - 1, mid, point = 0;
		while (left < right) {
			if (nums[0] < nums[nums.length - 1])
				break;
			mid = (left + right) / 2;
			if (nums[mid] > nums[mid + 1]) {
				point = mid + 1;
				break;
			} else {
				if (nums[mid] > nums[left]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
		}
		if (point > 0) {
			if (target > nums[point - 1] || target < nums[point]) {
				return -1;
			}
			if (target > nums[0]) {
				left = 0;
				right = point - 1;
				while (left <= right) {
					mid = (left + right) / 2;
					if (left < right && target < nums[mid]) {
						right = mid;
					} else if (left < right && target > nums[mid]) {
						left = mid + 1;
					} else if (nums[mid] == target) {
						return mid;
					} else {
						break;
					}
				}
			} else {
				left = point;
				right = nums.length - 1;
				while (left <= right) {
					mid = (left + right) / 2;
					if (left < right && target < nums[mid]) {
						right = mid;
					} else if (left < right && target > nums[mid]) {
						left = mid + 1;
					} else if (nums[mid] == target) {
						return mid;
					} else {
						break;
					}
				}
			}
		}
		if (point == 0) {
			if (target > nums[nums.length - 1] || target < nums[point]) {
				return -1;
			}
			left = 0;
			right = nums.length - 1;
			while (left <= right) {
				mid = (left + right) / 2;
				if (left < right && target < nums[mid]) {
					right = mid;
				} else if (left < right && target > nums[mid]) {
					left = mid + 1;
				} else if (nums[mid] == target) {
					return mid;
				} else {
					break;
				}
			}
		}
		return -1;
	}

	/**
	 * 看了大佬的之后，自己写了一下
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
				left = mid + 1;
			else if (target > nums[mid] && target < nums[0])
				left = mid + 1;
			else
				right = mid;
		}
		return left == right && nums[left] == target ? left : -1;
	}

	public static void main(String[] args) {
		M33 m33 = new M33();
		int[] nums = { 1,3 };
		int target = 3;
		int result = m33.search2(nums, target);
		System.out.println(result);
	}
}
