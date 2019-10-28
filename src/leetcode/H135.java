package leetcode;

import java.util.ArrayList;
import java.util.List;

public class H135 {
	/**
	 * 这个300ms
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		int len = ratings.length;
		if (len < 2)
			return len;
		List<Integer> peek = new ArrayList<Integer>();
		List<Integer> valley = new ArrayList<Integer>();
		List<Integer> plain = new ArrayList<Integer>();
		int[] nums = new int[len];
		int count = 0;
		if (ratings[1] > ratings[0]) {
			valley.add(0);
			nums[0] = 1;
		} else if (ratings[1] < ratings[0])
			peek.add(0);
		else {
			plain.add(0);
			nums[0] = 1;
		}
		for (int i = 1; i < ratings.length - 1; i++) {
			if ((ratings[i] > ratings[i - 1] && ratings[i] >= ratings[i + 1])
					|| (ratings[i] >= ratings[i - 1] && ratings[i] > ratings[i + 1]))
				peek.add(i);
			else if ((ratings[i] < ratings[i - 1] && ratings[i] <= ratings[i + 1])
					|| (ratings[i] <= ratings[i - 1] && ratings[i] < ratings[i + 1])) {
				valley.add(i);
				nums[i] = 1;
			} else if (ratings[i] == ratings[i - 1] && ratings[i] == ratings[i + 1]) {
				plain.add(i);
				nums[i] = 1;
			}
		}
		if (ratings[len - 1] < ratings[len - 2]) {
			valley.add(len - 1);
			nums[len - 1] = 1;
		} else if (ratings[len - 1] > ratings[len - 2])
			peek.add(len - 1);
		else {
			plain.add(len - 1);
			nums[len - 1] = 1;
		}
		for (int i = 0; i < valley.size(); i++) {
			int cur = 1;
			int left = valley.get(i) - 1;
			while (left >= 0 && nums[left] == 0 && !peek.contains(left)) {
				nums[left] = ++cur;
				left--;
			}
			cur = 1;
			int right = valley.get(i) + 1;
			while (right < len && nums[right] == 0 && !peek.contains(right)) {
				nums[right] = ++cur;
				right++;
			}
		}
		for (int i = 0; i < peek.size(); i++) {
			int left = peek.get(i) - 1;
			int right = peek.get(i) + 1;
			if (peek.get(i) == 0 || peek.contains(left))
				nums[peek.get(i)] = nums[peek.get(i) + 1] + 1;
			else if (peek.get(i) == len - 1 || peek.contains(right))
				nums[peek.get(i)] = nums[peek.get(i) - 1] + 1;
			else
				nums[peek.get(i)] = Math.max(nums[peek.get(i) - 1], nums[peek.get(i) + 1]) + 1;
		}
		for (int i = 0; i < nums.length; i++)
			count += nums[i];
		return count;
	}

	/**
	 * 这个4ms,上下这两个方法都是自己想出來写的，论思想的重要性，磨刀不误砍柴工，还是得多想一会儿，不能着急做
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy2(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;
		int count = 1, cur = 1, peek = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count += ++cur;
				peek = i;
			} else if (ratings[i] < ratings[i - 1]) {
				count += --cur;
				if (cur <= 0 && (i == ratings.length - 1 || i + 1 < ratings.length && ratings[i] <= ratings[i + 1])) {
					count += (i - peek + 1) * (1 - cur);
					cur = 1;
				} else if (cur > 0
						&& (i == ratings.length - 1 || i + 1 < ratings.length && ratings[i] <= ratings[i + 1])) {
					count += (i - peek) * (1 - cur);
					cur = 1;
				}
			} else {
				peek = i;
				cur = 1;
				count += cur;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		H135 h135 = new H135();
		int[] ratings = { 1, 2, 2 };
		int sum = h135.candy2(ratings);
		System.out.println(sum);
	}
}
