package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M49 {
	
	/**
	 * 这方法最后有个用例超时了
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<Integer> index = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			index.add(i);
		}
		int i = 0;
		while (i < index.size()) {
			int j = i + 1;
			List<String> temp = new ArrayList<String>();
			temp.add(strs[index.get(i)]);
			while (j < index.size()) {
				Map<Integer, Character> map = new HashMap<>();
				for (int k = 0; k < strs[index.get(i)].length(); k++) {
					map.put(k, strs[index.get(i)].charAt(k));
				}
				int cache = j;
				for (int k = 0; k < strs[index.get(j)].length(); k++) {
					if (strs[index.get(i)].length() != strs[index.get(j)].length()
							|| !map.containsValue(strs[index.get(j)].charAt(k))) {
						j++;
						break;
					}else {
						map.remove(getKey(map, strs[index.get(j)].charAt(k)));
					}
				}
				if (cache == j && strs[index.get(j)].length() != 0) {
					temp.add(strs[index.get(j)]);
					index.remove(j);
				}else if (j < index.size() && strs[index.get(j)].length() == 0 && strs[index.get(i)].length() == 0) {
					temp.add(strs[index.get(j)]);
					index.remove(j);
				}else if (j < index.size() && strs[index.get(j)].length() == 0) {
					j++;
				}
			}
			result.add(temp);
			i++;
		}
		return result;
	}
	
	public int getKey(Map<Integer, Character> map, char value) {
		int result = 0;
		for (int key : map.keySet()) {
			if (map.get(key).equals(value))
				result = key;
		}
		return result;
	}
	
	public List<List<String>> groupAnagrams2(String[] strs) {
		if(strs.length == 0)
			return new ArrayList<>();
		Map<String, List> map = new HashMap<String, List>();
		for (String str : strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String st = String.valueOf(ca);
			if(!map.containsKey(st)) {
				map.put(st, new ArrayList());
			}
			map.get(st).add(str);
		}
		return new ArrayList(map.values());	
	}
	
	/**
	 * 官方计数分类法，统计每个字母出现次数，有26个数字，彼此以“#”分隔，以此为键值
	 * @param strs
	 * @return
	 */
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
	
	public static void main(String[] args) {
		M49 m49 = new M49();
		String[] strs = { "hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab" };
		System.out.println(m49.groupAnagrams3(strs));
	}
}
