package leetcode;

public class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head.next == null && n == 1)
    		return null;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pointer = result;
        while(helper(pointer, n).next != null) {
        	pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return result.next; 
    }
    
    public ListNode helper(ListNode node, int n) {
    	while(n != 0) {
        	n--;
        	node = node.next;
        }
    	return node;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;;
    	ListNode first = dummy;
    	ListNode second = dummy;
    	for (int i = 0; i < n + 1; i++) {
			first = first.next;
		}
    	while(first != null) {
    		first = first.next;
    		second = second.next;
    	}
    	second.next = second.next.next;
    	return dummy.next;
    }
    
}
