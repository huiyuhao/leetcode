package leetcode;

import java.util.ArrayList;
import java.util.List;

class E155 {

	private List<Integer> min;
	private List<Integer> stack;

	/** initialize your data structure here. */
	public E155() {
		min = new ArrayList<>();
		stack = new ArrayList<>();
	}

	public void push(int x) {
		stack.add(x);
		if (min.size() == 0)
			min.add(x);
		else
			min.add(Math.min(min.get(min.size() - 1), x));
	}

	public void pop() {
		stack.remove(stack.size() - 1);
		min.remove(min.size() - 1);
	}

	public int top() {
		return stack.get(stack.size() - 1);
	}

	public int getMin() {
		return min.get(min.size() - 1);
	}

	public static void main(String[] args) {
		E155 minStack = new E155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}