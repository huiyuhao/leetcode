package leetcode;

public class E415 {
    public String addStrings(String num1, String num2) {
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
        	int sum = 0;
        	sum += carry;
        	sum += i >= 0 ? num1.charAt(i) - '0' : 0;
        	sum += j >= 0 ? num2.charAt(j) - '0' : 0;
        	carry = sum / 10;
        	sum %= 10;
        	sb.append(sum);
        }
        if(carry != 0) {
        	sb.append(carry);
        	carry = 0;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
		E415 e415 = new E415();
		String num1 = "9", num2 = "99";
		System.out.println(e415.addStrings(num1, num2));
	}
}
