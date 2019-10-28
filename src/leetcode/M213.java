package leetcode;

public class M213 {
	/**
	 * 动态规划，是E198的升级版
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		int len = nums.length;
		if (nums == null || len == 0)
			return 0;
		int[] save = new int[len];
		save[0] = nums[0];
		if (len > 1)
			save[1] = Math.max(nums[0], nums[1]);
		else
			return nums[0];
		//永远不打劫正着数最后一间屋子（从前往后打劫）
		for (int i = 2; i < save.length; i++) {
			save[i] = Math.max(save[i - 2] + nums[i], save[i - 1]);
		}
		int max = save[len - 2];
		//永远不打劫正着数第一间屋子（通过从后往前打劫来实现）
		save[len - 1] = nums[len - 1];
		save[len - 2] = Math.max(save[len - 1], nums[len - 2]);
		for (int i = len - 3; i > 0; i--) {
			save[i] = Math.max(save[i + 2] + nums[i], save[i + 1]);
		}
		max = max > save[1] ? max : save[1];
		return max;
	}

	public static void main(String[] args) {
		M213 m213 = new M213();
		System.out.println(m213.rob(new int[] { 1, 1, 1 }));
	}
}
