package leetcode;

public class E242 {
	public boolean isAnagram(String s, String t) {
		int[] n1 = new int[26];
		int[] n2 = new int[26];
		for (int i = 0; i < s.length(); i++)
			n1[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			n2[t.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++)
			if (n1[i] != n2[i])
				return false;
		return true;
	}
	
	/**
	 * 只用一个计数器表
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram2(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] counter = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        counter[s.charAt(i) - 'a']++;
	        counter[t.charAt(i) - 'a']--;
	    }
	    for (int count : counter) {
	        if (count != 0) {
	            return false;
	        }
	    }
	    return true;
	}
}
