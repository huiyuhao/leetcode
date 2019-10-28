package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15 {

	// 暴力，超时
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int index = 0, l = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (index == 0 && nums[i] + nums[j] + nums[k] == 0) {
						result.add(new ArrayList<>());
						result.get(index).add(nums[i]);
						result.get(index).add(nums[j]);
						result.get(index).add(nums[k]);
						index++;
						break;
					}
					if (nums[i] + nums[j] + nums[k] == 0) {
						for (l = 0; l < index; l++) {
							if ((nums[i] == result.get(l).get(0) && nums[j] == result.get(l).get(1))
									|| (nums[i] == result.get(l).get(0) && nums[j] == result.get(l).get(2))
									|| (nums[i] == result.get(l).get(1) && nums[j] == result.get(l).get(0))
									|| (nums[i] == result.get(l).get(1) && nums[j] == result.get(l).get(2))
									|| (nums[i] == result.get(l).get(2) && nums[j] == result.get(l).get(0))
									|| (nums[i] == result.get(l).get(2) && nums[j] == result.get(l).get(1))) {
								break;
							}
						}
						if (l == index) {
							result.add(new ArrayList<>());
							result.get(index).add(nums[i]);
							result.get(index).add(nums[j]);
							result.get(index).add(nums[k]);
							index++;
						}
					}
				}
			}
		}
		return result;
	}

	//双指针，调到吐
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int index = 0, j = 1, k = nums.length - 1;
		for (int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i -1])
				continue;
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					result.add(new ArrayList<>());
					result.get(index).add(nums[i]);
					result.get(index).add(nums[j]);
					result.get(index).add(nums[k]);
					index++;
					while(j < k && nums[j] == nums[j + 1] ) 
						j++;
					while(j < k && nums[k] == nums[k - 1])
						k--;
					j++;
					k--;
				}
				if (sum < 0)
					j++;
				if (sum > 0)
					k--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		M15 m15 = new M15();
		int[] nums = { 0,0,0 };
		List<List<Integer>> result = m15.threeSum2(nums);
		result.toString();
		System.out.println(result);
	}
}
