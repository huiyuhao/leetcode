package leetcode;

public class E198 {

	/**
	 * ��һ��д�ģ��ᳬʱ
	 * ֻ���ŵݹ��ˣ�û�ж�̬�滮��˼��
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
	 * ��̬�滮
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
	 * ��̬�滮�����Ż������ǲ��������Ǹ��ö�
	 * �ǿ��˹ٷ�������Լ�����д�Ķ�̬�滮�����˾���
	 * ʱ�临�Ӷ���һ���ģ����ǽ�Լ���ڴ�ռ�
	 * �������������У����ֻ�õ���ǰλ��֮ǰ�����Ĵ洢ֵ
	 * ��ʵû�б�Ҫ��һ�����鴢������������ڴ�����ֻ����漴��
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
