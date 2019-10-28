package leetcode;

import java.util.Stack;

public class E206 {
	/**
	 * 迭代
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(new ListNode(head.val));
			head = head.next;
		}
		ListNode res = new ListNode(0);
		ListNode p = res;
		while (!stack.isEmpty()) {
			p.next = stack.pop();
			p = p.next;
		}
		return res.next;
	}

	/**
	 * 迭代 这个比较精妙
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList3(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}

	/**
	 * 递归
	 * 思想和上面迭代差不多
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	public static void main(String[] args) {
		E206 e206 = new E206();
		Integer[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = ConstructList.constructList(nums);
		e206.reverseList3(head);
	}
}
