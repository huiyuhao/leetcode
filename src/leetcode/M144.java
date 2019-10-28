package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M144 {
	/**
	 * µÝ¹é
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			helper(root.left, res);
			helper(root.right, res);
		}
	}
	
	/**
	 * µü´ú
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return res;
		stack.push(root);
		TreeNode current = root;
		while(!stack.isEmpty()) {
			current = stack.pop();
			res.add(current.val);
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
		}
		return res;
	}
}
