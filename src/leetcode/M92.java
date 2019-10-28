package leetcode;

import java.util.Stack;

public class M92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		Stack<Integer> stack = new Stack<>();
		int index = 1;
		ListNode begin = head;
		ListNode p = head;
		while (index <= n) {
			if (index >= m && index <= n)
				stack.push(p.val);
			if (index == m)
				begin = p;
			index++;
			p = p.next;
		}
		index = m;
		while (index <= n) {
			int cur = stack.pop();
			begin.val = cur;
			begin = begin.next;
			index++;
		}
		return head;
	}

	/**
	 * 用递归回溯来反转
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		left = head;
		stop = false;
		helper(head, m, n);
		return head;
	}

	private boolean stop;
	private ListNode left;

	public void helper(ListNode right, int m, int n) {
		if (n == 1)
			return;
		right = right.next;
		if (m > 1)
			this.left = this.left.next;
		helper(right, m - 1, n - 1);
		if (left == right || right.next == left)
			stop = true;
		if (!stop) {
			int temp = left.val;
			left.val = right.val;
			right.val = temp;
			left = left.next;
		}
	}
}
