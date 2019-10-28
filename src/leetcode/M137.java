package leetcode;

import java.util.Arrays;

public class M137 {
    public int singleNumber(int[] nums) {
    	Arrays.sort(nums);
    	int i = 0;
    	while(i < nums.length - 1) {
    		if(nums[i] != nums[i + 2])
    			break;
    		i += 3;
    	}
    	return nums[i];
    }
    
    /**
     * 位运算，模3，大神解法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int num : nums){
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
