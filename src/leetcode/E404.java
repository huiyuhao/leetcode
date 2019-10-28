package leetcode;

public class E404 {
	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
        	return sum;
        if(root.left != null && root.left.left == null && root.left.right == null)
        	sum += root.left.val;
        else if(root.left != null)
        	sumOfLeftLeaves(root.left);
        if(root.right != null)
        	sumOfLeftLeaves(root.right);
        return sum;
    }
    
    public int sumOfLeftLeaves2(TreeNode root) {
    	if(root == null)
    		return 0;
    	if(root.left != null && root.left.left == null && root.left.right == null)
    		return root.left.val + sumOfLeftLeaves2(root.right);
    	return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }
    
    public static void main(String[] args) {
		E404 e404 = new E404();
		Integer[] nums = {3,9,20,null,null,15,7};
		TreeNode root = ConstructTree.constructTree(nums);
		System.out.println(e404.sumOfLeftLeaves2(root));
	}
}
