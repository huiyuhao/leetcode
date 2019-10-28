package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class M127 {

	int res;

	/**
	 * ��ʱ�ˣ�����������ȵ�˼��
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		int flag = 0;
		for (int i = 0; i < wordList.size(); i++) {
			if (onlyOneChange(beginWord, wordList.get(i)))
				flag++;
		}
		if (flag == 0)
			return 0;
		res = wordList.size();
		int cur = 1;
		boolean[] used = new boolean[wordList.size()];
		backtrack(beginWord, endWord, wordList, used, cur);
		return res;
	}

	public boolean onlyOneChange(String s1, String s2) {
		int flag = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				flag++;
			if (flag == 2)
				return false;
		}
		if (flag != 1)
			return false;
		return true;
	}

	public void backtrack(String beginWord, String endWord, List<String> wordList, boolean[] used, int cur) {
		int size = wordList.size();
		for (int j = 0; j < size; j++) {
			if (!used[j] && onlyOneChange(beginWord, wordList.get(j))) {
				String temp = beginWord;
				beginWord = wordList.get(j);
				used[j] = true;
				cur++;
				if (wordList.get(j).equals(endWord))
					res = res < cur ? res : cur;
				else
					backtrack(beginWord, endWord, wordList, used, cur);
				used[j] = false;
				cur--;
				beginWord = temp;
			}
		}
	}

	/**
	 * �������
	 * ���˺ö�Σ����ں��ˣ�������setȥ�أ�������˫��BFS��Ȼ��Ҳֻ�ǲ���ʱ�ˣ���ʱ900ms
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		// set��ȥ���õģ��������ٶȷǳ���Ҫ
		Set<String> set = new HashSet<>();
		if (beginWord.equals(endWord))
			return 1;
		if (!wordList.contains(endWord))
			return 0;
		if (onlyOneChange(beginWord, endWord))
			return 2;
		int flagBegin = 0;
		for (int i = 0; i < wordList.size(); i++) {
			if (onlyOneChange(beginWord, wordList.get(i)))
				flagBegin++;
		}
		if (flagBegin == 0)
			return 0;
		// <--����һ���ٵ�BFS��ֻ���ҵ���ʼ�׶νڵ��ٵ�һ��
		int flagEnd = 0;
		for (int i = 0; i < wordList.size(); i++) {
			if (onlyOneChange(endWord, wordList.get(i)))
				flagEnd++;
		}
		if (flagEnd < flagBegin) {
			String t = beginWord;
			beginWord = endWord;
			endWord = t;
		}
		// -->
		// now�ǵ�ǰ��ĵ���������temp����һ��ĵ�������������������ʵ�ֲַ�
		int now = 0, temp = 0;
		set.add(beginWord);
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		now++;
		// road��¼·����
		int road = 1;
		while (!queue.isEmpty()) {
			if (now == 0) {
				road++;
				now = temp;
				temp = 0;
			}
			String cur = queue.poll();
			now--;
			if (cur.equals(endWord))
				return road;
			for (int i = 0; i < wordList.size(); i++) {
				if (!set.contains(wordList.get(i)) && onlyOneChange(cur, wordList.get(i))) {
					set.add(wordList.get(i));
					queue.offer(wordList.get(i));
					temp++;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		M127 m127 = new M127();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(m127.ladderLength2(beginWord, endWord, wordList));
	}
}
