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

	public String decodeString2(String s) {
		Stack<String> stackStr = new Stack<String>();
		Stack<Integer> stackInt = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int curNum = 0;
		for (Character c : s.toCharArray()) {
			if (c <= '9' && c >= '0')
				curNum = curNum * 10 + c - '0';
			else if (c == '[') {
				stackStr.push(sb.toString());
				sb = new StringBuilder();
				stackInt.push(curNum);
				curNum = 0;
			} else if (c == ']') {
				StringBuilder sbTemp = new StringBuilder();
				int numTemp = stackInt.pop();
				for (int i = 0; i < numTemp; i++) {
					sbTemp.append(sb);
				}
				sb = new StringBuilder(stackStr.pop() + sbTemp);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * µÝ¹é¸ãÆð
	 * 
	 * @param s
	 * @return
	 */
	public String decodeString3(String s) {
		return helper(s, 0)[0];
	}

	public String[] helper(String s, int i) {
		StringBuilder sb = new StringBuilder();
		int curNum = 0;
		while (i < s.length()) {
			if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
				curNum = curNum * 10 + s.charAt(i) - '0';
			else if (s.charAt(i) == '[') {
				String[] temp = helper(s, i + 1);
				i = Integer.valueOf(temp[0]);
				for (int j = 0; j < curNum; j++)
					sb.append(temp[1]);
				curNum = 0;
			} else if (s.charAt(i) == ']')
				return new String[] { String.valueOf(i), sb.toString() };
			else
				sb.append(s.charAt(i));
			i++;
		}
		return new String[] { sb.toString() };
	}

	public static void main(String[] args) {
		M394 m394 = new M394();
		System.out.println(m394.decodeString2("3[a]2[bc]"));
	}
}
