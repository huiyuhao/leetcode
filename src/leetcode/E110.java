package leetcode;

public class E110 {
	/**
	 * 自己写的，也是自顶至底
	 * @param root
	 * @return
	 */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        int depth_left = 0;
        int depth_right = 0;
        if(root.left != null) {
        	depth_left = searchMaxDepth(root.left, depth_left);
    	}
    	if(root.right != null) {
    		depth_right = searchMaxDepth(root.right, depth_right);
    	}
    	if(Math.abs(depth_right - depth_left) > 1)
    		return false;
    	if(root.left != null && root.right != null)
    		return isBalanced(root.left) && isBalanced(root.right);
    	if(root.left != null)
    		return isBalanced(root.left);
    	if(root.right != null)
    		return isBalanced(root.right);    	
    	return true;
    }
    
    public int searchMaxDepth(TreeNode root, int depth) {
    	if(root == null)
        	return depth;
        depth++;
        int dep1 = searchMaxDepth(root.left, depth);
        int dep2 = searchMaxDepth(root.right, depth);
        depth = Math.max(dep1, dep2);
        return depth;
    }
    
    /**
     * 自顶至底
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
    	if(root == null)
    		return true;
    	return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }
    
    public int depth(TreeNode root) {
    	if(root == null)
    		return 0;
    	return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    /**
     * 自底至顶
     */
    boolean res = true;
    public boolean isBalanced3(TreeNode root) {
    	helper(root);
    	return res;
    }
    
    public int helper(TreeNode root) {
    	if(root == null)
    		return 0;
    	int left = helper(root.left) + 1;
    	int right = helper(root.right) + 1;
    	if(Math.abs(left - right) > 1)
    		res = false;
    	return Math.max(left, right);
    }
    
}
