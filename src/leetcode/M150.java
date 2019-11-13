package leetcode;

import java.util.Stack;

public class M150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				int cur = 0;
				switch (tokens[i]) {
				case "+":
					cur = a + b;
					break;
				case "-":
					cur = a - b;
					break;
				case "*":
					cur = a * b;
					break;
				case "/":
					cur = a / b;
					break;
				}
				stack.push(cur);
			} else {
//				stack.push(Integer.valueOf(tokens[i])); 
				stack.push(Integer.parseInt(tokens[i]));
//				int cur = 0;
//				if (tokens[i].charAt(0) == '-') {
//					for (int j = 1; j < tokens[i].length(); j++)
//						cur = cur * 10 + (tokens[i].charAt(j) - '0');
//					cur = -cur;
//				} else
//					for (int j = 0; j < tokens[i].length(); j++)
//						cur = cur * 10 + (tokens[i].charAt(j) - '0');
//				stack.push(cur);
			}
		}
		return stack.pop();
	}

	public int evalRPN2(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String str : tokens) {
			switch (str) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				int num1 = stack.pop();
				stack.push(stack.pop() / num1);
				break;
			default:
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		M150 m150 = new M150();
		String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(m150.evalRPN2(tokens));
	}
}
