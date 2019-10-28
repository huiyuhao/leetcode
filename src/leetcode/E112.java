package leetcode;

import java.util.LinkedList;

import javafx.util.Pair;

public class E112 {
	/**
	 * 深度优先  迭代
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair<TreeNode, Integer>(root, root.val));
        while(!stack.isEmpty()) {
        	Pair<TreeNode, Integer> current = stack.pollLast();
        	TreeNode currentNode = current.getKey();
        	int tempSum = current.getValue();
        	if(currentNode.left == null && currentNode.right == null && tempSum == sum)
        		return true;
        	if(currentNode.left != null)
        		stack.add(new Pair<TreeNode, Integer>(currentNode.left, tempSum + currentNode.left.val));
        	if(currentNode.right != null)
        		stack.add(new Pair<TreeNode, Integer>(currentNode.right, tempSum + currentNode.right.val));
        }
        return false;
    }
    
    /**
     * 递归  这个快
     */
    boolean res = false;
    public boolean hasPathSum2(TreeNode root, int sum) {
    	if(root == null)
    		return false;
    	tempSum(root, root.val, sum);
    	return res;
    }
    
    public void tempSum(TreeNode root, int temp, int sum) {
    	if(root.left == null && root.right == null && temp == sum)
    		res = true;
    	if(root.left != null)
    		tempSum(root.left, temp + root.left.val, sum);
    	if(root.right != null)
    		tempSum(root.right, temp + root.right.val, sum);
    }
}
