package leetcode;

public class M55 {
	public boolean canJump(int[] nums) {
		if (nums.length == 1 && nums[0] == 0)
			return true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int j = i - 1;
				for (j = i - 1; j >= 0; j--) {
					if (nums[j] >= nums.length - 1 - j)
						return true;
					if (nums[j] > i - j)
						break;
				}
				if (j < 0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		M55 m55 = new M55();
		int[] nums = { 2, 0, 0 };
		if (m55.canJump(nums))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
