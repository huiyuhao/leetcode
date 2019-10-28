package leetcode;

public class E38 {
	public String countAndSay(int n) {
		String start = "1", result = "1";
		char index = '1';
		int num = 0;
		for (int i = 0; i < n - 1; i++) {
			result = "";
			for (int j = 0; j < start.length(); j++) {
				if (start.charAt(j) == index) {
					num++;
				} else {
					result += String.valueOf(num);
					result += String.valueOf(index);
					num = 1;
					index = start.charAt(j);
				}
			}
			result += String.valueOf(num);
			result += String.valueOf(index);
			start = result;
			num = 0;
			index = start.charAt(0);
		}
		return result;
	}
	
	//用StringBuilder快，不能使用String"+"来拼接而是使用，避免产生大量无用的中间对象，耗费空间且执行效率低下（新建对象、回收对象花费大量时间）。
	public String countAndSay2(int n) {
		char[] result = {'1'};
		char index = '1';
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n - 1; i++) {
			int num = 0;
			for (int j = 0; j < result.length; j++) {
				if(result[j] == index)
					num++;
				else {
					sb.append(num);
					sb.append(index);
					num = 1;
					index = result[j];
				}
			}
			sb.append(num);
			sb.append(index);
			result = sb.toString().toCharArray();
			sb.delete(0, sb.length());
			index = result[0];
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		E38 e38 = new E38();
		int n = 4;
		String result = e38.countAndSay2(n);
		System.out.println(result);
	}
}
