package leetcode;

import java.util.Stack;

public class M739 {
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		if (T.length == 0)
			return res;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> site = new Stack<>();
		stack.push(T[0]);
		site.push(0);
		for (int i = 1; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > stack.peek()) {
				stack.pop();
				int index = site.pop();
				res[index] = i - index;
			}
			stack.push(T[i]);
			site.push(i);
		}
		return res;
	}

	/**
	 * 用栈记录下标，就不用两个栈了
	 * 
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures2(int[] T) {
		int[] res = new int[T.length];
		if (T.length == 0)
			return res;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int index = stack.pop();
				res[index] = i - index;
			}
			stack.push(i);
		}
		return res;
	}

	/**
	 * 倒着来
	 * 
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures3(int[] T) {
		int len = T.length;
		int[] res = new int[len];
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < res.length; j += res[j]) {
				if (T[i] < T[j]) {
					res[i] = j - i;
					break;
				} else if (res[j] == 0)
					break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M739 m739 = new M739();
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = m739.dailyTemperatures3(T);
		for (int i = 0; i < T.length; i++)
			System.out.print(res[i] + " ");
	}
}
