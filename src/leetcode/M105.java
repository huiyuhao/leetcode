package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class M105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0)
			return null;
		int len = preorder.length;
		int indexPre = 0;
		TreeNode root = new TreeNode(preorder[indexPre]);
		for (int i = 0; i < len; i++)
			if (inorder[i] == preorder[indexPre]) {
				helper(root, preorder, inorder, indexPre + 1, i, 0, len);
				break;
			}
		return root;
	}

	/**
	 * 存在一个问题，在中序遍历中找到根节点的位置每次都得遍历中序遍历的数组去寻找
	 * 
	 * @param root
	 * @param preorder
	 * @param inorder
	 * @param indexPre
	 * @param indexIn
	 * @param left
	 * @param right
	 * @return
	 */
	public int helper(TreeNode root, int[] preorder, int[] inorder, int indexPre, int indexIn, int left, int right) {
		if (indexPre >= preorder.length)
			return indexPre;
		for (int i = left; i < indexIn; i++) {
			if (inorder[i] == preorder[indexPre]) {
				root.left = new TreeNode(preorder[indexPre]);
				indexPre = helper(root.left, preorder, inorder, indexPre + 1, i, left, indexIn + 1);
				break;
			}
		}
		if (indexPre >= preorder.length)
			return indexPre;
		for (int i = indexIn + 1; i < right; i++) {
			if (inorder[i] == preorder[indexPre]) {
				root.right = new TreeNode(preorder[indexPre]);
				indexPre = helper(root.right, preorder, inorder, indexPre + 1, i, indexIn + 1, right);
				break;
			}
		}
		return indexPre;
	}

	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0)
			return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		int len = preorder.length;
		int indexPre = 0;
		TreeNode root = new TreeNode(preorder[indexPre]);
		for (int i = 0; i < len; i++)
			if (inorder[i] == preorder[indexPre]) {
				buildTreeHelper(root, preorder, inorder, indexPre + 1, i, 0, len, map);
				break;
			}
		return root;
	}

	/**
	 * 用一个HashMap把中序遍历数组的每个元素的值和下标存起来，这样寻找根节点的位置就可以直接得到了。
	 * 
	 * @param root
	 * @param preorder
	 * @param inorder
	 * @param indexPre
	 * @param indexIn
	 * @param left
	 * @param right
	 * @param map
	 * @return
	 */
	public int buildTreeHelper(TreeNode root, int[] preorder, int[] inorder, int indexPre, int indexIn, int left,
			int right, HashMap<Integer, Integer> map) {
		if (indexPre >= preorder.length)
			return indexPre;
		int index = map.get(preorder[indexPre]);
		if (index <= indexIn && index >= left) {
			root.left = new TreeNode(preorder[indexPre]);
			indexPre = buildTreeHelper(root.left, preorder, inorder, indexPre + 1, index, left, indexIn + 1, map);
		}
		if (indexPre >= preorder.length)
			return indexPre;
		index = map.get(preorder[indexPre]);
		if (index > indexIn && index < right) {
			root.right = new TreeNode(preorder[indexPre]);
			indexPre = buildTreeHelper(root.right, preorder, inorder, indexPre + 1, index, indexIn + 1, right, map);
		}
		return indexPre;
	}

	/**
	 * 这样就优美了很多
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree3(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return build(preorder, inorder, 0, inorder.length, 0, map);
	}

	public TreeNode build(int[] preorder, int[] inorder, int left, int right, int p, HashMap<Integer, Integer> map) {
		if (left == right)
			return null;
		TreeNode root = new TreeNode(preorder[p]);
		int site = map.get(preorder[p]);
		int leftNum = site - left;
		root.left = build(preorder, inorder, left, site, p + 1, map);
		root.right = build(preorder, inorder, site + 1, right, p + leftNum + 1, map);
		return root;
	}

	/**
	 * 用栈的方法
	 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	publiSc TreeNode buildTree4(int[] preorder, int[] inorder) {
		int pp = 0, pi = 1;
		Stack<Integer> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[pp++]);
		TreeNode cur = root;
		while (pp < preorder.length) {
			if (preorder[pp] != inorder[pi]) {
				stack.push(inorder[pi++]);
			} else if (!stack.isEmpty()) {
				cur.left = new TreeNode(stack.pop());
				cur = cur.left;
			} else
				cur.right = new TreeNode(preorder[pp]);
			pp++;
		}
		return root;
	}

	public static void main(String[] args) {
		M105 m105 = new M105();
		int[] preorder = { 3, 1, 2, 4 };
		int[] inorder = { 1, 2, 3, 4 };
		m105.buildTree3(preorder, inorder);
	}
}
