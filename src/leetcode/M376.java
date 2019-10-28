package leetcode;

public class M376 {
//	public int wiggleMaxLength(int[] nums) {
//		if (nums.length == 0)
//			return 0;
//		if (nums.length == 1 || nums.length == 2 && nums[0] == nums[1])
//			return 1;
//		int count = 2;
//		boolean allSame = true;
//		for (int i = 1; i < nums.length - 1; i++) {
//			if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
//				count++;
//				allSame = false;
//			}
//		}
//		return allSame ? 1 : count;
//	}

	public int wiggleMaxLength(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int index = 1;
		while (index < nums.length && nums[index] == nums[index - 1])
			index++;
		if (index == nums.length)
			return 1;
		// flag true 代表下一个要上升才算，false代表下一个要下降才算
		boolean flag = nums[index] > nums[index - 1] ? false : true;
		int count = 2;
		int cur = nums[index];

		for (int i = index + 1; i < nums.length; i++) {
			if ((!flag && nums[i] < cur) || (flag && nums[i] > cur)) {
				flag = !flag;
				count++;
			}
			cur = nums[i];
		}
		return count;
	}

	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public int wiggleMaxLength2(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		up[0] = down[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				down[i] = down[i - 1];
				up[i] = up[i - 1];
			}
		}
		return Math.max(up[nums.length - 1], down[nums.length - 1]);
	}

	/**
	 * 空间优化动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public int wiggleMaxLength3(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int up = 1;
		int down = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				up = down + 1;

			else if (nums[i] < nums[i - 1])
				down = up + 1;
		}
		return Math.max(up, down);
	}

	public static void main(String[] args) {
		M376 m376 = new M376();
		int[] nums = { 51, 226, 208, 165, 202, 286, 190, 212, 219, 271, 36, 245, 20, 238, 238, 89, 105, 66, 73, 9, 254,
				206, 221, 237, 203, 33, 249, 253, 150, 102, 57, 249, 203, 10, 123, 178, 85, 203, 35, 276, 129, 116, 37,
				163, 99, 142, 187, 249, 134, 77, 217, 298, 29, 127, 174, 115, 122, 178, 12, 80, 122, 76, 16, 41, 115,
				84, 104, 121, 127, 40, 287, 129, 9, 172, 112, 51, 40, 135, 205, 53, 259, 196, 248, 5, 123, 184, 209,
				130, 271, 42, 18, 143, 24, 101, 10, 273, 252, 50, 173, 80, 119, 129, 45, 257, 299, 78, 278, 78, 190,
				215, 284, 129, 200, 232, 103, 97, 167, 120, 49, 298, 141, 146, 154, 233, 214, 196, 244, 50, 110, 48,
				152, 82, 226, 26, 254, 276, 292, 286, 215, 56, 128, 122, 82, 241, 222, 12, 272, 192, 224, 136, 116, 70,
				39, 207, 295, 49, 194, 90, 210, 123, 271, 18, 276, 87, 177, 240, 276, 33, 155, 200, 51, 6, 212, 36, 149,
				202, 48, 114, 58, 91, 83, 221, 175, 148, 278, 300, 284, 86, 191, 95, 77, 215, 113, 257, 153, 135, 217,
				76, 85, 269, 126, 194, 199, 195, 20, 204, 194, 50, 220, 228, 90, 221, 256, 87, 157, 246, 74, 156, 9,
				196, 16, 259, 234, 79, 31, 206, 148, 12, 223, 151, 96, 229, 165, 9, 144, 26, 255, 201, 33, 89, 145, 155,
				1, 204, 37, 107, 80, 212, 88, 186, 254, 9, 158, 180, 24, 45, 158, 100, 52, 131, 71, 174, 229, 236, 296,
				299, 184, 168, 41, 45, 76, 68, 122, 85, 292, 238, 293, 179, 143, 128, 47, 87, 267, 53, 187, 76, 292, 0,
				160, 70, 172, 292, 9, 64, 156, 153, 26, 145, 196, 222 };
		System.out.println(m376.wiggleMaxLength2(nums));
	}
}
