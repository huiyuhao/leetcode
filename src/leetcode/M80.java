package leetcode;

public class M80 {
	/**
	 * ˫ָ�뷨
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int p1 = 1, p2 = 1;
		int sum = 1;
		while (p2 < nums.length) {
			if (nums[p2] == nums[p2 - 1]) {
				sum++;
				if (sum > 2) {
					p2++;
					continue;
				}
			} else
				sum = 1;
			nums[p1] = nums[p2];
			p1++;
			p2++;
		}
		return p1;
	}

	/**
	 * powcai����Ľⷨ��һ��ָ��Ϳ���
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n != nums[i - 2]) {
				nums[i] = n;
				i++;
			}
		}
		return i;
	}
}
