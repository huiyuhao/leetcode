package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M139 {
	/**
	 * ��̬�滮��һ��K.O
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		List<Integer> mark = new ArrayList<Integer>();
		mark.add(0);
		int index = 0;
		while (index <= len) {
			for (int i = mark.size() - 1; i >= 0; i--)
				if (wordDict.contains(s.substring(mark.get(i), index))) {
					mark.add(index);
					break;// ���ﲻbreak�ᳬ���ڴ�����
				}
			index++;
		}
		return mark.get(mark.size() - 1) == len ? true : false;
	}

	public static void main(String[] args) {
		M139 m139 = new M139();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(m139.wordBreak("leetcode", wordDict));
	}
}
