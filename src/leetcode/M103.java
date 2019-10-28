package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tier = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		queue.add(root);
		int flag = 1;
		int nextFlag = 0;
		int direction = 1;
		TreeNode cur = root;
		while (!queue.isEmpty()) {
			while (flag > 0) {
				cur = queue.poll();
				tier.add(cur.val);
				flag--;
				if (cur.left != null) {
					nextFlag++;
					queue.add(cur.left);
				}
				if (cur.right != null) {
					nextFlag++;
					queue.add(cur.right);
				}
			}
			if (direction < 0)
				Collections.reverse(tier);
			res.add(new ArrayList<>(tier));
			tier.clear();
			flag = nextFlag;
			nextFlag = 0;
			direction = -direction;
		}
		return res;
	}
}
