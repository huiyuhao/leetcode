package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class E205 {
	public boolean isIsomorphic(String s, String t) {
		int len = s.length();
		int[] n1 = new int[len];
		int[] n2 = new int[len];
		int index = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(s.charAt(i)))
				n1[i] = map.get(s.charAt(i));
			else {
				map.put(s.charAt(i), index);
				n1[i] = index++;
			}
		}
		map.clear();
		index = 0;
		for (int i = 0; i < len; i++) {
			if (map.containsKey(t.charAt(i)))
				n2[i] = map.get(t.charAt(i));
			else {
				map.put(t.charAt(i), index);
				n2[i] = index++;
			}
		}
		return Arrays.equals(n1, n2);
	}

	public boolean isIsomorphic2(String s, String t) {
		int len = s.length();
		char[] ch1 = s.toCharArray();
		char[] ch2 = t.toCharArray();
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (map.get(ch1[i]) != null)
				ch1[i] = (char) map.get(ch1[i]);
			else {
				if (map.containsValue(ch2[i]))
					return false;
				map.put(ch1[i], ch2[i]);
				ch1[i] = ch2[i];
			}
			if (ch1[i] != ch2[i])
				return false;
		}
		return true;
	}

	public boolean isIsomorphic3(String s, String t) {
		int[] n1 = new int[128];//128 阿斯克码的范围
		int[] n2 = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i), tc = t.charAt(i);
			if (n1[sc] != n2[tc])//检查上次出现的位置是否相同
				return false;
			n1[sc] = i + 1;//记录这次出现的位置
			n2[tc] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		E205 e205 = new E205();
		String s = "ab";
		String t = "aa";
		System.out.println(e205.isIsomorphic(s, t) ? "true" : "false");
	}
}
