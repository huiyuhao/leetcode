package leetcode;

public class Two {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x =(p != null) ? p.val : 0;
			int y =(q != null) ? q.val : 0;
			int sum = x + y + carry;
			carry = sum/10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p=p.next;
			if (q != null) q=q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
//	public static void main(String[] args) {
//		ListNode l1 = new ListNode(0);
//		ListNode l2 = new ListNode(0);
//		l1.val = 2;
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
//		l2.val = 5;
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
//		Two temp = new Two();
//		ListNode result= temp.addTwoNumbers(l1, l2);
//	}
}
