package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		if (root == null)
			return result;
		onePath(root, sum, currentPath, result);
		return result;
	}

	public void onePath(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> result) {
		currentPath.add(root.val);
		sum -= root.val;
		if (root.left == null && root.right == null && sum == 0) 
			result.add(new ArrayList<>(currentPath));
		if (root.left != null)
			onePath(root.left, sum, currentPath, result);
		if (root.right != null)
			onePath(root.right, sum, currentPath, result);
		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {
		M113 m113 = new M113();
		Integer[] nums = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
		TreeNode root = ConstructTree.constructTree(nums);
		System.out.println(m113.pathSum(root, 22));
	}
}
