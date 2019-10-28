package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

	private int size;
	private Queue<Integer> queue;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.size = size;
		queue = new LinkedList<Integer>();
	}

	public double next(int val) {
		if (size == 0)
			return 0;
		if (queue.size() == size)
			queue.poll();
		queue.add(val);
		int sum = 0;
		for (Integer i : queue)
			sum += i;
		return sum / (double) queue.size();
	}
}

class MovingAverage2 {

	private int size;
	private Queue<Integer> queue;
	private int sum;

	/** Initialize your data structure here. */
	public MovingAverage2(int size) {
		this.size = size;
		queue = new LinkedList<Integer>();
		sum = 0;
	}

	public double next(int val) {
		if (size == 0)
			return 0;
		if (queue.size() == size)
			sum -= queue.poll();
		queue.add(val);
		sum += val;
		return sum / (double) queue.size();
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */
