package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class H145 {
	/**
	 * 递归
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	helper(root, res);
    	return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
    	if(root != null) {
    		helper(root.left, res);
    		helper(root.right, res);
    		res.add(root.val);
    	}
    }
    
    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if(root == null)
    		return res;
    	stack.push(root);
    	TreeNode current = root;
    	while(!stack.isEmpty()) {
    		current = stack.pop();
    		res.add(current.val);
    		if(current.left != null)
    			stack.push(current.left);
    		if(current.right != null)
    			stack.push(current.right);
    	}
    	List<Integer> realRes = new ArrayList<>();
    	for (int i = res.size() - 1; i >= 0 ; i--) {
			realRes.add(res.get(i));
		}
//    	Collections.reverse(res);  可以代替上面的
    	return realRes;
    }
}
