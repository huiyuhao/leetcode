package leetcode;

import java.util.HashMap;
import java.util.Map;

public class M12 {
    public String intToRoman(int num) {
    	
    	//生成一个map需要时间，这么多map是有点慢的
    	Map<Integer, String> map = new HashMap<>();
    	map.put(1, "I");
    	map.put(2, "II");
    	map.put(3, "III");
    	map.put(4, "IV");
    	map.put(5, "V");
    	map.put(6, "VI");
    	map.put(7, "VII");
    	map.put(8, "VIII");
    	map.put(9, "IX");
    	map.put(10, "X");
    	map.put(20, "XX");
    	map.put(30, "XXX");
    	map.put(40, "XL");
    	map.put(50, "L");
    	map.put(60, "LX");
    	map.put(70, "LXX");
    	map.put(80, "LXXX");
    	map.put(90, "XC");
    	map.put(100, "C");
    	map.put(200, "CC");
    	map.put(300, "CCC");
    	map.put(400, "CD");
    	map.put(500, "D");
    	map.put(600, "DC");
    	map.put(700, "DCC");
    	map.put(800, "DCCC");
    	map.put(900, "CM");
    	map.put(1000, "M");
    	map.put(2000, "MM");
    	map.put(3000, "MMM");
    	int temp= num, i = 1;
    	StringBuilder sb = new StringBuilder();
        while (temp != 0) {
        	if (map.containsKey(temp % 10))
        		sb.insert(0, map.get(temp % 10 * i));
        	temp = temp /10;
        	i *= 10;
        }
        return String.valueOf(sb);
    }
    
    //这里用了数据字典，比较快
    public String intToRoman2(int num) {
    	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < values.length; i++) {
			int temp = num / values[i];
			if (temp == 0)
				continue;
			for (int j = 0; j < temp; j++) 
				sb.append(strs[i]);
			num -= temp * values[i];
			if (num == 0)
				break;
		}
    	return sb.toString();
    }
    
    
    
    public static void main(String[] args) {
		M12 m12 = new M12();
		int num = 1994;
		System.out.println(m12.intToRoman2(num));
	}
}
