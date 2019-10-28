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
	 * 超时了，这是深度优先的思想
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
	 * 广度优先
	 * 改了好多次，终于好了，加入了set去重，加入了双端BFS，然而也只是不超时了，用时900ms
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		// set是去重用的，对提升速度非常重要
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
		// <--这是一个假的BFS，只能找到开始阶段节点少的一端
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
		// now是当前层的单词数量，temp是下一层的单词数量，这两个变量实现分层
		int now = 0, temp = 0;
		set.add(beginWord);
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		now++;
		// road记录路径长
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
