package leetcode;

import java.util.Arrays;

public class E383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ch1 = ransomNote.toCharArray();
        char[] ch2 = magazine.toCharArray();
        int i = 0, j = 0;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        while(i < ch1.length && j < ch2.length) {
        	if(ch1[i] == ch2[j])
        		i++;
        	j++;
        }
        return i == ch1.length;
    }
    
    /**
     * 对26个英文字母做统计
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
    	int[] cnts = new int[26];
    	for (char ch : magazine.toCharArray()) {
			cnts[ch - 'a']++;
		}
    	for (char ch : ransomNote.toCharArray()) {
			cnts[ch - 'a']--;
			if(cnts[ch - 'a'] < 0)
				return false;
		}
    	return true;
    }
}
