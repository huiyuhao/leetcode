package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class M56 {
	public int[][] merge(int[][] intervals) {
		sort(intervals, 0, intervals.length - 1);
		if (intervals.length == 0)
			return new int[0][];
		ArrayList<int[]> temp = new ArrayList<>();
		temp.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= temp.get(temp.size() - 1)[1] && intervals[i][1] > temp.get(temp.size() - 1)[1])
				temp.get(temp.size() - 1)[1] = intervals[i][1];
			if (intervals[i][0] > temp.get(temp.size() - 1)[1])
				temp.add(intervals[i]);
		}
		int[][] res = new int[temp.size()][];
		for (int i = 0; i < res.length; i++) {
			res[i] = temp.get(i);
		}
		return res;
	}

	/**
	 * ��������
	 * 
	 * @param array
	 */
//	public static void quickSort(int[] array) {
//		int len;
//		if (array == null || (len = array.length) == 0 || len == 1) {
//			return;
//		}
//		sort(array, 0, len - 1);
//	}

	/**
	 * ���ź����㷨���ݹ�ʵ��
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public void sort(int[][] array, int left, int right) {
		if (left > right) {
			return;
		}
		// base�д�Ż�׼��
		int base = array[left][0];
		int base2 = array[left][1];
		int i = left, j = right;
		while (i != j) {
			// ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
			while (array[j][0] >= base && i < j) {
				j--;
			}

			// �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
			while (array[i][0] <= base && i < j) {
				i++;
			}

			// �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
			if (i < j) {
				int tmp = array[i][0];
				array[i][0] = array[j][0];
				array[j][0] = tmp;
				tmp = array[i][1];
				array[i][1] = array[j][1];
				array[j][1] = tmp;
			}
		}

		// ����׼���ŵ��м��λ�ã���׼����λ��
		array[left][0] = array[i][0];
		array[i][0] = base;
		array[left][1] = array[i][1];
		array[i][1] = base2;

		// �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
		// i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
		sort(array, left, i - 1);
		sort(array, i + 1, right);
	}

	public static void main(String[] args) {
		M56 m56 = new M56();
		int[][] intervals = { { 1, 4 }, { 0, 0 } };
		System.out.println(m56.merge(intervals));
	}
}
