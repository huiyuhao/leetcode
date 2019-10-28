package leetcode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class H23 {
	/**
	 * 自己第一次写的，比较朴素
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
		int min = Integer.MAX_VALUE;
		ListNode res = new ListNode(0);
		ListNode p = res;
		boolean flag = false;
		while (true) {
			flag = false;
			int i = 0;
			int minIndex = 0;
			while (i < lists.length) {
				if (lists[i] == null) {
					i++;
					continue;
				}
				if (lists[i].val < min) {
					flag = true;
					min = lists[i].val;
					minIndex = i;
				}
				i++;
			}
			if (!flag)
				break;
			lists[minIndex] = lists[minIndex].next;
			p.next = new ListNode(min);
			p = p.next;
			min = Integer.MAX_VALUE;
		}
		return res.next;
	}

	/**
	 * 清华大佬的代码 也是优先队列
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		queue.addAll(Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toList()));
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null)
				queue.add(node.next);
		}
		return dummy.next;
	}

	/**
	 * 分治算法
	 * 包含了递归
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		if (lists.length == 2)
			return mergeTwoLists(lists[0], lists[1]);
		int mid = lists.length / 2;
		ListNode[] l1 = new ListNode[mid];
		for (int i = 0; i < mid; i++) {
			l1[i] = lists[i];
		}
		ListNode[] l2 = new ListNode[lists.length - mid];
		for (int i = mid, j = 0; i < lists.length; i++, j++) {
			l2[j] = lists[i];
		}
		return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null;
		if (l1.val < l2.val) {
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
		} else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}
		return head;
	}

	/**
	 * 自己写用优先队列
	 * 不如分治算法快
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists4(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		ListNode res = new ListNode(0);
		ListNode p = res;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		while (!pq.isEmpty()) {
			ListNode cur = pq.poll();
			p.next = cur;
			p = p.next;
			if (cur.next != null)
				pq.add(cur.next);
		}
		return res.next;
	}

	public static void main(String[] args) {
		H23 h23 = new H23();
		Integer[] nums1 = { 1, 4, 5 };
		Integer[] nums2 = { 1, 3, 4 };
		Integer[] nums3 = { 2, 6 };
		ListNode l1 = ConstructList.constructList(nums1);
		ListNode l2 = ConstructList.constructList(nums2);
		ListNode l3 = ConstructList.constructList(nums3);
		ListNode[] lists = { l1, l2, l3 };
		ListNode res = h23.mergeKLists(lists);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
