package leetcode;

public class E67 {
    public String addBinary(String a, String b) {
    	int i = a.length() - 1, j = b.length() - 1, carry = 0;
    	StringBuilder sb = new StringBuilder();
        while (i >=0 && j >= 0) {
        	if(a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 0
        			|| a.charAt(i) == '0' && b.charAt(j) == '1' && carry == 1
        			|| a.charAt(i) == '1' && b.charAt(j) == '0' && carry == 1) {
        		sb.insert(0, '0');
        		carry = 1;
        	}else if(a.charAt(i) == '1' && b.charAt(j) == '0' && carry == 0
        			|| a.charAt(i) == '0' && b.charAt(j) == '0' && carry == 1
        			|| a.charAt(i) == '0' && b.charAt(j) == '1' && carry == 0) {
        		sb.insert(0, '1');
        		carry = 0;
        	}else if(a.charAt(i) == '0' && b.charAt(j) == '0' && carry == 0) {
        		sb.insert(0, '0');
        		carry = 0;
        	}else if(a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 1) {
        		sb.insert(0, '1');
        		carry = 1;
        	}
        	i--;
        	j--;
        }
        int k = i > j ? i - j - 1 : j - i - 1;
        String temp = i > j ? a.substring(0, i - j) : b.substring(0, j - i);
        if(carry == 0)
        	return temp + String.valueOf(sb);
        else {
        	while(k >= 0) {
        		if(temp.charAt(k) == '1' && carry == 0 || temp.charAt(k) == '0' && carry == 1) {
        			sb.insert(0, '1');
        			carry = 0;
        		}else if(temp.charAt(k) == '0' && carry == 0)
        			sb.insert(0, '0');
        		else if(temp.charAt(k) == '1' && carry == 1) {
        			sb.insert(0, '0');
        			carry = 1;
        		}
        		k--;
        	}
        	if(carry == 1)
        		sb.insert(0, '1');
        	return String.valueOf(sb);
        }
    }
    
    //还有方法可以用二进制直接做计算   a[i] - '0' 得到数字
    public String addBinary2(String a, String b) {
    	StringBuilder ans = new StringBuilder();
    	int carry = 0;
    	for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = carry;
			sum += i >= 0 ? a.charAt(i) - '0' : 0;
			sum += j >= 0 ? b.charAt(j) - '0' : 0;
			ans.append(sum % 2);
			carry = sum / 2;
		}
    	ans.append(carry == 1 ? carry : "");
    	return ans.reverse().toString();
    }
    
    //这种方法对特别长的二进制无法完成转化
    public String addBinary3(String a, String b) {
    	int sum = Integer.valueOf(a, 2) + Integer.valueOf(b, 2);
    	return Integer.toBinaryString(sum).toString();
    }
    
    public static void main(String[] args) {
		E67 e67 = new E67();
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(e67.addBinary2(a, b));
	}
}
