package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return res;
		queue.add(root);
		TreeNode current = root;
		int flag = 1;
		int nextFlag = 0;
		while (!queue.isEmpty()) {
			while (flag > 0) {
				current = queue.poll();
				temp.add(current.val);
				flag--;
				if (current.left != null) {
					queue.add(current.left);
					nextFlag++;
				}
				if (current.right != null) {
					queue.add(current.right);
					nextFlag++;
				}
			}
			res.add(new ArrayList<>(temp));
			temp.clear();
			flag = nextFlag;
			nextFlag = 0;
		}
		return res;
	}

	/**
	 * ตÝน้
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(root, res, 0);
		return res;
	}

	public void helper(TreeNode root, List<List<Integer>> res, int level) {
		if (root == null)
			return;
		if (res.size() <= level)
			res.add(new ArrayList<Integer>());
		res.get(level).add(root.val);
		helper(root.left, res, level + 1);
		helper(root.right, res, level + 1);
	}

	public static void main(String[] args) {
		M102 m102 = new M102();
		Integer[] nums = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = ConstructTree.constructTree(nums);
		m102.levelOrder(root);
	}
}
