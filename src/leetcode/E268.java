package leetcode;

import java.util.Arrays;

public class E268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] != 0)
        	return 0;
        for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i + 1] - nums[i] != 1)
				return nums[i] + 1;
		}
        return nums[nums.length - 1] + 1;
    }
    
    public int missingNumber2(int[] nums) {
    	int[] temp = new int[nums.length + 1];
    	for (int num : nums) {
			temp[num]++;
		}
     	for (int i = 0; i < temp.length; i++) {
			if(temp[i] == 0)
				return i;
		}
     	return 0;
    }
    
    public int missingNumber3(int[] nums) {
    	int result = 0;
    	for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i] ^ (i + 1);
		}
    	return result;
    }
}
