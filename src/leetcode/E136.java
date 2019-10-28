package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class E136 {
    public int singleNumber(int[] nums) {
    	Set<Integer> set = new HashSet<>();
        for (int num : nums) {
			if(set.contains(num))
				set.remove(num);
			else
				set.add(num);
		}
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
    
    public int singleNumber2(int[] nums) {
    	Arrays.sort(nums);
    	int i = 0;
    	while(i < nums.length - 1) {
    		if(nums[i] != nums[i + 1])
    			break;
    		i += 2;
    	}
    	return nums[i];
    }
    
    public int singleNumber3(int[] nums) {
    	int res = nums[0];
    	for (int i = 1; i < nums.length; i++)
			res ^= nums[i];		
    	return res;
    }
}
