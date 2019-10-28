package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M98 {
	/**
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		List<Integer> temp = new ArrayList<Integer>();
		helper(root, temp);
		for (int i = 0; i < temp.size() - 1; i++) {
			if (temp.get(i) >= temp.get(i + 1))
				return false;
		}
		return true;
	}

	public void helper(TreeNode root, List<Integer> temp) {
		if (root.left != null)
			helper(root.left, temp);
		temp.add(root.val);
		if (root.right != null)
			helper(root.right, temp);
	}

	/**
	 * 递归的第二种解法
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, Integer lower, Integer upper) {
		if (root == null)
			return true;
		if (lower != null && root.val <= lower)
			return false;
		if (upper != null && root.val >= upper)
			return false;
		if (!helper(root.left, lower, root.val))
			return false;
		if (!helper(root.right, root.val, upper))
			return false;
		return true;
	}
}
