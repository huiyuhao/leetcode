package leetcode;

import java.util.HashMap;

public class M106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = postorder.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return helper(inorder, postorder, 0, len, len - 1, map);
	}

	public TreeNode helper(int[] inorder, int[] postorder, int left, int right, int index,
			HashMap<Integer, Integer> map) {
		if (left == right)
			return null;
		TreeNode root = new TreeNode(postorder[index]);
		int site = map.get(root.val);
		int rightNum = right - site - 1;
		root.right = helper(inorder, postorder, site + 1, right, index - 1, map);
		root.left = helper(inorder, postorder, left, site, index - 1 - rightNum, map);
		return root;
	}
	
}
