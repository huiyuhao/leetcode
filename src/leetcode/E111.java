package leetcode;

import java.util.LinkedList;

import javafx.util.Pair;

public class E111 {
	/**
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return depth(root) + 1;
	}

	public int depth(TreeNode root) {
		if (root.left != null && root.right != null)
			return Math.min(depth(root.left), depth(root.right)) + 1;
		if (root.left != null)
			return depth(root.left) + 1;
		if (root.right != null)
			return depth(root.right) + 1;
		return 0;
	}

	/**
	 * 深度优先 迭代
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth2(TreeNode root) {
		if (root == null)
			return 0;
		int minDep = Integer.MAX_VALUE;
		LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
		stack.add(new Pair<TreeNode, Integer>(root, 1));
		while (!stack.isEmpty()) {
			Pair<TreeNode, Integer> current = stack.pollLast();
			TreeNode currentNode = current.getKey();
			int currentDepth = current.getValue();
			if (currentNode.left == null && currentNode.right == null)
				minDep = Math.min(minDep, currentDepth);
			if (currentNode.left != null)
				stack.add(new Pair<TreeNode, Integer>(currentNode.left, currentDepth + 1));
			if (currentNode.right != null)
				stack.add(new Pair<TreeNode, Integer>(currentNode.right, currentDepth + 1));
		}
		return minDep;
	}

	/**
	 * 广度优先 迭代
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth3(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
		stack.add(new Pair<TreeNode, Integer>(root, 1));
		int currentDepth = 0;
		while (!stack.isEmpty()) {
			Pair<TreeNode, Integer> current = stack.poll();
			TreeNode currentNode = current.getKey();
			currentDepth = current.getValue();
			if (currentNode.left == null && currentNode.right == null)
				break;
//    			return currentDepth;
			if (currentNode.left != null)
				stack.add(new Pair<TreeNode, Integer>(currentNode.left, currentDepth + 1));
			if (currentNode.right != null)
				stack.add(new Pair<TreeNode, Integer>(currentNode.right, currentDepth + 1));
		}
		return currentDepth;
//    	return 0;
	}

}
