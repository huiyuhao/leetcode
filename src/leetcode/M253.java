package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class M253 {
	/**
	 * 优先队列相当于是个堆了，重写还是不容易
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		pq.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= pq.peek()[1])
				pq.poll();
			pq.add(intervals[i]);
		}
		return pq.size();
	}

	/**
	 * 一样的思路，比较器换了种写法
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms2(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		pq.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= pq.peek())
				pq.poll();
			pq.add(intervals[i][1]);
		}
		return pq.size();
	}

	/**
	 * 这个最屌，有序化
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms3(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		int[] begin = new int[intervals.length];
		int[] end = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			begin[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(begin);
		Arrays.sort(end);
		int endPoint = 0;
		int usedRoom = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (begin[i] < end[endPoint])
				usedRoom++;
			else
				endPoint++;
		}
		return usedRoom;
	}
}
