package leetcode;

public class E104 {
    public int maxDepth(TreeNode root) {
    	int depth = 0;
        return searchMaxDepth(root, depth); 
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
}
