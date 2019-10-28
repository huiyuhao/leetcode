package leetcode;

import java.util.Arrays;

public class M16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp, sum, dif, result = 0, minDif = Integer.MAX_VALUE;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
        	left = i + 1;
        	right = nums.length - 1;
			temp = target - nums[i];
			while(left < right) {
				sum = nums[left] + nums[right];
				dif = sum - temp;
				if(Math.abs(dif) < minDif) {
					minDif = Math.abs(dif);
					result = sum + nums[i];
				}
				if(dif == 0)
					return result;
				if(dif < 0)
					left++;
				if(dif > 0)
					right--;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		M16 m16 = new M16();
		int[] nums = { -1,2,1,-4 };
		int target = 1;
		int result = m16.threeSumClosest(nums, target);
		System.out.println(result);
	}
}
