package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E219 {
	//暴力法，超时了
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= k && i < nums.length - j; j++) {
				if(nums[i] == nums[i + j])
					return true;
			}
		}
        return false;
    }
    
    //哈希
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
    	int j = 0;
    	Map<Integer, Integer> map = new HashMap<>(nums.length);
    	for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				j = map.get(nums[i]);
				if(i - j <= k)
					return true;
			}
			map.put(nums[i], i);
		}
    	return false;
    }
    
  //哈希
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
    	Set<Integer> set = new HashSet<>();
    	for (int i = 0; i < nums.length; i++) {
    		if(set.contains(nums[i]))
    			return true;
			set.add(nums[i]);
			if(set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
    	return false;
    }
}
