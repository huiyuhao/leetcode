package leetcode;

public class E160 {
	/**
	 * O(n * m) 的时间复杂度，很慢了
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode helpA = headA;
		ListNode helpB = headB;
		while (helpA != null) {
			while (helpB != null) {
				if (helpA == helpB)
					return helpA;
				helpB = helpB.next;
			}
			helpB = headB;
			helpA = helpA.next;
		}
		return null;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode helpA = headA;
		ListNode helpB = headB;
		while (helpA != null && helpB != null) {
			if (helpA == helpB)
				return helpA;
			helpA = helpA.next;
			helpB = helpB.next;
		}
		if (helpA == null)
			helpA = headB;
		else
			helpB = headA;
		while (helpA != null && helpB != null) {
			if (helpA == helpB)
				return helpA;
			helpA = helpA.next;
			helpB = helpB.next;
		}
		if (helpA == null)
			helpA = headB;
		else
			helpB = headA;
		while (helpA != null && helpB != null) {
			if (helpA == helpB)
				return helpA;
			helpA = helpA.next;
			helpB = helpB.next;
		}
		return null;
	}

	/**
	 * 上面方法的代码优化，思路是一样的
	 * 大神的代码思路
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode helpA = headA;
		ListNode helpB = headB;
		while (helpA != helpB) {
			helpA = helpA == null ? headB : helpA.next;
			helpB = helpB == null ? headA : helpB.next;
			//下面这样做是不对的，会错过两个链表不相交的情况，导致死循环
			//helpA = helpA.next == null ? headB : helpA.next;
			//helpB = helpB.next == null ? headA : helpB.next;
		}
		return helpA;
	}
}
