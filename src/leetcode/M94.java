package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M94 {
	/**
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		return helper(root, new ArrayList<Integer>());
	}

	public List<Integer> helper(TreeNode root, List<Integer> temp) {
		if (root != null) {
			helper(root.left, temp);
			temp.add(root.val);
			helper(root.right, temp);
		}
		return temp;
	}

	/**
	 * 迭代
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return result;
		TreeNode current = root;
		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			result.add(current.val);
			current = current.right;
		}
		return result;
	}

	/**
     * 莫里斯方法  线索二叉树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	TreeNode current = root;
    	TreeNode pre;
    	while (current != null) {
    		if(current.left == null) {  //如果没有左节点，就开始依次输出
    			result.add(current.val);
    			current = current.right;
    		}
    		else {
    			pre = current.left;  
    			while(pre.right != null)
    				pre = pre.right;  //找到根节点左子树上的最右叶子节点
    			pre.right = current;  //把根节点接在  根节点左子树上的最右叶子节点  的右节点上
    			TreeNode temp = current;  //暂存一下当前根节点，因为下一步要换掉根节点，但是根节点的左子树要剪掉
    			current = current.left;  //将根节点换为  原根节点的左节点
    			temp.left = null;  //将原根节点的左字树剪掉
    		}
    	}
    	return result;
    }
}
