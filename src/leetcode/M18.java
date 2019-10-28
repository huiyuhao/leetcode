package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int left, right, sum;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = nums.length - 1; j > 2; j--) {
				if (j < nums.length - 1 && nums[j] == nums[j + 1])
					continue;
				left = i + 1;
				right = j - 1;
				while (left < right) {
					sum = nums[i] + nums[left] + nums[right] + nums[j];
					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;
					}
					if(sum < target) left++;
					if(sum > target) right--;
				}
			}
		}
		return result;
	}
	
	//Ôö¼ÓÁË¼ôÖ¦
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int left, right, sum;
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target ) break;
			if(nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target ) continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				left = j + 1;
				right = nums.length - 1;
				while (left < right) {
					sum = nums[i] + nums[left] + nums[right] + nums[j];
					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;
					}
					if(sum < target) left++;
					if(sum > target) right--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		M18 m18 = new M18();
		int[] nums = {5,5,3,5,1,-5,1,-2};
		int target = 4;
		List<List<Integer>> result = m18.fourSum(nums, target);
		result.toString();
		System.out.println(result);
	}
}
