package leetcode;

public class E108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }
    
    public TreeNode sort(int[] nums, int left, int right) {
    	if(left > right)
    		return null;
    	int mid = (left + right) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = sort(nums, left, mid - 1);
    	root.right = sort(nums, mid + 1, right);
    	return root;
    }
    
    public static void main(String[] args) {
    	E108 e108 = new E108();
		int[] nums = {-10, -3, 0, 5, 9};
		e108.sortedArrayToBST(nums);
	}
}
