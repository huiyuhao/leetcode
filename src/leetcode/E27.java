package leetcode;

public class E27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
			if(nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
        return i;
    }
    public static void main(String[] args) {
    	int [] nums = {0,1,2,2,3,0,4,2};
    	int val = 2;
		E27 e27 = new E27();
		int result = e27.removeElement(nums, val);
		System.out.println(result);
	}
}
