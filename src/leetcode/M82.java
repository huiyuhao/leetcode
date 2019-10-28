package leetcode;

public class M82 {
	/**
	 * 思想和题解的快慢指针差不多
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode res = new ListNode(0);
		res = p;
		boolean flag = false;
		while (p.next != null) {
			while (p.next.next != null) {
				if (p.next.val == p.next.next.val) {
					p.next.next = p.next.next.next;
					flag = true;
				} else
					break;
			}
			if (flag) {
				p.next = p.next.next;
				flag = false;
			} else
				p = p.next;

		}
		return res.next;
	}

	/**
	 * 迭代，代码简洁非常好
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		if (next != null && head.val == next.val) {
			while (next != null && head.val == next.val)
				next = next.next;
			head = deleteDuplicates(next);
		} else
			head.next = deleteDuplicates(next);
		return head;
	}

	public static void main(String[] args) {
		M82 m82 = new M82();
		Integer[] nums = { 1, 1, 1, 2, 3 };
		ListNode head = ConstructList.constructList(nums);
		m82.deleteDuplicates(head);
	}
}
