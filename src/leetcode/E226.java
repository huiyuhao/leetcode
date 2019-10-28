package leetcode;

import java.util.LinkedList;

public class E226 {
	/**
	 * µÝ¹é
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	/**
	 * µü´ú
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left != null)
				stack.add(current.left);
			if (current.right != null)
				stack.add(current.right);
		}
		return root;
	}
}
