package leetcode;

public class E53 {
	public int maxSubArray(int[] nums) {
		int max = nums[0], sum = 0, left = 0, right = 0;
		int[] maxNums;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
					left = i;
					right = j;
				}	
			}
		}
		return max;
	}
	
	public int maxSubArray2(int[] nums) {
		int max = nums[0], sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}	
			}
		}
		return max;
	}
	
	//动态规划
	public int maxSubArray3(int[] nums) {
		int max = nums[0], sum = 0;
		for (int num : nums) {
			if(sum > 0) {
				sum += num;
			}else {
				sum = num;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	
	//sum(i,j) = sum(0,j) - sum(0,i)
	//我们只要记录前i总和最小值就可以了
	public int maxSubArray4(int[] nums) {
		int sum = 0;
		int max = nums[0];
		int min = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(max, sum - min);
			min = Math.min(min, sum);
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		E53 e53 = new E53();
		int max = e53.maxSubArray4(nums);
		System.out.println(max);
	}
}
