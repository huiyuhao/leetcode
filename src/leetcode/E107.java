package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		List<List<Integer>> realRes = new ArrayList<List<Integer>>();
    	for (int i = res.size() - 1; i >= 0 ; i--) {
			realRes.add(res.get(i));
		}
    	return realRes;
    }
}
