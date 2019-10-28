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
	 * 快速排序
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
	 * 快排核心算法，递归实现
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public void sort(int[][] array, int left, int right) {
		if (left > right) {
			return;
		}
		// base中存放基准数
		int base = array[left][0];
		int base2 = array[left][1];
		int i = left, j = right;
		while (i != j) {
			// 顺序很重要，先从右边开始往左找，直到找到比base值小的数
			while (array[j][0] >= base && i < j) {
				j--;
			}

			// 再从左往右边找，直到找到比base值大的数
			while (array[i][0] <= base && i < j) {
				i++;
			}

			// 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
			if (i < j) {
				int tmp = array[i][0];
				array[i][0] = array[j][0];
				array[j][0] = tmp;
				tmp = array[i][1];
				array[i][1] = array[j][1];
				array[j][1] = tmp;
			}
		}

		// 将基准数放到中间的位置（基准数归位）
		array[left][0] = array[i][0];
		array[i][0] = base;
		array[left][1] = array[i][1];
		array[i][1] = base2;

		// 递归，继续向基准的左右两边执行和上面同样的操作
		// i的索引处为上面已确定好的基准值的位置，无需再处理
		sort(array, left, i - 1);
		sort(array, i + 1, right);
	}

	public static void main(String[] args) {
		M56 m56 = new M56();
		int[][] intervals = { { 1, 4 }, { 0, 0 } };
		System.out.println(m56.merge(intervals));
	}
}
