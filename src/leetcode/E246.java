package leetcode;

import java.util.HashMap;

public class E246 {
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		StringBuilder sb = new StringBuilder();
		for (int i = num.length() - 1; i >= 0; i--) {
			if (!map.containsKey(num.charAt(i)))
				return false;
			sb.append(map.get(num.charAt(i)));
		}
		return num.equals(sb.toString()) ? true : false;
	}
}
