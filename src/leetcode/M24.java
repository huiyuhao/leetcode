package leetcode;

public class M24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode n1 = head;
		ListNode n2 = head.next;
		ListNode res = head.next;
		while (n2 != null) {
			helper(n1, n2);
			if (n1.next != null && n1.next.next != null) {
				ListNode temp = n1.next;
				n1.next = n1.next.next;
				n1 = temp;
				n2 = temp.next;
			} else {
				break;
			}
		}
		return res;
	}

	public void helper(ListNode n1, ListNode n2) {
		n1.next = n2.next;
		n2.next = n1;
	}

	/**
	 * 递归
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs2(next.next);
		next.next = head;
		return next;
	}

	/**
	 * 迭代（大神解法）
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs3(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while (temp.next != null && temp.next.next != null) {
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}

	public static void main(String[] args) {
		M24 m24 = new M24();
		Integer[] nums = { 1, 2, 3 };
		ListNode head = ConstructList.constructList(nums);
		ListNode res = head.next;
		m24.swapPairs(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
