package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class M752 {
	/**
	 * 真是繁杂啊，用了两个Set 和 两个Queue
	 * 
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock(String[] deadends, String target) {
		Set<String> used = new HashSet<>();
		Set<String> set = new HashSet<>();
		for (String s : deadends)
			set.add(s);
		if (set.contains("0000"))
			return -1;
		StringBuilder sb = new StringBuilder("0000");
		Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
		Queue<Integer> deep = new LinkedList<Integer>();
		queue.add(sb);
		used.add(sb.toString());
		deep.add(0);
		while (!queue.isEmpty()) {
			StringBuilder cur = queue.poll();
			int curDeep = deep.poll();
			StringBuilder temp = new StringBuilder(cur);
			if (cur.toString().equals(target))
				return curDeep;
			for (int i = 0; i < cur.length(); i++) {
				int num = cur.charAt(i) - '0';
				Integer left = (num - 1 + 10) % 10;
				Integer right = (num + 1) % 10;
				cur.replace(i, i + 1, left.toString());
				if (!set.contains(cur.toString()) && !used.contains(cur.toString())) {
					queue.add(new StringBuilder(cur));
					used.add(new String(cur));
					deep.add(curDeep + 1);
				}
				cur.replace(i, i + 1, right.toString());
				if (!set.contains(cur.toString()) && !used.contains(cur.toString())) {
					queue.add(new StringBuilder(cur));
					used.add(new String(cur));
					deep.add(curDeep + 1);
				}
				cur = new StringBuilder(temp);
			}
		}
		return -1;
	}

	public int openLock2(String[] deadends, String target) {
		Set<String> set = new HashSet<>();
		for (String s : deadends)
			set.add(s);
		if (set.contains("0000"))
			return -1;
		StringBuilder sb = new StringBuilder("0000");
		Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
		Queue<Integer> deep = new LinkedList<Integer>();
		queue.add(sb);
		set.add(sb.toString());
		deep.add(0);
		while (!queue.isEmpty()) {
			StringBuilder cur = queue.poll();
			int curDeep = deep.poll();
			StringBuilder temp = new StringBuilder(cur);
			if (cur.toString().equals(target))
				return curDeep;
			for (int i = 0; i < cur.length(); i++) {
				int num = cur.charAt(i) - '0';
				Integer left = (num - 1 + 10) % 10;
				Integer right = (num + 1) % 10;
				cur.replace(i, i + 1, left.toString());
				if (!set.contains(cur.toString())) {
					queue.add(new StringBuilder(cur));
					set.add(new String(cur));
					deep.add(curDeep + 1);
				}
				cur.replace(i, i + 1, right.toString());
				if (!set.contains(cur.toString())) {
					queue.add(new StringBuilder(cur));
					set.add(new String(cur));
					deep.add(curDeep + 1);
				}
				cur = new StringBuilder(temp);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		M752 m752 = new M752();
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";
		System.out.println(m752.openLock(deadends, target));

	}
}
