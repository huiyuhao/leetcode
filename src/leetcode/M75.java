package leetcode;

public class M75 {

	/**
	 * 计数排序法的两趟扫描算法
	 * 
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		int num0 = 0, num1 = 0, num2 = 0;
		for (int num : nums) {
			if (num == 0)
				num0++;
			else if (num == 1)
				num1++;
			else
				num2++;
		}
		int index = 0;
		for (int i = 0; i < num0; i++) {
			nums[index++] = 0;
		}
		for (int i = 0; i < num1; i++) {
			nums[index++] = 1;
		}
		for (int i = 0; i < num2; i++) {
			nums[index++] = 2;
		}
	}

	/**
	 * 一趟扫描算法
	 * 
	 * @param nums
	 */
	public void sortColors2(int[] nums) {
		int p1 = 0, p2 = nums.length - 1;
		int temp = 0;
		int i = 0;
		while (i <= p2) {
			if (nums[i] == 0) {
				temp = nums[i];
				nums[i] = nums[p1];
				nums[p1] = temp;
				p1++;
			} else if (nums[i] == 2) {
				temp = nums[i];
				nums[i] = nums[p2];
				nums[p2] = temp;
				p2--;
				i--;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		M75 m75 = new M75();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		m75.sortColors2(nums);
		for (int num : nums) {
			System.out.print(num);
		}
	}

}
