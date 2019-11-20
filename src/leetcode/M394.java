package leetcode;

import java.util.Stack;

public class M394 {
	public String decodeString(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ']') {
				stack.push(s.charAt(i));
			} else {
				StringBuilder sb = new StringBuilder();
				while (stack.peek() != '[')
					sb.append(stack.pop());
				sb.reverse();
				stack.pop();
				StringBuilder sbNum = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
					sbNum.append(stack.pop());
				int num = Integer.valueOf(sbNum.reverse().toString());
				String str = "";
				for (int j = 0; j < num; j++)
					str += sb;
				for (int j = 0; j < str.length(); j++)
					stack.push(str.charAt(j));
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty())
			res.append(stack.pop());
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		M394 m394 = new M394();
		System.out.println(m394.decodeString("3[a]2[bc]"));
	}
}
