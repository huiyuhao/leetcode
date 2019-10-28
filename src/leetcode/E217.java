package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E217 {
    public boolean containsDuplicate(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>(nums.length);
    	for (int i = 0; i < nums.length; i++) {
    		if(map.containsKey(nums[i]))
    			return true;
			map.put(nums[i], i);
		}
    	return false;
    }
    
    public boolean containsDuplicate2(int[] nums) {
    	Arrays.sort(nums);
    	for (int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1])
				return true;
		}
    	return false;    	
    }
    
    public boolean containsDuplicate3(int[] nums) {
    	Set<Integer> set = new HashSet<>(nums.length);
    	for (int num : nums) {
			set.add(num);
		}
    	if(nums.length == set.size())
    		return false;
    	return true;
    }
}
