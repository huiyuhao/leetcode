package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E589 {
	/**
	 * µÝ¹é
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorder(Node root) {
		return helper(root, new ArrayList<>());
	}

	public List<Integer> helper(Node root, List<Integer> temp) {
		if (root != null) {
			temp.add(root.val);
			for (Node child : root.children)
				helper(child, temp);
		}
		return temp;
	}

	/**
	 * µü´ú
	 * @param root
	 * @return
	 */
	public List<Integer> preorder2(Node root) {
		Stack<Node> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			result.add(temp.val);
			for (int i = temp.children.size() - 1; i >=  0; i--) {
				stack.push(temp.children.get(i));
			}
		}
		return result;
	}
	
}
