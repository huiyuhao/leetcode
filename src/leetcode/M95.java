package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M95 {
	//这题思路也太崎岖了
	public List<TreeNode> generateTrees(int n) {
		if(n == 0)
			return new ArrayList<TreeNode>();
		return helper(1, n);
	}

	public List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(left > right) {
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftTree = helper(left, i - 1);
			List<TreeNode> rightTree = helper(i + 1, right);
			for (TreeNode l : leftTree) {
				for (TreeNode r : rightTree) {
					TreeNode current = new TreeNode(i);
					current.left = l;
					current.right = r;
					res.add(current);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M95 m95 = new M95();
		m95.generateTrees(3);
	}
}
