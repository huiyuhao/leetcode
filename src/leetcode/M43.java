package leetcode;

public class M43 {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int carry = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num1.length(); i++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder temp = new StringBuilder();
			int sti1 = num1.charAt(num1.length() - 1 - i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int sti2 = num2.charAt(num2.length() - 1 - j) - '0';
				int pro = sti1 * sti2 + carry;
				if (pro / 10 != 0) {
					carry = pro / 10;
					pro %= 10;
				} else {
					carry = 0;
				}
				sb.append(pro);
			}
			if (carry != 0) {
				sb.append(carry);
				carry = 0;
			}
			sb.reverse();
			if (result.length() != 0) {
				for (int j = 1; j <= i; j++) {
					temp.append(result.charAt(result.length() - j));
				}
			}
			for (int j = sb.length() - 1, k = result.length() - 1 - i; j >= 0 || k >= 0; j--, k--) {
				int sum = 0;
				sum += carry;
				sum += j >= 0 ? sb.charAt(j) - '0' : 0;
				sum += k >= 0 ? result.charAt(k) - '0' : 0;
				temp.append(sum % 10);
				carry = sum / 10;
			}
			if (carry != 0) {
				temp.append(carry);
				carry = 0;
			}
			temp.reverse();
			result = temp;
		}
		return String.valueOf(result);
	}

	
	/**
	 * 上面方法有点慢，40多ms，看了3ms神的，先不着急进位，把每次乘法都存下来，详见代码
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply2(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int len1 = num1.length();
		int len2 = num2.length();
		int[] num = new int[len1 + len2];
		for (int i = len1 -1; i >= 0 ; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = len2 -1; j >= 0 ; j--) {
				int n2 = num2.charAt(j) - '0';
				num[len1 + len2 - 2 - i - j] += n1 * n2;
			}
		}
		int carry = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] += carry;
			carry = num[i] / 10;
			num[i] %= 10;
		}
		int l = len1 + len2 -1;
		while(num[l] == 0)
			l--;
		StringBuilder sb = new StringBuilder();
		for (int i = l; i >= 0; i--) {
			sb.append(num[i]);
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		M43 m43 = new M43();
		String num1 = "2";
		String num2 = "3";
		System.out.println(m43.multiply2(num1, num2));
	}
}
