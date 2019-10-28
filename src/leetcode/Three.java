package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Three {
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j <= n; j++) {
				if(allUnique(s, i, j)) {
					ans = Math.max(ans, j-i);
				}
			}
		}
		return ans;
	}
	
	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i=start; i<end; i++) {
			Character ch = s.charAt(i);
			if(set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}
	
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			set.add(s.charAt(i));
			ans = Math.max(ans, 1);
			for (int j = i+1; j < n; j++) {
				if(!(set.contains(s.charAt(j)))) {
					set.add(s.charAt(j));
					ans = Math.max(ans, j-i+1);
				}else {
					break;
				}
			}
		}
		return ans;
	}
	
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			}else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
	
	public static int lengthOfLongestSubstring4(String s) {
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(i < n && j < n) {
			if(!map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), j);
				j++;
				ans = Math.max(ans, j-i);
			}else {
				int x = map.get(s.charAt(j));
				for(int k = i; k <= x; k++) {
					map.remove(s.charAt(k));
				}
				map.put(s.charAt(j), j);
				j++;
				i = x + 1;
			}
		}
		return ans;
	}
	
	public static int lengthOfLongestSubstring5(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)) + 1, i);
			}
			map.put(s.charAt(j), j );
			ans = Math.max(ans, j-i+1);
		}
		return ans;
	}
	
	public static int lengthOfLongestSubstring6(String s) {
		int n = s.length();
		int ans = 0;
		int[] index = new int[128];
		for (int i = 0, j = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j-i+1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = " ";
		int ans = lengthOfLongestSubstring6(s);
		System.out.println(ans);
	}
}
