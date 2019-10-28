package leetcode;

import java.util.Arrays;

public class M274 {
	/**
	 * 用一个数组来记录引用超过每个数的数量，跑出来很慢
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int[] temp = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			for (int j = 1; j < temp.length; j++) {
				if (citations[i] >= j)
					temp[j]++;
			}
		}
		int h = temp.length - 1;
		while (h >= 0) {
			if (h <= temp[h])
				break;
			h--;
		}
		return h;
	}

	public int hIndex2(int[] citations) {
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i)
				return citations.length - i;
		}
		return 0;
	}

	/**
	 * 计数排序
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex3(int[] citations) {
		int n = citations.length;
		int[] temp = new int[n + 1];
		for (int c : citations) {
			temp[Math.min(n, c)]++;
		}
		int h = n;
		for (int i = temp[n]; h > i; i += temp[h]) {
			h--;
		}
		return h;
	}

	public static void main(String[] args) {
		M274 m274 = new M274();
		int[] citations = {};
		System.out.println(m274.hIndex(citations));
	}
}
