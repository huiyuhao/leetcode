package sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	public static void main(String[] args) {
		int[] ints = new int[] { 2, 324, 4, 57, 1 };

		System.out.println("增序排序后顺序");
		Arrays.sort(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}

		System.out.println("\n减序排序后顺序");
		// 要实现减序排序，得通过包装类型数组，基本类型数组是不行滴
		Integer[] integers = new Integer[] { 2, 324, 4, 4, 6, 1 };
		Arrays.sort(integers, new Comparator<Integer>() {
			/*
			 * 此处与c++的比较函数构成不一致 
			 * c++返回bool型,而Java返回的为int型 
			 * 当返回值>0时 进行交换，即排序(源码实现为两枢轴快速排序)
			 */
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

			public boolean equals(Object obj) {
				return false;
			}
		});
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}

		System.out.println("\n对部分排序后顺序");
		int[] ints2 = new int[] { 212, 43, 2, 324, 4, 4, 57, 1 };
		// 对数组的[2,6)位进行排序

		Arrays.sort(ints2, 2, 6);
		for (int i = 0; i < ints2.length; i++) {
			System.out.print(ints2[i] + " ");
		}

	}
}
