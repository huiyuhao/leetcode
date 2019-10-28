package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    public int majorityElement2(int[] nums) {
    	int count = 1;
    	int i = 1;
    	int pre = nums[0];
    	while (i < nums.length) {
    		if(pre == nums[i]) {
    			count++;
    		}else {
    			count--;
    		}
    		if(count == 0) {
    			i++;
    			pre = nums[i];
    			count++;
    		}
    		i++;	
    	}
    	return pre;
    }
    
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    
    public static void main(String[] args) {
		E169 e169 = new E169();
		int[] nums= {8,9,8,9,8};
		int most = e169.majorityElement3(nums);
		System.out.println(most);
	}
}
