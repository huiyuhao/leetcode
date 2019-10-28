package leetcode;

public class E21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode result = new ListNode(0);
    	ListNode temp = result;
    	while(l1 != null && l2 != null) {
    		if(l1.val > l2.val) {
    			temp.next = l2;
    			temp = temp.next;
    			l2 = l2.next;
    		}else {
    			temp.next = l1;
    			temp = temp.next;
    			l1 = l1.next;
    		}
    	}
    	if(l1 != null)
    		temp.next = l1;
    	if(l2 != null)
    		temp.next = l2;
    	return result.next;
    }
    
    public static void main(String[] args) {
		E21 e21 = new E21();
		Integer nums1[] = {1,2,4};
		Integer nums2[] = {1,3,4};
		ListNode l1 = ConstructList.constructList(nums1);
		ListNode l2 = ConstructList.constructList(nums2);
		ListNode result = e21.mergeTwoLists(l1, l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
		
	}
}
