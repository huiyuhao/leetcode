package leetcode;

import java.util.Stack;

public class H224 {
	public int calculate(String s) {
		return helper(s, 0)[0];
	}

	/**
	 * �Լ�д�ģ��õĵݹ飬��������ʱ�䳬��40%
	 * @param s
	 * @param begin
	 * @return
	 */
	public int[] helper(String s, int begin) {
		// res[0]Ϊ��������֣�res[1]Ϊָ��ľ���λ�ã�����λ�õĴ洢��Ϊ��������������ɺ�������')'������λ��
		int[] res = { 0, begin };
		// flag������ʾ��һ��������'+'����'-'
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ' ')
				continue;
			else if (cur == '(') {
				// ��Ϊ��������substring,���뷽�����ָ��λ�������λ�ã�������begin + i + 1���¾���λ��
				int[] temp = helper(s.substring(i + 1), begin + i + 1); 
				if (flag)
					res[0] += temp[0];
				else
					res[0] -= temp[0];
				i = temp[1] - begin; // ��Ϊ֮�������Ҫ�����λ�ý��У�����Ҫ�Ծ���λ�ü�ȥ��ǰ')'��Ӧ��'('�ľ���λ�ã��õ���Ҫʹ�õ����λ��
			} else if (cur == ')') {
				res[1] += i; // �������������ʱ�򣬸���һ�¾���λ��
				return res;
			} else if (cur == '+')
				flag = true;
			else if (cur == '-')
				flag = false;
			else {
				int num = 0;
				while (i < s.length() && (s.charAt(i) <= '9' && s.charAt(i) >= '0' || s.charAt(i) == ' ')) {
					if (s.charAt(i) == ' ') {
						i++;
						continue;
					}
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;

				if (flag)
					res[0] += num;
				else
					res[0] -= num;
			}
		}
		return res;
	}
	
	/**
	 * ��ʵ����'('��')'���־�Ӧ���뵽��ջ�����ģ������Ȼߣ��һ�ѵݹ�
	 * @param s
	 * @return
	 */
	public int calculate2(String s) {
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while(i < s.length()) {
			
			
		}
		
		
		return helper(s, 0)[0];
	}

	public static void main(String[] args) {
		H224 h224 = new H224();
		String s = "1-(5)";
		System.out.println(h224.calculate(s));
	}
}
