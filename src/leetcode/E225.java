package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class E225 {
	class MyStack {

		Queue<Integer> queue;
		Queue<Integer> helper;

		/** Initialize your data structure here. */
		public MyStack() {
			queue = new LinkedList<Integer>();
			helper = new LinkedList<Integer>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			queue.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			int res = 0;
			while (!queue.isEmpty()) {
				res = queue.poll();
				if (!queue.isEmpty())
					helper.add(new Integer(res));
			}
			queue = new LinkedList<>(helper);
			helper.clear();
			return res;
		}

		/** Get the top element. */
		public int top() {
			int res = 0;
			while (!queue.isEmpty()) {
				res = queue.poll();
				helper.add(new Integer(res));
			}
			queue = new LinkedList<>(helper);
			helper.clear();
			return res;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return queue.isEmpty();
		}
	}

	/**
	 * 用一个队列实现，碉堡了
	 * 
	 * @author yanghao
	 *
	 */
	class MyStack2 {

		Queue<Integer> queue;

		/** Initialize your data structure here. */
		public MyStack2() {
			queue = new LinkedList<Integer>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			queue.add(x);
			int sz = queue.size();
			for (int i = 1; i < sz; i++) {
				queue.add(queue.poll());
			}
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			return queue.poll();
		}

		/** Get the top element. */
		public int top() {
			return queue.peek();
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return queue.isEmpty();
		}
	}
}
