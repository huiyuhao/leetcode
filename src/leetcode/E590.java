package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E590 {
	/**
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
		return helper(root, new ArrayList<>());
	}

	public List<Integer> helper(Node root, List<Integer> temp) {
		if (root != null) {
			for (Node child : root.children)
				helper(child, temp);
			temp.add(root.val);
		}
		return temp;
	}

	/**
	 * 迭代
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorder2(Node root) {
		List<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		if (root == null)
			return result;
		stack.add(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			//这一步是往链表头插，实现后序
			result.add(0, current.val);
			for (Node child : current.children)
				stack.push(child);
		}
		return result;
	}
	
	/**
	 * 迭代  双栈法
	 * @param root
	 * @return
	 */
	public List<Integer> postorder3(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		s1.push(root);
		while(!s1.isEmpty()) {
			Node current = s1.pop();
			s2.push(current);
			for (Node child : current.children) {
				s1.push(child);
			}
		}
		while(!s2.isEmpty()) {
			result.add(s2.pop().val);
		}
		return result;
	}
}
