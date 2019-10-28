package leetcode;

public class E198 {

	/**
	 * 第一次写的，会超时
	 * 只想着递归了，没有动态规划的思想
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		helper(nums, 0, 0);
		if (nums.length > 1)
			helper(nums, 1, 0);
		return max;
	}

	int max = 0;

	public void helper(int[] nums, int index, int sum) {
		sum += nums[index];
		if (index + 2 < nums.length)
			helper(nums, index + 2, sum);
		if (index + 3 < nums.length)
			helper(nums, index + 3, sum);
		max = max > sum ? max : sum;

		sum -= nums[index];
	}

	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] save = new int[nums.length];
		save[0] = nums[0];
		if (nums.length > 1)
			save[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < save.length; i++) {
			save[i] = Math.max(nums[i] + save[i - 2], save[i - 1]);
		}
		return save[save.length - 1];
	}

	/**
	 * 动态规划更加优化，但是不如上面那个好懂
	 * 是看了官方题解后对自己上面写的动态规划进行了精简
	 * 时间复杂度是一样的，但是节约了内存空间
	 * 发现上述方法中，最多只用到当前位置之前两个的存储值
	 * 其实没有必要搞一个数组储存过往，两个内存进行轮换交替即可
	 * @param nums
	 * @return
	 */
	public int rob3(int[] nums) {
		int p1 = 0;
		int p2 = 0;
		for (int num : nums) {
			int temp = p2;
			p2 = Math.max(p1 + num, p2);
			p1 = temp;
		}
		return p2;
	}

	public static void main(String[] args) {
		E198 e198 = new E198();
		System.out.println(e198.rob2(new int[] { 2, 7, 9, 3, 1 }));
	}
}
