package leetcode;

public class M275 {
	/**
	 * ˼·�ʹ��붼�ܼ򵥣�����Ҫ3ms
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i)
				return citations.length - i;
		}
		return 0;
	}

	/**
	 * ���ֲ���,1ms�ܿ�
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex2(int[] citations) {
		int n = citations.length;
		if (citations == null || n == 0 || citations[n - 1] == 0)
			return 0;
		int begin = 0, end = citations.length - 1;
		while (begin < end) {
			int mid = (begin + end) / 2;
			if (citations[mid] < n - mid)
				begin = mid + 1;
			else
				end = mid;
		}
		return n - begin;
	}
}
