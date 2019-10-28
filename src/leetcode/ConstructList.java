package leetcode;

public class ConstructList {
	public static ListNode constructList(Integer[] nums){
		ListNode result = new ListNode(0);
		ListNode temp = result;
		for (int i = 0; i < nums.length; i++) {
			temp.next = new ListNode(nums[i]);
			temp = temp.next;
		}
		return result.next;
	}
}
