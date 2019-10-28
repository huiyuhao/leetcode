package leetcode;

public class E189 {
	public static void rotate(int[] nums, int k) {
		int[] temp = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			for (int j = 1; j < temp.length; j++) {
				temp[temp.length - j] = temp[temp.length - j - 1];
			}
			temp[0] = temp[temp.length - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}

	public static void rotate2(int[] nums, int k) {
		int temp;
		for (int i = 0; i < k; i++) {
			temp = nums[nums.length - 1];
			for (int j = 1; j < nums.length; j++) {
				nums[nums.length - j] = nums[nums.length - j - 1];
			}
			nums[0] = temp;
		}
	}

	public static void rotate3(int[] nums, int k) {
		int[] temp = new int[nums.length];
		for (int i = 0; i < temp.length; i++) {
			temp[(i + k) % temp.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}


	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate3(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
