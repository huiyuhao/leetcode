package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class M264 {
	/**
	 * 超时了
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		int index = 0, i = 1;
		while (index < n) {
			if (helper(i))
				index++;
			i++;
		}
		return --i;
	}

	public boolean helper(int num) {
		while (num != 1) {
			if (num % 2 == 0)
				num /= 2;
			else if (num % 3 == 0)
				num /= 3;
			else if (num % 5 == 0)
				num /= 5;
			else
				return false;
		}
		return true;
	}

	/**
	 * 三指针
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber2(int n) {
		int[] nums = new int[n + 1];
		int index = 1;
		int L1 = 1, L2 = 1, L3 = 1;
		nums[index++] = 1;
		while (index <= n) {
			int temp = Math.min(nums[L1] * 2, nums[L2] * 3);
			nums[index] = Math.min(temp, nums[L3] * 5);
			if (nums[index] == nums[L1] * 2)
				L1++;
			if (nums[index] == nums[L2] * 3)
				L2++;
			if (nums[index] == nums[L3] * 5)
				L3++;
			index++;
		}
		return nums[n];
	}

	/**
	 * 用PriorityQueue
	 * 是真的慢，远不如上面三指针
	 * @param n
	 * @return
	 */
	public int nthUglyNumber3(int n) {
		PriorityQueue<Long> queue = new PriorityQueue<>();
		long[] res = new long[n + 1];
		long[] base = { 2, 3, 5 };
		res[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < base.length; j++) {
				if (!queue.contains(res[i] * base[j]))
					queue.offer(res[i] * base[j]);
			}
			res[i + 1] = queue.poll();
		}
		return (int) res[n - 1];
	}
}
