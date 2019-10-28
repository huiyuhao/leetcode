package leetcode;

public class E26 {
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 0;
		while(i < nums.length) {
			j = i + 1;
			while(j < nums.length) {
				if(nums[i] != nums[j]) {
					i++;
					nums[i] = nums[j];
				}
				j++;
			}
			break;
		}
		return i + 1;
	}
	
	public int removeDuplicates2(int[] nums) {
		int i = 0, j = 1;
		while(j < nums.length) {
			if(nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
			j++;
		}
		return i + 1;
	}
	
	public static void main(String[] args) {
		int [] nums = {0,0,1,2,1,0,1};
		E26 e26 = new E26();
		int result = e26.removeDuplicates2(nums);
		System.out.println(result);
	}
}
