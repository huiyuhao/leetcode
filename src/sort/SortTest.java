package sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	public static void main(String[] args) {
		int[] ints = new int[] { 2, 324, 4, 57, 1 };

		System.out.println("���������˳��");
		Arrays.sort(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}

		System.out.println("\n���������˳��");
		// Ҫʵ�ּ������򣬵�ͨ����װ�������飬�������������ǲ��е�
		Integer[] integers = new Integer[] { 2, 324, 4, 4, 6, 1 };
		Arrays.sort(integers, new Comparator<Integer>() {
			/*
			 * �˴���c++�ıȽϺ������ɲ�һ�� 
			 * c++����bool��,��Java���ص�Ϊint�� 
			 * ������ֵ>0ʱ ���н�����������(Դ��ʵ��Ϊ�������������)
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

		System.out.println("\n�Բ��������˳��");
		int[] ints2 = new int[] { 212, 43, 2, 324, 4, 4, 57, 1 };
		// �������[2,6)λ��������

		Arrays.sort(ints2, 2, 6);
		for (int i = 0; i < ints2.length; i++) {
			System.out.print(ints2[i] + " ");
		}

	}
}
