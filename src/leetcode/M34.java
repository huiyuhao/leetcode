package leetcode;

public class M34 {
    public int[] searchRange(int[] nums, int target) {
        int begin = -1, end = -1, left = 0, right = nums.length - 1, mid;
        if(nums.length == 1 && nums[0] == target)
        	return new int[] {0, 0};
        while(left <= right) {
        	mid = (left + right) / 2;
        	if(nums[mid] < target) {
        		left = mid + 1;
        	}
        	if(nums[mid] > target) {
        		right = mid - 1;
        	}
        	if(nums[mid] == target) {
        		begin = mid;
        		end = mid;
        		break;
        	}	
        }
        while(begin >= 0 && end < nums.length) {
        	if(begin > 0 && nums[begin] == nums[begin - 1]) {
        		begin--;
        	}else if(end < nums.length - 1 && nums[end] == nums[end + 1]) {
        		end++;
        	}else {
        		break;
        	}
        }
        return new int[] {begin, end};
    }
    
	public static void main(String[] args) {
		M34 m34 = new M34();
		int[] nums = { 1 };
		int target = 1;
		int[] result = m34.searchRange(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
