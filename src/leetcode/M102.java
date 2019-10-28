package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		if (root == null)
			return res;
		stack.add(root);
		TreeNode current = root;
		int flag = 1;
		int nextFlag = 0;
		while (!stack.isEmpty()) {
			while (flag > 0) {
				current = stack.poll();
				temp.add(current.val);
				flag--;
				if (current.left != null) {
					stack.add(current.left);
					nextFlag++;
				}
				if (current.right != null) {
					stack.add(current.right);
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
	
	public static void main(String[] args) {
		M102 m102 = new M102();
		Integer[] nums = {3,9,20,null,null,15,7};
		TreeNode root = ConstructTree.constructTree(nums);
		m102.levelOrder(root);
	}
}
