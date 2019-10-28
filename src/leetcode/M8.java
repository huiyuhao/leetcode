package leetcode;

public class M8 {
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < ch.length && ch[i] == ' ')
        	i++;
        if (i < ch.length && (ch[i] == '+' || ch[i] == '-')) {
        	sb.append(ch[i]);
        	i++;
        }
        while (i < ch.length && Character.isDigit(ch[i])) {
        	sb.append(ch[i]);
        	i++;
        }
        if (i == 0 || sb.length() < 1 || !Character.isDigit(sb.charAt(sb.length() - 1)))
        	return 0;
		else
			try {
				return Integer.valueOf(sb.toString());
			} catch (NumberFormatException e) {
				if(sb.charAt(0) == '-')
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}
    }
    
    public static void main(String[] args) {
    	String str = " -34 --5";
		M8 m8 = new M8();
		System.out.println(m8.myAtoi(str));
	}
}
