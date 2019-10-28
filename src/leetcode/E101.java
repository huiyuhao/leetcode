package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E101 {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isMirror(root.left, root.right);
	}
	
	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
		
	}
	
	
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if(t1 == null && t2 == null)
				continue;
			if(t1 == null || t2 == null)
				return false;
			if(t1.val != t2.val)
				return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		E101 e101 = new E101();
		TreeNode root = createByPreorder(new Integer[] {1,2,2,null,3,null,3});
		System.out.println(e101.isSymmetric(root));
	}
	
	/**
	 * @author CQ
	 * @date 2019.07.03
	 * @description 按照前序遍历的次序构建链表，输入格式例如：{ 1, 2, null, null, 3, null, null }
	 * @param nums
	 * @return
	 */
	public static TreeNode createByPreorder(Integer nums[]) {
		int length = nums.length;
		List<Integer> numList = new ArrayList<Integer>();
		for (int n = 0; n < length; n++)
			numList.add(nums[n]);
		return createTreeByPreorder(numList);
	}

	private static TreeNode createTreeByPreorder(List<Integer> numList) {
		if (numList == null || numList.isEmpty())
			return null;
		if (numList.get(0) == null) {
			numList.remove(0);
			return null;
		}
		TreeNode currentNode = new TreeNode(numList.get(0));
		numList.remove(0);
		currentNode.left = createTreeByPreorder(numList);
		currentNode.right = createTreeByPreorder(numList);
		return currentNode;
	}
}
