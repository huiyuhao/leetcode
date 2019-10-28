package leetcode;

public class E168 {
	public String convertToTitle(int n) {
		char[] ch = new char[27];
		ch[0] = 'Z';
		for (int i = 1; i < ch.length; i++) {
			ch[i] = (char) ('A' + i - 1);
		}
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(ch[n % 26]);
			n = n % 26 == 0 ? n / 26 - 1 : n / 26;
		}
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		E168 e168 = new E168();
		System.out.println(e168.convertToTitle(53));
	}
}
