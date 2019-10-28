package leetcode;

import java.util.HashMap;
import java.util.Map;

public class E13 {
    public int romanToInt(String s) {
    	int sum = 0;
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'V')
				sum += 5;
			else if(s.charAt(i) == 'L')
				sum += 50;
			else if(s.charAt(i) == 'D')
				sum += 500;
			else if(s.charAt(i) == 'M')
				sum += 1000;
			else if(s.charAt(i) == 'I') {
				if(i < s.length() - 1 && s.charAt(i + 1) == 'V') {
					sum += 4;
					i++;
					continue;
				}
				else if(i < s.length() - 1 && s.charAt(i + 1) == 'X') {
					sum += 9;
					i++;
				}else {
					sum += 1;
				}
			}
			else if(s.charAt(i) == 'X') {
				if(i < s.length() - 1 && s.charAt(i + 1) == 'L') {
					sum += 40;
					i++;
					continue;
				}
				else if(i < s.length() - 1 && s.charAt(i + 1) == 'C') {
					sum += 90;
					i++;
				}else {
					sum += 10;
				}
			}
			else if(s.charAt(i) == 'C') {
				if(i < s.length() - 1 && s.charAt(i + 1) == 'D') {
					sum += 400;
					i++;
					continue;
				}
				else if(i < s.length() - 1 && s.charAt(i + 1) == 'M') {
					sum += 900;
					i++;
				}else {
					sum += 100;
				}
			}	
		}
        return sum;
    }
    
    public int romanToInt2(String s) {
    	Map<String, Integer> map = new HashMap<>();
    	map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
			if(i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
				ans += map.get(s.substring(i, i + 2));
				i++;
			}else {
				ans += map.get(s.substring(i, i + 1));
			}
		}
    	return ans;	
    }
}
