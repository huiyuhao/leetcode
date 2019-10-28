package leetcode;

import java.util.Arrays;

public class M31 {
    public void nextPermutation(int[] nums) {
    	int temp;
        for (int i = nums.length - 2; i >= 0; i--) {
        	for (int j = nums.length - 1; j > i; j--) {
        		if(nums[i] < nums[j]) {
        			temp = nums[i];
    				nums[i] = nums[j];
    				nums[j] = temp;
    				Arrays.sort(nums, i + 1, nums.length);
    				return;
        		}
			}	
		}
        Arrays.sort(nums);
    }
    
    public static void main(String[] args) {
		M31 m31 = new M31();
		int[] nums = {5,4,3,2,1};
		m31.nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}		
	}
}
