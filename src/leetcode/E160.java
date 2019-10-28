package leetcode;

public class E160 {
	/**
	 * O(n * m) ��ʱ�临�Ӷȣ�������
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
	 * ���淽���Ĵ����Ż���˼·��һ����
	 * ����Ĵ���˼·
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
			//�����������ǲ��Եģ��������������ཻ�������������ѭ��
			//helpA = helpA.next == null ? headB : helpA.next;
			//helpB = helpB.next == null ? headA : helpB.next;
		}
		return helpA;
	}
}
