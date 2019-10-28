package leetcode;

public class E203 {
	/**
	 * 迭代
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements3(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode res = new ListNode(0);
		res.next = head;
		while (head.next != null) {
			if (head.next.val == val)
				head.next = head.next.next;
			else
				head = head.next;
		}
		if (res.next.val == val)
			res.next = res.next.next;
		return res.next;
	}

	/**
	 * 优化迭代代码
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		res.next = head;
		while (cur.next != null) {
			if (cur.next.val == val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return res.next;
	}
	
	public static void main(String[] args) {
		E203 e203 = new E203();
		Integer[] nums = { 6, 6, 6, 6, 6 };
		ListNode head = ConstructList.constructList(nums);
		head = e203.removeElements2(head, 6);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
