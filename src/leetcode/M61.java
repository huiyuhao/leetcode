package leetcode;

public class M61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		ListNode p = head;
		int len = 1;
		while (p.next != null) {
			len++;
			p = p.next;
		}
		k = k % len;
		p.next = head;
		int index = len - k;
		while (index > 0) {
			head = head.next;
			p = p.next;
			index--;
		}
		p.next = null;
		return head;
	}

}
