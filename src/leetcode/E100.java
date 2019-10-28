package leetcode;

import java.util.ArrayList;
import java.util.List;

public class E100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		E100 e100 = new E100();
		TreeNode p = createByPreorder(new Integer[] {1,2,3});
		TreeNode q = createByPreorder(new Integer[] {1,2,3});
		System.out.println(e100.isSameTree(p, q));
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
